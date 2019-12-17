package com.junemon.daggerinmitch.helper

import android.content.Context

inline val Context.layoutInflater: android.view.LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater