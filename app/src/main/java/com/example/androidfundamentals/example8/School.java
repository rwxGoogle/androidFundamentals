package com.example.androidfundamentals.example8;

import com.google.gson.annotations.SerializedName;

/**
 * Created by roxanan on 17,December,2019
 */
public class School {
    @SerializedName("id")
    private String idSchool;
    private String name;
    private String address;
    private String schoolName;

    public String getId() {
        return idSchool;
    }

    public void setId(String id) {
        this.idSchool = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
