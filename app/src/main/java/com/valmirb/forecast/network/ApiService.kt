package com.valmirb.forecast.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.valmirb.forecast.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "7cfb2f02e38b5914cb03d1038379bbee"

//http://api.weatherstack.com/current?access_key=7cfb2f02e38b5914cb03d1038379bbee&query=london

interface ApiService {


    @GET("current")
    fun getCurrentWeather(@Query("query") location: String, @Query("lang") language: String = "en") : Deferred<CurrentWeatherResponse>



    //Deffered is a part of Kotlin Coorotines , whenever is ready


    companion object{
        operator fun invoke() : ApiService{
            val requestInterceptor = Interceptor{chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()


                return@Interceptor chain.proceed(request)
            }


            val okHttp = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttp)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}