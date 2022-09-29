package com.example.mad6;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import  com.example.mad6.TableSchema;

public class TableSchemaDBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "worksheet6";
    public TableSchemaDBHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE " + TableSchema.MadSixSchema.WorkSheet6 + "(" + TableSchema.MadSixSchema.Cols.ID + " INTEGER, " + TableSchema.MadSixSchema.Cols.NAME + " TEXT, " + TableSchema.MadSixSchema.Cols.STRENGTH + " INTEGER, " + TableSchema.MadSixSchema.Cols.RELATIONSHIP + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

    }
}
