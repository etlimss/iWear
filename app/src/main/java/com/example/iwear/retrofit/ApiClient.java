package com.example.iwear.retrofit;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder()
                            .registerTypeAdapter(WeatherResponse.class, new OpenWeatherDeserializer())
                            .create()
            ));

    private static Retrofit retrofit = retrofitBuilder.build();

    private static Api api = retrofit.create(Api.class);

    public static Api getApi() {
        return api;
    }
}
