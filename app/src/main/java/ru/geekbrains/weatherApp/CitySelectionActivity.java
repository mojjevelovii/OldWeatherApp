package ru.geekbrains.weatherApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class CitySelectionActivity extends AppCompatActivity {
    static final String CITY_NAME = "CITY_NAME";
    private EditText etInputCity;
    private ImageView ivSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_selection);
        initView();
    }

    private void initView() {
        etInputCity = findViewById(R.id.et_city_search);
        ivSearch = findViewById(R.id.iv_search);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewCity();
            }
        });
    }

    private void setNewCity() {
        Intent intentResult = new Intent();
        intentResult.putExtra(CITY_NAME, etInputCity.getText().toString());
        setResult(RESULT_OK, intentResult);
        finish();
    }
}
