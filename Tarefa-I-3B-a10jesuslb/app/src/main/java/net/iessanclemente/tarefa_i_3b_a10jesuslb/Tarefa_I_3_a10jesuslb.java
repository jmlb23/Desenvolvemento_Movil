package net.iessanclemente.tarefa_i_3b_a10jesuslb;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;


public class Tarefa_I_3_a10jesuslb extends FragmentActivity {


    private DialogoFragmento d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa__i_3_a10jesuslb);
        d = new DialogoFragmento();


    }

    public void xenerico(View v) {
        Bundle fei = new Bundle();
        switch (v.getId()) {
            case R.id.btnDialogMensaxe:
                fei.putInt("VALOR", v.getId());
                //poñolle argumentos o a clase que extende DialogFragment mediante un bundle
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;
            case R.id.btnDialogBotons:
                fei.putInt("VALOR", v.getId());
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;
            case R.id.btnLista:
                fei.putInt("VALOR", v.getId());
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;
            case R.id.btnUnica:
                fei.putInt("VALOR", v.getId());
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;
            case R.id.btnMultiple:
                fei.putInt("VALOR", v.getId());
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;
            case R.id.btnDialogoTexto:
                fei.putInt("VALOR", v.getId());
                d.setArguments(fei);
                d.show(getSupportFragmentManager(), "");
                break;

        }
    }
}
