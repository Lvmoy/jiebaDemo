package com.jiebademo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.manifmerger.Main;

/**
 * Created by HP on 2016/9/5.
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
     * Current expanded view holder.
     */
    private ViewHolder currentExpandedViewHolder;

    /**
     * 1 是对方来消息，在上方    0是自己发送的消息，在下方
     */
    private  int TYPE = 1;

    public MainAdapter(Context context, String[] items, int TYPE) {
        this.context = context;
        this.items = items;
        this.TYPE = TYPE;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(TYPE == 1){
            final View view = LayoutInflater.from(context).inflate(R.layout.item_top, parent ,false);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if(onItemSizeListener != null){
                        onItemSizeListener.onItemSize(view.getMeasuredWidth());
                    }
                }
            });
            return new ViewHolder(view);

        }else {
            final View view = LayoutInflater.from(context).inflate(R.layout.item_bottom, parent, false);
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
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(currentExpandedViewHolder == -1){

        }
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
        public final ImageView head;
        public final View textLayout;
        public final View moreLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            head = (ImageView) itemView.findViewById(R.id.iv_head);
            textLayout = itemView.findViewById(R.id.text_layout);
            moreLayout = itemView.findViewById(R.id.more_layout);
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

}
