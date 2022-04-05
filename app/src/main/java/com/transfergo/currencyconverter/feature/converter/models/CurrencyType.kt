package com.transfergo.currencyconverter.feature.converter.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.transfergo.currencyconverter.R
import com.transfergo.currencyconverter.domain.models.CurrencyTypeRequest

enum class CurrencyType(
    @StringRes val currencyNameRes: Int,
    @DrawableRes val currencyIconRes: Int
) {
    DKK(R.string.currency_dkk, R.drawable.ic_currency_dkk_small),
    EUR(R.string.currency_eur, R.drawable.ic_currency_eur_small),
    GBP(R.string.currency_gbp, R.drawable.ic_currency_gbp_small),
    HUF(R.string.currency_huf, R.drawable.ic_currency_huf_small),
    NOK(R.string.currency_nok, R.drawable.ic_currency_nok_small),
    PLN(R.string.currency_pln, R.drawable.ic_currency_pln_small),
    RON(R.string.currency_ron, R.drawable.ic_currency_ron_small),
    SEK(R.string.currency_sek, R.drawable.ic_currency_sek_small)
}


fun CurrencyType.mapToDomain(): CurrencyTypeRequest {
    return when (this) {
        CurrencyType.DKK -> CurrencyTypeRequest.DKK
        CurrencyType.EUR -> CurrencyTypeRequest.EUR
        CurrencyType.GBP -> CurrencyTypeRequest.GBP
        CurrencyType.HUF -> CurrencyTypeRequest.HUF
        CurrencyType.NOK -> CurrencyTypeRequest.NOK
        CurrencyType.PLN -> CurrencyTypeRequest.PLN
        CurrencyType.RON -> CurrencyTypeRequest.RON
        CurrencyType.SEK -> CurrencyTypeRequest.SEK
    }
}