package com.example.odoo.pertemuan4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText arti;
    protected Cursor cursor;
    DatabaseIstilah dbHelper;
    EditText istilah;
    EditText keterangan;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        dbHelper = new DatabaseIstilah(this);
        this.istilah = (EditText) findViewById(R.id.istilah);
        this.arti = (EditText) findViewById(R.id.arti);
        this.keterangan = (EditText) findViewById(R.id.keterangan);
        this.btn = (Button) findViewById(R.id.add_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into tableIstilah (istilah, arti, keterangan) values('" + istilah.getText().toString() + "','" + arti.getText().toString() + "','" + keterangan.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
