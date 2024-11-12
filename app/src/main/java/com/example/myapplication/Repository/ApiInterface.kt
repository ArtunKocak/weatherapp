package com.example.myapplication.Repository
import com.example.myapplication.Models.WeatherDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("current.json")
    suspend fun getData(@Query("key") key: String,@Query("q") q: String): Response<WeatherDetails>
}