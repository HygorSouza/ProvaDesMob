package com.example.arqdsis.provadesmob;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.okhttp.internal.Util;

/**
 * Created by arqdsis on 05/05/2017.
 */
public class PaisAdapter extends BaseAdapter {
    Activity context;
    Pais [] paises;

    public PaisAdapter(Activity context, Pais[] paises) {
        this.context = context;
        this.paises = paises;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    public int getCount() {
        return paises.length;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    public Object getItem(int position){
        if(position >= 0 && position < paises.length)
            return paises[position];
        else
            return null;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        //se nao recebeu um layout para reutilizar deve inflar um
        if(view == null) {
            //um inflater transforma um layout em uma view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_pais, parent, false);

           // ImageView letraCliente = (ImageView) view.findViewById(R.id.foto_cliente);
            TextView nomeCliente = (TextView)view.findViewById(R.id.nome_pais);
            //TextView detalheCliente = (TextView)view.findViewById(R.id.detalhe_cliente);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder( nomeCliente));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores

        //Drawable drawable = Util.getDrawable(context, paises[position].getIniciais());
        //holder.getFotoCliente().setImageDrawable(drawable);

        holder.getNomePais().setText(paises[position].getNome());
       // holder.getDetalheCliente().setText(String.format("%s - %s", clientes[position].getFone(),
           //     clientes[position].getEmail()));

        return view;
    }
}
