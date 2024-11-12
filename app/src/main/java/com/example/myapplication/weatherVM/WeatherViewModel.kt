package com.example.myapplication.weatherVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Models.WeatherDetails
import com.example.myapplication.Repository.ApiInterface
import com.example.myapplication.Repository.RetrofitInstance

class WeatherViewModel: ViewModel() {
    private val weatherRepo = RetrofitInstance.getInstance().create(ApiInterface::class.java)
    private val _weatherData: MutableLiveData<WeatherDetails> by lazy { MutableLiveData<WeatherDetails>() }
    val weatherData: LiveData<WeatherDetails> = _weatherData

    suspend fun refreshWD( q: String){
        val weather = weatherRepo.getData("027528c617324df089d124902240107",q)
//        _weatherData.value = weather.body()
        if(weather.code()==200){
            _weatherData.value = weather.body()
        }
        else{
            _weatherData.value?.location?.name ="error"
            _weatherData.value?.current?.temp_c= 0.0
        }


    }
}