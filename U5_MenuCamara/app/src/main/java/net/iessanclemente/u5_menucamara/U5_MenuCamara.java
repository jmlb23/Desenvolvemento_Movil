package net.iessanclemente.u5_menucamara;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class U5_MenuCamara extends AppCompatActivity {
    private Intent t;
    private final int VALOR_ENVIO = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u5__menu_camara);
        TextView tv = (TextView) findViewById(R.id.tvLanza);

        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menucamara, menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView im = (ImageView) findViewById(R.id.imgView);

        if (resultCode == RESULT_OK && requestCode == VALOR_ENVIO) {
            im.setVisibility(View.VISIBLE);
            im.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnlanza:

                t = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(t, VALOR_ENVIO);
                return true;
            case R.id.btncerra:
                finish();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucamara, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnlanza:

                t = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(t, VALOR_ENVIO);
                return true;
            case R.id.btncerra:
                finish();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }

    }
}
