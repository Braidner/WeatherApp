package org.braidner.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by smith / 10.04.2015.
 */
public class Weather {
    @SerializedName("main")
    private WeatherInfo weatherInfo;

    @SerializedName("weather")
    private List<Status> statusesList;

    @SerializedName("dt")
    private Date date;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public List<Status> getStatusesList() {
        return statusesList;
    }

    public void setStatusesList(List<Status> statusesList) {
        this.statusesList = statusesList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
