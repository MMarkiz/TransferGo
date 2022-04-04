package com.transfergo.currencyconverter.data.api.models.response

import java.math.BigDecimal

data class FxRatesResponse(
    val from: String?,
    val to: String?,
    val rate: BigDecimal?,
    val fromAmount: Float?,
    val toAmount: Float?,
) 
