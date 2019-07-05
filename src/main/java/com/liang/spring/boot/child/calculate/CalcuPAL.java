package com.liang.spring.boot.child.calculate;

/**
 * 根据 运动调查 计算活动水平 PAL
 * Created by: elvis(李亮)
 * 2019-04-18 16:14
 * Version: 1.0
 */
public class CalcuPAL {

    private static double PAL=0;//活动水平


    /**
     * 根据年龄 结合运动调查的运动情况 返回对应的PAL
     * @param age
     * @return
     */
    public static Double caluPAL(Integer age,Integer sport_status){


        if(age>0&&age<3){//年龄0~3
            //活动等级  正常活动    喜欢蹦跳
            if(sport_status==1) {
                PAL = 1.35;
            }
            //活动等级  平常比较安静 活动量不大
            if(sport_status==2) {
                PAL = 1.3;
            }
        }

        if(age>=3&&age<6){//年龄3~6
            //活泼好动
            if(sport_status==1) {
                PAL = 1.55;
            }
            //比较安静  活动量不大
            if(sport_status==2) {
                PAL = 1.4;
            }
        }

        /**
         *全天内各种类型的身体活动时间应累计超过180分钟以上。
         * 其中，中等及以上强度的身体活动累计不少于60分钟
         *
         * 注：如果年龄不满周岁，超过六个月则取上限，
         *    如6岁6个月，这按照7岁走
         *    如果6岁5个月，则按照6岁走
         */
        if(age>=6) {
            if (sport_status == 1) {

                if (age >= 6 && age <= 7) {
                    PAL = 1.75;
                } else if (age >= 8 && age <= 9) {
                    PAL = 1.8;
                } else if (age >= 10 && age <= 14) {
                    PAL = 1.85;
                } else if (age >= 15 && age <= 18) {
                    PAL = 1.95;
                }
            }


            /**
             * 全天内各种类型的身体活动时间应累计少于180分钟且不少于60分钟
             */
            if (sport_status == 2) {

                if (age >= 6 && age <= 7) {
                    PAL = 1.55;
                } else if (age >= 8 && age <= 9) {
                    PAL = 1.6;
                } else if (age >= 10 && age <= 14) {
                    PAL = 1.65;
                } else if (age >= 15 && age <= 18) {
                    PAL = 1.75;
                }
            }

            /**
             * 全天内各种类型的身体活动时间应累计少于60分钟，
             * 主要是看电子产品或以坐为主
             */
            if (sport_status == 3) {

                if (age >= 6 && age <= 7) {
                    PAL = 1.35;
                } else if (age >= 8 && age <= 9) {
                    PAL = 1.4;
                } else if (age >= 10 && age <= 14) {
                    PAL = 1.45;
                } else if (age >= 15 && age <= 18) {
                    PAL = 1.55;
                }
            }
        }


        return PAL;
    }
}
