package com.example.mobileappdevelop.simpledoctor;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class Doctor {
    private  String name;
    private String details;
    private  String appoinment;
    private String phone;
    private String email;
    private int id;
//region Constructor


    public Doctor(String name, String details, String appoinment, String phone, String email, int id) {
        this.name = name;
        this.details = details;
        this.appoinment = appoinment;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    public Doctor() {
    }
    //endregion

    //region Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppoinment(String appoinment) {
        this.appoinment = appoinment;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //endregion

    //region Getter

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    public String getAppoinment() {
        return appoinment;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    //endregion

    //region Method


    //endregion
}
