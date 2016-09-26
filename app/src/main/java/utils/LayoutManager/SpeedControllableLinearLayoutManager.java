package utils.LayoutManager;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
 * Created by HP on 2016/9/26.
 */

public class SpeedControllableLinearLayoutManager extends LinearLayoutManager {
    private float MILLISECONDS_PER_INCH = 0.03f;
    private Context context;

    public SpeedControllableLinearLayoutManager(Context context) {
        super(context);
        this.context = context;
    }

    public SpeedControllableLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;

    }

    public SpeedControllableLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.context = context;

    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()){
            @Nullable
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return SpeedControllableLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }

            /**
             * 主要就是重写他
             * @param displayMetrics 屏幕信息
             * @return 滑动每个像素所需的时间
             */
            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return MILLISECONDS_PER_INCH / displayMetrics.density;
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    public float getMILLISECONDS_PER_INCH() {
        return MILLISECONDS_PER_INCH;
    }

    public void setMILLISECONDS_PER_INCH(float MILLISECONDS_PER_INCH) {
        this.MILLISECONDS_PER_INCH = MILLISECONDS_PER_INCH;
    }


}
