package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityForFragments6 extends AppCompatActivity implements Listener {
    public static final String LOG_TAG = ActivityForFragments6.class.getSimpleName();
    public static final String KEY = "key";
    TextView activityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_fragments6);
        Log.d(LOG_TAG, "onCreate");
        activityTextView = findViewById(R.id.activity_text_view);

        Bundle bundle = new Bundle();
        bundle.putString(KEY, "Hello people of the day.");

        startFragmentDynamic(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "onResume");

        callMethodFromActivityToSetText();


    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(LOG_TAG, "onRestart");
    }

    private void callMethodFromActivityToSetText() {
        FirstFragment6 firstFragment6 = (FirstFragment6) getSupportFragmentManager()
                .findFragmentByTag(FirstFragment6.class.getSimpleName());
        firstFragment6.setTextForTextView1("hello this is the new text");

        firstFragment6.setLister(this);
    }

    private void startFragmentDynamic(Bundle bundle) {
        FirstFragment6 fragment6 = new FirstFragment6();
        fragment6.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,
                        fragment6,
                        FirstFragment6.class.getSimpleName())
                .commit();
    }

    @Override
    public void setText(String string) {
        activityTextView.setText(string);
    }
}
