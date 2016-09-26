package com.jiebademo;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.Properties;

import utils.LayoutManager.SpeedControllableLinearLayoutManager;
import utils.bubbleView.BubbleTextVew;

public class MainActivity extends AppCompatActivity {

    private static final String[] items = {
            "若一个对象不被任何变量引用，那么程序就无法再使用这个对象。",
            "为什么需要使用软引用?",
            "首先，我们看一个雇员信息查询系统的实例。",
            "工信部通信处女干事每月经过下属科室时都要亲口交代15口交换机等技术性器械的使用说明。",
            "作为一个Java对象，SoftReference对象除了具有保存软引用的特殊性之外。",
            "喝最烈的酒,去最好的医院抢救",
            "雪崩时，没有一片雪花觉得自己有责任",
            "王宝强被马蓉戴绿帽子了!!",
            "此时此刻，真的想不出来要讲什么了。",
            "还要我继续编下去么，真的吗，纣王都没你狠毒。",
            "诺贝尔获得者-诺贝尔被诺贝尔发明的炸药给炸死"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //设置actionBar透明
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            // window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_main);

        final RecyclerView mainRecycleView = (RecyclerView) findViewById(R.id.rv_main);
//        final StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
//        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
//        mainRecycleView.setLayoutManager(mLayoutManager);
        /**
         * set the speed of items' sliding
         *
         */
        final SpeedControllableLinearLayoutManager linearLayoutManager = new SpeedControllableLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setMILLISECONDS_PER_INCH(0.73f);
        mainRecycleView.setLayoutManager(linearLayoutManager);
        new LinearSnapHelper().attachToRecyclerView(mainRecycleView);
        final MainAdapter mainAdapter = new MainAdapter(MainActivity.this, items);
        mainRecycleView.setAdapter(mainAdapter);
   //     mainRecycleView.fling()


        mainAdapter.setOnItemSizeListener(new MainAdapter.OnItemSizeListener() {
            @Override
            public void onItemSize(int size) {
                mainAdapter.setOnItemSizeListener(null);
                final int padding = (mainRecycleView.getMeasuredWidth() - size) / 2;
                mainRecycleView.setPadding(padding, 0, padding, 0);
                mainRecycleView.smoothScrollToPosition(0);
            }

        });

        mainAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, MainAdapter.ViewHolder viewHolder) {
                final int currentPosition = (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.findLastVisibleItemPosition()) / 2;
                if(position != currentPosition){
                    mainRecycleView.smoothScrollToPosition(position);
                }else if(mainAdapter.isCollapsed(position)){
                    mainAdapter.expandItem(position, viewHolder);
                }else {
                    mainAdapter.collapseItem(viewHolder);
                }
            }
        });

        mainAdapter.setOnItemUpFlickListener(new MainAdapter.OnItemUpFlickListener() {
            @Override
            public void OnUpFlick(int position, MainAdapter.ViewHolder viewHolder, int currentExpandedItem) {
               if(currentExpandedItem != position && position != -1){
                   final int currentPosition = (linearLayoutManager.findFirstVisibleItemPosition() + linearLayoutManager.findLastVisibleItemPosition()) / 2;
                   if(position != currentPosition){
                       mainRecycleView.smoothScrollToPosition(position);
                   }
                    mainAdapter.expandItem(position, viewHolder);
                }
            }
        });

        mainAdapter.setOnItemDownFlickListener(new MainAdapter.OnItemDownFlickListener() {
            @Override
            public void OnDownFlick(int position, MainAdapter.ViewHolder viewHolder, int currentExpandedItem) {
                if(currentExpandedItem == position){
                    mainAdapter.collapseItem(viewHolder);
                }
            }
        });
//        BubbleTextVew b = (BubbleTextVew) findViewById(R.id.text);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if( ! TextUtils.isEmpty(et.getText().toString().trim())){
//                    switch (i) {
//                        case 0:
//                        String tempStr1 = "TO" + ToAnalysis.parse(et.getText().toString()).toString() + "\n";
//                        tv.setText(tempStr1);
//                        i++;
//                            break;
//                        case 1:
//                            tv.setText("");
//                            String tempStr2 ="NLP" + NlpAnalysis.parse(et.getText().toString()).toString() + "\n";
//                            tv.setText(tempStr2);
////                            break;
//
//                    }
//                }
//        });
    }

}