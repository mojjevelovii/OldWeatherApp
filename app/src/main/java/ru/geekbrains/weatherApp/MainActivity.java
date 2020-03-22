package ru.geekbrains.weatherApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int SELECT_CITY_REQUEST_CODE = 12;
    static final String YANDEX_URL = "https://yandex.ru/pogoda/";
    private TextView tvCity;
    private Button bExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initButtons();
    }

    private void initView() {
        tvCity = findViewById(R.id.tv_city);
        bExtra = findViewById(R.id.b_extra);
    }

    private void initButtons() {
        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCity();
            }
        });

        bExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraButtonClick();
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

    private void extraButtonClick() {
        String url = YANDEX_URL + tvCity.getText();
        Uri uri = Uri.parse(url);
        Intent browser = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browser);
    }
}
