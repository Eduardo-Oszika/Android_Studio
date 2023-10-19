package eduardo.ozika.exemploarquivointerno;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnS, btnE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTect);
        btnS = findViewById(R.id.btnS);
        btnE = findViewById(R.id.btnE);

        btnS.setOnClickListener(view -> {
            salvar();
        });

        btnE.setOnClickListener(view -> {
            excluir();
        });
    }

    private void salvar() {
        String conteudo = editText.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("myArq.txt", Context.MODE_PRIVATE);
            fos.write(conteudo.getBytes());
            fos.close();
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void excluir() {
        getApplicationContext().deleteFile("myArq.txt");
        Toast.makeText(this, "Excluir", Toast.LENGTH_SHORT).show();
        editText.setText("");
    }
}