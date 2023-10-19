package eduardo.ozika.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tela1 extends Fragment {
    private EditText editText;
    private Button btn;
    private TextView textView;

    public Tela1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tela1, container, false);
        editText = view.findViewById(R.id.editTextNome);
        btn = view.findViewById(R.id.buttonNome);
        textView = view.findViewById(R.id.textViewNome);

        btn.setOnClickListener(view1 -> {
            textView.setText(editText.getText().toString());
        });
        return view;
    }
}