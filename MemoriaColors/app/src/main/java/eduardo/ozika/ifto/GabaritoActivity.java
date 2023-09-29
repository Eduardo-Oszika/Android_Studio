package eduardo.ozika.ifto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GabaritoActivity extends AppCompatActivity {
    TableLayout table;
    TextView valorTotal;
    Button btn;
    int i = 0;
    int valor = 0;
    ArrayList<Memoria> gabarito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gabarito);
        table = findViewById(R.id.table);
        valorTotal = findViewById(R.id.valorTotal);
        btn = findViewById(R.id.responder);
        gabarito = (ArrayList<Memoria>) getIntent().getSerializableExtra("gabarito");
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                TextView text = (TextView) row.getChildAt(j);
                text.setText(text.getText() + gabarito.get(this.i).getNome());
                text.setTextColor(gabarito.get(this.i).getColor());
                valor += gabarito.get(this.i).getValor();
                this.i++;
            }
        }
        valorTotal.setText(valorTotal.getText() + String.valueOf(valor));
        btn.setOnClickListener(view -> {
            Intent it = new Intent(this, QuestionActivity.class);
            it.putExtra("gabarito", gabarito);
            it.putExtra("usuario", getIntent().getSerializableExtra("usuario"));
            startActivity(it);
        });
    }
}