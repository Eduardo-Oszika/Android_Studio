package com.ozika.ifto.exemploactionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mytoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("MyToolbar");
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.bolo == item.getItemId()){
            Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        }
        if(R.id.salgado == item.getItemId()){
            Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        }
        if(R.id.torta == item.getItemId()){
            Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        }
        if(android.R.id.home == item.getItemId()){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}