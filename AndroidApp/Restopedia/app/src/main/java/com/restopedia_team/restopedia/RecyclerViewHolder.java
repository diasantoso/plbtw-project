package com.restopedia_team.restopedia;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

/**
 * Created by HERYATMO on 17/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nResto;
    public ImageView gResto;

    public String nama, detil, alamat, kota;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        nResto = (TextView) itemView.findViewById(R.id.name);
        gResto = (ImageView) itemView.findViewById(R.id.cover);
    }

    @Override
    public void onClick(View view) {
        new LovelyStandardDialog(view.getContext())
                .setTopColorRes(R.color.primary_dark)
                .setTitle("Detail Resto")
                .setMessage("Resto Name : "+nama+"\n"+
                            "Detail : "+detil+"\n"+
                            "Address : "+alamat+"\n"+
                            "City : "+kota)
                .setNeutralButton("Cancel", null)
                .show();
    }
}
