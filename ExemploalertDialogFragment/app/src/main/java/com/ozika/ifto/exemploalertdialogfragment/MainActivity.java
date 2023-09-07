package com.ozika.ifto.exemploalertdialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonHello = findViewById(R.id.buttonHello);
        buttonHello.setOnClickListener(view -> {
            openDialogFragment();
        });
    }

    private void openDialogFragment() {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(),"clima");
    }
}