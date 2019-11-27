package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySecondLifecycle5 extends AppCompatActivity {
    public static final String LOG_TAG = ActivitySecondLifecycle5.class.getSimpleName();
    public static final String GREEDINGS_KEY = "greetings_key";
    TextView textView;
    Button finish;
    EditText greetingsInput;
    String greetings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_lifecycle5);

        textView = findViewById(R.id.second_username);
        finish = findViewById(R.id.finish);
        greetingsInput = findViewById(R.id.greetings_input);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String username = bundle.getString(ActivityLifecycle5.ANDROID_KEY);

            textView.setText(username);
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(GREEDINGS_KEY, greetings);
                setResult(Activity.RESULT_CANCELED, intent);
                finish();
            }
        });

        greetingsInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                greetings = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy");
    }
}
