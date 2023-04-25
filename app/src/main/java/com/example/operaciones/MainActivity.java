package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;


import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;
    private TextView tv_record;

    private MediaPlayer mp;

    int num_aleatorio = (int) (Math.random() * 3 + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.ett);
        iv_personaje = (ImageView) findViewById(R.id.iv_personaje);
        tv_record = (TextView)findViewById(R.id.tvrecord);


        Toast.makeText(this, "número " + num_aleatorio, Toast.LENGTH_SHORT).show();
        switch (num_aleatorio){
            case 1:
                iv_personaje.setImageResource(R.drawable.cocheuno);
                break;
            case 2:
                iv_personaje.setImageResource(R.drawable.cochedos);
                break;
            case 3:
                iv_personaje.setImageResource(R.drawable.cochetres);
                break;
        }
        mp = MediaPlayer.create(this, R.raw.temaprincipal);
        mp.start();
        mp.setLooping(true);

    }

    public  void Jugar(View view){
    String nombre = et_nombre.getText().toString();

    if (!nombre.equals("")) {
        mp.stop();
        mp.release();

        Intent intent =new Intent(this,mainnive1.class);

        intent.putExtra("", nombre);
        startActivity(intent);
        finish();
      } else {
        Toast.makeText(this, "primero debe introducir su nombre", Toast.LENGTH_SHORT).show();

        et_nombre.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        imm.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);
      }
    }
    @Override
    public void onBackPressed (){

      }
      //Método el botón Siguiente
    public void jugar(View view) {
        Intent jugar = new Intent(this, Mainnivel1.class);
        startActivity(jugar);
        finish();
      }
    }