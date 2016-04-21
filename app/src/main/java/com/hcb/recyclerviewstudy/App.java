package com.hcb.recyclerviewstudy;

import android.app.Application;
import android.content.Context;

import com.hcb.recyclerviewstudy.utils.DimensionUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2016/4/18.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        DimensionUtil.init(context);
        Logger.init();
    }
}
