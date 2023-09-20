package eduardo.ozika.ifto;

import java.io.Serializable;
import java.util.Date;

public class Usuario  implements Serializable {
    int id;
    String nome;
    String date;
    int valorTotal;

    public Usuario(String nome, String date) {
        this.nome = nome;
        this.date = date;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
