package com.transfergo.currencyconverter.feature.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.transfergo.currencyconverter.data.api.services.RatesService
import com.transfergo.currencyconverter.databinding.FragmentConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ConverterFragment : Fragment() {

    @Inject
    lateinit var service: RatesService

    private val viewModel: ConverterViewModel by viewModels()

    private lateinit var binding: FragmentConverterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@ConverterFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}
