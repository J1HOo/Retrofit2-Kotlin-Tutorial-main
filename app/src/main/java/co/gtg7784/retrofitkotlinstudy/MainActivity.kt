package co.gtg7784.retrofitkotlinstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        var baseURL = "https://api.openweathermap.org/"
        var appId = ""
        var city = "Seoul"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val text: TextView = findViewById(R.id.textView)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.getWeatherData(city, appId)
        call.enqueue(object: Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("MainActivity", "result : "+ t.message)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.code() == 200){
                    val body = response.body()
                    Log.d("MainActivity", "body : " + body.toString())
                    val weather = body!!.weather[0].main
                    val description = body!!.weather[0].description
                    val temp = body!!.main.temp - 273.15

                    val result =
                        "도시 : " + city +
                        "\n날씨 : " + weather +
                        "\n날씨 상세 : " + description +
                        "\n온도 : " + temp

                    text.text = result
                }
            }
        })
    }
}
