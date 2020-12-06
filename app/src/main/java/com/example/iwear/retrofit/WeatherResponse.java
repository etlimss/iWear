package com.example.iwear.retrofit;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    private Main main;

    public WeatherResponse(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
