package com.jiebademo.data;

import java.io.Serializable;

import utils.annotation.JsonIgnoreProperties;

/**
 * javaBean 基类
 * Created by lxy on 2016/9/28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBean implements Serializable{
}
