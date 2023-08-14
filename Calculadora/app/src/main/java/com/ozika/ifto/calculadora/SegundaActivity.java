package com.ozika.ifto.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        resultado = findViewById(R.id.resultado2);
        Double res = getIntent().getDoubleExtra("resultado",0);
        resultado.setText(res.toString());
    }
}