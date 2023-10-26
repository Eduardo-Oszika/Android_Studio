package eduardo.ozika.bancosqlexemplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {
    private static final int BANCO_VERSION = 1;
    private static final String BANCO_NOME = "meu_banco.db";
    public static final String BANCO_TABELA = "contato";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String TELEFONE = "telefone";

    public Banco(@Nullable Context context) {
        super(context, BANCO_NOME, null, BANCO_VERSION);
    }

    private static final String CRIAR_TABELA = "CREATE TABLE " + BANCO_TABELA + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOME + " TEXT, " + TELEFONE + " TEXT)";
    private static final String DELETA_TABELA = "DROP TABLE IF EXISTS " + BANCO_TABELA;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CRIAR_TABELA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETA_TABELA);
        onCreate(sqLiteDatabase);

    }
}
