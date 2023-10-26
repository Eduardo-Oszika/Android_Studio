package eduardo.ozika.bancosqlexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextnome, editTexttelefone;
    private Button salvar, listar, deletar;
    private Pessoa p;
    private static Banco helper;
    private CRUDBanco crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crud = new CRUDBanco(getApplicationContext());

        editTextnome = findViewById(R.id.edittextnome);
        editTexttelefone = findViewById(R.id.edittexttelefone);
        salvar = findViewById(R.id.btnS);
        listar = findViewById(R.id.btnL);
        deletar = findViewById(R.id.btnD);

        p = (Pessoa) getIntent().getSerializableExtra("dado");
        if (p != null) {
            editTexttelefone.setText(p.getTelefone());
            editTextnome.setText(p.getNome());
        }

        salvar.setOnClickListener(view -> {
            salvar();
        });
        listar.setOnClickListener(view -> {
            listar();
        });
        deletar.setOnClickListener(view -> {
            excluir();
        });

    }

    private void excluir() {
        int retorno = crud.excluir(p);
        if (retorno>0){
            Toast.makeText(this, "dados deletados", Toast.LENGTH_SHORT).show();
            editTextnome.setText("");
            editTexttelefone.setText("");
            p=null;
        }else{
            Toast.makeText(this, "erro ao excluir", Toast.LENGTH_SHORT).show();
        }
    }

    private void listar() {
        List<Pessoa> dados = crud.listar();
        if (dados!=null){
            Intent it = new Intent(MainActivity.this,Activity2.class);
            it.putExtra("dados", (Serializable) dados);
            startActivity(it);
            finish();
        }
        else {
            Toast.makeText(this, "sem dados", Toast.LENGTH_SHORT).show();
        }
    }

    private void salvar() {
        if (p==null){
            p=new Pessoa();
            p.setNome(editTextnome.getText().toString());
            p.setTelefone(editTexttelefone.getText().toString());
            long retorno = crud.add(p);
            if (retorno!=-1){
                Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
                p=null;
                editTextnome.setText("");
                editTexttelefone.setText("");
            }else {
                Toast.makeText(this, "Não Salvo", Toast.LENGTH_SHORT).show();
            }
        }else{
            p.setNome(editTextnome.getText().toString());
            p.setTelefone(editTexttelefone.getText().toString());
            int retorno = crud.atualizar(p);
            if (retorno !=0){
                Toast.makeText(this, "atualizado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "não atualizado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static SQLiteOpenHelper criarBanco(Context c) {
        if (helper == null) {
            helper = new Banco(c);
        }
        return helper;
    }
}