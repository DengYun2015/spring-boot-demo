package com.example.demo.util;

import java.util.Date;

public class Helper {

    public static Long GetCurrentTimestamp()
    {
        Date date = new Date();
        return date.getTime()/1000;
    }

}
