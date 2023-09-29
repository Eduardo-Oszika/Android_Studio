package eduardo.ozika.ifto;


import java.io.Serializable;

public class Memoria implements Serializable {
    int id;
    String nome;
    int color;
    int valor;

    public Memoria(int id, String nome, int color, int valor) {
        this.id = id;
        this.nome = nome;
        this.color = color;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}
