package com.ozika.ifto.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton radioButtonAndroid, radioButtonmicrosoft, radioButtonApple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButtonAndroid = findViewById(R.id.radio_android);
        radioButtonApple = findViewById(R.id.radio_apple);
        radioButtonmicrosoft = findViewById(R.id.radio_microsoft);
    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        if (view.getId()==R.id.radio_android){
            if (checked){
                Toast.makeText(this,"Acertou",Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.radio_apple){
            if (checked){
                Toast.makeText(this,"Errou",Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.radio_microsoft){
            if (checked){
                Toast.makeText(this,"Errou",Toast.LENGTH_SHORT).show();
            }
        }
    }
}