package com.example.androidfundamentals.example8;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMainActivity extends AppCompatActivity {

    private static final String TAG = RetrofitMainActivity.class.getSimpleName();
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retofit_main_activity);

        PersonApi api = getRetrofit().create(PersonApi.class);
        Call<List<User>> persons = api.getPersons("test_json2");
        persons.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());
                    List<User> users = response.body();

                    for (User user : users){
                        Log.d(TAG, "User name: " + user.getName());
                    }
                } else {

                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
