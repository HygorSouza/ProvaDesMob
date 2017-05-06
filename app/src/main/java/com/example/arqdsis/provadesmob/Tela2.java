package com.example.arqdsis.provadesmob;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * @author Hygor Souza   RA: 201517433
 */
public class Tela2 extends Activity {
    ArrayList<Pais> lista;

    public static final String NOME = "pais.nome";

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent intent = getIntent();
        lista = (ArrayList<Pais>)intent.getSerializableExtra(MainActivity.LISTA);
        BaseAdapter adapter = new PaisAdapter(this, lista.toArray(new Pais[0]));
        ListView listView = (ListView) findViewById(R.id.lista_paises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent( Tela2.this , DetalhePaisActivity.class);
                intent.putExtra(NOME, lista.get(position).getNome());


                startActivity(intent);

            }

        });
    }
}
