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

    public MealTimes(Long kcal, Long breakfastCerealQuantity, String examplesOfBreakfastCereals, Long breakfastVegetablesQuantity, String examplesOfBreakfastVegetables, Long breakfastFruitsQuantity, String examplesOfBreakfastFruits, Long breakfastEggsQuantity, String examplesOfBreakfastEggs, Long breakfastMilkQuantity, String examplesOfBreakfastMilk, Long snacksFruitsQuantity, String examplesOfSnacksFruits, Long lunchCerealQuantity, String examplesOfLunchCereals, Long lunchVegetablesQuantity, String examplesOfLunchVegetables, Long lunchMeatQuantity, String examplesOfLunchMeat, Long lunchOilQuantity, String examplesOfLunchOil, Long snacksNutQuantity, String examplesOfSnacksNut, Long dinnerCerealQuantity, String examplesOfDinnerCereals, Long dinnerVegetablesQuantity, String examplesOfDinnerVegetables, Long dinnerFisheriesQuantity, String examplesOfDinnerFisheries, Long dinnerSoybeanQuantity, String examplesOfDinnerSoybean, Long dinnerOilQuantity, String examplesOfDinnerOil) {
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

    public Long getKcal() {
        return Kcal;
    }

    public void setKcal(Long kcal) {
        Kcal = kcal;
    }

    public Long getBreakfastCerealQuantity() {
        return BreakfastCerealQuantity;
    }

    public void setBreakfastCerealQuantity(Long breakfastCerealQuantity) {
        BreakfastCerealQuantity = breakfastCerealQuantity;
    }

    public String getExamplesOfBreakfastCereals() {
        return ExamplesOfBreakfastCereals;
    }

    public void setExamplesOfBreakfastCereals(String examplesOfBreakfastCereals) {
        ExamplesOfBreakfastCereals = examplesOfBreakfastCereals;
    }

    public Long getBreakfastVegetablesQuantity() {
        return BreakfastVegetablesQuantity;
    }

    public void setBreakfastVegetablesQuantity(Long breakfastVegetablesQuantity) {
        BreakfastVegetablesQuantity = breakfastVegetablesQuantity;
    }

    public String getExamplesOfBreakfastVegetables() {
        return ExamplesOfBreakfastVegetables;
    }

    public void setExamplesOfBreakfastVegetables(String examplesOfBreakfastVegetables) {
        ExamplesOfBreakfastVegetables = examplesOfBreakfastVegetables;
    }

    public Long getBreakfastFruitsQuantity() {
        return BreakfastFruitsQuantity;
    }

    public void setBreakfastFruitsQuantity(Long breakfastFruitsQuantity) {
        BreakfastFruitsQuantity = breakfastFruitsQuantity;
    }

    public String getExamplesOfBreakfastFruits() {
        return ExamplesOfBreakfastFruits;
    }

    public void setExamplesOfBreakfastFruits(String examplesOfBreakfastFruits) {
        ExamplesOfBreakfastFruits = examplesOfBreakfastFruits;
    }

    public Long getBreakfastEggsQuantity() {
        return BreakfastEggsQuantity;
    }

    public void setBreakfastEggsQuantity(Long breakfastEggsQuantity) {
        BreakfastEggsQuantity = breakfastEggsQuantity;
    }

    public String getExamplesOfBreakfastEggs() {
        return ExamplesOfBreakfastEggs;
    }

    public void setExamplesOfBreakfastEggs(String examplesOfBreakfastEggs) {
        ExamplesOfBreakfastEggs = examplesOfBreakfastEggs;
    }

    public Long getBreakfastMilkQuantity() {
        return BreakfastMilkQuantity;
    }

    public void setBreakfastMilkQuantity(Long breakfastMilkQuantity) {
        BreakfastMilkQuantity = breakfastMilkQuantity;
    }

    public String getExamplesOfBreakfastMilk() {
        return ExamplesOfBreakfastMilk;
    }

    public void setExamplesOfBreakfastMilk(String examplesOfBreakfastMilk) {
        ExamplesOfBreakfastMilk = examplesOfBreakfastMilk;
    }

    public Long getSnacksFruitsQuantity() {
        return SnacksFruitsQuantity;
    }

    public void setSnacksFruitsQuantity(Long snacksFruitsQuantity) {
        SnacksFruitsQuantity = snacksFruitsQuantity;
    }

    public String getExamplesOfSnacksFruits() {
        return ExamplesOfSnacksFruits;
    }

    public void setExamplesOfSnacksFruits(String examplesOfSnacksFruits) {
        ExamplesOfSnacksFruits = examplesOfSnacksFruits;
    }

    public Long getLunchCerealQuantity() {
        return LunchCerealQuantity;
    }

    public void setLunchCerealQuantity(Long lunchCerealQuantity) {
        LunchCerealQuantity = lunchCerealQuantity;
    }

    public String getExamplesOfLunchCereals() {
        return ExamplesOfLunchCereals;
    }

    public void setExamplesOfLunchCereals(String examplesOfLunchCereals) {
        ExamplesOfLunchCereals = examplesOfLunchCereals;
    }

    public Long getLunchVegetablesQuantity() {
        return LunchVegetablesQuantity;
    }

    public void setLunchVegetablesQuantity(Long lunchVegetablesQuantity) {
        LunchVegetablesQuantity = lunchVegetablesQuantity;
    }

    public String getExamplesOfLunchVegetables() {
        return ExamplesOfLunchVegetables;
    }

    public void setExamplesOfLunchVegetables(String examplesOfLunchVegetables) {
        ExamplesOfLunchVegetables = examplesOfLunchVegetables;
    }

    public Long getLunchMeatQuantity() {
        return LunchMeatQuantity;
    }

    public void setLunchMeatQuantity(Long lunchMeatQuantity) {
        LunchMeatQuantity = lunchMeatQuantity;
    }

    public String getExamplesOfLunchMeat() {
        return ExamplesOfLunchMeat;
    }

    public void setExamplesOfLunchMeat(String examplesOfLunchMeat) {
        ExamplesOfLunchMeat = examplesOfLunchMeat;
    }

    public Long getLunchOilQuantity() {
        return LunchOilQuantity;
    }

    public void setLunchOilQuantity(Long lunchOilQuantity) {
        LunchOilQuantity = lunchOilQuantity;
    }

    public String getExamplesOfLunchOil() {
        return ExamplesOfLunchOil;
    }

    public void setExamplesOfLunchOil(String examplesOfLunchOil) {
        ExamplesOfLunchOil = examplesOfLunchOil;
    }

    public Long getSnacksNutQuantity() {
        return SnacksNutQuantity;
    }

    public void setSnacksNutQuantity(Long snacksNutQuantity) {
        SnacksNutQuantity = snacksNutQuantity;
    }

    public String getExamplesOfSnacksNut() {
        return ExamplesOfSnacksNut;
    }

    public void setExamplesOfSnacksNut(String examplesOfSnacksNut) {
        ExamplesOfSnacksNut = examplesOfSnacksNut;
    }

    public Long getDinnerCerealQuantity() {
        return DinnerCerealQuantity;
    }

    public void setDinnerCerealQuantity(Long dinnerCerealQuantity) {
        DinnerCerealQuantity = dinnerCerealQuantity;
    }

    public String getExamplesOfDinnerCereals() {
        return ExamplesOfDinnerCereals;
    }

    public void setExamplesOfDinnerCereals(String examplesOfDinnerCereals) {
        ExamplesOfDinnerCereals = examplesOfDinnerCereals;
    }

    public Long getDinnerVegetablesQuantity() {
        return DinnerVegetablesQuantity;
    }

    public void setDinnerVegetablesQuantity(Long dinnerVegetablesQuantity) {
        DinnerVegetablesQuantity = dinnerVegetablesQuantity;
    }

    public String getExamplesOfDinnerVegetables() {
        return ExamplesOfDinnerVegetables;
    }

    public void setExamplesOfDinnerVegetables(String examplesOfDinnerVegetables) {
        ExamplesOfDinnerVegetables = examplesOfDinnerVegetables;
    }

    public Long getDinnerFisheriesQuantity() {
        return DinnerFisheriesQuantity;
    }

    public void setDinnerFisheriesQuantity(Long dinnerFisheriesQuantity) {
        DinnerFisheriesQuantity = dinnerFisheriesQuantity;
    }

    public String getExamplesOfDinnerFisheries() {
        return ExamplesOfDinnerFisheries;
    }

    public void setExamplesOfDinnerFisheries(String examplesOfDinnerFisheries) {
        ExamplesOfDinnerFisheries = examplesOfDinnerFisheries;
    }

    public Long getDinnerSoybeanQuantity() {
        return DinnerSoybeanQuantity;
    }

    public void setDinnerSoybeanQuantity(Long dinnerSoybeanQuantity) {
        DinnerSoybeanQuantity = dinnerSoybeanQuantity;
    }

    public String getExamplesOfDinnerSoybean() {
        return ExamplesOfDinnerSoybean;
    }

    public void setExamplesOfDinnerSoybean(String examplesOfDinnerSoybean) {
        ExamplesOfDinnerSoybean = examplesOfDinnerSoybean;
    }

    public Long getDinnerOilQuantity() {
        return DinnerOilQuantity;
    }

    public void setDinnerOilQuantity(Long dinnerOilQuantity) {
        DinnerOilQuantity = dinnerOilQuantity;
    }

    public String getExamplesOfDinnerOil() {
        return ExamplesOfDinnerOil;
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
