package eduardo.ozika.ifto;

import java.io.Serializable;
import java.util.Calendar;

public class Usuario implements Serializable {
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

    public int getIdade() {
        int idade = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        String[] partes = date.split("/");
        if (partes.length == 3) {
            dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);
            ano = Integer.parseInt(partes[2]);
            if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.set(ano, mes - 1, dia); // mês inicia em zero
                Calendar dataAtual = Calendar.getInstance();
                idade = dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
                if (dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
                    idade--;
                } else if (dataAtual.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
                        && dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                    idade--;
                }
            } else {
                idade = -1;
            }
        } else {
            idade = -1;
        }
        return idade;
    }
}
