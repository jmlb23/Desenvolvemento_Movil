package net.iessanclemente.u4_02_spinneradapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class U4_02_SpinnerAdapter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] s = {"elemento 1","elemento 2","elemento 3","elemento 4","elemento 5"};

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u4_02__spinner_adapter);
        Spinner spDatos = (Spinner)findViewById(R.id.spDatos);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,s);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDatos.setAdapter(arrayAdapter);

        spDatos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),s[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u4_02__spinner_adapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
