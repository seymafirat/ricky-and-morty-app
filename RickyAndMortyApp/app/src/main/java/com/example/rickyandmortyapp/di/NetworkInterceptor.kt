package com.example.rickyandmortyapp.di

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        println(request)
        request = request.newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Accept","application/json")
            .build()
        println(request)
        return chain.proceed(request)
    }
}