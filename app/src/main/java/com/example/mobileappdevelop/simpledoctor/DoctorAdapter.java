package com.example.mobileappdevelop.simpledoctor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nocturnal on 07-Apr-17.
 */

public class DoctorAdapter extends ArrayAdapter{

    private Context context;
    private ArrayList<Doctor> doctors;

    public DoctorAdapter(@NonNull Context context, ArrayList<Doctor> doctors) {
        super(context,R.layout.custom_layout ,doctors );
        this.context = context;
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_layout,parent,false);

        TextView doctorName = (TextView) convertView.findViewById(R.id.doctorName);
        TextView doctorSpeciality = (TextView) convertView.findViewById(R.id.doctorSpeciality);

        doctorName.setText(doctors.get(position).getName());
        doctorSpeciality.setText(doctors.get(position).getDetails());

        return convertView;
    }
}
