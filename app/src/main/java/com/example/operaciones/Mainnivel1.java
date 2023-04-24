package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mainnivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score;
    private ImageView iv_Auno, iv_Ados, iv_vidas;
    private EditText et_respuesta;
    private MediaPlayer mp, mp_great, mp_bad;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas = 3;
    String nombre_jugador, string_score, string_vidas;

    String numero [] = {"cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve"};


    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnivel1);

        tv_nombre = findViewById(R.id.tvnombre);
        tv_score = findViewById(R.id.tvscore);
        et_respuesta = findViewById(R.id.etresultado);

        String texto = getIntent().getStringExtra("texto");
        tv_nombre.setText("Jugador: " + texto);


    }
    public void comprobar (View view){
        String respuesta = et_respuesta.getText().toString();

        if (!respuesta.equals("")){
            //musica cuando se tenga
            int respuesta_jugador = Integer.parseInt(respuesta);
            if (resultado == respuesta_jugador){
                score++;
                tv_score.setText(score);
            }else {
                //musica cuando la tengamos
                vidas--;

                switch (vidas){
                    case 3:
                         iv_vidas.setImageResource(R.drawable.tequeda3vida);
                        break;
                    case 2:
                        Toast.makeText(this, "te quedan dos coches", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.tequeda2vida);
                        break;
                    case 1:
                        Toast.makeText(this, "Te queda un coche", Toast.LENGTH_SHORT).show();
                        iv_vidas.setImageResource(R.drawable.tequeda1vida);
                        break;
                    case 0:
                        Toast.makeText(this, "Has pierdido", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        // mp.stop();
                        // mp.release();
                        break;
                }
                tv_score.setText(score);
            }
            NumAleatorio();
        }
    }
    public void NumAleatorio(){
        if(score <= 9) {

            numAleatorio_uno = (int) (Math.random() * 10);
            numAleatorio_dos = (int) (Math.random() * 10);

            resultado = numAleatorio_uno + numAleatorio_dos;

            if (resultado <= 10) {

                for (int i = 0; i < numero.length; i++) {
                    int id = getResources().getIdentifier(numero[i], "drawable", getPackageName());
                    if (numAleatorio_uno == i) {
                        iv_Auno.setImageResource(id);
                    }
                    if (numAleatorio_dos == i) {
                        iv_Ados.setImageResource(id);
                    }
                }

            } else {
                NumAleatorio();
            }

        }
        }
        }
