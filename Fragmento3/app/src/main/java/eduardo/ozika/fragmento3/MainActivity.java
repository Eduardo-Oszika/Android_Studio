package eduardo.ozika.fragmento3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            Bundle bundle =new Bundle();
            bundle.putInt("num",10);

            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container_view_tag, Fragmento.class,bundle).commit();
        }
    }
}