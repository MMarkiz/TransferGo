package com.transfergo.currencyconverter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.transfergo.common.RxJavaImmediateSchedulersRule
import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import com.transfergo.currencyconverter.domain.usecases.RatesUseCase
import com.transfergo.currencyconverter.feature.converter.ConverterViewModel
import com.transfergo.currencyconverter.feature.converter.models.CurrencyType
import io.reactivex.rxjava3.core.Single
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import java.math.BigDecimal


@RunWith(JUnit4::class)
class ConverterViewModelUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val immediateSchedulersRule = RxJavaImmediateSchedulersRule()

    private val productsRepo: RatesUseCase = mock(RatesUseCase::class.java)
    private val ratesRequest = FxRatesRequest("PLN", "GBP", BigDecimal(100))
    private val rates = FxRates("PLN", "GBP", BigDecimal(100), 100f, 100f)
    lateinit var converterViewModel: ConverterViewModel

    @Before
    fun initialize() {
        given(productsRepo.getFxRates(ratesRequest)).willReturn(Single.just(rates))
        converterViewModel = ConverterViewModel(productsRepo)
    }

    @Test
    fun initialState_CorrectCurrenciesValues() {
        assertThat(converterViewModel.currencyFrom.value).isEqualTo(CurrencyType.PLN)
        assertThat(converterViewModel.currencyTo.value).isEqualTo(CurrencyType.GBP)
    }

    @Test
    fun switchCurrencies_CorrectCurrenciesValues() {
        converterViewModel.switchCurrencies()
        assertThat(converterViewModel.currencyFrom.value).isEqualTo(CurrencyType.GBP)
        assertThat(converterViewModel.currencyTo.value).isEqualTo(CurrencyType.PLN)
    }

    @Test
    fun convertCurrencies_Success() {
        val statuses: MutableList<ConverterViewModel.FxRatesStatus> = mutableListOf()
        converterViewModel.fxRatesStatus.observeForever { statuses.add(it) }
        converterViewModel.mutableAmount.value = "100"
        converterViewModel.convertCurrencies()

        assertThat(statuses[0]).isEqualTo(ConverterViewModel.FxRatesStatus.Loading)
        assertThat(statuses[1]).isEqualTo(
            ConverterViewModel.FxRatesStatus.Success(
                FxRates("PLN", "GBP", BigDecimal(100), 100f, 100f)
            )
        )
    }
}