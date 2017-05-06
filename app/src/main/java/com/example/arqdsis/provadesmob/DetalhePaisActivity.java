package com.example.arqdsis.provadesmob;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

/**
 * @author Hygor Souza   RA: 201517433
 */
public class DetalhePaisActivity extends AppCompatActivity {
   Pais pais;
    PaisRequester requester;


    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        Intent intent = getIntent();
        pais = new Pais();
        pais.setNome(intent.getStringExtra(Tela2.NOME));

        requester = new PaisRequester();
        if(requester.isConnected(this)) {
            //usando AsyncTask - veja a class DownloadImageTask abaixo
            new DowloadImageTask().execute();

        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    private class DowloadImageTask extends AsyncTask<String, Void, Bitmap> {

        /**
         * @author Hygor Souza   RA: 201517433
         */
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
              //  img = requester.getImage(MainActivity.URI);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return img;
        }

        /**
         * @author Hygor Souza   RA: 201517433
         */
        @Override
        protected void onPostExecute(Bitmap img){
           // clienteImageView.setImageBitmap(img);
        }
    }

}

