package com.ozika.ifto.caracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    ImageView image;
    TextView texto, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent it = getIntent();

        texto = findViewById(R.id.text);
        image = findViewById(R.id.image);
        resultado = findViewById(R.id.resultado);

        texto.setText(it.getStringExtra("resultado"));
        if(it.getIntExtra("img",-1) == 0){
            image.setImageResource(R.drawable.cara);
            resultado.setText("Cara");
        } else if (it.getIntExtra("img",-1) == 1) {
            image.setImageResource(R.drawable.coroa);
            resultado.setText("Coroa");
        }else{
            texto.setText("Algo deu errado");
        }
    }
}