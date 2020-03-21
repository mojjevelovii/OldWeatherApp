package ru.geekbrains.weatherApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int SELECT_CITY_REQUEST_CODE = 12;
    private TextView tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvCity = findViewById(R.id.tv_city);
        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCity();
            }
        });
    }

    private void selectCity() {
        Intent intent = new Intent(this, CitySelectionActivity.class);
        startActivityForResult(intent, SELECT_CITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_CITY_REQUEST_CODE) {
            tvCity.setText(data.getStringExtra(CitySelectionActivity.CITY_NAME));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
