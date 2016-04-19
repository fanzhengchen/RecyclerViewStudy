package com.hcb.recyclerviewstudy;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.handle)
    ImageView handle;
    @Bind(R.id.text)
    TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void fillData(String text) {
        textView.setText(text);
    }
}
