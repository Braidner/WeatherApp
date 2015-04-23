package org.braidner.weatherapp.model.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smith / 11.04.2015.
 */
public class WeatherInfo {
    private static final double CELSIUS = 273.15d;

    @SerializedName("temp")
    private Double temperature;
    @SerializedName("temp_min")
    private Double temperatureMax;
    @SerializedName("temp_max")
    private Double temperatureMin;

    public Double getTemperature() {
        return temperature - CELSIUS;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperatureMax() {
        return temperatureMax - CELSIUS;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Double getTemperatureMin() {
        return temperatureMin - CELSIUS;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }
}
