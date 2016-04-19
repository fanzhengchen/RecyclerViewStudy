package com.hcb.recyclerviewstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class RecyclerGridActivity extends BaseActivity {


    private static final String TAG = "RecyclerViewGridActivity";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_grid);
        ButterKnife.bind(this);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        String[] strings = getResources().getStringArray(R.array.main_items);
        List<String> data = Arrays.asList(strings);
        Logger.d(TAG, data.size());
        adapter = new Adapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
