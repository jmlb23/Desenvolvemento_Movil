package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Vista_Texto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__texto);
        Intent intento = getIntent();
        ArrayAdapter<String> adapter = null;
        Spinner sp = (Spinner) Vista_Texto.this.findViewById(R.id.spnLista);
        ListView l = (ListView) Vista_Texto.this.findViewById(R.id.lstVista);

        if (intento.hasExtra("TIPO")) {

            switch (intento.getStringExtra("TIPO")) {
                case "ListView":
                    l.setVisibility(View.VISIBLE);
                    //definoa duas veces e como final porque teño que usala tanto no case do List coma no spinner
                    final List<String> list = Arrays.asList(intento.getStringExtra("VALORES").split("\\|"));
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                    l.setAdapter(adapter);
                    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(), String.format("posicion %d:\n%s", position, list.get(position)), Toast.LENGTH_SHORT).show();
                        }
                    });

                    sp.setVisibility(View.GONE);

                    break;
                case "Spiner":
                    sp.setVisibility(View.VISIBLE);
                    final List<String> list2 = Arrays.asList(intento.getStringExtra("VALORES").split("\\|"));
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list2);
                    sp.setAdapter(adapter);
                    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getApplicationContext(), String.format("posicion %d:\n%s", position, list2.get(position)), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    l.setVisibility(View.GONE);
                    break;
            }

        }
    }
}
