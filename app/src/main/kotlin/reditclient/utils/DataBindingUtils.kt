package com.oleeja.reditclient.reditclient.utils

import android.text.format.DateUtils
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.squareup.picasso.Picasso

@BindingConversion
fun convertNumberToString(i: Number?) = i?.toString() ?: "--"

@BindingAdapter("app:image")
fun setImage(view: AppCompatImageView, image: String?) {
    image?.let {
        Picasso.with(view.context).load(it).into(view)
    }
}

@BindingAdapter("app:date")
fun setDate(view: AppCompatTextView, date: Long?) {
    date?.let {
        view.text = DateUtils.getRelativeTimeSpanString( it*1000, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS,  0)
    }
}