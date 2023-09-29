package eduardo.ozika.ifto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TerceiraActivity extends AppCompatActivity {
    Button gab, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);
        gab = findViewById(R.id.button);
        res = findViewById(R.id.button2);
        Usuario user = (Usuario) getIntent().getSerializableExtra("usuario");
        ArrayList<Memoria> memorias = (ArrayList<Memoria>) getIntent().getSerializableExtra("memorias");

        gab.setOnClickListener(view -> {
            Intent at = new Intent(this, GabaritoActivity.class);
            at.putExtra("gabarito", gerarGabarito(memorias));
            at.putExtra("usuario", user);
            startActivity(at);
        });
        res.setOnClickListener(view -> {
            Intent at = new Intent(this, QuestionActivity.class);
            at.putExtra("gabarito", gerarGabarito(memorias));
            at.putExtra("usuario", user);
            startActivity(at);
        });

    }

    private ArrayList<Memoria> gerarGabarito(ArrayList<Memoria> memorias) {
        ArrayList<Memoria> gabarito = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gabarito.add(memorias.get(i));
        }
        return gabarito;
    }
}