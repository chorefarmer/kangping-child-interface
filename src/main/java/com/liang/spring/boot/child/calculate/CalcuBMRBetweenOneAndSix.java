package com.liang.spring.boot.child.calculate;

/**
 *
 *计算1-6岁 基础代谢率 BMR
 * Created by: elvis(李亮)
 * 2019-04-22 17:50
 * Version: 1.0
 */
public class CalcuBMRBetweenOneAndSix {

    private static double BMR=0;//基础代谢
    private static double W=0;//体重 单位千克 kg

    /**
     * 1-3岁按照体重和性别计算BMR
     * @param age
     * @param sex
     * @param weight
     * @return
     */
    public static Double calcuBMR(Integer age,Integer sex,Double weight){

        /**
         * 0-1岁按照体重和性别计算BMR
         */

        /*1-3岁按照体重和性别计算BMR*/
        if(age>=1&&age<3){
            if(sex==1){//男童
                BMR=60.9*weight-54;
            }else if(sex==0){//女童
                BMR=61*weight-51;
            }
        }


        /*3-6岁 （包括3岁学龄前儿童）按照体重和性别计算BMR*/
        if(age>=3&&age<6){
            if(sex==1){//男童
                BMR=22.7*weight+495;
            }else if(sex==0){//女童
                BMR=22.5*weight+499;
            }
        }
        return BMR;
    }
}
