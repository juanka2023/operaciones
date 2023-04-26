package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mainnivel1 extends AppCompatActivity {

    private TextView tv_nombre, tv_score, tv_invisible, tv_invisible2;
    private ImageView iv_Auno, iv_Ados, iv_vidas;
    private EditText et_respuesta;
    private MediaPlayer mp, mp_great, mp_bad;

    int score, numAleatorio_uno, numAleatorio_dos, resultado, vidas = 3;
    String nombre_jugador, string_score, string_vidas;

    String NombreBaseDatos = "administracion";

   //"no hace falta en mi caso" String numero[] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};


    @SuppressLint({"MissingInflatedId", "RestrictedApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnivel1);

        tv_nombre = findViewById(R.id.tvnombre);
        tv_score = findViewById(R.id.tvscore);
        et_respuesta = findViewById(R.id.etresultado);
        iv_Auno = findViewById(R.id.ivvalor1);
        iv_Ados = findViewById(R.id.ivvalor2);
        iv_vidas = findViewById(R.id.ivida);
        tv_invisible = findViewById(R.id.tv_invisible);

        String texto = getIntent().getStringExtra("texto");
        tv_nombre.setText("Jugador: " + texto);

        int numeroAleatorio1 = (int) (Math.random() * 10);
        int resultado = 10 - numeroAleatorio1;
        int numeroAleatorio2 = (int) (Math.random() * resultado);
        int operacion = numeroAleatorio1 + numeroAleatorio2;

        tv_invisible.setText(Integer.toString(operacion));



        switch (numeroAleatorio1){
            case 0:
                iv_Auno.setImageResource(R.drawable.cero);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 1:
                iv_Auno.setImageResource(R.drawable.uno);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 2:
                iv_Auno.setImageResource(R.drawable.dos);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 3:
                iv_Auno.setImageResource(R.drawable.tres);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 4:
                iv_Auno.setImageResource(R.drawable.cuatro);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 5:
                iv_Auno.setImageResource(R.drawable.cinco);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 6:
                iv_Auno.setImageResource(R.drawable.seis);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 7:
                iv_Auno.setImageResource(R.drawable.siete);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 8:
                iv_Auno.setImageResource(R.drawable.ocho);
                tv_invisible.setText(numeroAleatorio1);
                break;
            case 9:
                iv_Auno.setImageResource(R.drawable.nueve);
                tv_invisible.setText(numeroAleatorio1);
                break;
        }

        switch (numeroAleatorio2){
            case 0:
                iv_Ados.setImageResource(R.drawable.cero);
                break;
            case 1:
                iv_Ados.setImageResource(R.drawable.uno);
                break;
            case 2:
                iv_Ados.setImageResource(R.drawable.dos);
                break;
            case 3:
                iv_Ados.setImageResource(R.drawable.tres);
                break;
            case 4:
                iv_Ados.setImageResource(R.drawable.cuatro);
                break;
            case 5:
                iv_Ados.setImageResource(R.drawable.cinco);
                break;
            case 6:
                iv_Ados.setImageResource(R.drawable.seis);
                break;
            case 7:
                iv_Ados.setImageResource(R.drawable.siete);
                break;
            case 8:
                iv_Ados.setImageResource(R.drawable.ocho);
                break;
            case 9:
                iv_Ados.setImageResource(R.drawable.nueve);
                break;
        }
    }

    public void comprobar(View view) {
        String respuesta = et_respuesta.getText().toString();
        String numeroInvi_String = tv_invisible.getText().toString();
        String numeroInvi2_String = tv_invisible2.getText().toString();

        int valor1_int = Integer.parseInt(numeroInvi_String);
        int valor2_int = Integer.parseInt(numeroInvi2_String);

        if (!respuesta.equals("")) {
            mp_great = MediaPlayer.create(this, R.raw.acierto);
            //int respuesta_jugador = Integer.parseInt(numeroInvi_String);
            if (resultado == valor1_int) {
                score++;
                tv_score.setText(score);
            } else {
                mp_bad = MediaPlayer.create(this, R.raw.fallo);
                vidas--;

                switch (vidas) {
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
                        Toast.makeText(this, "Has perdido", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        mp.stop();
                        mp.release();
                        break;
                }
                tv_score.setText(score);
            }
        }
        mp = MediaPlayer.create(this, R.raw.pasodenivel);
        mp.start();
        mp.setLooping(true);
    }

    /*public void NumAleatorio() {
        if (score <= 9) {

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

        } else {
            Intent intent = new Intent(this, MainActivityNivel2.class);

            string_score = String.valueOf(score);
            string_vidas = String.valueOf(vidas);
            intent.putExtra("jugador", nombre_jugador);
            intent.putExtra("score", string_score);
            intent.putExtra("vidas", string_vidas);

            startActivity(intent);
            finish();
            mp.stop();
            mp.release();
        }
    }*/

}

