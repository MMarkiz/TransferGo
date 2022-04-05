package com.transfergo.currencyconverter.data.api.mappers

import com.transfergo.currencyconverter.data.api.models.response.FxRatesResponse
import com.transfergo.currencyconverter.domain.models.FxRates
import javax.inject.Inject

class FxRatesMapper @Inject constructor() {

    fun transform(fxRatesResponse: FxRatesResponse) = with(fxRatesResponse) {
        FxRates(
            from,
            to,
            rate,
            fromAmount,
            toAmount,
        )
    }
}
