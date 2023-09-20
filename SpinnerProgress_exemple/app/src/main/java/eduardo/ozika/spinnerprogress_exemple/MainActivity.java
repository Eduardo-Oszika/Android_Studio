package eduardo.ozika.spinnerprogress_exemple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editText;
    private RadioButton r,i;
    private Button button;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private String idades[]={"20","30","40","50","..."};
    private Estudante estudante;
    private int f;
    private ProgressBar progressBar;
    private TextView textViewResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextNome);
        r = findViewById(R.id.radioButtonR);
        i = findViewById(R.id.radioButtonI);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        textViewResultado = findViewById(R.id.textViewResultado);
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,idades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(view -> {
            executarProgressBar();
        });

    }

    private void executarProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
        Handler handler = new Handler(Looper.getMainLooper());
        f = progressBar.getProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (f<100){
                    f+=10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(f);
                            if(f>=100){
                                textViewResultado.setText(estudante.toString());
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
    private String obterSituacao(){
        String s = "";
        if(r.isChecked())
            s = "regular";
        if(i.isChecked())
            s="iregular";
        return s;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int item = Integer.parseInt(idades[i]);
        estudante = new Estudante(editText.getText().toString(),obterSituacao(),item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}