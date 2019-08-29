package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * DietarySurvey 儿童 膳食调查 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
@IdClass(PeopleKey.class)
public class DietarySurvey implements Serializable{

	@Id  // 主键
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long guardian_phone; // 表关联字段 监护人联系方式

	@Id
	private Integer inspectOrder;

	private Integer stapleFood;//主食量

	private Integer vegetables;//蔬菜量

	private Integer marineProducts;//海产品量

	private Integer egg;//鸡蛋量


	private Integer fruits;//水果量

	//2019-4-18 添加禽畜肉类
	private Integer PoultryMeat;


	private Integer milk;//牛奶量


	private Integer nut;//坚果量

//	private String eatingPrefer;//饮食偏好
//
//	private String eatingHabits;//饮食习惯

	private Boolean prefersSweet;//偏爱甜食

	private Boolean prefersFRY;//喜好油炸食品

	private Boolean prefersSodas;//喜好碳酸饮料

	private Boolean withoutBreakfast;//经常不吃早饭

	private Boolean ateAndPlayed;//边吃边玩

	private Boolean irregularDiet;//饮食无规律

	protected DietarySurvey() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
	}

	public DietarySurvey(Long guardian_phone, Integer inspectOrder, Integer stapleFood, Integer vegetables, Integer marineProducts, Integer egg, Integer fruits, Integer poultryMeat, Integer milk, Integer nut, Boolean prefersSweet, Boolean prefersFRY, Boolean prefersSodas, Boolean withoutBreakfast, Boolean ateAndPlayed, Boolean irregularDiet) {
		this.guardian_phone = guardian_phone;
		this.inspectOrder = inspectOrder;
		this.stapleFood = stapleFood;
		this.vegetables = vegetables;
		this.marineProducts = marineProducts;
		this.egg = egg;
		this.fruits = fruits;
		PoultryMeat = poultryMeat;
		this.milk = milk;
		this.nut = nut;
		this.prefersSweet = prefersSweet;
		this.prefersFRY = prefersFRY;
		this.prefersSodas = prefersSodas;
		this.withoutBreakfast = withoutBreakfast;
		this.ateAndPlayed = ateAndPlayed;
		this.irregularDiet = irregularDiet;
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

	public Integer getStapleFood() {
		return stapleFood;
	}

	public void setStapleFood(Integer stapleFood) {
		this.stapleFood = stapleFood;
	}

	public Integer getVegetables() {
		return vegetables;
	}

	public void setVegetables(Integer vegetables) {
		this.vegetables = vegetables;
	}

	public Integer getMarineProducts() {
		return marineProducts;
	}

	public void setMarineProducts(Integer marineProducts) {
		this.marineProducts = marineProducts;
	}

	public Integer getEgg() {
		return egg;
	}

	public void setEgg(Integer egg) {
		this.egg = egg;
	}

	public Integer getFruits() {
		return fruits;
	}

	public void setFruits(Integer fruits) {
		this.fruits = fruits;
	}

	public Integer getPoultryMeat() {
		return PoultryMeat;
	}

	public void setPoultryMeat(Integer poultryMeat) {
		PoultryMeat = poultryMeat;
	}

	public Integer getMilk() {
		return milk;
	}

	public void setMilk(Integer milk) {
		this.milk = milk;
	}

	public Integer getNut() {
		return nut;
	}

	public void setNut(Integer nut) {
		this.nut = nut;
	}

	public Boolean getPrefersSweet() {
		return prefersSweet;
	}

	public void setPrefersSweet(Boolean prefersSweet) {
		this.prefersSweet = prefersSweet;
	}

	public Boolean getPrefersFRY() {
		return prefersFRY;
	}

	public void setPrefersFRY(Boolean prefersFRY) {
		this.prefersFRY = prefersFRY;
	}

	public Boolean getPrefersSodas() {
		return prefersSodas;
	}

	public void setPrefersSodas(Boolean prefersSodas) {
		this.prefersSodas = prefersSodas;
	}

	public Boolean getWithoutBreakfast() {
		return withoutBreakfast;
	}

	public void setWithoutBreakfast(Boolean withoutBreakfast) {
		this.withoutBreakfast = withoutBreakfast;
	}

	public Boolean getAteAndPlayed() {
		return ateAndPlayed;
	}

	public void setAteAndPlayed(Boolean ateAndPlayed) {
		this.ateAndPlayed = ateAndPlayed;
	}

	public Boolean getIrregularDiet() {
		return irregularDiet;
	}

	public void setIrregularDiet(Boolean irregularDiet) {
		this.irregularDiet = irregularDiet;
	}

	@Override
	public String toString() {
		return "DietarySurvey{" +
				"guardian_phone=" + guardian_phone +
				", inspectOrder=" + inspectOrder +
				", stapleFood=" + stapleFood +
				", vegetables=" + vegetables +
				", marineProducts=" + marineProducts +
				", egg=" + egg +
				", fruits=" + fruits +
				", PoultryMeat=" + PoultryMeat +
				", milk=" + milk +
				", nut=" + nut +
				", prefersSweet=" + prefersSweet +
				", prefersFRY=" + prefersFRY +
				", prefersSodas=" + prefersSodas +
				", withoutBreakfast=" + withoutBreakfast +
				", ateAndPlayed=" + ateAndPlayed +
				", irregularDiet=" + irregularDiet +
				'}';
	}
}
