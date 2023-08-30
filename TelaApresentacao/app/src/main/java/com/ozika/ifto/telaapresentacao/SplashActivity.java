package com.ozika.ifto.telaapresentacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.i("thread1",Thread.currentThread().getName());

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("thread2",Thread.currentThread().getName());
                Intent it = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(it);
            }
        },4000);
    }
}