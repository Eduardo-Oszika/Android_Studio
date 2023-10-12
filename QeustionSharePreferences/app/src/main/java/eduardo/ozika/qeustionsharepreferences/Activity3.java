package eduardo.ozika.qeustionsharepreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import eduardo.ozika.qeustionsharepreferences.databinding.Activity3Binding;

public class Activity3 extends AppCompatActivity {
    Activity3Binding bind3;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        bind3 = Activity3Binding.inflate(getLayoutInflater());
        setContentView(bind3.getRoot());
        sp = getSharedPreferences("dados_user", MODE_PRIVATE);

        bind3.score.setText(sp.getString("score","deu errado"));
    }
}