package com.ozika.ifto.animalquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }

    public void perguntaPagina(View view){
        Intent it = new Intent(SegundaActivity.this,PerguntaActivity.class);
        startActivity(it);
        finish();
    }
}