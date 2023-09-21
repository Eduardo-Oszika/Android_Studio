package eduardo.ozika.spinnerpersonalizadoexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinner;
    private MyAdapter myAdapter;
//    private ArrayAdapter adapterPlanetes;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

//        adapterPlanetes = ArrayAdapter.createFromResource(MainActivity.this, R.array.planets_array, android.R.layout.simple_spinner_item);
//        adapterPlanetes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myAdapter = new MyAdapter(MainActivity.this,criarLista());
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    private ArrayList<ItemList> criarLista() {
        ArrayList<ItemList> itens = new ArrayList<>();
        String[] planetas = getResources().getStringArray(R.array.planets_array);
        ArrayList<Integer> imagens = new ArrayList<>();
        imagens.add(R.drawable.earth);
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