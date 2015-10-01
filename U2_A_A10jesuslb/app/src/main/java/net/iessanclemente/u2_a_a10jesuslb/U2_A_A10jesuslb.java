package net.iessanclemente.u2_a_a10jesuslb;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class U2_A_A10jesuslb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2__a__a10jesuslb);
        final CheckBox c = (CheckBox) findViewById(R.id.ckBox);
        //listener do checkbox
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText et = (EditText) findViewById(R.id.txtEdi);
                et.setText("");
            }
        });

        Switch s = (Switch) findViewById(R.id.swt);
        //listener do switch para o deslizamento
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                Chronometer c = (Chronometer) findViewById(R.id.crono);
                if (isChecked) {
                    c.setBase(SystemClock.elapsedRealtime());
                    c.start();

                } else {

                    c.stop();
                }
            }
        });
        Chronometer ch = (Chronometer) findViewById(R.id.crono);
        //listener do cronometro para os ticks
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                // TODO Auto-generated method stub
                if (chronometer.getText().toString().equals("00:15")) {
                    U2_A_A10jesuslb.this.finish();
                }

            }
        });

        final Spinner spn = (Spinner) findViewById(R.id.spn);
        //listener do spiner
        spn.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if (spn.getSelectedItem().toString().matches("Le[oó]n")) {
                    Toast.makeText(getApplicationContext(), R.string.text_toast_no_gal, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.text_toast_gal, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }


    //metodo asociado o boton agega
    public void agrega(View v) {

        TextView tv = (TextView) findViewById(R.id.txtLabel);
        EditText et = (EditText) findViewById(R.id.txtEdi);
        if (et.getText().toString().equals("")) {
            tv.setText("");
        }else {
            if(tv.getText().toString().equals("")) tv.append(et.getText());
            else tv.append(" "+et.getText());
        }

    }

    //metodo asociado os radios por cuestions de deseño non usei o radioGroup
    public void radios(View v) {

        RadioButton r = (RadioButton) v;
        if (r.getId() == R.id.rtbRed) {
            TextView tv = (TextView) findViewById(R.id.txtLabel);
            //esta deprecado
            tv.setTextColor(getResources().getColor(R.color.red));
            RadioButton rbt = (RadioButton) findViewById(R.id.rtbBlue);
            rbt.setChecked(false);
        } else {
            TextView tv = (TextView) findViewById(R.id.txtLabel);
            tv.setTextColor(getResources().getColor(R.color.blue));
            RadioButton rbt = (RadioButton) findViewById(R.id.rtbRed);
            rbt.setChecked(false);

        }
    }

    //metodo asociado o click da foto
    public void foto(View v) {
        Toast.makeText(getApplicationContext(), R.string.text_image, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u2__a__a10jesuslb, menu);
        return true;
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
