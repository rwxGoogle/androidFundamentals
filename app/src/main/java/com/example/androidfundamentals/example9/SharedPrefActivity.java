package com.example.androidfundamentals.example9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidfundamentals.R;

public class SharedPrefActivity extends AppCompatActivity {
    private static final String USER_LOCAL_STORE = "user_local_store";
    private static final String USER_NAME = "user_name";
    private static final String USER_SURNAME = "user_surname";
    private EditText name;
    private EditText surname;
    private TextView nameSurname;

    private String userName;
    private String userSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        userName = "";
        userSurname = "";

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        nameSurname = findViewById(R.id.name_surname);
        nameSurname.setText(userName + userSurname);

        Log.d("TAG", getUserNameSurNameFromSharedPref());
        nameSurname.setText(getUserNameSurNameFromSharedPref());

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        surname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userSurname = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveUserNameInSharedPref(userName);

        saveUserSurNameInSharedPref(userSurname);
    }


    private void saveUserNameInSharedPref(String userName) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    private void saveUserSurNameInSharedPref(String userSurName) {
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_SURNAME, userSurName);
        editor.apply();
    }

    private String getUserNameSurNameFromSharedPref() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);

        return sharedPreferences.getString(USER_NAME, "") + " "
                + sharedPreferences.getString(USER_SURNAME, "");
    }
}
