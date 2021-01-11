package co.gtg7784.retrofitkotlinstudy

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord") val coord: Coordinate,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: Main,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val datetime: Int,
    @SerializedName("sys") val system: System,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val status: Int
)

data class Coordinate(
    @SerializedName("lat") val lat: Float,
    @SerializedName("lon") val lon: Float
)

data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class Main(
    @SerializedName("temp") val temp: Float,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("temp_min") val tempMin: Float,
    @SerializedName("temp_max") val tempMax: Float
)

data class Wind(
    @SerializedName("speed") val speed: Float,
    @SerializedName("deg") val degree: Int
)

data class Clouds(
    @SerializedName("all") val all: Int
)

data class System(
    @SerializedName("type") val type: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("message") val message: Float,
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int
)

