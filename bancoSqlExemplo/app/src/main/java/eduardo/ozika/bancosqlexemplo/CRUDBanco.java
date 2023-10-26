package eduardo.ozika.bancosqlexemplo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CRUDBanco {

    private Context context;

    public CRUDBanco(Context context) {
        this.context = context;
    }
    public long add(Pessoa p){
        SQLiteDatabase db = MainActivity.criarBanco(context).getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Banco.NOME,p.getNome());
        cv.put(Banco.TELEFONE,p.getTelefone());
        long linhaId = db.insert(Banco.BANCO_TABELA,null,cv);
        return linhaId;

    }

    public List<Pessoa> listar(){
        SQLiteDatabase db = MainActivity.criarBanco(context).getReadableDatabase();
        List<Pessoa> dados = new ArrayList<>();
        String consulta = "SELECT * FROM "+Banco.BANCO_TABELA;
        Cursor cursor = db.rawQuery(consulta, null);
        while (cursor.moveToNext()) {
            Pessoa p = new Pessoa();
            p.setId(Integer.parseInt(cursor.getString(0)));
            p.setNome(cursor.getString(1));
            p.setTelefone(cursor.getString(2));
            dados.add(p);
        }
        return dados;
    }

    public int atualizar(Pessoa p){
        SQLiteDatabase db = MainActivity.criarBanco(context).getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Banco.NOME,p.getNome());
        cv.put(Banco.TELEFONE,p.getTelefone());
        String where = Banco.ID+"=?";
        String args[]= {String.valueOf(p.getId())};
        int contID = db.update(Banco.BANCO_TABELA,cv,where,args);
        return contID;
    }

    public int excluir(Pessoa p){
        SQLiteDatabase db = MainActivity.criarBanco(context).getWritableDatabase();
        String where = Banco.ID+"=?";
        String args[]= {String.valueOf(p.getId())};
        int contID = db.delete(Banco.BANCO_TABELA,where,args);
        return contID;

    }
}
