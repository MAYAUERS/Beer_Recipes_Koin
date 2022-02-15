package com.example.beer_recipes_koin.di

import com.example.beer_recipes_koin.data.BeerApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule= module {

    single { provideRetrofit(client = get()) }
    factory { provideApi(retrofit = get()) }
    factory { provideOkhttpClient(httpLoggingInterceptor = get()) }
    factory { HttpLoggingInterceptor() }
}

fun provideRetrofit(client: OkHttpClient):Retrofit{
    return Retrofit.Builder()
        .baseUrl("https://api.punkapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) :OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
}

fun provideApi(retrofit: Retrofit):BeerApi{
    return retrofit.create(BeerApi::class.java)
}