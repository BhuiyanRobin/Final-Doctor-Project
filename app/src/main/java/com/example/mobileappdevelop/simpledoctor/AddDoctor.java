package com.example.mobileappdevelop.simpledoctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddDoctor extends Activity {

    private EditText addfullnhameEt;
    private EditText addspecialityEt;
    private EditText addappoinmentEt;
    private EditText addphoneEt;
    private EditText addemailEt;
    DoctorService _doctorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);
_doctorService=new DoctorService(this);

        addfullnhameEt = (EditText) findViewById(R.id.a_d_fullnhame);
        addspecialityEt = (EditText) findViewById(R.id.a_d_speciality);
        addappoinmentEt = (EditText) findViewById(R.id.a_d_appoinment);
        addphoneEt = (EditText) findViewById(R.id.a_d_phone);
        addemailEt = (EditText) findViewById(R.id.a_d_email);
    }

    public void addDoctor(View view) {
        String name = addfullnhameEt.getText().toString();
        String speciality = addspecialityEt.getText().toString();
        String appointment = addappoinmentEt.getText().toString();
        String phone = addphoneEt.getText().toString();
        String email = addemailEt.getText().toString();

        Doctor aDoctor=new Doctor(name,speciality,appointment,phone,email,0);
        _doctorService.Add(aDoctor);
        Intent myIntent = new Intent(view.getContext(),
                DoctorsList.class);
        startActivityForResult(myIntent, 0);
        finish();
    }
}
