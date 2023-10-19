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

public class Tela2 extends Fragment {

    private EditText editText;
    private Button btn;
    private TextView textView;

    public Tela2() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tela2, container, false);
        editText = view.findViewById(R.id.editTextCurso);
        btn = view.findViewById(R.id.buttonCurso);
        textView = view.findViewById(R.id.textViewCurso);

        btn.setOnClickListener(view1 -> {
            textView.setText(editText.getText().toString());
        });
        return view;
    }
}