package com.example.iwear.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("/data/2.5/weather?units=metric&appid=34298a39d146721a3a52d89221114682")
    Call<WeatherResponse> getWeatherData(@Query("q") String name);
}
