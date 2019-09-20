package com.liang.spring.boot.child.untils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by: elvis(李亮)
 * 2019-04-24 16:35
 * Version: 1.0
 */
public class GetAgeByBirth {

    public static int getAgeFromBirthTime(Date birthday) {

        Calendar now = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        b.setTime(birthday);
        int year = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) - b.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH);
        if (month < 0) {
            month = 12 - b.get(Calendar.MONTH) + now.get(Calendar.MONTH);
            year -= 1;
        }
        if (day < 0) {
            day = b.getMaximum(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
            month -= 1;
        }

//        String age=null;
//        if(year>0&&month>0&&day>0){
//            age= year + "岁" + month + "个月" + day + "天";
//        }else if(year<0&&month>0&&day>0){
//            age=month + "个月" + day + "天";
//        }else if(year<0&&month<0&&day>0){
//            age=day + "天";
//        }
        if(year>3){
            if (month>=6){
                year+=1;
            }
        }
//        if(year<1){
//            int month_=getMonthFromBirthTime(birthday);
//            year=Integer.parseInt("0."+month);
//        }
//        return year + "岁" + month + "个月" + day + "天";
        return year;
    }

    public static int getMonthFromBirthTime(Date birthday) {

        Calendar now = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        b.setTime(birthday);
        int year = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) - b.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH);
        if (month < 0) {
            month = 12 - b.get(Calendar.MONTH) + now.get(Calendar.MONTH);
            year -= 1;
        }
        if (day < 0) {
            day = b.getMaximum(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
            month -= 1;
        }

//        String age=null;
//        if(year>0&&month>0&&day>0){
//            age= year + "岁" + month + "个月" + day + "天";
//        }else if(year<0&&month>0&&day>0){
//            age=month + "个月" + day + "天";
//        }else if(year<0&&month<0&&day>0){
//            age=day + "天";
//        }
//        if (month>=6){
//            year+=1;
//        }
//        return year + "岁" + month + "个月" + day + "天";
        return month;
    }

    public static String getActualAgeFromBirthTime(Date birthday) {

        Calendar now = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        b.setTime(birthday);
        int year = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) - b.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH);
        if (month < 0) {
            month = 12 - b.get(Calendar.MONTH) + now.get(Calendar.MONTH);
            year -= 1;
        }
        if (day < 0) {
            day = b.getMaximum(Calendar.DAY_OF_MONTH) - b.get(Calendar.DAY_OF_MONTH) + now.get(Calendar.DAY_OF_MONTH);
            month -= 1;
        }

        String age=null;
        if(year>3){
            age= year + "岁";
        }else if(year>=1&&year<=3){
            age=year + "岁" + month + "个月";
        }else if(year<1){
            age=month + "个月" +day + "天";
        }

//
        return age;
    }
}
