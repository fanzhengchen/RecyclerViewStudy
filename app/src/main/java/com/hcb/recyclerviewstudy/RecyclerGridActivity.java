package com.hcb.recyclerviewstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.hcb.recyclerviewstudy.ItemHelper.ItemTouchCallback;
import com.hcb.recyclerviewstudy.ItemHelper.OnStartDragListener;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class RecyclerGridActivity extends BaseActivity implements OnStartDragListener {


    private static final String TAG = "RecyclerViewGridActivity";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private Adapter adapter;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_grid);
        ButterKnife.bind(this);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        String[] strings = getResources().getStringArray(R.array.dummy_items);
        List<String> data = Arrays.asList(strings);
        adapter = new Adapter(data, this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        ItemTouchHelper.Callback callback = new ItemTouchCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
