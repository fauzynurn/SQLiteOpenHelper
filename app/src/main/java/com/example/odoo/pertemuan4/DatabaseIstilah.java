package com.example.odoo.pertemuan4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseIstilah extends SQLiteOpenHelper {
    public static final String ARTI = "arti";
    private static final String DATABASE_NAME = "dbIstilah2";
    private static final int DATABASE_VERSION = 1;
    public static final String ISTILAH = "istilah";
    public static final String KETERANGAN = "keterangan";

    public DatabaseIstilah(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tableIstilah(_id integer primary key autoincrement, istilah text null, arti text null, keterangan text null);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
