package net.iessanclemente.u3_a10jesuslb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.btnDtTlf);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int VALOR = 43;
                Intent t = new Intent();
                t.setClass(getApplicationContext(), U3_a10jesuslb_secundaria.class);
                startActivityForResult(t, VALOR);
            }
        });
        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(0);
                return true;
            }
        });

        Button datos = (Button) findViewById(R.id.btnDatos);
        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = getIntent();
                if (!t.hasExtra("TEXTO") && !t.hasExtra("TELEFONO")) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.tstDatos), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Correo: " + t.getStringExtra("TEXTO") + "\n" + "Telefono: " + t.getStringExtra("TELEFONO"), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**
     * fago uso de getIntent().getStringExtra() en vez dun string porque estou dentro dunha clase anonima
     * e se usase un string seria final e non poderia ser modificada
     * unha vez que volvese da actividade xa teria un valor por defecto
     *
     * @param id
     * @return Dialog
     */
    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == 0) {

            AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
            d.setTitle(getResources().getString(R.string.selec));
            CharSequence[] s = {getResources().getString(R.string.strTlf), getResources().getString(R.string.strText)};

            d.setSingleChoiceItems(s, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent t = null;
                    if (which == 0) {
                        dialog.dismiss();
                        if (getIntent().getStringExtra("TELEFONO") != null && !getIntent().getStringExtra("TELEFONO").equals("")) {
                            try {
                                t = new Intent();
                                t.setAction(Intent.ACTION_CALL);
                                t.setData(Uri.parse("tel:" + getIntent().getStringExtra("TELEFONO")));
                                MainActivity.this.startActivity(t);
                            } catch (SecurityException e) {
                                Log.w("erro", e.getMessage());
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.strNoTlf), Toast.LENGTH_SHORT).show();


                        }
                    } else {
                        dialog.dismiss();
                        //tiña un erro con Action_Search xa que usa calquer app na que se poida buscar unha cadea de texto
                        t = new Intent(Intent.ACTION_WEB_SEARCH);
                        if (getIntent().getStringExtra("TEXTO") != null && !getIntent().getStringExtra("TEXTO").equals("")) {


                            t.putExtra(SearchManager.QUERY, getIntent().getStringExtra("TEXTO"));
                            startActivity(t);


                        } else {

                            t.putExtra(SearchManager.QUERY, "casa");
                            startActivity(t);
                        }
                    }
                }
            });
            d.setNegativeButton(getResources().getString(R.string.btnCancelar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            return d.create();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 43) {
            setIntent(data);
            //Toast.makeText(getApplicationContext(),"chegou",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
