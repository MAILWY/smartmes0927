package org.jlhh.mes.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyong on 2017/10/10.
 */
public class Time {
    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDateSSS() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
