package com.example.a10jesuslb.shared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {

    EditText et = (EditText)findViewById(R.id.etGlobal);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);


        SharedPreferences sp = getSharedPreferences("valores",MODE_WORLD_WRITEABLE);
        et.setText(sp.getString("GLOBAIS" ,""));


    }

    public void actualizar(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("valores",MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("GLOBAL",et.getText().toString());
        this.finish();



    }
}
