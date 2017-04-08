package com.example.mobileappdevelop.simpledoctor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bhuiy on 4/6/2017.
 */

public class HealthCenterContext extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "iCare";
    public static final int DATABASE_VERSION = 1;

    public static final String HEALTH_CENTER_TABLE = "tbl_health_center";
    public static final String TABLE_COL_HEALTH_ID = "tbl_id";
    public static final String TABLE_COL_DOCTOR_ID = "tbl_DocId";
    public static final String TABLE_COL_DETAILS = "tbl_details";
    public static final String TABLE_COL_DATE = "tbl_date";
    public static final String TABLE_COL_PREP_POSITION = "tbl_prepPosition";
    public static final String CREATE_TABLE_HEALTH_CENTER = "create table "+HEALTH_CENTER_TABLE+"("+
            TABLE_COL_HEALTH_ID+" integer primary key, "+
            TABLE_COL_DOCTOR_ID+" integer, "+
            TABLE_COL_DETAILS+" text, "+
            TABLE_COL_PREP_POSITION+" Integer, "+
            TABLE_COL_DATE+" date);";
    public HealthCenterContext(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HEALTH_CENTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+HEALTH_CENTER_TABLE);
        onCreate(db);
    }
}
