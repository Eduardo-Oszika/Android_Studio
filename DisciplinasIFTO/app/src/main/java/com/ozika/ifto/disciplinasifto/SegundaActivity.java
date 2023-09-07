package com.ozika.ifto.disciplinasifto;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {
    ListView listView;
    TextView periodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Intent it = getIntent();
        listView = findViewById(R.id.listView);
        periodo = findViewById(R.id.text);

        Resources resource = getResources();
        String[] disciplinas;
        ArrayAdapter<String> adapter;
        if (it.getIntExtra("periodo", -1) == R.id.periodo1) {
            disciplinas = resource.getStringArray(R.array.Periodo1);
            periodo.setText("1° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);
        } else if (it.getIntExtra("periodo", -1) == R.id.periodo2) {
            disciplinas = resource.getStringArray(R.array.Periodo2);
            periodo.setText("2° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);

        } else if (it.getIntExtra("periodo", -1) == R.id.periodo3) {
            disciplinas = resource.getStringArray(R.array.Periodo3);
            periodo.setText("3° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);

        } else if (it.getIntExtra("periodo", -1) == R.id.periodo4) {
            disciplinas = resource.getStringArray(R.array.Periodo4);
            periodo.setText("4° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);

        } else if (it.getIntExtra("periodo", -1) == R.id.periodo5) {
            disciplinas = resource.getStringArray(R.array.Periodo5);
            periodo.setText("5° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);

        } else if (it.getIntExtra("periodo", -1) == R.id.periodo6) {
            disciplinas = resource.getStringArray(R.array.Periodo6);
            periodo.setText("6° Periodo");
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, disciplinas);
            listView.setAdapter(adapter);

        }
    }
}