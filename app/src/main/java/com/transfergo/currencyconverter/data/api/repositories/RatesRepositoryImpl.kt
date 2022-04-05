package com.transfergo.currencyconverter.data.api.repositories

import com.transfergo.currencyconverter.data.api.mappers.FxRatesMapper
import com.transfergo.currencyconverter.data.api.services.RatesService
import com.transfergo.currencyconverter.domain.RatesRepository
import com.transfergo.currencyconverter.domain.models.FxRates
import com.transfergo.currencyconverter.domain.models.FxRatesRequest
import io.reactivex.rxjava3.core.Single
import java.math.BigDecimal
import javax.inject.Inject

internal class RatesRepositoryImpl @Inject constructor(
    private val ratesService: RatesService,
    private val fxRatesMapper: FxRatesMapper,
) : RatesRepository {


    override fun getFxRates(fxRatesRequest: FxRatesRequest): Single<FxRates> {
        return ratesService.getFxRates(
            fxRatesRequest.currencyFrom,
            fxRatesRequest.currencyTo,
            fxRatesRequest.amount,
        ).map { fxRatesMapper.transform(it) }
    }
}
