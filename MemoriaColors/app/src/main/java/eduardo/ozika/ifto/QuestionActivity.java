package eduardo.ozika.ifto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    TextView textViewUserInfo;
    ArrayList<EditText> editTexts;
    ArrayList<ImageView> imageViews;
    Button btn;
    int valorTotal;
    Usuario user;
    ArrayList<Memoria> gabarito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        valorTotal = 0;
        editTexts = new ArrayList<>();
        imageViews = new ArrayList<>();
        editTexts.add(findViewById(R.id.editTextColor1));
        imageViews.add(findViewById(R.id.imageViewColor1));
        editTexts.add(findViewById(R.id.editTextColor2));
        imageViews.add(findViewById(R.id.imageViewColor2));
        editTexts.add(findViewById(R.id.editTextColor3));
        imageViews.add(findViewById(R.id.imageViewColor3));
        editTexts.add(findViewById(R.id.editTextColor4));
        imageViews.add(findViewById(R.id.imageViewColor4));
        editTexts.add(findViewById(R.id.editTextColor5));
        imageViews.add(findViewById(R.id.imageViewColor5));
        editTexts.add(findViewById(R.id.editTextColor6));
        imageViews.add(findViewById(R.id.imageViewColor6));
        editTexts.add(findViewById(R.id.editTextColor7));
        imageViews.add(findViewById(R.id.imageViewColor7));
        editTexts.add(findViewById(R.id.editTextColor8));
        imageViews.add(findViewById(R.id.imageViewColor8));
        editTexts.add(findViewById(R.id.editTextColor9));
        imageViews.add(findViewById(R.id.imageViewColor9));
        editTexts.add(findViewById(R.id.editTextColor10));
        imageViews.add(findViewById(R.id.imageViewColor10));
        btn = findViewById(R.id.buttonGuess);
        textViewUserInfo = findViewById(R.id.textViewUserInfo);
        Intent it = getIntent();
        user = (Usuario) it.getSerializableExtra("usuario");
        gabarito = (ArrayList<Memoria>) it.getSerializableExtra("gabarito");
        textViewUserInfo.setText("Nome: " + user.nome + "\nIdade: " + String.valueOf(user.getIdade()));
        btn.setOnClickListener(view -> {
            for (int i = 0; i < 10; i++) {
                valorTotal=0;
                editTexts.get(i).getText().toString().toLowerCase();
                gabarito.get(i).getNome().toLowerCase();
                if (gabarito.get(i).getNome().toLowerCase().equals(editTexts.get(i).getText().toString().toLowerCase())) {
                    valorTotal += gabarito.get(i).getValor();
                    imageViews.get(i).setImageResource(R.drawable.feliz);

                } else {
                    imageViews.get(i).setImageResource(R.drawable.triste);
                }
                imageViews.get(i).setVisibility(View.VISIBLE);
            }
            textViewUserInfo.setText(textViewUserInfo.getText() + "\nValorTotal: " + valorTotal);
        });
    }
}