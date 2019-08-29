package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * LaboratoryDetection 儿童 实验室检测 实体类
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity
@DynamicUpdate
@IdClass(PeopleKey.class)
public class LaboratoryDetection implements Serializable{

	@Id  // 主键
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long guardian_phone; // 表关联字段 监护人联系方式

	@Id
	private Integer inspectOrder;

	private Double flavol;//血清黄醇浓度

	private Double serum25;//血清25-（OHD）水平

	private Double SerumZinc;//血清锌

	private Double glucoseTolerance;//葡萄糖耐受2小时血糖


	private Double GlycatedHemoglobin;//糖化血红蛋白

	//2019-04-18 添加缺少的字段脂肪肝
	private Double fattyiverL;


	private Double bindingProtein;//血清视黄醇结合蛋白


	private Double oxyphorase;//血红蛋白


	private Double FBG;//空腹血糖


	private Double RBG;//随机血糖

	private Double bloodFat;//血脂

	/**2019-4-19 添加上传文件*/
	@Transient
	private MultipartFile file;

	/**2019-4-19 添加文件路径地址*/
	private String path;


	public LaboratoryDetection() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用

	}

	public LaboratoryDetection(Long guardian_phone, Integer inspectOrder, Double flavol, Double serum25, Double serumZinc, Double glucoseTolerance, Double glycatedHemoglobin, Double fattyiverL, Double bindingProtein, Double oxyphorase, Double FBG, Double RBG, Double bloodFat, MultipartFile file, String path) {
		this.guardian_phone = guardian_phone;
		this.inspectOrder = inspectOrder;
		this.flavol = flavol;
		this.serum25 = serum25;
		SerumZinc = serumZinc;
		this.glucoseTolerance = glucoseTolerance;
		GlycatedHemoglobin = glycatedHemoglobin;
		this.fattyiverL = fattyiverL;
		this.bindingProtein = bindingProtein;
		this.oxyphorase = oxyphorase;
		this.FBG = FBG;
		this.RBG = RBG;
		this.bloodFat = bloodFat;
		this.file = file;
		this.path = path;
	}

	public void setGuardian_phone(Long guardian_phone) {
		this.guardian_phone = guardian_phone;
	}

	public void setInspectOrder(Integer inspectOrder) {
		this.inspectOrder = inspectOrder;
	}

	public void setFlavol(Double flavol) {
		this.flavol = flavol;
	}

	public void setSerum25(Double serum25) {
		this.serum25 = serum25;
	}

	public void setSerumZinc(Double serumZinc) {
		SerumZinc = serumZinc;
	}

	public void setGlucoseTolerance(Double glucoseTolerance) {
		this.glucoseTolerance = glucoseTolerance;
	}

	public void setGlycatedHemoglobin(Double glycatedHemoglobin) {
		GlycatedHemoglobin = glycatedHemoglobin;
	}

	public void setFattyiverL(Double fattyiverL) {
		this.fattyiverL = fattyiverL;
	}

	public void setBindingProtein(Double bindingProtein) {
		this.bindingProtein = bindingProtein;
	}

	public void setOxyphorase(Double oxyphorase) {
		this.oxyphorase = oxyphorase;
	}

	public void setFBG(Double FBG) {
		this.FBG = FBG;
	}

	public void setRBG(Double RBG) {
		this.RBG = RBG;
	}

	public void setBloodFat(Double bloodFat) {
		this.bloodFat = bloodFat;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "LaboratoryDetection{" +
				"guardian_phone=" + guardian_phone +
				", inspectOrder=" + inspectOrder +
				", flavol=" + flavol +
				", serum25=" + serum25 +
				", SerumZinc=" + SerumZinc +
				", glucoseTolerance=" + glucoseTolerance +
				", GlycatedHemoglobin=" + GlycatedHemoglobin +
				", fattyiverL=" + fattyiverL +
				", bindingProtein=" + bindingProtein +
				", oxyphorase=" + oxyphorase +
				", FBG=" + FBG +
				", RBG=" + RBG +
				", bloodFat=" + bloodFat +
				", file=" + file +
				", path='" + path + '\'' +
				'}';
	}
}
