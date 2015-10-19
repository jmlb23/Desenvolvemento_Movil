package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        boolean modo = false;
        OutputStreamWriter osw = null;
        RadioButton rbtEngade = (RadioButton) findViewById(R.id.rbtEngade);
        RadioButton rbtSobre = (RadioButton) findViewById(R.id.rbtSobre);
        EditText etCoche = (EditText) findViewById(R.id.etNome);
        String nome = "hola";
        String cade = null;
        File f = null;
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        if (rbtEngade.isChecked()) {
            modo = true;
        } else if (rbtSobre.isChecked()) {
            modo = false;
        }

        try {
            f = getExternalFilesDir(null);
            osw  = new OutputStreamWriter(new FileOutputStream(new File(f.getAbsolutePath(),nome),modo));
            cade = etCoche.getText().toString().concat(" - ").concat(df.format(Calendar.getInstance().getTime())).concat("\n");
            osw.write(cade);
            Log.i("RUTA", f.getAbsolutePath().concat("/").concat(nome));
            Log.i("MENSAXE",cade);
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
        FramentoDialogo d = new FramentoDialogo();
        d.show(getFragmentManager(), "Elixe");

    }
}
