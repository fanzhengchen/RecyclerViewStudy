package com.hcb.recyclerviewstudy.ItemHelper;

/**
 * Created by fanzhengchen on 4/17/16.
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
