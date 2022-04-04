package com.transfergo.currencyconverter.domain.models

import java.math.BigDecimal

data class FxRates(
    val from: String?,
    val to: String?,
    val rate: BigDecimal?,
    val fromAmount: Float?,
    val toAmount: Float?,
)