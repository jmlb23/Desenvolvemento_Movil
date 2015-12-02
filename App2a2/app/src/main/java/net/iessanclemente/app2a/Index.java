package net.iessanclemente.app2a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.*;
import java.util.ArrayList;

public class Index extends Activity {
    private final int VALOR = 0xffff;
    private ImageView img;
    private final String RUTA = "/UD-A2A/MUSICA";
    private final String RUTA_FOTO = "/UD-A2A/FOTO";
    private File rutaSd = new File(Environment.getExternalStorageDirectory().getPath());
    private File rutaMusica = new File(rutaSd.getPath().concat(RUTA));
    private File rutaFotos = new File(rutaSd.getPath().concat(RUTA_FOTO));
    private ArrayList<String> listRutas = new ArrayList<>();
    private Spinner spn;
    //traballo cunha soa instancia por activity de MediaPlayer e MediaRecorder
    MediaPlayer mp = new MediaPlayer();
    private MediaRecorder mRecorder = new MediaRecorder();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        creaCartafol();
        copiaAssets();
        cargaSpinner(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == VALOR) {
            img = (ImageView) findViewById(R.id.imgAmosa);
            img.setImageBitmap(BitmapFactory.decodeFile(new File(rutaFotos.getAbsolutePath().concat("/foto.jpg")).getPath()));

        }
    }

    public void onClickReproduce(View view) {
        String cancion = listRutas.get(spn.getSelectedItemPosition());
        Button b = (Button)findViewById(R.id.btnReproduce);

        if(b.getText().equals(getResources().getString(R.string.strBtnReproducir))) {
            mp.reset();
            try {
                mp.setDataSource(cancion);
                mp.prepare();


            } catch (IOException e) {
                Log.i(getPackageName(), e.getMessage());
            }
            mp.start();
            b.setText(getString(R.string.strPara));
        }
        else if(b.getText().equals(getString(R.string.strPara))){
            mp.stop();
            b.setText(getResources().getString(R.string.strBtnReproducir));
        }
    }

    public void onClickGrava(View view) {

        Button b = (Button)findViewById(R.id.btnGrava);
        if(b.getText().equals(getResources().getString(R.string.strBtnGravar))) {
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setOutputFile(rutaMusica.getAbsolutePath().concat("/record.3gp"));
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            try {
                mRecorder.prepare();
            } catch (IOException e) {
                Log.e(this.getPackageName(), "prepare() failed");
            }

            mRecorder.start();
            b.setText(getResources().getString(R.string.strBtnParaGravar));
        }else if(b.getText().toString().equals(getResources().getString(R.string.strBtnParaGravar))){
            mRecorder.release();
            b.setText(getResources().getString(R.string.strBtnGravar));
        }





    }

    public void onClickFoto(View view) {
        Intent foto = new Intent();
        foto.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        if (!new File(rutaFotos.getAbsolutePath().concat("/foto.jpg")).exists()) {
            try {
                new File(rutaFotos.getAbsolutePath().concat("/foto.jpg")).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //problema se lle digo que mo garde nun arquivo non o envia no bundle
        foto.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(rutaFotos.getAbsolutePath().concat("/foto.jpg"))));

        startActivityForResult(foto, VALOR);


    }

    public void cargaSpinner(boolean limpa) {
        spn = (Spinner) findViewById(R.id.spnMusica);

        if (limpa) {
            listRutas.clear();
        }
        for (File l : rutaMusica.listFiles()) {
            listRutas.add(l.getAbsolutePath());
            Log.i(this.getPackageName().concat("LISTA"), l.getAbsolutePath());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, listRutas);
        spn.setAdapter(adapter);


    }

    public void creaCartafol() {

        if (!rutaMusica.exists() || !rutaFotos.exists()) {
            rutaMusica.mkdirs();
            rutaFotos.mkdirs();


        } else {
            return;
        }
    }

    public void copiaAssets() {


        AssetManager am = getAssets();
        String cancion1 = "reverse.mp3";
        String cancion2 = "rimsample.mp3";
        try {
            InputStream is = am.open(cancion1);
            FileOutputStream fos = new FileOutputStream(rutaMusica.getAbsolutePath().concat("/" + cancion1));
            int valor = 0;
            while ((valor = is.read()) > -1) {
                fos.write(valor);
                fos.flush();
            }
            is = am.open(cancion2);
            fos = new FileOutputStream(rutaMusica.getAbsolutePath().concat("/" + cancion2));
            valor = 0;
            while ((valor = is.read()) > -1) {
                fos.write(valor);
                fos.flush();
            }
            is.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
