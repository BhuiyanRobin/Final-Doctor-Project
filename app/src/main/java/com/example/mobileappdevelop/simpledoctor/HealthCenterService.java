package com.example.mobileappdevelop.simpledoctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class HealthCenterService {
    private HealthCenterContext healthCenterContext;
    private SQLiteDatabase sqLiteDatabase;

    public HealthCenterService(Context context) {
        healthCenterContext = new HealthCenterContext(context);
    }
    public void open(){
        sqLiteDatabase = healthCenterContext.getWritableDatabase();
    }
    public void close(){
        healthCenterContext.close();
    }


    public ArrayList<HealthCenter> GetAll()
    {
        ArrayList<HealthCenter> healthCenters=new ArrayList<HealthCenter>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(healthCenterContext.HEALTH_CENTER_TABLE,null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor!=null&&cursor.getCount()>0)
        {
            for(int i = 0; i < cursor.getCount(); i++){

                HealthCenter healthCenter=new HealthCenter();

                healthCenter.setId(cursor.getInt(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DOCTOR_ID)));
                healthCenter.setDocId(cursor.getInt(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DOCTOR_ID)));
                healthCenter.setDetails(cursor.getString(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DETAILS)));
                healthCenter.setDate(cursor.getString(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DATE)));

                healthCenters.add(healthCenter);

                cursor.moveToNext();
            }
        }
        this.close();
        return healthCenters;
    }
    public boolean Add(HealthCenter healthCenter)
    {
        this.open();
        ContentValues values = new ContentValues();

        values.put(healthCenterContext.TABLE_COL_DOCTOR_ID,healthCenter.getDocId());
        values.put(healthCenterContext.TABLE_COL_DETAILS,healthCenter.getDetails());
        values.put(healthCenterContext.TABLE_COL_DATE,healthCenter.getDate());
        values.put(healthCenterContext.TABLE_COL_PREP_POSITION,healthCenter.getPescription());

        long id = sqLiteDatabase.insert(healthCenterContext.HEALTH_CENTER_TABLE,null,values);
        this.close();
        if(id > 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean Update(HealthCenter healthCenter)
    {
        this.open();
        ContentValues values = new ContentValues();
        values.put(healthCenterContext.TABLE_COL_DOCTOR_ID,healthCenter.getDocId());
        values.put(healthCenterContext.TABLE_COL_DETAILS,healthCenter.getDetails());
        values.put(healthCenterContext.TABLE_COL_DATE,healthCenter.getDate());
        values.put(healthCenterContext.TABLE_COL_PREP_POSITION,healthCenter.getPescription());
        int rowId = sqLiteDatabase.update(healthCenterContext.HEALTH_CENTER_TABLE,values,healthCenterContext.TABLE_COL_DOCTOR_ID+" = ?",new String[]{Integer.toString(healthCenter.getId())});
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
        int deleted = sqLiteDatabase.delete(healthCenterContext.HEALTH_CENTER_TABLE,healthCenterContext.TABLE_COL_HEALTH_ID+" = ?",new String[]{Integer.toString(id)});
       this.close();
        if(deleted > 0){
            return true;
        }else{
            return false;
        }
    }
    public HealthCenter Find(int id)
    {
        HealthCenter healthCenter=new HealthCenter();
        this.open();
        Cursor cursor = sqLiteDatabase.query(healthCenterContext.HEALTH_CENTER_TABLE,new String[]{healthCenterContext.TABLE_COL_HEALTH_ID},Integer.toString(id),null,null,null,null);
        while (cursor.moveToNext())
        {
            healthCenter.setId(cursor.getInt(cursor.getColumnIndex(healthCenterContext.TABLE_COL_HEALTH_ID)));
            healthCenter.setDocId(cursor.getInt(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DOCTOR_ID)));
            healthCenter.setDetails(cursor.getString(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DETAILS)));
            healthCenter.setDate(cursor.getString(cursor.getColumnIndex(healthCenterContext.TABLE_COL_DATE)));
            healthCenter.setPescription(cursor.getInt(cursor.getColumnIndex(healthCenterContext.TABLE_COL_PREP_POSITION)));

        }
        this.close();
        return healthCenter;
    }
}
