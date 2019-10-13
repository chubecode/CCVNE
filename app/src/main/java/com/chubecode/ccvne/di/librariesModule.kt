package com.chubecode.ccvne.di

import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.dsl.module

/**
 * Created by ChuTien on ${1/25/2017}.
 */
val librariesModule = module(override = true) {
    single { initFresco(get()) }

}

fun initFresco(context: Context) {
    Fresco.initialize(context)

}