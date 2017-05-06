package com.example.arqdsis.provadesmob;

import android.widget.TextView;


/**
 * @author Hygor Souza   RA: 201517433
 */
public class ViewHolder {
    private TextView nomePais;

    /**
     * @author Hygor Souza   RA: 201517433
     */
    public ViewHolder(TextView nomePais) {
        this.nomePais = nomePais;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    public TextView getNomePais() {
        return nomePais;
    }

    /**
     * @author Hygor Souza   RA: 201517433
     */
    public void setNomePais(TextView nomePais) {
        this.nomePais = nomePais;
    }



}
