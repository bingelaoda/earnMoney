package com.example.lottory01.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:TimeUtils
 * Description:
 */
public class TimeUtils {

    public static String oneDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss E");
        String format = simpleDateFormat.format(date);

        return format;
    }
}
