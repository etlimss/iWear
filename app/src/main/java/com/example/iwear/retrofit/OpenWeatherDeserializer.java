package com.example.iwear.retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class OpenWeatherDeserializer implements JsonDeserializer<WeatherResponse> {
    @Override
    public WeatherResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement content = json.getAsJsonObject().get("main");
        return new WeatherResponse(context.deserialize(content, Main.class));
    }
}