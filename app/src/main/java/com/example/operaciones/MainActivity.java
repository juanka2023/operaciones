package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;
    private TextView tv_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //Método el botón Siguiente
    public void jugar(View view) {
        Intent jugar = new Intent(this, Mainnivel1.class);
        startActivity(jugar);
        finish();


    }
}