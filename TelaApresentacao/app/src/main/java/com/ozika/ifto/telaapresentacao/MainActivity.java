package com.ozika.ifto.telaapresentacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            numero = Integer.parseInt(editText.getText().toString());
            gerarNumero(numero);
        });
    }

    private void gerarNumero(int numjogador) {
        Random r = new Random();
        int numcomputador = r.nextInt(11);
        if(numcomputador>numjogador){
            Toast.makeText(this,"Android venceu "+numcomputador+" > "+numjogador,Toast.LENGTH_SHORT).show();
        }else if(numcomputador==numjogador){
            Toast.makeText(this,"Empate "+numcomputador+" = "+numjogador,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Jogador venceu "+numcomputador+" < "+numjogador,Toast.LENGTH_SHORT).show();
        }
    }
}