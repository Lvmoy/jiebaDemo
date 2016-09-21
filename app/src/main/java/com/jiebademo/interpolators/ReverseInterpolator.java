package com.jiebademo.interpolators;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

/**
 * Created by HP on 2016/9/14.
 */
public class ReverseInterpolator implements Interpolator {
    /**
     * Interpolator to reverse.
     */
    private final Interpolator mInterpolator;

    /**
     * Reverse interpolator constructor.
     *
     * @param interpolator Interpolator to reverse.
     */
    public ReverseInterpolator(@NonNull final Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }
    @Override
    public float getInterpolation(float input) {
        return 1 - mInterpolator.getInterpolation(input);
    }
}
