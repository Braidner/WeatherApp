package org.braidner.weatherapp.api;

import org.braidner.weatherapp.response.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by smith / 10.04.2015.
 */

public interface WeatherApi {

    @GET("/forecast")
    public void getForecastWeather(@Query("q") String query, @Query("lang") String lang, Callback<WeatherResponse> callback);

    @GET("/forecast/daily")
    public void getForecastDailyWeather(@Query("q") String query, @Query("lang") String lang, @Query("cnt") Integer countDays, @Query("units") String units, Callback<WeatherResponse> callback);
}
