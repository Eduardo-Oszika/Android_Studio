package com.ozika.ifto.exemploalertsimples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonHello = findViewById(R.id.buttonHello);
        buttonHello.setOnClickListener(view -> {
            criarDialog();
        });
    }

    private void criarDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Hello")
                .setCancelable(false)
                .setMessage("Como estar o clima hoje ")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Quente",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,
                                        "beba muita agua", Toast.LENGTH_SHORT).show();
                            }
                        })
                .setNegativeButton("Frio", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,
                                "coloque uma jaqueta", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Bom", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,
                                "Aproveite", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }
}