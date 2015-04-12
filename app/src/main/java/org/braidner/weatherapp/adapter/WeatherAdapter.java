package org.braidner.weatherapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.braidner.weatherapp.R;
import org.braidner.weatherapp.model.Weather;
import org.braidner.weatherapp.util.Constants;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by smith / 10.04.2015.
 */
public class WeatherAdapter extends ArrayAdapter<Weather> {

    private LayoutInflater inflater;
    private static DisplayImageOptions displayImageOptions;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.0");

    public WeatherAdapter(Context context) {
        super(context, 0);
        inflater = LayoutInflater.from(context);
        displayImageOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .build();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.weather_element, parent, false);
            holder = new ViewHolder();
            holder.temperature = (TextView) convertView.findViewById(R.id.temperature);
            holder.weatherInfo = (TextView) convertView.findViewById(R.id.weather_info);
            holder.icon = (ImageView) convertView.findViewById(R.id.weather_image);
            holder.date = (TextView) convertView.findViewById(R.id.weather_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Weather weather = getItem(position);
        holder.populateItem(weather);

        return convertView;
    }

    static class ViewHolder {
        TextView weatherInfo;
        TextView temperature;
        TextView date;
        ImageView icon;

        @SuppressLint("SimpleDateFormat")
        void populateItem(Weather weather) {
            weatherInfo.setText(weather.getStatusesList().get(0).getDescription());
            temperature.setText(decimalFormat.format(weather.getWeatherInfo().getTemperature()));
            date.setText(new SimpleDateFormat("dd.MM.yyy HH:mm").format(weather.getDate()));
            ImageLoader.getInstance().displayImage(weather.getStatusesList().get(0).getIcon(), icon, displayImageOptions);
        }

    }
}
