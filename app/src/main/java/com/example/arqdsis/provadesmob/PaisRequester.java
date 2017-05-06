package com.example.arqdsis.provadesmob;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class PaisRequester {
    OkHttpClient client = new OkHttpClient();

    public ArrayList<Pais> get (String url, String chave) throws IOException {
        ArrayList<Pais> lista = new ArrayList<>();
        System.out.println(url);
        // FormBody formBody = new FormBody.Builder().add("chave", chave).build();
        //System.out.println(formBody);
        //Request request = new Request.Builder().url(url).post(formBody).build();
        Request request = new Request.Builder().url(url).build();
        System.out.println(request);
        Response response = client.newCall(request).execute();
        System.out.println(response);
        String jsonString = response.body().string();
        System.out.println(jsonString);
        try{
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for(int i = 0; i < root.length(); i++){
                Pais p = new Pais();
                item = (JSONObject)root.get(i);
                p.setNome( item.getString("name") );

                int id = item.getInt("id");

                lista.add(p);
            }
        } catch (JSONException e){
            throw new IOException(e);
        } finally {
            if(lista.size() == 0){
                lista.add(new Pais());
            }
        }
        return lista;
    }
    public Bitmap getImage(String url) throws IOException{
        Bitmap img = null;

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }


}
