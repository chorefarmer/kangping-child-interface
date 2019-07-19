package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 餐次举例  实体
 * @Author: liliang
 * @Description:
 * @Date: Create in 18:00 2019/7/11
 */
@Entity
@DynamicUpdate
public class MealTimes {

    @Id  // 主键
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
    private Long Kcal; // 表关联字段 千卡能量值

    //早餐
    @Column(columnDefinition="varchar(100) COMMENT '早餐谷类食物量'")
    private Long BreakfastCerealQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '早餐谷类参考举例'")
    private String ExamplesOfBreakfastCereals;

    @Column(columnDefinition="varchar(100) COMMENT '早餐蔬菜食物量'")
    private Long BreakfastVegetablesQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '早餐蔬菜参考举例'")
    private String ExamplesOfBreakfastVegetables;//

    @Column(columnDefinition="varchar(100) COMMENT '早餐水果食物量'")
    private Long BreakfastFruitsQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '早餐水果参考举例'")
    private String ExamplesOfBreakfastFruits;

    @Column(columnDefinition="varchar(100) COMMENT '早餐蛋类食物量'")
    private Long BreakfastEggsQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '早餐蛋类参考举例'")
    private String ExamplesOfBreakfastEggs;

    @Column(columnDefinition="varchar(100) COMMENT '早餐乳制品食物量'")
    private Long BreakfastMilkQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '早餐乳制品参考举例'")
    private String ExamplesOfBreakfastMilk;

    //加餐
    @Column(columnDefinition="varchar(100) COMMENT '加餐水果食物量'")
    private Long  SnacksFruitsQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '加餐水果参考举例'")
    private String ExamplesOfSnacksFruits;

    //午餐
    @Column(columnDefinition="varchar(100) COMMENT '午餐谷类食物量'")
    private Long LunchCerealQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '午餐谷类参考举例'")
    private String ExamplesOfLunchCereals;

    @Column(columnDefinition="varchar(100) COMMENT '午餐蔬菜食物量'")
    private Long LunchVegetablesQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '午餐蔬菜参考举例'")
    private String ExamplesOfLunchVegetables;

    @Column(columnDefinition="varchar(100) COMMENT '午餐禽畜肉类食物量'")
    private Long LunchMeatQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '午餐禽畜肉类参考举例'")
    private String ExamplesOfLunchMeat;

    @Column(columnDefinition="varchar(100) COMMENT '午餐烹调油类食物量'")
    private Long LunchOilQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '午餐烹调油参考举例'")
    private String ExamplesOfLunchOil;

    @Column(columnDefinition="varchar(100) COMMENT '加餐乳制品食物量'")
    private Long SnacksMilkQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '加餐乳制品参考举例'")
    private String ExamplesOfSnacksMilk;

    //加餐
    @Column(columnDefinition="varchar(100) COMMENT '加餐坚果食物量'")
    private Long  SnacksNutQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '加餐坚果参考举例'")
    private String ExamplesOfSnacksNut;

    //晚餐
    @Column(columnDefinition="varchar(100) COMMENT '晚餐谷类食物量'")
    private Long DinnerCerealQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐谷类参考举例'")
    private String ExamplesOfDinnerCereals;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐蔬菜食物量'")
    private Long DinnerVegetablesQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐蔬菜参考举例'")
    private String ExamplesOfDinnerVegetables;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐水产类食物量'")
    private Long DinnerFisheriesQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐水产类参考举例'")
    private String ExamplesOfDinnerFisheries;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐大豆食物量'")
    private Long DinnerSoybeanQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐大豆参考举例'")
    private String ExamplesOfDinnerSoybean;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐烹调油类食物量'")
    private Long DinnerOilQuantity;

    @Column(columnDefinition="varchar(100) COMMENT '晚餐烹调油参考举例'")
    private String ExamplesOfDinnerOil;

    public MealTimes() {
    }

    public MealTimes(Long kcal, Long breakfastCerealQuantity, String examplesOfBreakfastCereals, Long breakfastVegetablesQuantity, String examplesOfBreakfastVegetables, Long breakfastFruitsQuantity, String examplesOfBreakfastFruits, Long breakfastEggsQuantity, String examplesOfBreakfastEggs, Long breakfastMilkQuantity, String examplesOfBreakfastMilk, Long snacksFruitsQuantity, String examplesOfSnacksFruits, Long lunchCerealQuantity, String examplesOfLunchCereals, Long lunchVegetablesQuantity, String examplesOfLunchVegetables, Long lunchMeatQuantity, String examplesOfLunchMeat, Long lunchOilQuantity, String examplesOfLunchOil, Long snacksMilkQuantity, String examplesOfSnacksMilk, Long snacksNutQuantity, String examplesOfSnacksNut, Long dinnerCerealQuantity, String examplesOfDinnerCereals, Long dinnerVegetablesQuantity, String examplesOfDinnerVegetables, Long dinnerFisheriesQuantity, String examplesOfDinnerFisheries, Long dinnerSoybeanQuantity, String examplesOfDinnerSoybean, Long dinnerOilQuantity, String examplesOfDinnerOil) {
        Kcal = kcal;
        BreakfastCerealQuantity = breakfastCerealQuantity;
        ExamplesOfBreakfastCereals = examplesOfBreakfastCereals;
        BreakfastVegetablesQuantity = breakfastVegetablesQuantity;
        ExamplesOfBreakfastVegetables = examplesOfBreakfastVegetables;
        BreakfastFruitsQuantity = breakfastFruitsQuantity;
        ExamplesOfBreakfastFruits = examplesOfBreakfastFruits;
        BreakfastEggsQuantity = breakfastEggsQuantity;
        ExamplesOfBreakfastEggs = examplesOfBreakfastEggs;
        BreakfastMilkQuantity = breakfastMilkQuantity;
        ExamplesOfBreakfastMilk = examplesOfBreakfastMilk;
        SnacksFruitsQuantity = snacksFruitsQuantity;
        ExamplesOfSnacksFruits = examplesOfSnacksFruits;
        LunchCerealQuantity = lunchCerealQuantity;
        ExamplesOfLunchCereals = examplesOfLunchCereals;
        LunchVegetablesQuantity = lunchVegetablesQuantity;
        ExamplesOfLunchVegetables = examplesOfLunchVegetables;
        LunchMeatQuantity = lunchMeatQuantity;
        ExamplesOfLunchMeat = examplesOfLunchMeat;
        LunchOilQuantity = lunchOilQuantity;
        ExamplesOfLunchOil = examplesOfLunchOil;
        SnacksMilkQuantity = snacksMilkQuantity;
        ExamplesOfSnacksMilk = examplesOfSnacksMilk;
        SnacksNutQuantity = snacksNutQuantity;
        ExamplesOfSnacksNut = examplesOfSnacksNut;
        DinnerCerealQuantity = dinnerCerealQuantity;
        ExamplesOfDinnerCereals = examplesOfDinnerCereals;
        DinnerVegetablesQuantity = dinnerVegetablesQuantity;
        ExamplesOfDinnerVegetables = examplesOfDinnerVegetables;
        DinnerFisheriesQuantity = dinnerFisheriesQuantity;
        ExamplesOfDinnerFisheries = examplesOfDinnerFisheries;
        DinnerSoybeanQuantity = dinnerSoybeanQuantity;
        ExamplesOfDinnerSoybean = examplesOfDinnerSoybean;
        DinnerOilQuantity = dinnerOilQuantity;
        ExamplesOfDinnerOil = examplesOfDinnerOil;
    }

    public void setKcal(Long kcal) {
        Kcal = kcal;
    }

    public void setBreakfastCerealQuantity(Long breakfastCerealQuantity) {
        BreakfastCerealQuantity = breakfastCerealQuantity;
    }

    public void setExamplesOfBreakfastCereals(String examplesOfBreakfastCereals) {
        ExamplesOfBreakfastCereals = examplesOfBreakfastCereals;
    }

    public void setBreakfastVegetablesQuantity(Long breakfastVegetablesQuantity) {
        BreakfastVegetablesQuantity = breakfastVegetablesQuantity;
    }

    public void setExamplesOfBreakfastVegetables(String examplesOfBreakfastVegetables) {
        ExamplesOfBreakfastVegetables = examplesOfBreakfastVegetables;
    }

    public void setBreakfastFruitsQuantity(Long breakfastFruitsQuantity) {
        BreakfastFruitsQuantity = breakfastFruitsQuantity;
    }

    public void setExamplesOfBreakfastFruits(String examplesOfBreakfastFruits) {
        ExamplesOfBreakfastFruits = examplesOfBreakfastFruits;
    }

    public void setBreakfastEggsQuantity(Long breakfastEggsQuantity) {
        BreakfastEggsQuantity = breakfastEggsQuantity;
    }

    public void setExamplesOfBreakfastEggs(String examplesOfBreakfastEggs) {
        ExamplesOfBreakfastEggs = examplesOfBreakfastEggs;
    }

    public void setBreakfastMilkQuantity(Long breakfastMilkQuantity) {
        BreakfastMilkQuantity = breakfastMilkQuantity;
    }

    public void setExamplesOfBreakfastMilk(String examplesOfBreakfastMilk) {
        ExamplesOfBreakfastMilk = examplesOfBreakfastMilk;
    }

    public void setSnacksFruitsQuantity(Long snacksFruitsQuantity) {
        SnacksFruitsQuantity = snacksFruitsQuantity;
    }

    public void setExamplesOfSnacksFruits(String examplesOfSnacksFruits) {
        ExamplesOfSnacksFruits = examplesOfSnacksFruits;
    }

    public void setLunchCerealQuantity(Long lunchCerealQuantity) {
        LunchCerealQuantity = lunchCerealQuantity;
    }

    public void setExamplesOfLunchCereals(String examplesOfLunchCereals) {
        ExamplesOfLunchCereals = examplesOfLunchCereals;
    }

    public void setLunchVegetablesQuantity(Long lunchVegetablesQuantity) {
        LunchVegetablesQuantity = lunchVegetablesQuantity;
    }

    public void setExamplesOfLunchVegetables(String examplesOfLunchVegetables) {
        ExamplesOfLunchVegetables = examplesOfLunchVegetables;
    }

    public void setLunchMeatQuantity(Long lunchMeatQuantity) {
        LunchMeatQuantity = lunchMeatQuantity;
    }

    public void setExamplesOfLunchMeat(String examplesOfLunchMeat) {
        ExamplesOfLunchMeat = examplesOfLunchMeat;
    }

    public void setLunchOilQuantity(Long lunchOilQuantity) {
        LunchOilQuantity = lunchOilQuantity;
    }

    public void setExamplesOfLunchOil(String examplesOfLunchOil) {
        ExamplesOfLunchOil = examplesOfLunchOil;
    }

    public void setSnacksMilkQuantity(Long snacksMilkQuantity) {
        SnacksMilkQuantity = snacksMilkQuantity;
    }

    public void setExamplesOfSnacksMilk(String examplesOfSnacksMilk) {
        ExamplesOfSnacksMilk = examplesOfSnacksMilk;
    }

    public void setSnacksNutQuantity(Long snacksNutQuantity) {
        SnacksNutQuantity = snacksNutQuantity;
    }

    public void setExamplesOfSnacksNut(String examplesOfSnacksNut) {
        ExamplesOfSnacksNut = examplesOfSnacksNut;
    }

    public void setDinnerCerealQuantity(Long dinnerCerealQuantity) {
        DinnerCerealQuantity = dinnerCerealQuantity;
    }

    public void setExamplesOfDinnerCereals(String examplesOfDinnerCereals) {
        ExamplesOfDinnerCereals = examplesOfDinnerCereals;
    }

    public void setDinnerVegetablesQuantity(Long dinnerVegetablesQuantity) {
        DinnerVegetablesQuantity = dinnerVegetablesQuantity;
    }

    public void setExamplesOfDinnerVegetables(String examplesOfDinnerVegetables) {
        ExamplesOfDinnerVegetables = examplesOfDinnerVegetables;
    }

    public void setDinnerFisheriesQuantity(Long dinnerFisheriesQuantity) {
        DinnerFisheriesQuantity = dinnerFisheriesQuantity;
    }

    public void setExamplesOfDinnerFisheries(String examplesOfDinnerFisheries) {
        ExamplesOfDinnerFisheries = examplesOfDinnerFisheries;
    }

    public void setDinnerSoybeanQuantity(Long dinnerSoybeanQuantity) {
        DinnerSoybeanQuantity = dinnerSoybeanQuantity;
    }

    public void setExamplesOfDinnerSoybean(String examplesOfDinnerSoybean) {
        ExamplesOfDinnerSoybean = examplesOfDinnerSoybean;
    }

    public void setDinnerOilQuantity(Long dinnerOilQuantity) {
        DinnerOilQuantity = dinnerOilQuantity;
    }

    public void setExamplesOfDinnerOil(String examplesOfDinnerOil) {
        ExamplesOfDinnerOil = examplesOfDinnerOil;
    }

    @Override
    public String toString() {
        return "MealTimes{" +
                "Kcal=" + Kcal +
                ", BreakfastCerealQuantity=" + BreakfastCerealQuantity +
                ", ExamplesOfBreakfastCereals='" + ExamplesOfBreakfastCereals + '\'' +
                ", BreakfastVegetablesQuantity=" + BreakfastVegetablesQuantity +
                ", ExamplesOfBreakfastVegetables='" + ExamplesOfBreakfastVegetables + '\'' +
                ", BreakfastFruitsQuantity=" + BreakfastFruitsQuantity +
                ", ExamplesOfBreakfastFruits='" + ExamplesOfBreakfastFruits + '\'' +
                ", BreakfastEggsQuantity=" + BreakfastEggsQuantity +
                ", ExamplesOfBreakfastEggs='" + ExamplesOfBreakfastEggs + '\'' +
                ", BreakfastMilkQuantity=" + BreakfastMilkQuantity +
                ", ExamplesOfBreakfastMilk='" + ExamplesOfBreakfastMilk + '\'' +
                ", SnacksFruitsQuantity=" + SnacksFruitsQuantity +
                ", ExamplesOfSnacksFruits='" + ExamplesOfSnacksFruits + '\'' +
                ", LunchCerealQuantity=" + LunchCerealQuantity +
                ", ExamplesOfLunchCereals='" + ExamplesOfLunchCereals + '\'' +
                ", LunchVegetablesQuantity=" + LunchVegetablesQuantity +
                ", ExamplesOfLunchVegetables='" + ExamplesOfLunchVegetables + '\'' +
                ", LunchMeatQuantity=" + LunchMeatQuantity +
                ", ExamplesOfLunchMeat='" + ExamplesOfLunchMeat + '\'' +
                ", LunchOilQuantity=" + LunchOilQuantity +
                ", ExamplesOfLunchOil='" + ExamplesOfLunchOil + '\'' +
                ", SnacksMilkQuantity=" + SnacksMilkQuantity +
                ", ExamplesOfSnacksMilk='" + ExamplesOfSnacksMilk + '\'' +
                ", SnacksNutQuantity=" + SnacksNutQuantity +
                ", ExamplesOfSnacksNut='" + ExamplesOfSnacksNut + '\'' +
                ", DinnerCerealQuantity=" + DinnerCerealQuantity +
                ", ExamplesOfDinnerCereals='" + ExamplesOfDinnerCereals + '\'' +
                ", DinnerVegetablesQuantity=" + DinnerVegetablesQuantity +
                ", ExamplesOfDinnerVegetables='" + ExamplesOfDinnerVegetables + '\'' +
                ", DinnerFisheriesQuantity=" + DinnerFisheriesQuantity +
                ", ExamplesOfDinnerFisheries='" + ExamplesOfDinnerFisheries + '\'' +
                ", DinnerSoybeanQuantity=" + DinnerSoybeanQuantity +
                ", ExamplesOfDinnerSoybean='" + ExamplesOfDinnerSoybean + '\'' +
                ", DinnerOilQuantity=" + DinnerOilQuantity +
                ", ExamplesOfDinnerOil='" + ExamplesOfDinnerOil + '\'' +
                '}';
    }
}
