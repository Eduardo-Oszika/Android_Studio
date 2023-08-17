package com.ozika.ifto.animalquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }

    public void proximaPagina(){
        Intent it = new Intent(SegundaActivity.this,PerguntaActivity.class);
        startActivity(it);
        finish();
    }
}