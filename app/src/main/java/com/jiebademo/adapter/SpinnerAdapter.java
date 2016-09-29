package com.jiebademo.adapter;

import android.content.Context;

import java.util.List;

import utils.niceSpinner.NiceSpinnerAdapter;

/**
 * segmented words items
 * Created by lxy on 2016/9/29.
 */

public class SpinnerAdapter extends NiceSpinnerAdapter{
    public SpinnerAdapter(Context context, List items, int textColor, int backgroundSelector) {
        super(context, items, textColor, backgroundSelector);
    }
}
