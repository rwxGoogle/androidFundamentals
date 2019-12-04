package com.example.androidfundamentals.w6examples.example3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

/**
 * Created by roxanan on 17,April,2019
 */
public class Example3Activity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

        Hello3Fragment fragment = new Hello3Fragment();
        fragment.setListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, fragment, Hello3Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void theseAreTheNumbers(int no1, int no2) {
        Toast.makeText(this, "These are the numbers, no1: " + no1 + " no2: " + no2, Toast.LENGTH_LONG)
                .show();
    }


    public void getHello() {

    }
}