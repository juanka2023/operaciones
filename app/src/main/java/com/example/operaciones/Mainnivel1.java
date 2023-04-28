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

    private TextView tv_nombre, tv_score, tv_invisible, tv_invisible2 , vidas;
    private ImageView iv_Auno, iv_Ados, iv_vidas;
    private EditText et_respuesta;
    private MediaPlayer mp, mp_great, mp_bad;

    int score, numAleatorio_uno, numAleatorio_dos, resultado;
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
        iv_vidas = findViewById(R.id.iv_vida3);
        tv_invisible = findViewById(R.id.tv_invisible);
        tv_invisible2 = findViewById(R.id.tv_invisible2);
        vidas = findViewById(R.id.tv_vidas);

        String nombre = getIntent().getStringExtra("nombre");
        tv_nombre.setText(nombre);

        int puntosInt = getIntent().getIntExtra("npuntos", 0);
        if (puntosInt==0) {
            tv_score.setText("0");
        }else {
            String valor = String.valueOf(puntosInt);
            tv_score.setText(valor);
        }

        //String vidas_string = getIntent().getStringExtra("vidas");
        //vidas.setText(vidas_string);
        int vidasInt =getIntent().getIntExtra("nvidas",3);

        if(vidas.getText().toString().equals("1")){
            iv_vidas.setImageResource(R.drawable.tequeda1vida);
        }else if(vidas.getText().toString().equals("2")){
            iv_vidas.setImageResource(R.drawable.tequeda2vida);
        }else if(vidas.getText().toString().equals("3")){
            iv_vidas.setImageResource(R.drawable.tequeda3vida);
        }

        mp = MediaPlayer.create(this, R.raw.pasodenivel);
        mp.start();
        mp.setLooping(true);

        mp_great = MediaPlayer.create(this, R.raw.acierto);
        mp_bad = MediaPlayer.create(this, R.raw.fallo);


        int numeroAleatorio1 = (int) (Math.random() * 10);
        int resultado = 10 - numeroAleatorio1;
        int numeroAleatorio2 = (int) (Math.random() * resultado);
        int operacion = numeroAleatorio1 + numeroAleatorio2;

        tv_invisible.setText(Integer.toString(operacion));
        //tv_invisible2.setText(Integer.toString(operacion));


        switch (numeroAleatorio1) {
            case 0:
                iv_Auno.setImageResource(R.drawable.cero);

                break;
            case 1:
                iv_Auno.setImageResource(R.drawable.uno);

                break;
            case 2:
                iv_Auno.setImageResource(R.drawable.dos);

                break;
            case 3:
                iv_Auno.setImageResource(R.drawable.tres);

                break;
            case 4:
                iv_Auno.setImageResource(R.drawable.cuatro);

                break;
            case 5:
                iv_Auno.setImageResource(R.drawable.cinco);

                break;
            case 6:
                iv_Auno.setImageResource(R.drawable.seis);

                break;
            case 7:
                iv_Auno.setImageResource(R.drawable.siete);

                break;
            case 8:
                iv_Auno.setImageResource(R.drawable.ocho);

                break;
            case 9:
                iv_Auno.setImageResource(R.drawable.nueve);

                break;
        }

        switch (numeroAleatorio2) {
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
        String scoreString = tv_score.getText().toString();
        int scoreInt = 0;

        if (score <= 9) {
            String vidasString = vidas.getText().toString();
            int vidasInt = Integer.parseInt(vidasString);

            if (respuesta.equals(numeroInvi_String)) {

                mp_great.start();
                scoreInt = Integer.parseInt(scoreString);
                scoreInt+=1;

                //score++;
                //tv_score.setText("Score: " + score);
                Intent next = new Intent(this, Mainnivel1.class);
                next.putExtra("npuntos", scoreInt);
                next.putExtra("nombre", tv_nombre.getText().toString());
                next.putExtra("nvidas", vidas.getText().toString());
                startActivity(next);
                et_respuesta.setText("");
                Toast.makeText(this, "correcto", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(this, Mainnivel1.class);


                //string_score = String.valueOf(scoreInt);
                //string_vidas = String.valueOf(vidas);
                //next.putExtra("nombre", tv_nombre.getText().toString());
                //intent.putExtra("score", tv_score.getText().toString());
                //intent.putExtra("vidas", string_vidas);

                //startActivity(intent);

            } else {

                mp_bad = MediaPlayer.create(this, R.raw.fallo);
                vidasInt=-1;
                vidasString = Integer.toString(vidasInt);
                vidas.setText(vidasString);
               // int vidasInt = 3;
               // vidasInt--;


                Toast.makeText(this, "Incorecto", Toast.LENGTH_SHORT).show();
                switch (vidasInt) {
                    case 3:
                        iv_vidas.setImageResource(R.drawable.tequeda3vida);
                        break;
                    case 2:
                        Toast.makeText(this, "Te quedan 2 coches", Toast.LENGTH_LONG).show();
                        iv_vidas.setImageResource(R.drawable.tequeda2vida);
                        break;
                    case 1:
                        Toast.makeText(this, "Te queda 1 coche", Toast.LENGTH_LONG).show();
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
                Intent next = new Intent(this, Mainnivel1.class);
                next.putExtra("vidas", vidas.getText().toString());
                startActivity(next);
                et_respuesta.setText("");
            }
        } else {
            Intent intent = new Intent(this, Mainnivel2.class);

            //string_score = String.valueOf(scoreInt);
            //string_vidas = String.valueOf(vidas);
            //nombre_jugador = tv_nombre.getText().toString();
            //intent.putExtra("jugador", nombre_jugador);
            //intent.putExtra("score", string_score);
            //intent.putExtra("vidas", string_vidas);

            startActivity(intent);
            finish();
            mp.stop();
            mp.release();
        }

    }

}













