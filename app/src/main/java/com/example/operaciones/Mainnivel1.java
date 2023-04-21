package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mainnivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score;
    private ImageView ivvuno, ivvdos, avvida;
    private EditText et_respuesta;

    int score, numAlealeatorio_uno,numAlealeatorio_dos, resultado, vida = 3;
    String nombre_jugador, string_score, string_vidas;

    String numero [] = {"cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};

    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnivel1);


        Toast.makeText(this, "nivel 1, sumas basicas", Toast.LENGTH_SHORT).show();

        tv_nombre = (TextView) findViewById(R.id.tvnombre);
        tv_score = (TextView) findViewById(R.id.tvscore);
        avvida = (ImageView) findViewById(R.id.iv_vida);
        ivvdos= (ImageView) findViewById(R.id.ivvalordos);
        ivvuno = (ImageView) findViewById(R.id.ivvalor1);
        et_respuesta = (EditText) findViewById(R.id.et_respuestas;

        nombre_jugador = getIntent().getStringExtra("jugador");
        tv_nombre.setText("Jugador: " + nombre_jugador);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }

}