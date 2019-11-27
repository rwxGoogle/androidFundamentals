package com.example.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by roxanan on 26,November,2019
 */
public class ActivityLifecycle5 extends AppCompatActivity {
    public static final String LOG_TAG = ActivityLifecycle5.class.getSimpleName();
    public static final String ANDROID_KEY = "android_key";
    private static final String SAVE_INSTANCE_STATE = "save_instance_state";
    private static final int REQEST_CODE = 150;
    private String usernameString = "";
    TextView username;
    Button navigate;
    EditText usernameInput;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lifecycle5);

        initViews();

        Log.d(LOG_TAG, "onCreate, savedInstanceState= " + savedInstanceState);

        if (savedInstanceState != null) {
            String saveInstanceStateText = savedInstanceState.getString(SAVE_INSTANCE_STATE);
            username.setText(saveInstanceStateText);
        }

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startSecondActivity();

                //startSecondActivityForResult();

                call();
            }
        });

        usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usernameString = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    //explicit intent
    private void startSecondActivity() {
        Intent intent = new Intent(ActivityLifecycle5.this,
                ActivitySecondLifecycle5.class);

        intent.putExtra(ANDROID_KEY, usernameString);

        startActivity(intent);
    }

    //explicit intent
    private void startSecondActivityForResult() {
        Intent intent = new Intent(ActivityLifecycle5.this,
                ActivitySecondLifecycle5.class);
        intent.putExtra(ANDROID_KEY, usernameString);

        startActivityForResult(intent, REQEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d(LOG_TAG, "result ok");
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        String greetings = bundle.getString(ActivitySecondLifecycle5.GREEDINGS_KEY);
                        username.setText(greetings);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d(LOG_TAG, "result canceled");
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        Log.d(LOG_TAG, "onSaveInstanceState");

//        String androidFundamentals = "Android Fundamentals Course 5";
//        outState.putString(SAVE_INSTANCE_STATE, androidFundamentals);

        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(LOG_TAG, "onSaveInstanceState");

        String androidFundamentals = "Android Fundamentals Course 5";
        outState.putString(SAVE_INSTANCE_STATE, androidFundamentals);

        super.onSaveInstanceState(outState);
    }

    private void initViews() {
        username = findViewById(R.id.username);
        navigate = findViewById(R.id.navigateButton);
        usernameInput = findViewById(R.id.username_input);
    }

    //implicit intent
    private void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0040012345"));
        startActivity(intent);
    }
}
