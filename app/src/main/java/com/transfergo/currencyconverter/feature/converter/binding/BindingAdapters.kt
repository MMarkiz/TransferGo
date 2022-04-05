package com.transfergo.currencyconverter.feature.converter.binding

import android.widget.AutoCompleteTextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.transfergo.currencyconverter.feature.converter.models.CurrencyType


@BindingAdapter("currency")
fun setCurrency(view: AutoCompleteTextView, currencyType: CurrencyType?) = with(view) {
    currencyType?.let {
        setText(context.getString(currencyType.currencyNameRes))
        setCompoundDrawablesRelativeWithIntrinsicBounds(
            AppCompatResources.getDrawable(context, currencyType.currencyIconRes),
            null,
            null,
            null
        )
    }
}