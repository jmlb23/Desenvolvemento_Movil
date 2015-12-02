package net.iessanclemente.ud_a3a_thread_a10jesuslb;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Random;


public class Index extends AppCompatActivity {


    Thread fio;
    //fagoo cun array porque a refencia é final non o contido
    int[] num_conta = new int[]{0};
    int[] num_conta_async = new int[]{0};
    TextView tv;


    AsyncTask<Void, Integer, Boolean> task;
    Handler ponte = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            TextView tv2 = (TextView) findViewById(R.id.txtVisualizar);
            tv2.setText(msg.arg1 + "");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);



    }

    public void onClickEmpezaThread(View view) {
        fio = new Thread() {

            boolean flag = true;

            {
                if(task!=null){
                    Toast.makeText(Index.this, "ainda esta correndo o AsyncTask...", Toast.LENGTH_SHORT).show();
                    flag=false;
                }

            }

            @Override
            public void run() {
                if(flag) {
                    int numero = (int) ((Math.random() * 5) + 1);
                    Message msg = new Message();
                    msg.arg1 = numero + 5;

                    ponte.sendMessage(msg);

                    for (int i = 1; i <= 30; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            this.interrupt();
                            num_conta[0] = i;
                            return;
                        }
                    }

                }
            }
        };
        fio.start();
    }

    public void onClickEmpezaAsinc(View view) {
        task = new AsyncTask<Void, Integer, Boolean>() {
            int valor = 0;
            @Override
            protected Boolean doInBackground(Void... params) {
                for (Integer i = 1; i <= 30; i++) {
                    num_conta_async[0]=i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
                return null;
            }

            @Override
            protected void onCancelled(Boolean aBoolean) {

            }



            @Override
            protected void onPreExecute() {
                if (fio != null) {
                    Toast.makeText(Index.this, "ainda esta correndo o Thread...", Toast.LENGTH_SHORT).show();
                    this.cancel(true);
                }else{
                    int numero = (int) ((Math.random() * 5) + 6);


                    tv = (TextView) findViewById(R.id.txtVisualizar);
                    tv.setText(""+numero);
                }
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
            }
        };
        task.execute();

    }


    public void onClickParaAsinc(View view) {
        task.cancel(true);
        task =null;
        tv = (TextView) findViewById(R.id.txtVisualizar);
        Toast.makeText(this, "" + (num_conta_async[0] == Integer.parseInt(tv.getText().toString()) ? "noraboa acertaches " + num_conta_async[0] : num_conta_async[0]), Toast.LENGTH_SHORT).show();
    }

    public void onClickParaThread(View view) {
        fio.interrupt();
        fio=null;
        tv = (TextView) findViewById(R.id.txtVisualizar);
        Toast.makeText(this, "" + (num_conta[0] == Integer.parseInt(tv.getText().toString()) ? "noraboa acertaches " + num_conta[0] : num_conta[0]), Toast.LENGTH_SHORT).show();

    }
}
