package com.transfergo.currencyconverter.domain.usecases

import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import io.reactivex.rxjava3.core.Single

interface RatesUseCase {

    fun getFxRates(fxRatesRequest: FxRatesRequest): Single<FxRates>
}
