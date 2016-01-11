package net.iessanclemente.ud_a_45_a_a10jesuslb;

import android.content.AsyncQueryHandler;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String rutaSD = Environment.getExternalStorageDirectory().getAbsolutePath();
    ArrayList<Dire>contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickDescarga(View view) throws InterruptedException {
        TextView textView = (TextView)findViewById(R.id.tvTexto);
        Thread fioDescarga = new Thread(new Runnable(){

            @Override
            public void run() {
                OutputStream os;
                InputStream is;

                try {
                    URL url = new URL("http://manuais.iessanclemente.net/images/2/20/Platega_pdm_rutas.xml");
                    HttpURLConnection cnn = null;
                    cnn = (HttpURLConnection)url.openConnection();
                    cnn.setConnectTimeout(15000);
                    cnn.setReadTimeout(10000);
                    cnn.setRequestMethod("POST");
                    cnn.setDoInput(true);

                    cnn.connect();

                    int codigo = cnn.getResponseCode();

                    if(codigo != HttpURLConnection.HTTP_OK){
                        return;
                    }else{
                        os = new FileOutputStream(new File(rutaSD.concat("/Platega_pdm_rutas.xml")));
                        is = cnn.getInputStream();
                        int cont=0;
                        byte[] buffer = new byte[1024];

                        while((cont = is.read(buffer))!=-1){
                            os.write(buffer,0,cont);
                        }

                        os.flush();
                        os.close();
                        is.close();
                        cnn.disconnect();


                    }

                }catch(MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        Thread fioXML = new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    FileInputStream is = new FileInputStream(new File(rutaSD.concat("/Platega_pdm_rutas.xml")));

                    XmlPullParser parser = Xml.newPullParser();
                    parser.setInput(is, "UTF-8");

                    int evento = parser.nextTag();
                    Dire contacto = null;

                    while (evento != XmlPullParser.END_DOCUMENT) {
                        if (evento == XmlPullParser.START_TAG) {
                            if (parser.getName().equals("ruta")) {      // Un novo contacto
                                contacto = new Dire();
                                evento = parser.nextTag();      // Pasamos a <nome>
                                contacto.setNome(parser.nextText());
                                evento = parser.nextTag();      // Pasamos a <dir>
                                contacto.setDescripcion(parser.nextText());
                            }
                        }
                        if (evento == XmlPullParser.END_TAG) {
                            if (parser.getName().equals("ruta")) {      // Un novo contacto
                                contactos.add(contacto);
                            }
                        }

                        evento = parser.next();
                    }

                    is.close();
                }catch(IOException e){

                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


            }
        });
        fioDescarga.start();
        fioDescarga.join();
        fioXML.start();
        fioXML.join();

        for(Dire d : contactos){
            textView.setText(textView.getText()+d.toString());
        }
    }
}
