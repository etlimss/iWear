package com.example.iwear;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iwear.retrofit.Api;
import com.example.iwear.retrofit.ApiClient;
import com.example.iwear.retrofit.WeatherResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private TextView tempText, descText, humidityText;
    private ImageView searchBtn;
    private EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        searchBtn = findViewById(R.id.search_img);
        tempText = findViewById(R.id.tempText);
        descText = findViewById(R.id.description);
        humidityText = findViewById(R.id.humidity);
        searchField = findViewById(R.id.searchLocation);

        searchBtn.setOnClickListener(v -> getWeatherData(searchField.getText().toString().trim()));
    }



    private void getWeatherData(String name) {

        Api apiInterface = ApiClient.getApi();

        Call<WeatherResponse> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                Log.v("Retrofit", "response " + response.body());

                if(response.isSuccessful()) {

                    try {

                        tempText.setText("Temperature: " + " " + response.body().getMain().getTemp() + " C");
                        descText.setText("Feels Like: " + " " + response.body().getMain().getFeels_like());
                        humidityText.setText("Humidity: " + " " + response.body().getMain().getHumidity());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
              }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}