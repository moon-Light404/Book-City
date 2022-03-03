package com.ding.util;

public class ToInt {
    public static int parseInt(String strInt,int defaultValue){
        try{
            return Integer.parseInt(strInt);
        }catch (Exception e){

        }
        return defaultValue;
    }

//    public static void main(String[] args) {
//        System.out.println(parseInt("",2));
//    }
}
