package com.ozika.ifto.exemplo_app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCafe extends AppCompatActivity {
    private EditText qtd;
    private Button btnCafe;
    private double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        btnCafe = findViewById(R.id.buttonCafe);
        qtd = findViewById(R.id.ediText_quantidade);
        Intent intent = getIntent();
        if(intent!=null){
            valores = intent.getDoubleExtra("valores",0);
        }
        btnCafe.setOnClickListener(view -> {
            calcular();
        });

    }

    public void calcular(){
        int unidade = Integer.parseInt(qtd.getText().toString());
        double total = unidade*2.00;
        Intent i = new Intent(ActivityCafe.this,MainActivity.class);
        valores = valores +total;
        i.putExtra("total",valores);
        startActivity(i);
    }
}