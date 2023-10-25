package eduardo.ozika.exemploarquivoexterno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNome;
    private Button buttonS,buttonE,buttonL;
    private TextView textViewLeitura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        buttonS = findViewById(R.id.buttonS);
        buttonE = findViewById(R.id.buttonE);
        buttonL = findViewById(R.id.buttonL);
        textViewLeitura = findViewById(R.id.textViewLeitura);
        buttonS.setOnClickListener(view -> {
            salvar();
        });
        buttonE.setOnClickListener(view -> {

        });
        buttonL.setOnClickListener(view -> {

        });
    }
    private void salvar(){
        String dados = editTextNome.getText().toString();
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            File file = new File(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"myArq.txt");
            if (file!=null){
                try {
                    FileOutputStream fos = new FileOutputStream(file);
//                    fos.write(dados.getBytes());
                    OutputStreamWriter ows = new OutputStreamWriter(fos);
                    ows.write(dados);
                    ows.close();
                    fos.close();
                    Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
                    Log.i("File", file.getAbsolutePath());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(this, "no File", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "no free", Toast.LENGTH_SHORT).show();
        }
    }
}