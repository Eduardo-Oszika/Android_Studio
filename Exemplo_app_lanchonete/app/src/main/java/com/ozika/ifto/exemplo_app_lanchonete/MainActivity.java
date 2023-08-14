package com.ozika.ifto.exemplo_app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView bolo,cafe;
    private Button calcular;
    private TextView resultado;
    private double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bolo = findViewById(R.id.image_bolo);
        cafe = findViewById(R.id.image_cafe);
        calcular = findViewById(R.id.button_calcular);
        resultado = findViewById(R.id.textViewResultado);

        Intent it = getIntent();
        if(it != null){
            double valor = it.getDoubleExtra("total",0);
            valores = valores + valor;
        }
    }

    public void escolher(View view){
        if(R.id.image_bolo == view.getId()){
            Intent intentBolo = new Intent(MainActivity.this, ActivityBolo.class);
            startActivity(intentBolo);
        }
        if(R.id.image_cafe == view.getId()){
            Intent intentCafe = new Intent(MainActivity.this, ActivityCafe.class);
            if(valores!=0){
                intentCafe.putExtra("valores",valores);
            }
            startActivity(intentCafe);
        }
        if(R.id.button_calcular == view.getId()){
            resultado.setText(String.valueOf(valores));
        }
    }
}