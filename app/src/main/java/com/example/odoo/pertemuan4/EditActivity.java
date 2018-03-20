package com.example.odoo.pertemuan4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    EditText arti;
    protected Cursor cursor;
    DatabaseIstilah dbHelper;
    Button edit;
    EditText istilah;
    EditText keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

        dbHelper = new DatabaseIstilah(this);
        this.istilah = findViewById(R.id.istilah);
        this.arti = findViewById(R.id.arti);
        this.keterangan = findViewById(R.id.keterangan);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM tableIstilah WHERE istilah = '" + getIntent().getStringExtra(DatabaseIstilah.ISTILAH) + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            this.istilah.setText(this.cursor.getString(1).toString());
            this.arti.setText(this.cursor.getString(2).toString());
            this.keterangan.setText(this.cursor.getString(3).toString());
        }
        this.edit = findViewById(R.id.edit_button);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update tableIstilah set istilah='" + istilah.getText().toString() + "', arti='" + arti.getText().toString() + "', keterangan='" + keterangan.getText().toString() + "' where _id='" + cursor.getInt(0) + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
