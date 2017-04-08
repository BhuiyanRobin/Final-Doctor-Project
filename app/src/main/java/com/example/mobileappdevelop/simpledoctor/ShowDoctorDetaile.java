package com.example.mobileappdevelop.simpledoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDoctorDetaile extends AppCompatActivity {

    private String name;
    private String speciality;
    private String appoinmentDate;
    private String phone;
    private String email;

    private TextView doctorNameTv;
    private TextView doctorSpecialityTv;
    private TextView doctorAppointmentTv;
    private TextView doctorPhoneTv;
    private TextView doctorEmailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctor_detaile);

        Intent intent = getIntent();
        name  = intent.getStringExtra("name");
        speciality  = intent.getStringExtra("speciality");
        appoinmentDate  = intent.getStringExtra("appoinmentDate");
        phone  = intent.getStringExtra("phone");
        email  = intent.getStringExtra("email");

        doctorNameTv = (TextView) findViewById(R.id.dp_doctorName);
        doctorSpecialityTv = (TextView) findViewById(R.id.dp_doctorSpeciality);
        doctorAppointmentTv = (TextView) findViewById(R.id.dp_doctorAppointment);
        doctorPhoneTv = (TextView) findViewById(R.id.dp_doctorPhone);
        doctorEmailTv = (TextView) findViewById(R.id.dp_doctorEmail);


        doctorNameTv.setText(name);
        doctorSpecialityTv.setText(speciality);
        doctorAppointmentTv.setText(appoinmentDate);
        doctorPhoneTv.setText(phone);
        doctorEmailTv.setText(email);
    }
}
