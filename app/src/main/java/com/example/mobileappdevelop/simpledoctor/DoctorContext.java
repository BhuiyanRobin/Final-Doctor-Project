package com.example.mobileappdevelop.simpledoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class DoctorContext extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "iCare";
    public static final int DATABASE_VERSION = 1;

    public static final String DOCTOR_TABLE = "tbl_doctor";
    public static final String TABLE_COL_DOCTOR_ID = "tbl_id";
    public static final String TABLE_COL_DOCTOR_NAME = "tbl_name";
    public static final String TABLE_COL_DOCTOR_DETAILS = "tbl_details";
    public static final String TABLE_COL_DOCTOR_APPOINTMENT = "tbl_appointment";
    public static final String TABLE_COL_DOCTOR_EMAIL = "tbl_email";
    public static final String TABLE_COL_DOCTOR_PHONE = "tbl_phone";
    public static final String CREATE_TABLE_DOCTOR = "create table "+DOCTOR_TABLE+"("+
            TABLE_COL_DOCTOR_ID+" integer primary key, "+
            TABLE_COL_DOCTOR_NAME+" text, "+
            TABLE_COL_DOCTOR_DETAILS+" text, "+
            TABLE_COL_DOCTOR_APPOINTMENT+" text, "+
            TABLE_COL_DOCTOR_EMAIL+" text,"+
            TABLE_COL_DOCTOR_PHONE+" text);";
    public DoctorContext(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOCTOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DOCTOR_TABLE);
        onCreate(db);
    }
}
