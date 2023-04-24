package com.example.operaciones;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;
    private TextView tv_record;

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

    }

    //Método el botón Siguiente
    public void jugar(View view) {
        Intent jugar = new Intent(this, Mainnivel1.class);
        startActivity(jugar);
        finish();

   }
}
