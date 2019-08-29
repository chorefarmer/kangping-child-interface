package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * DietaryGuide 儿童 膳食指导日摄入量 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
public class DietaryGuide implements Serializable{

	@Id  // 主键
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long Kcal; // 表关联字段 千卡能量值

	@Column(columnDefinition="varchar(100) COMMENT '实际份数'")
	private Long practicalF;//实际份数

	@Column(columnDefinition="varchar(100) COMMENT '主食份数'")
	private Double stapleFoodF;//主食份数

	private Double stapleFoodG;//主食克数`
	@Column(columnDefinition="varchar(100) COMMENT '蔬菜份数'")
	private Double vegetablesF;//蔬菜份数

	private Double vegetablesG;//蔬菜克数

	@Column(columnDefinition="varchar(100) COMMENT '水果份数'")
	private Double fruitsF;//水果份数

	private Double fruitsG;//水果克数

	@Column(columnDefinition="varchar(100) COMMENT '禽畜份数'")
	private Double livestockF;//禽畜份数

	private Double livestockG;//禽畜克数

	@Column(columnDefinition="varchar(100) COMMENT '水产份数'")
	private Double aquaticProductF;//水产份数

	private Double aquaticProductG;//水产克数

	@Column(columnDefinition="varchar(100) COMMENT '蛋份数'")
	private Double eggF;//蛋份数

	private Double eggG;//蛋克数

	@Column(columnDefinition="varchar(100) COMMENT '奶份数'")
	private Double milkF;//奶份数

	private Double milkG;//奶克数

	@Column(columnDefinition="varchar(100) COMMENT '豆份数'")
	private Double beanF;//豆份数

	private Double beanG;//豆克数

	@Column(columnDefinition="varchar(100) COMMENT '坚果份数'")
	private Double nutF;//坚果份数

	private Double nutG;//坚果克数

	@Column(columnDefinition="varchar(100) COMMENT '油份数'")
	private Double oilF;//油份数

	private Double oilG;//油克数

	protected DietaryGuide() {
	}

	public DietaryGuide(Long kcal, Double stapleFoodF, Double stapleFoodG, Double vegetablesF, Double vegetablesG, Double fruitsF, Double fruitsG, Double livestockF, Double livestockG, Double aquaticProductF, Double aquaticProductG, Double eggF, Double eggG, Double milkF, Double milkG, Double beanF, Double beanG, Double nutF, Double nutG, Double oilF, Double oilG) {
		Kcal = kcal;
		this.stapleFoodF = stapleFoodF;
		this.stapleFoodG = stapleFoodG;
		this.vegetablesF = vegetablesF;
		this.vegetablesG = vegetablesG;
		this.fruitsF = fruitsF;
		this.fruitsG = fruitsG;
		this.livestockF = livestockF;
		this.livestockG = livestockG;
		this.aquaticProductF = aquaticProductF;
		this.aquaticProductG = aquaticProductG;
		this.eggF = eggF;
		this.eggG = eggG;
		this.milkF = milkF;
		this.milkG = milkG;
		this.beanF = beanF;
		this.beanG = beanG;
		this.nutF = nutF;
		this.nutG = nutG;
		this.oilF = oilF;
		this.oilG = oilG;
	}

	public Long getKcal() {
		return Kcal;
	}

	public void setKcal(Long kcal) {
		Kcal = kcal;
	}

	public Double getStapleFoodF() {
		return stapleFoodF;
	}

	public void setStapleFoodF(Double stapleFoodF) {
		this.stapleFoodF = stapleFoodF;
	}

	public Double getStapleFoodG() {
		return stapleFoodG;
	}

	public void setStapleFoodG(Double stapleFoodG) {
		this.stapleFoodG = stapleFoodG;
	}

	public Double getVegetablesF() {
		return vegetablesF;
	}

	public void setVegetablesF(Double vegetablesF) {
		this.vegetablesF = vegetablesF;
	}

	public Double getVegetablesG() {
		return vegetablesG;
	}

	public void setVegetablesG(Double vegetablesG) {
		this.vegetablesG = vegetablesG;
	}

	public Double getFruitsF() {
		return fruitsF;
	}

	public void setFruitsF(Double fruitsF) {
		this.fruitsF = fruitsF;
	}

	public Double getFruitsG() {
		return fruitsG;
	}

	public void setFruitsG(Double fruitsG) {
		this.fruitsG = fruitsG;
	}

	public Double getLivestockF() {
		return livestockF;
	}

	public void setLivestockF(Double livestockF) {
		this.livestockF = livestockF;
	}

	public Double getLivestockG() {
		return livestockG;
	}

	public void setLivestockG(Double livestockG) {
		this.livestockG = livestockG;
	}

	public Double getAquaticProductF() {
		return aquaticProductF;
	}

	public void setAquaticProductF(Double aquaticProductF) {
		this.aquaticProductF = aquaticProductF;
	}

	public Double getAquaticProductG() {
		return aquaticProductG;
	}

	public void setAquaticProductG(Double aquaticProductG) {
		this.aquaticProductG = aquaticProductG;
	}

	public Double getEggF() {
		return eggF;
	}

	public void setEggF(Double eggF) {
		this.eggF = eggF;
	}

	public Double getEggG() {
		return eggG;
	}

	public void setEggG(Double eggG) {
		this.eggG = eggG;
	}

	public Double getMilkF() {
		return milkF;
	}

	public void setMilkF(Double milkF) {
		this.milkF = milkF;
	}

	public Double getMilkG() {
		return milkG;
	}

	public void setMilkG(Double milkG) {
		this.milkG = milkG;
	}

	public Double getBeanF() {
		return beanF;
	}

	public void setBeanF(Double beanF) {
		this.beanF = beanF;
	}

	public Double getBeanG() {
		return beanG;
	}

	public void setBeanG(Double beanG) {
		this.beanG = beanG;
	}

	public Double getNutF() {
		return nutF;
	}

	public void setNutF(Double nutF) {
		this.nutF = nutF;
	}

	public Double getNutG() {
		return nutG;
	}

	public void setNutG(Double nutG) {
		this.nutG = nutG;
	}

	public Double getOilF() {
		return oilF;
	}

	public void setOilF(Double oilF) {
		this.oilF = oilF;
	}

	public Double getOilG() {
		return oilG;
	}

	public void setOilG(Double oilG) {
		this.oilG = oilG;
	}

	@Override
	public String toString() {
		return "DietaryGuide{" +
				"Kcal=" + Kcal +
				", stapleFoodF=" + stapleFoodF +
				", stapleFoodG=" + stapleFoodG +
				", vegetablesF=" + vegetablesF +
				", vegetablesG=" + vegetablesG +
				", fruitsF=" + fruitsF +
				", fruitsG=" + fruitsG +
				", livestockF=" + livestockF +
				", livestockG=" + livestockG +
				", aquaticProductF=" + aquaticProductF +
				", aquaticProductG=" + aquaticProductG +
				", eggF=" + eggF +
				", eggG=" + eggG +
				", milkF=" + milkF +
				", milkG=" + milkG +
				", beanF=" + beanF +
				", beanG=" + beanG +
				", nutF=" + nutF +
				", nutG=" + nutG +
				", oilF=" + oilF +
				", oilG=" + oilG +
				'}';
	}
}
