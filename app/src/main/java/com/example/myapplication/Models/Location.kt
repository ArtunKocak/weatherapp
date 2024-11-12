package com.example.myapplication.Models

data class Location(
    var name: String,
    var region: String,
    var country: String,
    var lat: Double,
    var lon: Double,
    var tz_id: String,
    var localtime_epoch: Long,
    var localtime: String

)