package com.hcb.recyclerviewstudy;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcb.recyclerviewstudy.ItemHelper.ItemTouchHelperViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {


    @Bind(R.id.handle)
    public ImageView handle;
    @Bind(R.id.text)
    public TextView textView;

    private View itemView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    public void fillData(String text) {
        textView.setText(text);
    }


    @Override
    public void onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public void onItemClear() {
        itemView.setBackgroundColor(0);
    }
}
