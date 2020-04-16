package reditclient.di

import com.google.gson.Gson
import data.source.api.RedditService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitNetworkModule = module{
    single { createRetrofit(get(), get()).create(RedditService::class.java) }

    single { GsonConverterFactory.create(Gson()) }

    single { OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })}
}

private fun createRetrofit(
    okhttpClient: OkHttpClient,
    converterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(RedditService.ENDPOINT)
        .client(okhttpClient)
        .addConverterFactory(converterFactory)
        .build()
}