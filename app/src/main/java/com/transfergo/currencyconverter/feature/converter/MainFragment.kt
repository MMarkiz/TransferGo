package com.transfergo.currencyconverter.feature.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.transfergo.currencyconverter.data.api.ApiService
import com.transfergo.currencyconverter.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var service: ApiService

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@MainFragment
            fragment = this@MainFragment
        }

        return binding.root
    }

    fun convert() {
        service.getFxRates(
            currencyFrom = binding.fromTextView.text.toString(),
            currencyTo = binding.toTextView.text.toString(),
            amount = binding.amountEditText.text.toString().toBigDecimal()
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                binding.run {
                    convertedToEditText.isVisible = true
                    convertedToCurrencyTextView.isVisible = true
                    convertedToEditTextLabelTextView.isVisible = true

                    convertedToCurrencyTextView.text = binding.toTextView.text
                    convertedToEditText.setText(
                        (response.rate!! * binding.amountEditText.text.toString().toBigDecimal()).toString()
                    )
                }
            }, {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
            })
    }
}
