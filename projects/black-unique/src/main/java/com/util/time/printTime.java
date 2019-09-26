package com.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class printTime {
    public static void printTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
        System.out.println(sdf.format(d));
    }
}
