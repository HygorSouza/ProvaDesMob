package com.example.arqdsis.provadesmob;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Hygor Souza   RA: 201517433
 */
public class MainActivity extends Activity {
    EditText nomeRegiao;
    PaisRequester requester;
    Intent intent;
    ArrayList<Pais> lista;
    public static final String URI = "https://restcountries.eu/rest/v2/region/";
    public static final String LISTA = "prova.listaDePaises";

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeRegiao = (EditText) findViewById(R.id.nome_regiao);
    }


    /**
     * @author Hygor Souza   RA: 201517433
     */
    public void buscarRegiao(View view) {
        final String nome = nomeRegiao.getText().toString();
        requester = new PaisRequester();

        intent = new Intent(this, Tela2.class);

        if(requester.isConnected(this)) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(URI+nome,nome);
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
