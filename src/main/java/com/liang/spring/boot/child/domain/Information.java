package com.liang.spring.boot.child.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Information 儿童 基本信息 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
public class Information implements Serializable{

	@Id  // 主键
	private Long guardian_phone;//监护人联系方式  04-08需要确定数据类型

	private String name;//儿童姓名

	private Integer sex;//儿童性别

	private Integer height;//儿童身高

	//@JsonFormat(pattern="yyyy-MM-dd")
	//2019-4-22 取消数据格式化  返回Unix时间戳
	private Date birth;//出生日期

	//	选填项

	private Integer nation;//名族


	private Integer blood;//血型


	private String guardian;//监护人



	private Integer educationalOfParents;//家长受教育程度


	private String remark;//备注

	/** 创建时间. */
	@Column(name="CREATE_TIME",insertable=false, updatable=false)
	@Generated(GenerationTime.INSERT)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** 更新时间. */
	@LastModifiedDate
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	protected Information() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
	}

	public Information(Long guardian_phone, String name, Integer sex, Integer height, Date birth, Integer nation, Integer blood, String guardian, Integer educationalOfParents, String remark, Date createTime, Date updateTime) {
		this.guardian_phone = guardian_phone;
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.birth = birth;
		this.nation = nation;
		this.blood = blood;
		this.guardian = guardian;
		this.educationalOfParents = educationalOfParents;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Long getGuardian_phone() {
		return guardian_phone;
	}

	public void setGuardian_phone(Long guardian_phone) {
		this.guardian_phone = guardian_phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Integer getBlood() {
		return blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public Integer getEducationalOfParents() {
		return educationalOfParents;
	}

	public void setEducationalOfParents(Integer educationalOfParents) {
		this.educationalOfParents = educationalOfParents;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Information{" +
				"guardian_phone=" + guardian_phone +
				", name='" + name + '\'' +
				", sex=" + sex +
				", height=" + height +
				", birth=" + birth +
				", nation=" + nation +
				", blood=" + blood +
				", guardian='" + guardian + '\'' +
				", educationalOfParents=" + educationalOfParents +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				'}';
	}
}
