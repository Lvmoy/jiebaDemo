package com.jiebademo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
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

import utils.bubbleView.BubbleTextVew;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    TextView tv;
    private static final String[] items = {
            "若一个对象不被任何变量引用，那么程序就无法再使用这个对象。",
            "为什么需要使用软引用",
            "首先，我们看一个雇员信息查询系统的实例。",
            "工信部通信处女干事每月经过下属科室时都要亲口交代15口交换机等技术性器械的使用说明",
            "作为一个Java对象，SoftReference对象除了具有保存软引用的特殊性之外",
            "喝最烈的酒,去最好的医院抢救",
            "雪崩时，没有一片雪花觉得自己有责任",
            "王宝强被马蓉戴绿帽子了"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        final RecyclerView mainRecycleView = (RecyclerView) findViewById(R.id.rv_main);
        mainRecycleView.setAdapter();

        BubbleTextVew b = (BubbleTextVew) findViewById(R.id.text);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( ! TextUtils.isEmpty(et.getText().toString().trim())){
//                    switch (i) {
//                        case 0:
//                        String tempStr1 = "TO" + ToAnalysis.parse(et.getText().toString()).toString() + "\n";
//                        tv.setText(tempStr1);
//                        i++;
//                            break;
//                        case 1:
//                            tv.setText("");
                            String tempStr2 ="NLP" + NlpAnalysis.parse(et.getText().toString()).toString() + "\n";
                            tv.setText(tempStr2);
//                            break;

                    }
                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item_top clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
