package com.example.cityinformation

import android.util.Base64
import com.example.cityinformation.Response.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIn {
private val AUTH="Basic"+Base64.encodeToString("sss".toByteArray(),Base64.NO_WRAP)
private const val BASEURL="https://www.wizzie.online/CityInformation/"
private val okhttps=okhttp3.OkHttpClient.Builder()
    .addInterceptor {
        chain->
        val original=chain.request()
val reqbuilder=original.newBuilder()
    .method(original.method(),original.body())
    .addHeader("Authorization", AUTH)
val request=reqbuilder.build()
chain.proceed(request)
    }.build()
val instance : Api by lazy {
  val retro=  Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttps)
        .build()
    retro.create(Api::class.java)
}

}