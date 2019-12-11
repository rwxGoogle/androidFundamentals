package com.example.androidfundamentals.w6examples.example4;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

/**
 * Created by roxanan on 17,April,2019
 */
public class Example4Activity extends AppCompatActivity implements Listener {
    static final String LABEL_WHAT_TO_LOAD = "whatToLoad";

    private boolean userPressedBackForFirstTime = false;
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);

//        this.isLandscape = findViewById(R.id.detail) != null;
//
//        if (savedInstanceState == null) {
//            MasterFragment masterFragment = new MasterFragment();
//            masterFragment.setListener(this);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.master, masterFragment, MasterFragment.class.getSimpleName())
//                    .commit();
//        } else {
//            Fragment masterFragment = getSupportFragmentManager().findFragmentByTag(MasterFragment.class.getSimpleName());
//            if (masterFragment != null) {
//                ((MasterFragment) masterFragment).setListener(this);
//            }
//        }
    }

    @Override
    public void showHello4Fragment() {
        if (isLandscape) {
            addHelloFragment();
        } else {
            Intent intent = new Intent(this, MasterActivity.class);
            intent.putExtra(LABEL_WHAT_TO_LOAD, "hello");
            startActivity(intent);
        }
    }

    @Override
    public void showAnother4Fragment() {
        if (isLandscape) {
            addOtherFragment();
        } else {
            Intent intent = new Intent(this, MasterActivity.class);
            intent.putExtra(LABEL_WHAT_TO_LOAD, "another");
            startActivity(intent);
        }
    }

    private void addOtherFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, new Another4Fragment(), Another4Fragment.class.getSimpleName())
                .commit();
    }

    private void addHelloFragment() {
        Hello4Fragment fragment = new Hello4Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, fragment, Hello4Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (!userPressedBackForFirstTime) {
            Toast.makeText(this, "To exit press back again", Toast.LENGTH_LONG)
                    .show();
            userPressedBackForFirstTime = true;
        } else {
            super.onBackPressed();
        }
    }
}
