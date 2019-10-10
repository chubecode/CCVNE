package com.chubecode.ccvne

import android.app.Application
import com.chubecode.ccvne.di.networkModule
import com.chubecode.ccvne.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by ChuTien on ${1/25/2017}.
 */
class App  : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            module {
                viewModelModule
                networkModule
            }
        }
    }
}