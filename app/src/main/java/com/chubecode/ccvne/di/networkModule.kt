package com.chubecode.ccvne.di

import android.content.Context
import com.chubecode.ccvne.BuildConfig
import com.chubecode.ccvne.data.remote.ApiService
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by ChuTien on ${1/25/2017}.
 */
val networkModule = module(override = true) {
    single { createOkHttpCache(get()) }
    single { createLoggingInterceptor() }
    single { createHeaderInterceptor() }
    single { createOkHttpClient(get(), get(), get()) }
    single { createAppRetrofit(get()) }
    single { createApiService(get()) }
}


fun createOkHttpCache(context: Context): Cache {
    val size = (10 * 1024 * 1024).toLong() // 10 Mb
    return Cache(context.cacheDir, size)
}

fun createLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
    return logging
}

fun createHeaderInterceptor(): Interceptor {
    return Interceptor { chain ->
        val request = chain.request()
        val newUrl = request.url().newBuilder()
            .addQueryParameter("api_key", "API_KEY_VALUE")
            .build()
        val newRequest = request.newBuilder()
            .url(newUrl)
            .header("Content-Type", "application/json")
            .method(request.method(), request.body())
            .build()
        chain.proceed(newRequest)
    }
}


fun createOkHttpClient(
    cache: Cache,
    logging: Interceptor,
    header: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
//        .cache(cache)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
//        .addInterceptor(header)
        .addInterceptor(logging)
        .build()
}

fun createAppRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(TikXmlConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun createApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}
