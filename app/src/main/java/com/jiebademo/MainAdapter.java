package com.jiebademo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiebademo.interpolators.ReverseInterpolator;

import java.io.InputStream;

import utils.FrameLayout.ClickableFrameLayout;
import utils.bubbleView.BubbleDrawable;
import utils.bubbleView.BubbleImageView;
import utils.niceSpinner.NiceSpinner;

/**
 * Created by lxy on 2016/9/5.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    /**
     * Value for no item expanded.
     */
    public static final int NONE = -1;

    /**
     * context
     */
    private final Context context;

    /**
     * 语句集合
     */
    private final String[] items;

    /**
     * On item size listener.
     */
    private OnItemSizeListener onItemSizeListener;

    /**
     * On item click listener.
     */
    private OnItemClickListener onItemClickListener;

    /**
     * On item up flick listener
     */
    private OnItemUpFlickListener onItemUpFlickListener;

    /**
     * On item down flick listener
     */
    private OnItemDownFlickListener onItemDownFlickListener;

    /**
     * Current expanded view holder.
     */
    private ViewHolder currentExpandedViewHolder;


    /**
     * Current expanded item.
     */
    private int currentExpandedItem = -1;
    /**
     * 1 是对方来消息，在上方    0是自己发送的消息，在下方
     */
    private  int TYPE = -1;
    private boolean isFingerSliding = false;

    private float mBeginPosX ;
    private float mBeginPosY ;
    private float mEndPosX ;
    private float mEndPosY ;

    public MainAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(onItemSizeListener != null){
                    onItemSizeListener.onItemSize(view.getMeasuredWidth());
                }
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if(currentExpandedViewHolder == holder){
            currentExpandedViewHolder = null;
    }

        if(currentExpandedItem == position){
            currentExpandedViewHolder = holder;
        }

        if(position != -1 && position % 2 == 0 ){
            holder.bottomHead.setVisibility(View.GONE);
            holder.topHead.setVisibility(View.VISIBLE);
            holder.textImageView.setmArrowLocation(BubbleDrawable.ArrowLocation.TOP);
            holder.textImageView.setmArrowPosition(50);
            holder.textImageView.setImageResource(R.drawable.simple);
            holder.textLayout.setCardBackgroundColor(Color.TRANSPARENT);
            holder.textLayout.setCardElevation(0);
            holder.textLayout.setMaxCardElevation(0);
  //          holder.textLayout.setPadding(20, 70, 20, 0);

        }else if(position != -1 && position % 2 == 1 ){
            holder.topHead.setVisibility(View.GONE);
            holder.bottomHead.setVisibility(View.VISIBLE);
            holder.textImageView.setmArrowLocation(BubbleDrawable.ArrowLocation.BOTTOM);
            holder.textImageView.setmArrowPosition(325);
            holder.textImageView.setImageResource(R.drawable.flower);
            holder.textLayout.setCardBackgroundColor(Color.TRANSPARENT);
            holder.textLayout.setCardElevation(0);
            holder.textLayout.setMaxCardElevation(0);
  //          holder.textLayout.setPaddingRelative(20, 0, 20, 70);
  //          holder.textLayout.setPadding(20, 0, 20, 70);
        }
        holder.textView.setText(items[position]);

        holder.frameLayout.setLongClickable(true);
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position, holder);
                }
            }
        });

        holder.frameLayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        mBeginPosX = event.getX();
                        mBeginPosY = event.getY();
//                        if(onItemDownFlickListener != null){
//                            onItemDownFlickListener.OnDownFlick(position, holder, currentExpandedItem);
//                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mEndPosX = event.getX();
                        mEndPosY = event.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        if((mEndPosY - mBeginPosY) > 0 && Math.abs(mEndPosY - mBeginPosY) > 25 && Math.abs(mEndPosX - mBeginPosX) < 170){
                            if(onItemUpFlickListener != null){
                                onItemDownFlickListener.OnDownFlick(position, holder, currentExpandedItem);
                                isFingerSliding = true;
                            }
                        }else if((mEndPosY - mBeginPosY) < 0 && Math.abs(mEndPosY - mBeginPosY) > 25 && Math.abs(mEndPosX - mBeginPosX) < 170){
                            if(onItemDownFlickListener != null){
                                onItemUpFlickListener.OnUpFlick(position, holder, currentExpandedItem);
                                isFingerSliding = true;
                            }
                        }

                        break;
                }
                if(isFingerSliding){
                    isFingerSliding = false;

                    return true;
                }
                else{
                    return false;
                }
            }
        });

        holder.keysSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(currentExpandedItem == position){
            expandView(holder, false);
        }else {
            collapseView(holder, false);
        }
    }

    private void collapseView(ViewHolder holder, boolean animate) {
        if(holder.moreLayout.getVisibility() != View.INVISIBLE){
            holder.moreLayout.setVisibility(View.INVISIBLE);
            final Animation scaleMoreAnimation = AnimationUtils.loadAnimation(context, R.anim.reveal_more);
            if(!animate){
                scaleMoreAnimation.setDuration(0);
            }
            holder.textLayout.animate()
                    .translationY(0)
                    .setDuration(scaleMoreAnimation.getDuration())
                    .setInterpolator(scaleMoreAnimation.getInterpolator())
                    .start();
            scaleMoreAnimation.setInterpolator(new ReverseInterpolator(scaleMoreAnimation.getInterpolator()));
            holder.moreLayout.startAnimation(scaleMoreAnimation);
        }
    }

    private void expandView(ViewHolder holder, boolean animate) {
        if(holder.moreLayout.getVisibility() != View.VISIBLE){
            holder.moreLayout.setVisibility(View.VISIBLE);
            final Animation scaleMoreAnimation = AnimationUtils.loadAnimation(context, R.anim.reveal_more);
            if(! animate){
                scaleMoreAnimation.setDuration(0);
            }
            holder.moreLayout.startAnimation(scaleMoreAnimation);
            holder.textLayout.animate()
                    .translationY(-context.getResources().getDimensionPixelSize(R.dimen.picture_translate_distance))
                    .setDuration(scaleMoreAnimation.getDuration())
                    .setInterpolator(scaleMoreAnimation.getInterpolator())
                    .start();
        }
    }

    /**
     * Expands item.
     *
     * @param position   Item's position.
     * @param viewHolder Item's view holder.
     */
    public void expandItem(int position, ViewHolder viewHolder){
        if(currentExpandedItem == position && currentExpandedItem != NONE && currentExpandedViewHolder != null){
            return;
        }else if(currentExpandedItem != NONE && currentExpandedViewHolder != null){
            collapseItem(currentExpandedViewHolder);
        }

        currentExpandedItem = position;
        currentExpandedViewHolder = viewHolder;

        expandView(viewHolder, true);
    }

    /**
     * Collapses item.
     *
     * @param viewHolder Item's view holder.
     */
    public void collapseItem(final ViewHolder viewHolder) {
        currentExpandedItem = -1;
        collapseView(viewHolder, true);
    }

    /**
     * Determines if an item is collapsed.
     *
     * @param position Item position.
     * @return TRUE if collapsed.
     */
    public boolean isCollapsed(final int position) {
        return currentExpandedItem != position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.length;
        }else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View rootView;
        public final ImageView topHead;
        public final ImageView bottomHead;
        public final CardView textLayout;
        public final CardView moreLayout;
        public final TextView textView;
        public final BubbleImageView textImageView;
        public final NiceSpinner keysSpinner;
        public final ClickableFrameLayout frameLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            topHead = (ImageView) itemView.findViewById(R.id.iv_top_head);
            bottomHead = (ImageView) itemView.findViewById(R.id.iv_bottom_head);
            textLayout = (CardView) itemView.findViewById(R.id.text_layout);
            moreLayout = (CardView) itemView.findViewById(R.id.more_layout);
            textView = (TextView) itemView.findViewById(R.id.tv_words);
            textImageView = (BubbleImageView) itemView.findViewById(R.id.iv_words);
            frameLayout = (ClickableFrameLayout) itemView.findViewById(R.id.words_layout);
            keysSpinner = (NiceSpinner) itemView.findViewById(R.id.spinner_bottom);


        }
    }


    /**
     * Defines on item size listener.
     *
     * @param onItemSizeListener On item size listener.
     */
    public void setOnItemSizeListener(final OnItemSizeListener onItemSizeListener) {
        this.onItemSizeListener = onItemSizeListener;
    }

    /**
     * Defines on item click listener.
     *
     * @param onItemClickListener On click listener.
     */
    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    public void setOnItemUpFlickListener(OnItemUpFlickListener onItemUpFlickListener) {
        this.onItemUpFlickListener = onItemUpFlickListener;
    }

    public void setOnItemDownFlickListener(OnItemDownFlickListener onItemDownFlickListener) {
        this.onItemDownFlickListener = onItemDownFlickListener;
    }

    /**
     * On item size listener interface.
     */
    public interface OnItemSizeListener {
        void onItemSize(int size);
    }

    /**
     * On item click listener interface.
     */
    public interface OnItemClickListener {
        void onClick(int position, MainAdapter.ViewHolder viewHolder);
    }

    /**
     * On item up flick listener interface
     */
    public interface OnItemUpFlickListener{
        void OnUpFlick(int position, MainAdapter.ViewHolder viewHolder, int currentExpandedItem);
    }

    /**
     * On item down flick listener interface
     */
    public interface OnItemDownFlickListener{
        void OnDownFlick(int position, MainAdapter.ViewHolder viewHolder, int currentExpandedItem);
    }
}
