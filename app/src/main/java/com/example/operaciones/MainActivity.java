package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;


import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;
    private TextView tv_record;

    private Button btn_jugar;

    private MediaPlayer mp;
    String NombreBaseDatos = "administracion";

    int num_aleatorio = (int) (Math.random() * 3 + 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.ettnombre);
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

    public void Jugar (View view){

        AdminSQLiteOpenHelper admi = new AdminSQLiteOpenHelper(this, NombreBaseDatos,null,1);
        SQLiteDatabase BasedeDatos = admi.getWritableDatabase();

        Cursor consulta = BasedeDatos.rawQuery("select * from lista where puntuacion = (select max(puntuacion) from lista)", null);
        String nombre = et_nombre.getText().toString();

        if(!nombre.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);

            BasedeDatos.insert("lista", null, registro);

            BasedeDatos.close();
            String texto = nombre;
            Intent i = new Intent(this, Mainnivel1.class);
            i.putExtra("texto", texto);
            startActivity(i);
            Toast.makeText(this, "Nivel 1", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Introduce un nombre para continuar", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed (){

      }

    }