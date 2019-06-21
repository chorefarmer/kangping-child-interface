package com.liang.spring.boot.child.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 13:45 2019/6/14
 */
@Entity
@DynamicUpdate
public class BodyCompositionTest {

    @Id
    private Long guardian_phone;//表关联字段  监护人联系方式  编号

    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date CheckDate;//测试日期

    private Double Fat;//脂肪

    private Double Sclerotin;//骨质

    private Double Protein;//蛋白质

    private Double IntracellularFluid;//细胞內液

    private Double ExtracellularFluid;//细胞外液

    //总体水  liang-20190617 细胞內液  细胞
//    private Double ExtracellularFluid;

    private Double Muscle;//肌肉

    private Double FatfreeBodyWeight;//瘦体重

    private Double Height;//身高

    private Double Weight;//体重

    private Double BodyFatPercent;//体脂百分比

    private Double SkeletalMuscle;//骨骼肌

    private Double WeightIndexBMI;//BMI

    private Double WaistToHipratio;//腰臀比

    private Double  MetabolicRate;  //基础代谢

    private Double VisceralFat;//内脏脂肪

    private Double score;//分数


    protected BodyCompositionTest() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    }

    public BodyCompositionTest(Long guardian_phone, Date checkDate, Double fat, Double sclerotin, Double protein, Double intracellularFluid, Double extracellularFluid, Double muscle, Double fatfreeBodyWeight, Double height, Double weight, Double bodyFatPercent, Double skeletalMuscle, Double weightIndexBMI, Double waistToHipratio, Double metabolicRate, Double visceralFat, Double score) {
        this.guardian_phone = guardian_phone;
        CheckDate = checkDate;
        Fat = fat;
        Sclerotin = sclerotin;
        Protein = protein;
        IntracellularFluid = intracellularFluid;
        ExtracellularFluid = extracellularFluid;
        Muscle = muscle;
        FatfreeBodyWeight = fatfreeBodyWeight;
        Height = height;
        Weight = weight;
        BodyFatPercent = bodyFatPercent;
        SkeletalMuscle = skeletalMuscle;
        WeightIndexBMI = weightIndexBMI;
        WaistToHipratio = waistToHipratio;
        MetabolicRate = metabolicRate;
        VisceralFat = visceralFat;
        this.score = score;
    }

    public Long getGuardian_phone() {
        return guardian_phone;
    }

    public void setGuardian_phone(Long guardian_phone) {
        this.guardian_phone = guardian_phone;
    }

    public Date getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(Date checkDate) {
        CheckDate = checkDate;
    }

    public Double getFat() {
        return Fat;
    }

    public void setFat(Double fat) {
        Fat = fat;
    }

    public Double getSclerotin() {
        return Sclerotin;
    }

    public void setSclerotin(Double sclerotin) {
        Sclerotin = sclerotin;
    }

    public Double getProtein() {
        return Protein;
    }

    public void setProtein(Double protein) {
        Protein = protein;
    }

    public Double getIntracellularFluid() {
        return IntracellularFluid;
    }

    public void setIntracellularFluid(Double intracellularFluid) {
        IntracellularFluid = intracellularFluid;
    }

    public Double getExtracellularFluid() {
        return ExtracellularFluid;
    }

    public void setExtracellularFluid(Double extracellularFluid) {
        ExtracellularFluid = extracellularFluid;
    }

    public Double getMuscle() {
        return Muscle;
    }

    public void setMuscle(Double muscle) {
        Muscle = muscle;
    }

    public Double getFatfreeBodyWeight() {
        return FatfreeBodyWeight;
    }

    public void setFatfreeBodyWeight(Double fatfreeBodyWeight) {
        FatfreeBodyWeight = fatfreeBodyWeight;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public Double getBodyFatPercent() {
        return BodyFatPercent;
    }

    public void setBodyFatPercent(Double bodyFatPercent) {
        BodyFatPercent = bodyFatPercent;
    }

    public Double getSkeletalMuscle() {
        return SkeletalMuscle;
    }

    public void setSkeletalMuscle(Double skeletalMuscle) {
        SkeletalMuscle = skeletalMuscle;
    }

    public Double getWeightIndexBMI() {
        return WeightIndexBMI;
    }

    public void setWeightIndexBMI(Double weightIndexBMI) {
        WeightIndexBMI = weightIndexBMI;
    }

    public Double getWaistToHipratio() {
        return WaistToHipratio;
    }

    public void setWaistToHipratio(Double waistToHipratio) {
        WaistToHipratio = waistToHipratio;
    }

    public Double getMetabolicRate() {
        return MetabolicRate;
    }

    public void setMetabolicRate(Double metabolicRate) {
        MetabolicRate = metabolicRate;
    }

    public Double getVisceralFat() {
        return VisceralFat;
    }

    public void setVisceralFat(Double visceralFat) {
        VisceralFat = visceralFat;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BodyCompositionTest{" +
                "guardian_phone=" + guardian_phone +
                ", CheckDate=" + CheckDate +
                ", Fat=" + Fat +
                ", Sclerotin=" + Sclerotin +
                ", Protein=" + Protein +
                ", IntracellularFluid=" + IntracellularFluid +
                ", ExtracellularFluid=" + ExtracellularFluid +
                ", Muscle=" + Muscle +
                ", FatfreeBodyWeight=" + FatfreeBodyWeight +
                ", Height=" + Height +
                ", Weight=" + Weight +
                ", BodyFatPercent=" + BodyFatPercent +
                ", SkeletalMuscle=" + SkeletalMuscle +
                ", WeightIndexBMI=" + WeightIndexBMI +
                ", WaistToHipratio=" + WaistToHipratio +
                ", MetabolicRate=" + MetabolicRate +
                ", VisceralFat=" + VisceralFat +
                ", score=" + score +
                '}';
    }
}
