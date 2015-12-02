package com.example.a10jesuslb.shared;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickGarda(View view) {
        TextView tvLoc = (TextView)findViewById(R.id.shared);
        TextView tvGlo = (TextView)findViewById(R.id.global);


        SharedPreferences preferencesLoais = getPreferences(MODE_PRIVATE);
        SharedPreferences preferencesGlobais = getSharedPreferences("valores", MODE_WORLD_READABLE);


        SharedPreferences.Editor edLoc = preferencesLoais.edit();
        SharedPreferences.Editor edGlo = preferencesGlobais.edit();

        edLoc.putString("LOCAIS",tvLoc.getText().toString());
        edGlo.putString("GLOBAIS",tvGlo.getText().toString());

        edLoc.commit();
        edGlo.commit();

    }

    public void onClickCarga(View view) {
        SharedPreferences preferencesLoais = getPreferences(MODE_PRIVATE);
        SharedPreferences preferencesGlobais = getSharedPreferences("valores", MODE_PRIVATE);
        String s = preferencesLoais.getString("LOCAIS", "non sei");

        TextView tvLoc = (TextView)findViewById(R.id.shared);
        tvLoc.setText(s);

    }

    public void onClickLanza(View view) {

        Intent t = new Intent(this,Secundaria.class);
        startActivity(t);
    }
}
