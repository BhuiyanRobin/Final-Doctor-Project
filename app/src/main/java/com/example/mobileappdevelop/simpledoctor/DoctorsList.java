package com.example.mobileappdevelop.simpledoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DoctorsList extends AppCompatActivity {

    private ListView doctorsListView;
    private ArrayList<Doctor> myDoctorList;

    Doctor doctors;
    DoctorAdapter doctorAdapter;
    DoctorService _doctorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        _doctorService=new DoctorService(this);


        doctorsListView = (ListView) findViewById(R.id.doctorsListView);
        myDoctorList = new ArrayList<Doctor>();
        doctors = new Doctor();

        myDoctorList = _doctorService.GetAll();

        doctorAdapter = new DoctorAdapter(this,myDoctorList);

        doctorsListView.setAdapter(doctorAdapter);


        doctorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int count = 0;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Doctor selectedDoctor = myDoctorList.get(position);

                Toast.makeText(DoctorsList.this,myDoctorList.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent  = new Intent(DoctorsList.this,ShowDoctorDetaile.class);

                intent.putExtra("name",selectedDoctor.getName());
                intent.putExtra("speciality",selectedDoctor.getDetails());
                intent.putExtra("appoinmentDate",selectedDoctor.getAppoinment());
                intent.putExtra("phone",selectedDoctor.getPhone());
                intent.putExtra("email",selectedDoctor.getEmail());
                startActivity(intent);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),
                        AddDoctor.class);
                startActivityForResult(myIntent, 0);
                finish();
            }
        });
    }

}
