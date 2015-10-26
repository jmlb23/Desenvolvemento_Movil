package com.example.a10jesuslb.i_4b_a10jesuslb_nova;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

public class I_4B_a10jesuslb extends FragmentActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_4_b_a10jesuslb);
    }

    public void onClickAmosa(View view) {
        if(view.getId()==R.id.btnFrag){
            Log.i("BTN","frag");

        }else{
            Log.i("BTN", "show");
            showDialog(0);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_multichoice);
        arrayAdapter.add("movidon");
        arrayAdapter.add("movidon 2");
        arrayAdapter.add("movidon 3");
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }

    public void onClickAppend(View view) {

    }
}
