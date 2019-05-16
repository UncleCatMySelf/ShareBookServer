package com.github.myself.util;

/**
 * 积分称号转换工具类
 * Created by MySelf on 2019/5/16.
 */
public class TitleChangeIntegralUtil {

    public static String tittleChangeByIntegral(String Integral){
        int scope = Integer.parseInt(Integral);
        String title = "生员";
        if (scope <= 100){
            return title;
        } else if (scope <= 150){
            return title = "秀才";
        } else if (scope <= 250){
            return title = "举人";
        } else if (scope <= 400){
            return title = "贡士";
        } else if (scope <= 600){
            return title = "进士";
        } else if (scope <= 900){
            return title = "探花";
        } else if (scope <= 1400){
            return title = "榜眼";
        } else {
            return title = "状元";
        }
    }

}
