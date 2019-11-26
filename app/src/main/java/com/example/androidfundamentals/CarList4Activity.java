package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidfundamentals.adapters.RecyclerViewAdapter;
import com.example.androidfundamentals.data.DataSource;

import java.util.List;

public class CarList4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list4);

        // Get the data source
        DataSource dataSource = new DataSource();
        List<String> carList = dataSource.getCars();

        // Initialize recycler view
        RecyclerView recyclerView = findViewById(R.id.car_list);

        //Initialize the linear layout manager -> handles organization of UI components in a View
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        // Set linear layout manager to recycler view
        recyclerView.setLayoutManager(layoutManager);

        // Initialize recycler view adapter with car list (data source)
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(carList);

        // Set recycler view adapter to recycler view
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
