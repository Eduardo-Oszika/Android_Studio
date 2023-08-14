package com.ozika.ifto.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2, operador;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.numero1);
        num2 = findViewById(R.id.numero2);
        operador = findViewById(R.id.operador);
        btn = findViewById(R.id.resultado);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, SegundaActivity.class);
                it.putExtra("resultado", calcular(num1, num2, operador));
                startActivity(it);
                finish();
            }
        });
    }

    private Double calcular(EditText num1, EditText num2, EditText operador) {
        Double res;
        switch (operador.getText().toString()) {
            case "+":
                res = (Double.parseDouble(num1.getText().toString())) + (Double.parseDouble(num2.getText().toString()));
            break;
            case "-":
                res = (Double.parseDouble(num1.getText().toString())) - (Double.parseDouble(num2.getText().toString()));
            break;
            case "*":
                res = (Double.parseDouble(num1.getText().toString())) * (Double.parseDouble(num2.getText().toString()));
            break;
            case "/":
                res = (Double.parseDouble(num1.getText().toString())) / (Double.parseDouble(num2.getText().toString()));
            break;
            default:
                res = 0.0;
            break;
        }
        return res;
    }
}