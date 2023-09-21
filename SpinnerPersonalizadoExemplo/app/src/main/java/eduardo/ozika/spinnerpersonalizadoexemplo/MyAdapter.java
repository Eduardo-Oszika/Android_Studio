package eduardo.ozika.spinnerpersonalizadoexemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ItemList> itens;

    public MyAdapter(Context context, ArrayList<ItemList> itens) {
        this.inflater = LayoutInflater.from(context);
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemList item = itens.get(i);
        view = inflater.inflate(R.layout.item_spinner,null);

        TextView texto = view.findViewById(R.id.texto2);
        texto.setText(item.getInfo());
        ImageView image = view.findViewById(R.id.imagem);
        image.setImageResource(item.getImagem());
        return view;
    }
}
