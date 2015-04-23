package org.braidner.weatherapp.model.weather;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

/**
 * Created by smith / 11.04.2015.
 */
public class City {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("population")
    private String population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
