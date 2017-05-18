package com.restopedia_team.restopedia;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by HERYATMO on 17/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView nResto, dResto;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        nResto = (TextView) itemView.findViewById(R.id.name);
        dResto = (TextView) itemView.findViewById(R.id.hobby);
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
    }
}
