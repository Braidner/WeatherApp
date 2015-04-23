package org.braidner.weatherapp.model.entity;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by KuznetsovNE on 23.04.2015.
 */
public class WeatherEntity {

    @DatabaseField(generatedId = true)
    private Long id;
}
