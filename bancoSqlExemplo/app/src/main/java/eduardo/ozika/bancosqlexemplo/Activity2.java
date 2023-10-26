package eduardo.ozika.bancosqlexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lista;
    private ArrayAdapter<Pessoa> adapter;
    private List<Pessoa> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        lista = findViewById(R.id.lista);
        dados = (List<Pessoa>) getIntent().getSerializableExtra("dados");
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dados);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Pessoa p = (Pessoa) adapterView.getItemAtPosition(i);
        Intent it = new Intent(this, MainActivity.class);
        it.putExtra("dado",p);
        startActivity(it);
    }
}