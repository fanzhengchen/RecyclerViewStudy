package com.hcb.recyclerviewstudy;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hcb.recyclerviewstudy.ItemHelper.ItemTouchHelperAdapter;
import com.hcb.recyclerviewstudy.ItemHelper.OnStartDragListener;
import com.hcb.recyclerviewstudy.utils.DimensionUtil;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class Adapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    private List<String> list;
    private static final int HEIGHT = DimensionUtil.getInstance().dipToPix(50);
    private final OnStartDragListener mOnStartDragListener;

    public Adapter(List<String> data, OnStartDragListener onStartDragListener) {
//        Logger.d("fuck", context.toString());
        if (data == null) {
            list = new ArrayList<>();
        } else {
            list = data;
        }
        mOnStartDragListener = onStartDragListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.item_view, null);
        itemView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, HEIGHT));
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        Logger.d(list.get(position));
        holder.fillData(list.get(position));
        holder.handle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
}
