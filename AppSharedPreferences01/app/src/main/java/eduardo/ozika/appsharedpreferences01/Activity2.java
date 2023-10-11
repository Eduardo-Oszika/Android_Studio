package eduardo.ozika.appsharedpreferences01;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import eduardo.ozika.appsharedpreferences01.databinding.Activity2Binding;
import eduardo.ozika.appsharedpreferences01.databinding.ActivityMainBinding;

public class Activity2 extends AppCompatActivity {
    private SharedPreferences sp;
    private Activity2Binding bind2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind2 = Activity2Binding.inflate(getLayoutInflater());
        setContentView(bind2.getRoot());
        sp = getSharedPreferences("dados_user",MODE_PRIVATE);
        recuperarCor();
    }
    private void recuperarCor(){
        if(sp.contains("nome_user")&&sp.contains("cor_user")){
            String nome = sp.getString("nome_user","nome");
            bind2.text.setText(nome);
            String cor = sp.getString("cor_user","branca");
            if(cor.equals("verde")){
                bind2.layout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
            if(cor.equals("vermelho")){
                bind2.layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            }
            if(cor.equals("azul")){
                bind2.layout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            }
            if(cor.equals("branca")){
                bind2.layout.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
    }
}