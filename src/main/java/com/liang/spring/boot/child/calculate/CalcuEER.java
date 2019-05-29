package com.liang.spring.boot.child.calculate;

import static com.liang.spring.boot.child.calculate.CalcuBMRBetweenOneAndSix.calcuBMR;
import static com.liang.spring.boot.child.calculate.CalcuPAL.caluPAL;

/**
 * 计算 每天需要的 总能量 EER
 * Created by: elvis(李亮)
 * 2019-04-22 10:50
 * Version: 1.0
 */
public class CalcuEER {


    private static double ERR=0;//每天需要的总能量
    private static double TEE=0;//每日日总能量消耗
    private static double EnergyStorag=0;//用于体重增长的能量储存



    /**
     * 计算12个月以内的婴儿的每天能量总需求量 即小于一岁的婴儿
     * @param sex
     * @return
     */
    public static Double calcuEEROfFirstYear(Integer sex){

        /**
         * 0-6个月的婴儿，分男女，给出母乳喂养时奶量
         * */
        if(sex==1){//男婴
            ERR=544;
        }else if(sex==2){//女婴
            ERR=495;
        }

        /*纯母乳喂养  母乳喂养时奶量*/

        /**
         * 0-6个月的婴儿，配方奶喂养，分男女，计算出配方奶的量
         */
        /*配方奶喂养  配方奶的量*/

        /**
         * 7-12月婴儿混合喂养婴儿
         */
        /*混合喂养儿  */
        if(sex==1){//男婴
            ERR=719;
        }else if(sex==2){//女婴
            ERR=673;
        }
        return ERR;
    }


    /**
     * 计算1-6岁幼儿每天能量总需求量
     * @param sex
     * @param weight
     * @param sport_status
     * @param age
     * @param PAL
     * @return
     */
    public static Double calcuEERBetweenFirstAndSix(Integer sex,Double weight,Integer sport_status,Integer age,Double PAL){

        /*计算1-3岁幼儿每天能量总需求量*/
        if(age>=1&&age<3){
            EnergyStorag=19;
            TEE=calcuBMR(age,sex,weight)* caluPAL(age,sport_status);
            ERR=TEE+EnergyStorag;
        }

        /*计算 3-6岁（包括3岁学龄前儿童） 每天能量总需求量*/
        if(age>=3&&age<6){
            EnergyStorag=19;
            TEE=calcuBMR(age,sex,weight)* caluPAL(age,sport_status);
            ERR=TEE+EnergyStorag;
        }

        return ERR;
    }

    /**
     *计算6-18岁幼儿每天能量总需求量  BMR结果 来自 体成分检测结果
     * @param BMR
     * @param age
     * @param sport_status
     * @return
     */
    public static Double calcuEERreaterThanSix(Double BMR,Integer age,Integer sport_status){
        /*计算 6-18岁 每天能量总需求量*/
        if(age>=6&&age<=18){
            EnergyStorag=19;
            TEE=BMR* caluPAL(age,sport_status);
            ERR=TEE+EnergyStorag;
        }
        return ERR;
    }




}
