package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * AllergiesAndIntolerances 儿童 食物过敏与不耐受 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
@IdClass(PeopleKey.class)
public class AllergiesAndIntolerances implements Serializable{

	@Id  // 主键
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long guardian_phone; // 表关联字段 监护人联系方式

	@Id
	private Integer inspectOrder;

	//食物过敏
	private String egg;//鸡蛋

	private String milk;//牛奶

	private String peanut;//花生

	private String soya;//大豆


	private String barley;//大麦


	private String wheat;//小麦


	private String mast;//坚果


	private String fish;//鱼

	private String prawn;//虾

	//食物不耐受
	private String lactobiose;//乳糖

	private String egg_;//鸡蛋


	protected AllergiesAndIntolerances() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
	}

	public AllergiesAndIntolerances(Long guardian_phone, Integer inspectOrder, String egg, String milk, String peanut, String soya, String barley, String wheat, String mast, String fish, String prawn, String lactobiose, String egg_) {
		this.guardian_phone = guardian_phone;
		this.inspectOrder = inspectOrder;
		this.egg = egg;
		this.milk = milk;
		this.peanut = peanut;
		this.soya = soya;
		this.barley = barley;
		this.wheat = wheat;
		this.mast = mast;
		this.fish = fish;
		this.prawn = prawn;
		this.lactobiose = lactobiose;
		this.egg_ = egg_;
	}

	public Long getGuardian_phone() {
		return guardian_phone;
	}

	public void setGuardian_phone(Long guardian_phone) {
		this.guardian_phone = guardian_phone;
	}

	public Integer getInspectOrder() {
		return inspectOrder;
	}

	public void setInspectOrder(Integer inspectOrder) {
		this.inspectOrder = inspectOrder;
	}

	public String getEgg() {
		return egg;
	}

	public void setEgg(String egg) {
		this.egg = egg;
	}

	public String getMilk() {
		return milk;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}

	public String getPeanut() {
		return peanut;
	}

	public void setPeanut(String peanut) {
		this.peanut = peanut;
	}

	public String getSoya() {
		return soya;
	}

	public void setSoya(String soya) {
		this.soya = soya;
	}

	public String getBarley() {
		return barley;
	}

	public void setBarley(String barley) {
		this.barley = barley;
	}

	public String getWheat() {
		return wheat;
	}

	public void setWheat(String wheat) {
		this.wheat = wheat;
	}

	public String getMast() {
		return mast;
	}

	public void setMast(String mast) {
		this.mast = mast;
	}

	public String getFish() {
		return fish;
	}

	public void setFish(String fish) {
		this.fish = fish;
	}

	public String getPrawn() {
		return prawn;
	}

	public void setPrawn(String prawn) {
		this.prawn = prawn;
	}

	public String getLactobiose() {
		return lactobiose;
	}

	public void setLactobiose(String lactobiose) {
		this.lactobiose = lactobiose;
	}

	public String getEgg_() {
		return egg_;
	}

	public void setEgg_(String egg_) {
		this.egg_ = egg_;
	}

	@Override
	public String toString() {
		return "AllergiesAndIntolerances{" +
				"guardian_phone=" + guardian_phone +
				", inspectOrder=" + inspectOrder +
				", egg='" + egg + '\'' +
				", milk='" + milk + '\'' +
				", peanut='" + peanut + '\'' +
				", soya='" + soya + '\'' +
				", barley='" + barley + '\'' +
				", wheat='" + wheat + '\'' +
				", mast='" + mast + '\'' +
				", fish='" + fish + '\'' +
				", prawn='" + prawn + '\'' +
				", lactobiose='" + lactobiose + '\'' +
				", egg_='" + egg_ + '\'' +
				'}';
	}
}
