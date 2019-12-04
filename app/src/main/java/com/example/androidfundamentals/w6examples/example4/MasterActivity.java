package com.example.androidfundamentals.w6examples.example4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

import static com.example.androidfundamentals.w6examples.example4.Example4Activity.LABEL_WHAT_TO_LOAD;

/**
 * Created by roxanan on 17,April,2019
 */
public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        String whatToLoad = getIntent().getStringExtra(LABEL_WHAT_TO_LOAD);

        if (whatToLoad.equals("hello")) {
            addHelloFragment();
        } else if (whatToLoad.equals("another")) {
            addOtherFragment();
        }
    }

    private void addOtherFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, new Another4Fragment(), Another4Fragment.class.getSimpleName())
                .commit();
    }

    private void addHelloFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, new Hello4Fragment(), Hello4Fragment.class.getSimpleName())
                .commit();
    }

}
