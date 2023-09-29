package eduardo.ozika.ifto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ArrayList<Memoria> memorias;
    ArrayList<Memoria> gabarito;
    TextView textcor;
    int i = 0;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        linearLayout = findViewById(R.id.backgroundColors);
        memorias = (ArrayList<Memoria>) getIntent().getSerializableExtra("memorias");

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        textcor= findViewById(R.id.textCor);
        it = new Intent(SegundaActivity.this, TerceiraActivity.class);
        it.putExtra("memorias", memorias);
        it.putExtra("usuario", usuario);
        Handler handler = new Handler(Looper.getMainLooper());


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j <= 10; j++) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(i<10){
                                setarCor();
                            }
                            else{
                                startActivity(it);
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
//        for (int j = 0; j < 10; j++) {
//            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    setarCor();
//                }
//            },1000*j);
//        }
//
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(it);
//            }
//        },10000);

    }

    private void setarCor() {
        memorias = (ArrayList<Memoria>) it.getSerializableExtra("memorias");
        linearLayout.setBackgroundColor(memorias.get(i).color);
        textcor.setText(memorias.get(i).nome);
        i ++;
    }
}