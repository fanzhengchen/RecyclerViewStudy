package com.hcb.recyclerviewstudy.utils;

import android.content.Context;

/**
 * Created by Administrator on 2016/4/18.
 */
public class DimensionUtil {
    private static Context context;
    private static float scale;
    private static volatile DimensionUtil instance = null;

    public static void init(Context ctx) {
        context = ctx;
        scale = ctx.getResources().getDisplayMetrics().density;
    }

    public static DimensionUtil getInstance() {
        DimensionUtil dimensionUtil = instance;
        if (dimensionUtil == null) {
            synchronized (DimensionUtil.class) {
                dimensionUtil = instance;
                if (dimensionUtil == null) {
                    dimensionUtil = new DimensionUtil();
                    instance = dimensionUtil;
                }
            }
        }
        return dimensionUtil;
    }


    public int pixToDip(float pixels) {
        return (int) (pixels / scale + 0.5);
    }

    public int dipToPix(float dip) {
        return (int) (dip * scale + 0.5);
    }
}
