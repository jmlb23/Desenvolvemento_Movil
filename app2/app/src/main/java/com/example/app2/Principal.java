package com.example.app2;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal extends Activity {
    private final int VALOR = 0xffff;
    private ImageView img;
    private final String RUTA = "/UD-A2A/MUSICA";
    private final String RUTA_FOTO = "/UD-A2A/FOTO";
    private File rutaSd = new File(Environment.getExternalStorageDirectory().getPath());
    private File rutaMusica = new File(rutaSd.getPath().concat(RUTA));
    private File rutaFotos = new File(rutaSd.getPath().concat(RUTA_FOTO));
    private ArrayList<String> listRutas = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        creaCartafol();
        cargaSpinner();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == VALOR) {
            img = (ImageView)findViewById(R.id.imgAmosa);
            img.setImageBitmap(BitmapFactory.decodeFile(new File(rutaFotos.getAbsolutePath().concat("/foto.jpg")).getPath()));
        }
    }

    public void onClickReproduce(View view) {

    }

    public void onClickGrava(View view) {

    }

    public void onClickFoto(View view) {
        Intent foto = new Intent();
        foto.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        if(!new File(rutaFotos.getAbsolutePath().concat("/foto.jpg")).exists()) {
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

    public void cargaSpinner() {
        Spinner spn = (Spinner) findViewById(R.id.spnMusica);
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
}
