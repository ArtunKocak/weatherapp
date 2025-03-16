package com.example.myapplication.Models

data class WeatherRequest(
    val key: String =  "Enter API Key Here",
    var q: String = "London"
)
