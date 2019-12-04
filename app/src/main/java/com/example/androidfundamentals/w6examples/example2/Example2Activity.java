package com.example.androidfundamentals.w6examples.example2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

/**
 * Created by roxanan on 17,April,2019
 */
public class Example2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, new Hello2Fragment(), Hello2Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Hello2Fragment fragment =
                (Hello2Fragment) getSupportFragmentManager().findFragmentByTag(Hello2Fragment.class.getSimpleName());
        fragment.setLabel("Label");
    }
}
