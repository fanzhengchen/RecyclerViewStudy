package com.hcb.recyclerviewstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/12/16.
 */
public class RecyclerListActivity extends AppCompatActivity {

    @Bind(R.id.recyclerViewList)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_list);
        ButterKnife.bind(this);
    }


}
