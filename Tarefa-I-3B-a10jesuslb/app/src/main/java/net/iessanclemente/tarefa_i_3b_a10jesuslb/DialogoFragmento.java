package net.iessanclemente.tarefa_i_3b_a10jesuslb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jesus on 10/12/15.
 */
public class DialogoFragmento extends DialogFragment {

    private AlertDialog.Builder v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getContext(),Tarefa_I_3_a10jesuslb.tipo.toString(),Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        switch (getArguments().getInt("VALOR")) {
            case R.id.btnDialogMensaxe:
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getResources().getString(R.string.textoTitulo));
                v.setMessage(getResources().getString(R.string.texto));

                return v.create();
            case R.id.btnDialogBotons:
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getResources().getString(R.string.botonsTitulo));
                v.setCancelable(false);
                v.setMessage(getResources().getString(R.string.botons));
                v.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches aceptar", Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches cancelar", Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNeutralButton(R.string.neutro, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches Pode ser", Toast.LENGTH_SHORT).show();
                    }
                });
                return v.create();

            case R.id.btnLista:
                //non pode ter message
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getResources().getString(R.string.listaTitulo));
                v.setItems(R.array.arrayLista, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return v.create();
            case R.id.btnUnica:
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getString(R.string.unica));
                v.setSingleChoiceItems(R.array.arrayLista, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return v.create();
            case R.id.btnMultiple:
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getString(R.string.mulTitulo));
                v.setMultiChoiceItems(R.array.arrayLista, new boolean[]{true, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(getContext(), isChecked ? "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which] : "Deselecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Selecionaches o " + getResources().getStringArray(R.array.arrayLista)[which], Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return v.create();
            case R.id.btnDialogoTexto:
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
                View vista = layoutInflater.inflate(R.layout.message_layout, null);
                final EditText usuario = (EditText) vista.findViewById(R.id.etuser);
                final EditText contrasinal = (EditText) vista.findViewById(R.id.etpass);
                v = new AlertDialog.Builder(getContext());
                v.setTitle(getString(R.string.dialogoTexto));
                v.setView(vista);
                v.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "O usuario é " + usuario.getText().toString() + "\nO contrasinal é " + contrasinal.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                v.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                return v.create();

        }
        return null;
    }
}
