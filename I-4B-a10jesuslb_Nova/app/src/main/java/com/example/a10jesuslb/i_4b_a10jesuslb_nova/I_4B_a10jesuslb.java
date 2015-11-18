package com.example.a10jesuslb.i_4b_a10jesuslb_nova;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class I_4B_a10jesuslb extends FragmentActivity{

    Dictionary<String,Boolean> dict;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_4_b_a10jesuslb);
        Aux.addValores(Aux.castArray(getResources().getStringArray(R.array.valore_iniciais)));


    }
    //funcion asociada os botons
    public void onClickAmosa(View view) {
        //se a view que se clicou é o do fragemento xo definimos cunha clase anonima e amosamolo
        if(view.getId()==R.id.btnFrag){
            DialogFragment d = new DialogFragment(){

                @Override
                public Dialog onCreateDialog(Bundle savedInstanceState) {

                    return I_4B_a10jesuslb.this.construe();
                }
            };
            d.show(getFragmentManager(),"");
        //se o show amosamos o dialogo clasico
        }else if(view.getId()==R.id.btnShow){
            //se uso o showdialog android crea so unha soa vez o dialogo e en posteriores chamadas reutilizao
            this.onCreateDialog(0).show();

        }
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        return construe();
    }

    //funcion que esta asociada o click para que agrege
    public void onClickAppend(View view) {

        EditText editText =(EditText)findViewById(R.id.etEngade);
        if(editText.getText()!=null && !editText.getText().toString().equals("")) Aux.addValores(editText.getText().toString().contains(",")? editText.getText().toString().split(","): new String[]{editText.getText().toString()});
        else Toast.makeText(getApplicationContext(),getResources().getString(R.string.tstAdvertencia), Toast.LENGTH_SHORT).show();
        editText.setText("");
    }

    //funcion que construe o dialog
    public Dialog construe(){
        AlertDialog.Builder builder = new AlertDialog.Builder(I_4B_a10jesuslb.this);
        builder.setTitle(getResources().getString(R.string.strTitulo));
        dict = new Hashtable<>();
        builder.setMultiChoiceItems(Aux.castArray(Aux.valores.toArray()), Aux.calculaBool(Aux.castArray(Aux.valores.toArray())), new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)dict.put(Aux.castArray(Aux.valores.toArray())[which], isChecked);
                else dict.remove(Aux.castArray(Aux.valores.toArray())[which]);

            }

        });
        builder.setNegativeButton(getResources().getString(R.string.btnCancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton(getResources().getString(R.string.btnAcept), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                TextView tv = (TextView) I_4B_a10jesuslb.this.findViewById(R.id.tvAmosa);
                tv.setText("");
                Enumeration<String> enu = dict.keys();
                String cade = new String("valores: ");
                while (enu.hasMoreElements()) {
                    cade = cade.concat(" " + enu.nextElement());

                }
                tv.setText(cade);

            }
        });
        return builder.create();
    }
}
