package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidfundamentals.adapters.CarsAdapter;
import com.example.androidfundamentals.data.DataSource;

import java.util.List;

public class CarsOfTheDay4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_of_the_day4);

        RecyclerView recyclerView = findViewById(R.id.cars_of_the_day_list);
        List<String> carsOfTheDay = new DataSource().getCars();
        CarsAdapter carsAdapter = new CarsAdapter(carsOfTheDay);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(carsAdapter);

    }
}
