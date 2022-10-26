package com.polish.alertnews.common.utils.header

import com.polish.alertnews.common.constant.NetworkConstant
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            chain.request()
                .newBuilder()
                .addHeader("X-Api-Key", NetworkConstant.API_KEY)
                .build()
        )
    }
}