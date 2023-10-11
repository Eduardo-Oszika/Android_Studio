package eduardo.ozika.appsharedpreferences01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import eduardo.ozika.appsharedpreferences01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    SharedPreferences sp;
    RadioButton radiovermelho,radioverde,radioazul;

    ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        sp = getSharedPreferences("dados_user",MODE_PRIVATE);
        if (sp.contains("nome_user")&& sp.contains("cor_user")){
            Intent i = new Intent(this,Activity2.class);
            startActivity(i);
        }
//        setContentView(R.layout.activity_main);
//        editText = findViewById(R.id.edittext);
//        button = findViewById(R.id.btn);
//        radioazul = findViewById(R.id.azul);
//        radioverde = findViewById(R.id.verde);
//        radiovermelho = findViewById(R.id.vermelho);
        bind.btn.setOnClickListener(view -> {
            clicar();
        });

    }
    private void clicar(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nome_user",bind.edittext.getText().toString());
        editor.putString("cor_user",obterCor());
        boolean resp = editor.commit();
        if(resp){
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,Activity2.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Não Salvo", Toast.LENGTH_SHORT).show();
        }
    }
    private String obterCor(){
        String cor="";
        if(bind.vermelho.isChecked())
            cor = "vermelho";
        if(bind.verde.isChecked())
            cor = "verde";
        if(bind.azul.isChecked())
            cor = "azul";
        return cor;
    }
}