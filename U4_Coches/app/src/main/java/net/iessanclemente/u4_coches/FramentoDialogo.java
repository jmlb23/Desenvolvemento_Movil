package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FramentoDialogo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setCancelable(false);
        adb.setTitle(getTag());
        final String[] arr = new String[]{
                "ListView", "Spiner"
        };

        adb.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BufferedReader br = null;
                Intent envia = new Intent();
                File f = getActivity().getExternalFilesDir(null);
                File f2 = new File(f.getAbsolutePath(),"hola");
                StringBuilder sb = new StringBuilder();

                if (which == 0) {

                    try {
                        br = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));

                        String s = null;
                        boolean flag = true;
                        while(flag){

                            s=br.readLine();

                            if(s==null) {
                                flag = false;
                                continue;
                            }else{

                                sb.append(s).append("|");
                            }
                        }
                        Log.d("VALOR", sb.toString());
                        envia.setClassName(getActivity(), Vista_Texto.class.getName().toString());
                        envia.putExtra("VALORES", sb.toString());
                        envia.putExtra("TIPO",arr[which]);
                        startActivity(envia);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dismiss();
                } else if (which == 1) {
                    try {
                        br = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));

                        String s = null;
                        boolean flag = true;

                        while(flag){

                            s=br.readLine();

                            if(s==null) {
                                flag = false;
                                continue;
                            }else{

                                sb.append(s).append("|");
                            }
                        }
                        Log.d("VALOR", sb.toString());
                        envia.setClassName(getActivity(), Vista_Texto.class.getName().toString());
                        envia.putExtra("VALORES", sb.toString());
                        envia.putExtra("TIPO",arr[which]);
                        startActivity(envia);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dismiss();
                }
            }
        });
        return adb.create();
    }
}
