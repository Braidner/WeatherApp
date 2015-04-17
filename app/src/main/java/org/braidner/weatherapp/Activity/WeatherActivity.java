package org.braidner.weatherapp.Activity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.braidner.weatherapp.R;
import org.braidner.weatherapp.adapter.WeatherAdapter;
import org.braidner.weatherapp.api.WeatherApi;
import org.braidner.weatherapp.response.WeatherResponse;
import org.braidner.weatherapp.util.Constants;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.concurrent.CompletionService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class WeatherActivity extends ListActivity {

    private WeatherApi weatherApi;
    private ListView listView;
    private WeatherAdapter weatherAdapter;
    private Callback<WeatherResponse> weatherCallback = new Callback<WeatherResponse>() {
        @Override
        public void success(WeatherResponse weatherResponse, Response response) {
            weatherAdapter.addAll(weatherResponse.getWeatherList());
            weatherAdapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e(error.toString(),error.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherApi = getWeatherApi();
        listView = (ListView) findViewById(R.id.weather_list);
        weatherAdapter = new WeatherAdapter(this);
        listView.setAdapter(weatherAdapter);
//        weatherApi.getForecastWeather("Moscow,ru", "ru", weatherCallback);
        weatherApi.getForecastDailyWeather("Moscow,ru", "ru", 5, "metric", weatherCallback);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, WeatherInfoActivity.class);
        intent.putExtra(Constants.WEATHER, weatherAdapter.getItem(position));
        startActivity(intent);
    }

    public WeatherApi getWeatherApi() {
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong() * 1000);
            }
        });

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.WEATHER_API)
                .setConverter(new GsonConverter(builder.create()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        return adapter.create(WeatherApi.class);
    }

}
