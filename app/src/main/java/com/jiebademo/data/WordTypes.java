package com.jiebademo.data;


/**
 * 词性 兼容ICTPOS标准
 * Created by lxy on 2016/9/28.
 */

public class WordTypes {
    /**
     * 名词（1个一类，7个二类，5个三类）
     */
    public final static String N = "n";   //名词
    public final static String NR = "nr";  //人名
    public final static String NR1 = "nr1";//汉语姓氏
    public final static String NR2 = "nr2";//汉语名字
    public final static String NRJ = "nrj";//日语人名
    public final static String NRF = "nrf";//音译人名
    public final static String NS = "ns";//地名
    public final static String NSF = "nsf";//音译地名
    public final static String NT = "nt";//机构团体名
    public final static String NZ = "nz";//其它专名
    public final static String NL= "nl";//名词性惯用语
    public final static String NG = "ng";//名词性语素
    public final static String NW = "nw";//新词

    /**
     * 时间词 （1个一类，1个二类）
     */
    public final static String T = "t";//时间词
    public final static String TG = "tg";//时间词性语素

    /**
     * 处所词 （1个一类）
     */
    public final static String S = "s";//处所词

    /**
     * 方位词 （1个一类）
     */
    public final static String F = "f";//方位词

    /**
     * 动词 （1个一类，9个二类）
     */
    public final static String V = "v";//动词
    public final static String VD = "vd";//副动词
    public final static String VN = "vn";//名动词
    public final static String VSHI= "vshi";//动词“是”
    public final static String VYOU = "vyou";//动词“有”
    public final static String VF = "vf";//趋向动词
    public final static String VX = "vx";//形式动词
    public final static String VI = "vi";//不及物动词
    public final static String VL = "vl";//动词性惯用语
    public final static String VG = "vg";//动词性语素

    /**
     * 形容词 （1个一类，4个二类）
     */
    public final static String A = "a";//形容词
    public final static String AD = "ad";//副形词
    public final static String AN = "an";//名形词
    public final static String AG = "ag";//形容词性语素
    public final static String AL = "al";//形容词性惯用语

    /**
     * 区别词 （1个一类，1个二类）
     */
    public final static String B = "b";//区别词
    public final static String BL = "bl";//区别词性惯用语

    /**
     * 状态词 （1个一类）
     */
    public final static String Z = "z";//状态词

    /**
     * 代词 （1个一类，4个二类，6个三类）
     */
    public final static String WORD_R= "r";//代词
    public final static String RR = "rr";//人称代词
    public final static String RZ = "rz";//指示代词
    public final static String RZT = "rzt";//时间指示代词
    public final static String RZS = "rzs";//处所指示代词
    public final static String RZV = "rzv";//谓词性指示代词
    public final static String RY = "ry";//疑问代词
    public final static String RYT = "ryt";//时间疑问代词
    public final static String RYS = "rys";//处所疑问代词
    public final static String RYV = "ryv";//谓词性疑问代词
    public final static String RG = "rg";//代词性语素

    /**
     * 数词 （1个一类，1个二类）
     */
    public final static String M = "m";//数词
    public final static String MQ = "mq";//数量词

    /**
     * 量词 （1个一类）
     */
    public final static String Q = "q";//量词
    public final static String QV = "qv";//动量词
    public final static String QT = "qt";//时量词

    /**
     * 副词 （1个一类）
     */
    public final static String D = "d";//副词

    /**
     * 介词 （1个一类，2个二类）
     */
    public final static String P = "p";//介词
    public final static String PBA = "pba";//介词“把”
    public final static String PBEI = "pbei";//介词“被”

    /**
     * 连词 （1个一类，1个二类）
     */
    public final static String WORD_C = "c";//连词
    public final static String CC = "cc";//并列连词

    /**
     * 助词 （1个一类，15个二类）
     */
    public final static String U = "u";//助词
    public final static String UZHE = "uzhe";//着
    public final static String ULE = "ule";//了 喽
    public final static String UGUO = "uguo";//过
    public final static String UDE1 = "ude1";//的 底
    public final static String UDE2 = "ude2";//地
    public final static String UDE3 = "ude3";//得
    public final static String USUO = "usuo";//所
    public final static String UDENG = "udeng";//等 等等 云云
    public final static String UYY = "uyy";//一样 一般 似的 般
    public final static String UDH = "udh";//的话
    public final static String ULS = "uls";//来讲 来说 而言 说来
    public final static String UZHI = "uzhi";//之
    public final static String ULIAN = "ulian";//连 （“连小学生都会”）

    /**
     * 叹词 （1个一类）
     */
    public final static String E = "e";//叹词

    /**
     * 语气词 （1个一类）
     */
    public final static String Y = "y";//语气词

    /**
     * 拟声词 （1个一类）
     */
    public final static String O = "o";//拟声词

    /**
     * 前缀 （1个一类）
     */
    public final static String H = "h";//前缀

    /**
     * 后缀 （1个一类）
     */
    public final static String K = "k";//后缀

    /**
     * 字符串 （1个一类，2个二类）
     */
    public final static String X = "x";//字符串
    public final static String XX = "xx";//非语素词
    public final static String XU = "xu";//网址URL

    /**
     * 标点符号 （1个一类， 16个二类）
     */
    public final static String W = "w";//标点符号
    public final static String WKZ = "wkz";//左括号，全角：（{【《....
    public final static String WKY = "wky";//右括号，全角：）}】》....
    public final static String WYZ = "wyz";//左引号，全角：‘“
    public final static String WYY = "wyy";//右引号，全角：’”
    public final static String WJ = "wj";//句号，全角：。
    public final static String WW = "ww";//问号，全角：？ 半角：?
    public final static String WT = "wt";//叹号，全角：！ 半角：!
    public final static String WD = "wd";//逗号，全角：， 半角：,
    public final static String WF = "wf";//分好，全角：； 半角：;
    public final static String WN = "wn";//顿号，全角：、
    public final static String WM = "wm";//冒号，全角：： 半角：:
    public final static String WS = "ws";//省略号，全角：…… 半角：..
    public final static String WP = "wp";//破折号，全角：-- __ 半角：---
    public final static String WB = "wb";//百分号千分号，全角：% 半角
    public final static String WH = "wh";//单位符号， 全角：℃ ° ¥ 半角：




}
