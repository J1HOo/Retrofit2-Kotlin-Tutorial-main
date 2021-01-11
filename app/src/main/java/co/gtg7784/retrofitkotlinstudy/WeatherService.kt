package co.gtg7784.retrofitkotlinstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    fun getWeatherData (
        @Query("q") city: String,
        @Query("appid") appId: String
    ) : Call<WeatherResponse>
}