package com.plbtw_asek.restopedia;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.plbtw_asek.restopedia.API.ApiClient;
import com.plbtw_asek.restopedia.API.ApiInterface;
import com.plbtw_asek.restopedia.Model.StatusMessage;
import com.restopedia_team.restopedia.R;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HERYATMO on 17/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nResto;
    public ImageView gResto;

    public String id, nama, detil, alamat, kota;

    public int status;

    StatusMessage statusMessage;

    public RecyclerViewHolder(View itemView, int status) {
        super(itemView);

        itemView.setOnClickListener(this);

        nResto = (TextView) itemView.findViewById(R.id.name);
        gResto = (ImageView) itemView.findViewById(R.id.cover);

        this.status = status;
    }

    @Override
    public void onClick(View view) {
        if(status == 0) {
            new LovelyStandardDialog(view.getContext())
                    .setTopColorRes(R.color.primary_dark)
                    .setTitle("Detail Resto")
                    .setMessage("Resto Name : "+nama+"\n"+
                            "Detail : "+detil+"\n"+
                            "Address : "+alamat+"\n"+
                            "City : "+kota)
                    .setNeutralButton("Cancel", null)
                    .show();
        } else if(status == 1) {
            new LovelyStandardDialog(view.getContext())
                    .setTopColorRes(R.color.primary_dark)
                    .setTitle("Detail Resto")
                    .setMessage("Resto Name : "+nama+"\n"+
                            "Detail : "+detil+"\n"+
                            "Address : "+alamat+"\n"+
                            "City : "+kota)
                    .setPositiveButton("Delete", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            delKonten();
                        }
                    })
                    .setNeutralButton("Cancel", null)
                    .show();
        }
    }

    void delKonten() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StatusMessage> call = apiService.delKonten("tLRJEVQGkZNpmB7sxq3218", id);
        call.enqueue(new Callback<StatusMessage>() {
            @Override
            public void onResponse(Call<StatusMessage> call, Response<StatusMessage> response) {
                statusMessage = response.body();
                Log.i("Success", "Upload Success");
            }

            @Override
            public void onFailure(Call<StatusMessage> call, Throwable t) {
                Log.i("Failed", "Upload Failed");
            }
        });
    }
}
