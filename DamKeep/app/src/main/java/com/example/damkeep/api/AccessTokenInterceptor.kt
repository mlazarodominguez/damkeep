package com.example.damkeep.api

import com.example.damkeep.common.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor( ) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
            .header("Authorization", "Bearer ${Constants.TOKEN}")
        val request = builder.build()
        return chain.proceed(request)
    }

}