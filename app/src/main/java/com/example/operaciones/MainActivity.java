package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Método el botón Siguiente
    public void jugar(View view){
        Intent jugar = new Intent(this,Mainnivel1.class);
        startActivity(jugar);
    }
}