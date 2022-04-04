package com.transfergo.currencyconverter.domain.usecases

import com.transfergo.currencyconverter.domain.RatesRepository
import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

internal class RatesUseCaseImpl @Inject constructor(
    private val ratesRepository: RatesRepository,
) : RatesUseCase {

    override fun getFxRates(fxRatesRequest: FxRatesRequest): Single<FxRates> {
        return ratesRepository.getFxRates(fxRatesRequest)
    }

}
