package org.braidner.weatherapp.response;

import com.google.gson.annotations.SerializedName;

import org.braidner.weatherapp.model.City;
import org.braidner.weatherapp.model.Weather;

import java.util.List;

/**
 * Created by smith / 11.04.2015.
 */
public class WeatherResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("city")
    private City city;

    @SerializedName("list")
    private List<Weather> weatherList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
