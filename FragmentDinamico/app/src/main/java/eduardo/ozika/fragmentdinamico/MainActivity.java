package eduardo.ozika.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private FragmentManager fm;

    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
    }

    public  void trocar(View v){
        if (v.getId()==R.id.buttontela1){
            ft = fm.beginTransaction();
            ft.replace(R.id.telaPrincipal,new Tela1());
            ft.commit();
        }
        if (v.getId()==R.id.buttontela2){

            ft = fm.beginTransaction();
            ft.replace(R.id.telaPrincipal,new Tela2());
            ft.commit();
        }
    }
}