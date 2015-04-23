package org.braidner.weatherapp.model.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smith / 15.04.2015.
 */
public class Temperature {

    @SerializedName("min")
    private Double min;

    @SerializedName("max")
    private Double max;

    @SerializedName("morn")
    private Double morning;

    @SerializedName("day")
    private Double day;

    @SerializedName("eve")
    private Double evening;

    @SerializedName("night")
    private Double night;

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getEvening() {
        return evening;
    }

    public void setEvening(Double evening) {
        this.evening = evening;
    }

    public Double getMorning() {
        return morning;
    }

    public void setMorning(Double morning) {
        this.morning = morning;
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }
}
