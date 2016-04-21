package com.hcb.recyclerviewstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.hcb.recyclerviewstudy.ItemHelper.ItemTouchCallback;
import com.hcb.recyclerviewstudy.ItemHelper.OnStartDragListener;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class RecyclerListActivity extends BaseActivity implements OnStartDragListener {

    @Bind(R.id.recyclerViewList)
    RecyclerView recyclerView;


    private Adapter adapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_list);
        ButterKnife.bind(this);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        String[] data = getResources().getStringArray(R.array.dummy_items);
        adapter = new Adapter(Arrays.asList(data), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper.Callback callback = new ItemTouchCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
