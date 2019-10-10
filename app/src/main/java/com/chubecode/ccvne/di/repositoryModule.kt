package com.chubecode.ccvne.di

import com.chubecode.ccvne.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module(override = true) {
    single { NewsRepository(get()) }
}
