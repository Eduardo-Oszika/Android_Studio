package com.ozika.ifto.exemplo_app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityBolo extends AppCompatActivity {
    private EditText qtd;
    private Button btnBolo;
    private double valores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolo);
        btnBolo = findViewById(R.id.buttonBolo);
        qtd = findViewById(R.id.ediText_quantidadeBolo);
        btnBolo.setOnClickListener(view -> {
            calcular();
        });

    }

    private void calcular() {
        int unidade = Integer.parseInt(qtd.getText().toString());
        double total = unidade*5.00;
        Intent i = new Intent(ActivityBolo.this,MainActivity.class);
        valores = valores +total;
        i.putExtra("total",valores);
        startActivity(i);
    }
}