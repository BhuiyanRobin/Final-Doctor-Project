package com.example.mobileappdevelop.simpledoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class DoctorService {
    private DoctorContext doctorContext;
    private SQLiteDatabase sqLiteDatabase;

    public DoctorService(Context context) {
        doctorContext = new DoctorContext(context);
    }
    public void open(){
        sqLiteDatabase = doctorContext.getWritableDatabase();
    }
    public void close(){
        doctorContext.close();
    }


    public ArrayList<Doctor> GetAll()
    {
        ArrayList<Doctor> doctors=new ArrayList<Doctor>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(doctorContext.DOCTOR_TABLE,null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor!=null&&cursor.getCount()>0)
        {
            for(int i = 0; i < cursor.getCount(); i++){

                Doctor aDoctor=new Doctor();

                aDoctor.setId(cursor.getInt(cursor.getColumnIndex(DoctorContext.TABLE_COL_DOCTOR_ID)));
                aDoctor.setName(cursor.getString(cursor.getColumnIndex(DoctorContext.TABLE_COL_DOCTOR_NAME)));
                aDoctor.setAppoinment(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_APPOINTMENT)));
                aDoctor.setDetails(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_DETAILS)));
                aDoctor.setPhone(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_PHONE)));
                aDoctor.setEmail(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_EMAIL)));

                doctors.add(aDoctor);

                cursor.moveToNext();
            }
        }
        this.close();
        return doctors;
    }
    public boolean Add(Doctor aDoctor)
    {
        this.open();
        ContentValues values = new ContentValues();
        values.put(doctorContext.TABLE_COL_DOCTOR_NAME,aDoctor.getName());
        values.put(doctorContext.TABLE_COL_DOCTOR_DETAILS,aDoctor.getDetails());
        values.put(doctorContext.TABLE_COL_DOCTOR_APPOINTMENT,aDoctor.getAppoinment());
        values.put(doctorContext.TABLE_COL_DOCTOR_PHONE,aDoctor.getPhone());
        values.put(doctorContext.TABLE_COL_DOCTOR_EMAIL,aDoctor.getEmail());

        long id = sqLiteDatabase.insert(doctorContext.DOCTOR_TABLE,null,values);
        this.close();
        if(id > 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean Update(Doctor aDoctor)
    {
        this.open();
        ContentValues values = new ContentValues();
        values.put(DoctorContext.TABLE_COL_DOCTOR_NAME,aDoctor.getName());
        values.put(DoctorContext.TABLE_COL_DOCTOR_DETAILS,aDoctor.getName());
        values.put(DoctorContext.TABLE_COL_DOCTOR_APPOINTMENT,aDoctor.getName());
        values.put(DoctorContext.TABLE_COL_DOCTOR_PHONE,aDoctor.getName());
        values.put(DoctorContext.TABLE_COL_DOCTOR_EMAIL,aDoctor.getName());
        int rowId = sqLiteDatabase.update(DoctorContext.DOCTOR_TABLE,values,DoctorContext.TABLE_COL_DOCTOR_ID+" = ?",new String[]{Integer.toString(aDoctor.getId())});
        this.close();

        if(rowId > 0){
            return true;
        }else{
            return false;
        }

    }
    public boolean Remove(int id)
    {
        this.open();
        int deleted = sqLiteDatabase.delete(DoctorContext.DOCTOR_TABLE,DoctorContext.TABLE_COL_DOCTOR_ID+" = ?",new String[]{Integer.toString(id)});
        this.close();
        if(deleted > 0){
            return true;
        }else{
            return false;
        }

    }
    public Doctor Find(int id)
    {
        Doctor aDoctor=new Doctor();
        this.open();
        Cursor cursor = sqLiteDatabase.query(doctorContext.DOCTOR_TABLE,new String[]{DoctorContext.TABLE_COL_DOCTOR_ID},Integer.toString(id),null,null,null,null);
        while (cursor.moveToNext())
        {
            aDoctor.setId(cursor.getInt(cursor.getColumnIndex(DoctorContext.TABLE_COL_DOCTOR_ID)));
            aDoctor.setName(cursor.getString(cursor.getColumnIndex(DoctorContext.TABLE_COL_DOCTOR_NAME)));
            aDoctor.setAppoinment(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_APPOINTMENT)));
            aDoctor.setDetails(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_DETAILS)));
            aDoctor.setPhone(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_PHONE)));
            aDoctor.setEmail(cursor.getString(cursor.getColumnIndex(doctorContext.TABLE_COL_DOCTOR_EMAIL)));

        }
        this.close();
        return aDoctor;
    }
}
