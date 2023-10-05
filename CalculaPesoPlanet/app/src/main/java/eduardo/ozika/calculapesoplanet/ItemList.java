package eduardo.ozika.calculapesoplanet;

public class ItemList {
    private int imagem;
    private String info;


    public ItemList(int imagem, String info) {
        this.imagem = imagem;
        this.info = info;
    }


    public ItemList() {
    }


    public int getImagem() {
        return imagem;
    }


    public void setImagem(int imagem) {
        this.imagem = imagem;
    }


    public String getInfo() {
        return info;
    }


    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "ItemLista{" +
                "imagem=" + imagem +
                ", info='" + info + '\'' +
                '}';
    }
}
