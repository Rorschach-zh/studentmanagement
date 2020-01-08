package com.tujiao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AgeUtils {
    public static int getAge(Date birth) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        int age = Integer.parseInt(sf.format(new Date())) -
                Integer.parseInt(sf.format(birth));
        return age;
    }
}
