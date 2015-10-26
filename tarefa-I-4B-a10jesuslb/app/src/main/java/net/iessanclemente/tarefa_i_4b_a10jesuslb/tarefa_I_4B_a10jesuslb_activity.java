package net.iessanclemente.tarefa_i_4b_a10jesuslb;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class tarefa_I_4B_a10jesuslb_activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa__i_4_b_a10jesuslb_activity);
    }

    public void onClickShow(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
       //showDialog();
        gete
    }

    public void onClickEngade(View view) {
        EditText et = (EditText)findViewById(R.id.etNovo);
        DialogoFrag.l =  et.getText().toString().split("\n");
    }

    public void onClickDialog(View view) {
        DialogoFrag d = new DialogoFrag();
        d.show(getSupportFragmentManager(), "");
    }
}
