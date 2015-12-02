package net.iessanclemente.u4_01_depuracion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class U4_01_Depuracion extends AppCompatActivity {

    final String s = "DEPURACION";
    final String sBtn = "DEPURACION BOTON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u4_01__depuracion);
        Log.e(s, "Mensaxe de erro");
        Log.w(s, "Mensaxe de aviso");
        Log.i(s, "Mensaxe de informacion");
        Log.d(s, "Mensaxe de depuracion");
        Log.v(s, "Mensaxe de verbose");
    }

    public void onClickEnvia(View v) {
        EditText et = (EditText) findViewById(R.id.etNumeros);

        if (et.getText().toString().equals("21")) {
            Toast.makeText(getApplicationContext(), "tes os pes na terra", Toast.LENGTH_SHORT).show();
            Log.i(sBtn, "dentro do if");
        } else if (et.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "non metiches nada", Toast.LENGTH_SHORT).show();
            Log.i(sBtn, "dentro do else if");
        } else {
            Toast.makeText(getApplicationContext(), "estas fora deste planeta", Toast.LENGTH_SHORT).show();
            Log.i(sBtn, "dentro do else");
        }

    }
}
