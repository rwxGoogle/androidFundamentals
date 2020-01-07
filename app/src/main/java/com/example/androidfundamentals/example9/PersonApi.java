package com.example.androidfundamentals.example9;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {

    @GET("/rwxGoogle/androidFundamentals/master/{fileName}")
    Call<List<Person>> getPersons(@Path("fileName") String jsonToFetch);
}
