package com.jiebademo.data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Created by lxy on 2016/9/29.
 */

public class SegResultData implements Serializable{
    private List<SegResultBean> list;
    private String diaText;
    private boolean isSent;
    private int uiId;
    private int diaId;

    public int getDiaId() {
        return diaId;
    }

    public void setDiaId(int diaId) {
        this.diaId = diaId;
    }

    public String getDiaText() {
        return diaText;
    }

    public void setDiaText(String diaText) {
        this.diaText = diaText;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public List<SegResultBean> getList() {
        return list;
    }

    public void setList(List<SegResultBean> list) {
        this.list = list;
    }

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }
}
