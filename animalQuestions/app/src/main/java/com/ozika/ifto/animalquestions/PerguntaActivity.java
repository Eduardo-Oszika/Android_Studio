package com.ozika.ifto.animalquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class PerguntaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
    }

    public void resposta(View view){
        Boolean checked = ((RadioButton)view).isChecked();
        int acertou = 0;
        if (view.getId()==R.id.radioButton1){
            if (checked){
                acertou = 1;
                Toast.makeText(this,"Errou",Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.radioButton2){
            if (checked){
                acertou = 1;
                Toast.makeText(this,"Errou",Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.radioButton3){
            if (checked){
                acertou = 2;
                Toast.makeText(this,"Acertou",Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId()==R.id.radioButton4){
            if (checked){
                acertou = 1;
                Toast.makeText(this,"Errou",Toast.LENGTH_SHORT).show();
            }
        }
        if(acertou==2) {
            Intent it = new Intent(PerguntaActivity.this, AcertouActivity.class);
            startActivity(it);
        }
        if(acertou==1){
            Intent it = new Intent(PerguntaActivity.this, ErrouActivity.class);
            startActivity(it);
        }
    }
}