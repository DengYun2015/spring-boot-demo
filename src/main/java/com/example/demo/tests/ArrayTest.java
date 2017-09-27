package com.example.demo.tests;

import com.example.demo.annotation.TestAnnotation;

/**
 * Created by dengyun on 2017/9/4.
 */
public class ArrayTest {

    @TestAnnotation("StringArrayTest")
    public static void  test()
    {
        String[] str = new String[]{"a","bb","asdasd"};
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }

    }

}
