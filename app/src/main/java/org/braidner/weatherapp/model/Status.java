package org.braidner.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import org.braidner.weatherapp.util.Constants;

/**
 * Created by smith / 11.04.2015.
 */
public class Status {

    @SerializedName("id")
    private Long id;
    @SerializedName("main")
    private String status;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return Constants.WEATHER_IMAGES + icon + ".png";
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
