package com.hcb.recyclerviewstudy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hcb.recyclerviewstudy.utils.DimensionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class Adapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<String> list;
    private static final int HEIGHT = DimensionUtil.getInstance().dipToPix(50);

    public Adapter(Context context, List<String> data) {
        if (data == null) {
            list = new ArrayList<>();
        } else {
            list = data;
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item_view, null);
        itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, HEIGHT));
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.fillData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }
}
