package eduardo.ozika.qeustionsharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import eduardo.ozika.qeustionsharepreferences.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {
    private SharedPreferences sp;
    private Activity2Binding bind2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind2 = Activity2Binding.inflate(getLayoutInflater());
        setContentView(bind2.getRoot());
        sp = getSharedPreferences("dados_user",MODE_PRIVATE);
        bind2.responser.setOnClickListener(view -> {
            responder();
        });

    }

    private void responder() {
        int score = 0;
        if (bind2.radiobutton1.isChecked())
            score++;
        if (bind2.radiobutton6.isChecked())
            score++;
        if (bind2.radiobutton9.isChecked())
            score++;
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("score",String.valueOf(score));
        editor.commit();
        Intent it = new Intent(this, Activity3.class);
        startActivity(it);
    }
}