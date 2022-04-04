package com.transfergo.currencyconverter.domain

import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import io.reactivex.rxjava3.core.Single

interface RatesRepository {

    fun getFxRates(fxRatesRequest: FxRatesRequest): Single<FxRates>
}
