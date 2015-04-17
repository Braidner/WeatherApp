package org.braidner.weatherapp.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.braidner.weatherapp.R;
import org.braidner.weatherapp.model.Weather;
import org.braidner.weatherapp.util.Constants;

import java.io.Serializable;


public class WeatherInfoActivity extends ActionBarActivity {

    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        Intent intent = getIntent();
        weather = (Weather) intent.getSerializableExtra(Constants.WEATHER);
    }


}
