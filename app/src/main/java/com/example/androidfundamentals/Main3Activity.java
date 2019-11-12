package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    private static final String URL = "http://developer.android.com";
    private static final String TAG = Main3Activity.class.getSimpleName();
    private WebView webView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        spinner.setAdapter(getSpinnerAdapter());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(URL);

        initListeners();
    }

    private void initViews() {
        webView = findViewById(R.id.web_view);
        spinner = findViewById(R.id.spinner);
    }

    private void initListeners() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemSelected(), i= " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(TAG, "onNothingSelected()");
            }
        });
    }

    private List<String> getAndroidVersionsList() {
        List<String> androidVersions = new ArrayList();
        androidVersions.add("Api 21");
        androidVersions.add("Api 22");
        androidVersions.add("Api 23");
        androidVersions.add("Api 28");
        androidVersions.add("Api 29");
        return androidVersions;
    }

    private ArrayAdapter<String> getSpinnerAdapter() {
        return new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getAndroidVersionsList());
    }
}
