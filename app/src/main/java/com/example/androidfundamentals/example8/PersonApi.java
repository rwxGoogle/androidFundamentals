package com.example.androidfundamentals.example8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {

    @GET("/rwxGoogle/androidFundamentals/master/{fileName}")
    Call<List<User>> getPersons(@Path("fileName") String jsonToFetch);
}
