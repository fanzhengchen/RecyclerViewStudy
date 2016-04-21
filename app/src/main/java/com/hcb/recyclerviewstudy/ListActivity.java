package com.hcb.recyclerviewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fanzhengchen on 4/17/16.
 */
public class ListActivity extends AppCompatActivity {

    @Bind(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
    }

//    @OnTextChanged(R.id.editText)
//    public void change(EditText editText) {
//        Logger.i(this.getLocalClassName(), editText.toString());
//    }
}
