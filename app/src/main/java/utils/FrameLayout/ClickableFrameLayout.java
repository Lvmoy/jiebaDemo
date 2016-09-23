package utils.FrameLayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/** clickable frameLayout
 * intercept all the touch event
 * Created by lxy on 2016/9/22.
 */

public class ClickableFrameLayout extends FrameLayout{
    private OnClickListener  mOnClickListener;
    public ClickableFrameLayout(Context context) {
        super(context);
    }

    public ClickableFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ClickableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
        mOnClickListener = l;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mOnClickListener != null;
    }
}
