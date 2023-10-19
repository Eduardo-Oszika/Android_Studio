package eduardo.ozika.fragmentdinamico;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1 extends Fragment {


    private EditText editText;
    private Button button;
    private TextView textView;


    public Tela1() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //  return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tela1,container,false);
        editText = view.findViewById(R.id.editTextNome);
        button = view.findViewById(R.id.buttonNome);
        textView = view.findViewById(R.id.textViewNome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });
        return view;
    }
}//class
