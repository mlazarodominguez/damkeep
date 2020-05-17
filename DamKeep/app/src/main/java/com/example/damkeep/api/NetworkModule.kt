package com.example.damkeep.api

import android.content.Context
import android.content.SharedPreferences

import com.example.damkeep.common.Constants
import com.example.damkeep.di.MyApp

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule{

    @Singleton
    @Provides
    @Named("url")
    fun provideBaseUrl(): String = Constants.API_BASE_URL



    @Singleton
    @Provides
    fun provideOkHttpClient(accessTokenInterceptor: AccessTokenInterceptor): OkHttpClient {
        return with(OkHttpClient.Builder()) {
            addInterceptor(accessTokenInterceptor)
            connectTimeout(Constants.TIMEOUT_INMILIS, TimeUnit.MILLISECONDS)
            build()
        }
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        val sharedPref = MyApp.instance?.getSharedPreferences(
            Constants.SHARED_PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPref
    }

    @Singleton
    @Provides
    fun provideTheMovieDBRetrofitService(@Named("url") baseUrl: String, okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

}