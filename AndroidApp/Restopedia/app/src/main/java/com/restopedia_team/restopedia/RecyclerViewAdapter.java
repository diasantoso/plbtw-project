package com.restopedia_team.restopedia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.restopedia_team.restopedia.Model.KontenDatum;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HERYATMO on 17/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<KontenDatum> item;


    public RecyclerViewAdapter(List<KontenDatum> list) {
        this.item = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, null);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(layoutView);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nResto.setText(item.get(position).getNamaResto());
        holder.dResto.setText(item.get(position).getDetailResto());
        Picasso.with(holder.itemView.getContext()).load(item.get(position).getGambar()).into(holder.gResto);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
