package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * SportsSurvey 儿童 运动调查 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
@IdClass(PeopleKey.class)
public class SportsSurvey implements Serializable{

	@Id  // 主键
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long guardian_phone; // 表关联字段 监护人联系方式

	@Id
	private Integer inspectOrder;

	//运动情况
	private Integer sport_status;//运动情况

//	private Integer torpent;//不活泼
//
//	private Integer allegro;//较活泼
//
//	private Integer veryLively;//非常活泼

	//睡眠时间
//	private Integer sleepValue;//不足8小时

//	private Integer lacking;//不足8小时
//
//	private Integer among;//8-10小时
//
//	private Integer greaterThan;//大于10小时


	protected SportsSurvey() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
	}

	public SportsSurvey(Long guardian_phone, Integer inspectOrder, Integer sport_status) {
		this.guardian_phone = guardian_phone;
		this.inspectOrder = inspectOrder;
		this.sport_status = sport_status;
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

	public Integer getSport_status() {
		return sport_status;
	}

	public void setSport_status(Integer sport_status) {
		this.sport_status = sport_status;
	}

	@Override
	public String toString() {
		return "SportsSurvey{" +
				"guardian_phone=" + guardian_phone +
				", inspectOrder=" + inspectOrder +
				", sport_status=" + sport_status +
				'}';
	}
}
