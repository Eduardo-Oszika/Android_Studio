package eduardo.ozika.ifto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText nome, data;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.nome);
        data = findViewById(R.id.data);
        button = findViewById(R.id.brincandoCores);
        button.setOnClickListener(view -> {
            Intent it = new Intent(MainActivity.this, SegundaActivity.class);
            it.putExtra("usuario", (Usuario) gerarUsuario(nome.getText().toString(), data));
            it.putExtra("memorias", gerarsequencia());

            startActivity(it);
        });

    }

    private Usuario gerarUsuario(String nome, EditText data) {
//        String texto = data.getText().toString();
////        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            Date d = sdf.parse(texto);
//            return new Usuario(nome, d);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }

        return new Usuario(nome, data.getText().toString());

    }

    private ArrayList<Memoria> gerarsequencia() {
        ArrayList<Memoria> memorias = new ArrayList<>();
        memorias.add(new Memoria(0, "laranja_escuro", getColor(R.color.laranja_escuro), 10));
        memorias.add(new Memoria(1, "Black", getColor(R.color.black), 20));
        memorias.add(new Memoria(2, "white", getColor(R.color.white), 30));
        memorias.add(new Memoria(3, "vermelho_claro", getColor(R.color.vermelho_claro), 40));
        memorias.add(new Memoria(4, "roxo_claro", getColor(R.color.roxo_claro), 50));
        memorias.add(new Memoria(5, "roxo_azul", getColor(R.color.roxo_azul), 60));
        memorias.add(new Memoria(6, "roxo_escuro", getColor(R.color.roxo_escuro), 70));
        memorias.add(new Memoria(7, "rosa", getColor(R.color.rosa), 80));
        memorias.add(new Memoria(8, "azul_claro", getColor(R.color.azul_claro), 90));
        memorias.add(new Memoria(9, "verde_azul", getColor(R.color.verde_azul), 95));
        memorias.add(new Memoria(10, "verde_grama", getColor(R.color.verde_grama), 85));
        memorias.add(new Memoria(11, "verde_claro", getColor(R.color.verde_claro), 75));
        memorias.add(new Memoria(12, "verde_amarelo", getColor(R.color.verde_amarelo), 65));
        memorias.add(new Memoria(13, "amarelo", getColor(R.color.amarelo), 55));
        memorias.add(new Memoria(14, "amarelo_queimado", getColor(R.color.amarelo_queimado), 45));
        memorias.add(new Memoria(15, "laranja_claro", getColor(R.color.laranja_claro), 35));
        memorias.add(new Memoria(16, "vermelho_florescente", getColor(R.color.vermelho_florescente), 25));
        memorias.add(new Memoria(17, "azul_escuro", getColor(R.color.azul_escuro), 15));
        memorias.add(new Memoria(18, "cinza", getColor(R.color.cinza), 5));
        memorias.add(new Memoria(19, "marrom", getColor(R.color.marrom), 100));

        Collections.shuffle(memorias);
        return memorias;
    }
}