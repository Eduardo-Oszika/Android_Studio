package eduardo.ozika.calculapesoplanet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private MyAdapter myAdapter;
    private EditText editPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        myAdapter = new MyAdapter(MainActivity.this,criarLista());
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);
        editPeso = findViewById(R.id.peso);

        FloatingActionButton btn = findViewById(R.id.btnflutuante);
        btn.setOnClickListener(view -> {
            double peso = Double.parseDouble(editPeso.getText().toString());
            ItemList item = (ItemList) spinner.getSelectedItem();
            if(item.getImagem() == R.drawable.earth){
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.mars){
                peso = peso * 0.38;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.jupter){
                peso = peso * 2.64;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.neptune){
                peso = peso * 1.18;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.saturn){
                peso = peso * 1.15;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.mercury){
                peso = peso * 0.37;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.uranus){
                peso = peso * 1.17;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
            if(item.getImagem() == R.drawable.venus){
                peso = peso *0.88;
                Snackbar.make(view, String.valueOf(peso),Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });
    }

    private ArrayList<ItemList> criarLista() {
        ArrayList<ItemList> itens = new ArrayList<>();
        String[] planetas = getResources().getStringArray(R.array.planets_array);
        ArrayList<Integer> imagens = new ArrayList<>();
        imagens.add(R.drawable.mercury);
        imagens.add(R.drawable.venus);
        imagens.add(R.drawable.earth);
        imagens.add(R.drawable.mars);
        imagens.add(R.drawable.jupter);
        imagens.add(R.drawable.saturn);
        imagens.add(R.drawable.uranus);
        imagens.add(R.drawable.neptune);

        for (int i = 0; i < planetas.length; i++) {
            ItemList item = new ItemList(imagens.get(i),planetas[i]);
            itens.add(item);
        }
        return itens;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ItemList item = (ItemList) spinner.getItemAtPosition(i);
        Toast.makeText(this, item.getInfo(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}