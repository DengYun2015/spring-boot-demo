package com.example.demo.tests;


/**
 * Created by dengyun on 2017/9/4.
 */
public class Test {


    public static void main(String[] argv) {
        int a = 0,b;
        String Line;
        while (a<9){
            b=0;
            a++;
            Line = "";
            while(b<9){
                b++;
                if(b>a){
                    break;
                }
                String ji = Integer.toString(a*b);
                Line += Integer.toString(a)+"x"+Integer.toString(b)+"="+(ji)+" ";
                if(ji.length()==1){
                    Line +=" ";
                }
            }
            System.out.println(Line);
        }
    }

}
