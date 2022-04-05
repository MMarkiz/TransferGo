package com.transfergo.currencyconverter.feature.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import com.transfergo.currencyconverter.domain.usecases.RatesUseCase
import com.transfergo.currencyconverter.feature.converter.models.CurrencyType
import com.transfergo.currencyconverter.feature.converter.models.mapToDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val ratesUseCase: RatesUseCase
) : ViewModel() {

    private val mutableCurrencyFrom = MutableLiveData(CurrencyType.PLN)
    val currencyFrom: LiveData<CurrencyType> = mutableCurrencyFrom

    private val mutableCurrencyTo = MutableLiveData(CurrencyType.GBP)
    val currencyTo: LiveData<CurrencyType> = mutableCurrencyTo

    val mutableAmount = MutableLiveData<String>()
    val amount: LiveData<String> = mutableAmount

    private val mutableFxRatesStatus = MutableLiveData<FxRatesStatus>()
    val fxRatesStatus: LiveData<FxRatesStatus> = mutableFxRatesStatus

    private val mutableConvertedToAmount = MutableLiveData<String>()
    val convertedToAmount: LiveData<String> = mutableConvertedToAmount

    private val mutableIsFirstConversionDone = MutableLiveData(false)
    val isFirstConversionDone: LiveData<Boolean> = mutableIsFirstConversionDone

    fun convertCurrencies() {
        mutableFxRatesStatus.value = FxRatesStatus.Loading
        amount.value?.let { amount ->
            currencyTo.value?.let { currencyTo ->
                currencyFrom.value?.let { currencyFrom ->
                    ratesUseCase.getFxRates(
                        FxRatesRequest(
                            currencyFrom = currencyFrom.mapToDomain().name,
                            currencyTo = currencyTo.mapToDomain().name,
                            amount = amount.toBigDecimal(),
                        )
                    )
                        .observeOn(Schedulers.io())
                        .subscribe({ response ->
                            mutableConvertedToAmount.postValue(response.toAmount.toString())
                            mutableIsFirstConversionDone.postValue(true)
                            mutableFxRatesStatus.postValue(FxRatesStatus.Success(response))
                        }, {
                            mutableFxRatesStatus.postValue(FxRatesStatus.Error)
                        })
                }
            }
        }
    }

    fun switchCurrencies() {
        val oldCurrencyFromValue = mutableCurrencyFrom.value
        mutableCurrencyFrom.value = currencyTo.value
        mutableCurrencyTo.value = oldCurrencyFromValue
        convertCurrencies()
    }

    sealed class FxRatesStatus {
        object Loading : FxRatesStatus()
        data class Success(val fxRates: FxRates) : FxRatesStatus()
        object Error : FxRatesStatus()
    }
}
