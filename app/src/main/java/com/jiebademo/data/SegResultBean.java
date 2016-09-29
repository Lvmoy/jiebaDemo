package com.jiebademo.data;

import android.support.annotation.NonNull;

/**
 * 单个分词word Bean
 * Created by lxy on 2016/9/28.
 */

public class SegResultBean extends BaseBean {
    private int diaID;
    private int id;
    private String word;
    private String type;
    private int foreSegId;
    private int postSegId;
    private boolean isMain;
    public int getDiaID() {
        return diaID;
    }

    public void setDiaID(int diaID) {
        this.diaID = diaID;
    }

    public int getForeSegId() {
        return foreSegId;
    }

    public void setForeSegId(int foreSegId) {
        this.foreSegId = foreSegId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public int getPostSegId() {
        return postSegId;
    }

    public void setPostSegId(int postSegId) {
        this.postSegId = postSegId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
