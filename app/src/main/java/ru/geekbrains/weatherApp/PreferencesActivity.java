package ru.geekbrains.weatherApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

import ru.geekbrains.weatherApp.viewStateHolders.PropertiesViewStateHolder;

public class PreferencesActivity extends AppCompatActivity {
    private static final String THEME = "dark";
    private static final String UNITS = "units";
    private static final String PRESSURE = "pressure";
    private static final String WIND = "wind";

    Switch swDarkTheme;
    Switch swTemperatureUnits;
    CheckBox cbWindSpeed;
    CheckBox cbAtmospherePressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        initViews();
        showToast("on create");
    }

    private void initViews() {
        swDarkTheme = findViewById(R.id.sw_dark_theme);
        swTemperatureUnits = findViewById(R.id.sw_temperature_units);
        cbAtmospherePressure = findViewById(R.id.cb_atmosphere_pressure);
        cbWindSpeed = findViewById(R.id.cb_wind_speed);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("on start");
        swDarkTheme.setChecked(PropertiesViewStateHolder.getInstance().isTheme());
        swTemperatureUnits.setChecked(PropertiesViewStateHolder.getInstance().isUnits());
        cbAtmospherePressure.setChecked(PropertiesViewStateHolder.getInstance().isPressure());
        cbWindSpeed.setChecked(PropertiesViewStateHolder.getInstance().isWind());
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("on stop");
        PropertiesViewStateHolder.getInstance().setTheme(swDarkTheme.isChecked());
        PropertiesViewStateHolder.getInstance().setUnits(swTemperatureUnits.isChecked());
        PropertiesViewStateHolder.getInstance().setPressure(cbAtmospherePressure.isChecked());
        PropertiesViewStateHolder.getInstance().setWind(cbWindSpeed.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        swDarkTheme.setChecked(savedInstanceState.getBoolean(THEME, false));
        swTemperatureUnits.setChecked(savedInstanceState.getBoolean(UNITS, false));
        cbWindSpeed.setChecked(savedInstanceState.getBoolean(WIND, false));
        cbAtmospherePressure.setChecked(savedInstanceState.getBoolean(PRESSURE, false));
        showToast("on restore instance state");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("on destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(THEME, swDarkTheme.isChecked());
        outState.putBoolean(UNITS, swTemperatureUnits.isChecked());
        outState.putBoolean(PRESSURE, cbAtmospherePressure.isChecked());
        outState.putBoolean(WIND, cbWindSpeed.isChecked());
        super.onSaveInstanceState(outState);
        showToast("on save instance state");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("on restart");
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.d("lc", msg);
    }
}
