package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.app.Dialog;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Calendar;

public class U4_Coches_Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u4__coches__principal);
        RadioGroup rg = (RadioGroup) findViewById(R.id.grpElecion);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtEngade) {

                    if(!Environment.getExternalStorageDirectory().canWrite()){
                        Toast.makeText(getApplicationContext(), "non se pode escribir na sd saindo...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else if(checkedId == R.id.rbtSobre){
                    if(!Environment.getExternalStorageDirectory().canWrite()){
                        Toast.makeText(getApplicationContext(), "non se pode escribir na sd saindo...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }

    public void onClickEscribe(View view) {
        //non fai falla poñer teminacion porque xa mapea na clase R os Recursos
        boolean modo = false;
        OutputStreamWriter osw = null;
        RadioButton rbtEngade = (RadioButton) findViewById(R.id.rbtEngade);
        RadioButton rbtSobre = (RadioButton) findViewById(R.id.rbtSobre);
        EditText etCoche = (EditText) findViewById(R.id.etNome);

        if (rbtEngade.isChecked()) {
            modo = true;
        } else if (rbtSobre.isChecked()) {
            modo = false;
        }

        try {
            File f = getExternalFilesDir(null);
            osw  = new OutputStreamWriter(new FileOutputStream(new File(f.getAbsolutePath(),"hola"),modo));
            osw.write(etCoche.getText().toString().concat(" ").concat(Calendar.getInstance().getTime().toString()).concat("\n"));

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            etCoche.setText("");

        }

    }



    public void onClickModo(View view) {
        //mal implementado
        FramentoDialogo d = new FramentoDialogo();
        d.show(getFragmentManager(),"Elixe");

    }
}
