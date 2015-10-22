package net.iessanclemente.tarefa_i_4b_a10jesuslb;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import java.util.List;


public class DialogoFrag extends DialogFragment{

    public static String[] l;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMultiChoiceItems(l, comproba(l), new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        return builder.create();
    }

    public boolean[] comproba(String... s){
        boolean[] b = new boolean[s.length];

        for(int i =0; i<b.length; i++){
            b[i] = false;
        }
        return b;
    }
}
