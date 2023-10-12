package eduardo.ozika.qeustionsharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import eduardo.ozika.qeustionsharepreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bind;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        sp = getSharedPreferences("dados_user", MODE_PRIVATE);
        bind.entrar.setOnClickListener(view -> {
                if (sp.getString("nome_user","nome").equals(bind.none.getText().toString()) && sp.getString("senha_user", "senha").equals(bind.senha.getText().toString())){
                    Intent i = new Intent(this, Activity3.class);
                    startActivity(i);
                }
                else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("nome_user",bind.none.getText().toString());
                    editor.putString("senha_user",bind.senha.getText().toString());
                    boolean vai = editor.commit();
                    Intent i = new Intent(this, Activity2.class);
                    startActivity(i);


                }
        });
    }
}