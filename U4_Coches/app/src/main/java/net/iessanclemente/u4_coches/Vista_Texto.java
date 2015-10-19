package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

public class Vista_Texto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__texto);
        Intent intento = getIntent();
        if(intento.hasExtra("TIPO")){
            switch(intento.getIntExtra("TIPO",0)){
                case 0:
                    ListView l =(ListView)findViewById(R.id.lstVista);
                    l.setVisibility(View.VISIBLE);

                    break;
                case 1:
                    Spinner sp =(Spinner)findViewById(R.id.spnLista);
                    sp.setVisibility(View.VISIBLE);
                    break;
            }

        }
    }
}
