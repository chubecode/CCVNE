package com.chubecode.ccvne.di

import com.chubecode.ccvne.ui.detail.ViewerViewModel
import com.chubecode.ccvne.ui.main.MainViewModel
import com.chubecode.ccvne.ui.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by ChuTien on ${1/25/2017}.
 */
val viewModelModule = module(override = true){
    viewModel{MainViewModel()}
    viewModel{NewsViewModel(get())}
    viewModel{ViewerViewModel()}
}