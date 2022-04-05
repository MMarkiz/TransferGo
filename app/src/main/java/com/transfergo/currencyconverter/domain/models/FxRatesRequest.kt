package com.transfergo.currencyconverter.domain.models

import java.math.BigDecimal

data class FxRatesRequest(
    val currencyFrom: String,
    val currencyTo: String,
    val amount: BigDecimal
) 
