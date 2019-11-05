package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String ANDROID_LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the text from the label
        TextView label = findViewById(R.id.label);

        String labelText = label.getText().toString();
        Log.d(ANDROID_LOG_TAG, labelText);

        label.setText("Hello Android Developers");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(ANDROID_LOG_TAG, "Click on Button!!");
                ((RatingBar) findViewById(R.id.rating_bar)).setRating(2.0F);
            }
        });

        ((CheckBox) findViewById(R.id.checkbox))
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        Log.d(ANDROID_LOG_TAG, "Click on Checkbox!!" + b);
                    }
                });

        ((EditText) findViewById(R.id.edit_text)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(ANDROID_LOG_TAG, "beforeTextChanged  " + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //this callback is used to see the text filled in Edit Text
                Log.d(ANDROID_LOG_TAG, "onTextChanged  " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(ANDROID_LOG_TAG, "afterTextChanged  " + editable.toString());
            }
        });

        ((Switch) findViewById(R.id.switch_view))
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        Log.d(ANDROID_LOG_TAG, "onCheckedChanged()" + b);
                    }
                });

        ((RatingBar) findViewById(R.id.rating_bar))
                .setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        Log.d(ANDROID_LOG_TAG, "onRating" + ratingBar.getRating() +
                                "from User " + b);
                    }
                });

        ((RadioGroup) findViewById(R.id.radio_group))
                .setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        //i is the id of the RadioButton
                        RadioButton checkedButton = radioGroup.findViewById(i);
                        Log.d(ANDROID_LOG_TAG, "onCheckedChanged  "
                                + checkedButton.getText().toString());
                    }
                });
    }
}
