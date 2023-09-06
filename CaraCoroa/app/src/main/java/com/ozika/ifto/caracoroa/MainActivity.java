package com.ozika.ifto.caracoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jogar(View view){
        Random random = new Random();
        Intent it = new Intent(MainActivity.this, ResultadoActivity.class);
        Log.i("id", String.valueOf(view.getId()));

        int i = random.nextInt(2);
        if(view.getId() == R.id.cara){
            if(i==0){
                it.putExtra("resultado","Parabens você ganhou");
                it.putExtra("img",0);
            }else {
                it.putExtra("resultado","O Computador ganhou, Tente novamente");
                it.putExtra("img",1);
            }
        }
        if(view.getId() == R.id.coroa){
            if(i==1){
                it.putExtra("resultado","Parabens você ganhou");
                it.putExtra("img",1);
            }else {
                it.putExtra("resultado","O Computador ganhou, Tente novamente");
                it.putExtra("img",0);
            }
        }
        startActivity(it);
    }

}