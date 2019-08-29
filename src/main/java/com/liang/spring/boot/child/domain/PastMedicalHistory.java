package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * PastMedicalHistory 主诉与症状 实体
 * 
 * @since 1.0.0 2019年3月5日
 * @author LiLiang
 */
@Entity  // 实体
@DynamicUpdate
@IdClass(PeopleKey.class)
public class PastMedicalHistory implements Serializable{

	@Id  // 主键
	//@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Long guardian_phone; // 表关联字段 监护人联系方式

	@Id
	private Integer inspectOrder;

	//既往病史
	//	出生情况
	private String normal;//正常

	private String premature;//早产儿

	private String Macrosomia;//巨大儿

	private String lowBirthWeight;//低体重儿

	private String polyembryony;//多胎


	//母亲妊娠不良习惯
	private String drink;//饮酒

	private String smoke;//吸烟

	private String vegetarian;//素食

	//母亲妊娠疾病情况
	private String diabetes;//妊娠期糖尿病

	private String hypertension;//妊娠期高血压

	private String acalcerosis;//缺钙

	private String hypovitaminosisD;//维生素D缺乏

	private String hypovitaminosisA;//维生素A缺乏

	private String zincDeficiency;//缺锌

	private String anemia;//缺铁性贫血


	//孩子临床表现情况
	//头发
	private String hairThin;//细软

	private String hairFew;//稀少

	private String hairchangeColor;//变色

	private String hairEmbrittlement;//变脆

	private String hairCaducous;// 易脱落

	private String hairBaldness;//环形脱发

	private String hairDry;//干燥

	private String hairPressureAlopecia;// 枕秃

	//眼睛
	private String xerophthalmia;//干眼症

	private String keratomalacia;//角膜软化

	private String keratohelcosis;//角膜溃疡

	//皮肤
	private String peeling;//干燥起皮

	private String furfur;//脱屑

	private String keratosisPilaris;//毛囊角化性丘疹

	//口腔
	private String geographicTongue;//地图舌

	private String cankerSore;//反复口腔溃疡

	//牙齿
	private String enamel;//牙釉质脱落

	private String opsigenes;//易发生智齿

	private String odontiasis;//婴儿出牙晚

	private String bleedingGums;//牙龈出血


	protected PastMedicalHistory() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
	}

	public PastMedicalHistory(Long guardian_phone, Integer inspectOrder, String normal, String premature, String macrosomia, String lowBirthWeight, String polyembryony, String drink, String smoke, String vegetarian, String diabetes, String hypertension, String acalcerosis, String hypovitaminosisD, String hypovitaminosisA, String zincDeficiency, String anemia, String hairThin, String hairFew, String hairchangeColor, String hairEmbrittlement, String hairCaducous, String hairBaldness, String hairDry, String hairPressureAlopecia, String xerophthalmia, String keratomalacia, String keratohelcosis, String peeling, String furfur, String keratosisPilaris, String geographicTongue, String cankerSore, String enamel, String opsigenes, String odontiasis, String bleedingGums) {
		this.guardian_phone = guardian_phone;
		this.inspectOrder = inspectOrder;
		this.normal = normal;
		this.premature = premature;
		Macrosomia = macrosomia;
		this.lowBirthWeight = lowBirthWeight;
		this.polyembryony = polyembryony;
		this.drink = drink;
		this.smoke = smoke;
		this.vegetarian = vegetarian;
		this.diabetes = diabetes;
		this.hypertension = hypertension;
		this.acalcerosis = acalcerosis;
		this.hypovitaminosisD = hypovitaminosisD;
		this.hypovitaminosisA = hypovitaminosisA;
		this.zincDeficiency = zincDeficiency;
		this.anemia = anemia;
		this.hairThin = hairThin;
		this.hairFew = hairFew;
		this.hairchangeColor = hairchangeColor;
		this.hairEmbrittlement = hairEmbrittlement;
		this.hairCaducous = hairCaducous;
		this.hairBaldness = hairBaldness;
		this.hairDry = hairDry;
		this.hairPressureAlopecia = hairPressureAlopecia;
		this.xerophthalmia = xerophthalmia;
		this.keratomalacia = keratomalacia;
		this.keratohelcosis = keratohelcosis;
		this.peeling = peeling;
		this.furfur = furfur;
		this.keratosisPilaris = keratosisPilaris;
		this.geographicTongue = geographicTongue;
		this.cankerSore = cankerSore;
		this.enamel = enamel;
		this.opsigenes = opsigenes;
		this.odontiasis = odontiasis;
		this.bleedingGums = bleedingGums;
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

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getPremature() {
		return premature;
	}

	public void setPremature(String premature) {
		this.premature = premature;
	}

	public String getMacrosomia() {
		return Macrosomia;
	}

	public void setMacrosomia(String macrosomia) {
		Macrosomia = macrosomia;
	}

	public String getLowBirthWeight() {
		return lowBirthWeight;
	}

	public void setLowBirthWeight(String lowBirthWeight) {
		this.lowBirthWeight = lowBirthWeight;
	}

	public String getPolyembryony() {
		return polyembryony;
	}

	public void setPolyembryony(String polyembryony) {
		this.polyembryony = polyembryony;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getHypertension() {
		return hypertension;
	}

	public void setHypertension(String hypertension) {
		this.hypertension = hypertension;
	}

	public String getAcalcerosis() {
		return acalcerosis;
	}

	public void setAcalcerosis(String acalcerosis) {
		this.acalcerosis = acalcerosis;
	}

	public String getHypovitaminosisD() {
		return hypovitaminosisD;
	}

	public void setHypovitaminosisD(String hypovitaminosisD) {
		this.hypovitaminosisD = hypovitaminosisD;
	}

	public String getHypovitaminosisA() {
		return hypovitaminosisA;
	}

	public void setHypovitaminosisA(String hypovitaminosisA) {
		this.hypovitaminosisA = hypovitaminosisA;
	}

	public String getZincDeficiency() {
		return zincDeficiency;
	}

	public void setZincDeficiency(String zincDeficiency) {
		this.zincDeficiency = zincDeficiency;
	}

	public String getAnemia() {
		return anemia;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}

	public String getHairThin() {
		return hairThin;
	}

	public void setHairThin(String hairThin) {
		this.hairThin = hairThin;
	}

	public String getHairFew() {
		return hairFew;
	}

	public void setHairFew(String hairFew) {
		this.hairFew = hairFew;
	}

	public String getHairchangeColor() {
		return hairchangeColor;
	}

	public void setHairchangeColor(String hairchangeColor) {
		this.hairchangeColor = hairchangeColor;
	}

	public String getHairEmbrittlement() {
		return hairEmbrittlement;
	}

	public void setHairEmbrittlement(String hairEmbrittlement) {
		this.hairEmbrittlement = hairEmbrittlement;
	}

	public String getHairCaducous() {
		return hairCaducous;
	}

	public void setHairCaducous(String hairCaducous) {
		this.hairCaducous = hairCaducous;
	}

	public String getHairBaldness() {
		return hairBaldness;
	}

	public void setHairBaldness(String hairBaldness) {
		this.hairBaldness = hairBaldness;
	}

	public String getHairDry() {
		return hairDry;
	}

	public void setHairDry(String hairDry) {
		this.hairDry = hairDry;
	}

	public String getHairPressureAlopecia() {
		return hairPressureAlopecia;
	}

	public void setHairPressureAlopecia(String hairPressureAlopecia) {
		this.hairPressureAlopecia = hairPressureAlopecia;
	}

	public String getXerophthalmia() {
		return xerophthalmia;
	}

	public void setXerophthalmia(String xerophthalmia) {
		this.xerophthalmia = xerophthalmia;
	}

	public String getKeratomalacia() {
		return keratomalacia;
	}

	public void setKeratomalacia(String keratomalacia) {
		this.keratomalacia = keratomalacia;
	}

	public String getKeratohelcosis() {
		return keratohelcosis;
	}

	public void setKeratohelcosis(String keratohelcosis) {
		this.keratohelcosis = keratohelcosis;
	}

	public String getPeeling() {
		return peeling;
	}

	public void setPeeling(String peeling) {
		this.peeling = peeling;
	}

	public String getFurfur() {
		return furfur;
	}

	public void setFurfur(String furfur) {
		this.furfur = furfur;
	}

	public String getKeratosisPilaris() {
		return keratosisPilaris;
	}

	public void setKeratosisPilaris(String keratosisPilaris) {
		this.keratosisPilaris = keratosisPilaris;
	}

	public String getGeographicTongue() {
		return geographicTongue;
	}

	public void setGeographicTongue(String geographicTongue) {
		this.geographicTongue = geographicTongue;
	}

	public String getCankerSore() {
		return cankerSore;
	}

	public void setCankerSore(String cankerSore) {
		this.cankerSore = cankerSore;
	}

	public String getEnamel() {
		return enamel;
	}

	public void setEnamel(String enamel) {
		this.enamel = enamel;
	}

	public String getOpsigenes() {
		return opsigenes;
	}

	public void setOpsigenes(String opsigenes) {
		this.opsigenes = opsigenes;
	}

	public String getOdontiasis() {
		return odontiasis;
	}

	public void setOdontiasis(String odontiasis) {
		this.odontiasis = odontiasis;
	}

	public String getBleedingGums() {
		return bleedingGums;
	}

	public void setBleedingGums(String bleedingGums) {
		this.bleedingGums = bleedingGums;
	}

	@Override
	public String toString() {
		return "PastMedicalHistory{" +
				"guardian_phone=" + guardian_phone +
				", inspectOrder=" + inspectOrder +
				", normal='" + normal + '\'' +
				", premature='" + premature + '\'' +
				", Macrosomia='" + Macrosomia + '\'' +
				", lowBirthWeight='" + lowBirthWeight + '\'' +
				", polyembryony='" + polyembryony + '\'' +
				", drink='" + drink + '\'' +
				", smoke='" + smoke + '\'' +
				", vegetarian='" + vegetarian + '\'' +
				", diabetes='" + diabetes + '\'' +
				", hypertension='" + hypertension + '\'' +
				", acalcerosis='" + acalcerosis + '\'' +
				", hypovitaminosisD='" + hypovitaminosisD + '\'' +
				", hypovitaminosisA='" + hypovitaminosisA + '\'' +
				", zincDeficiency='" + zincDeficiency + '\'' +
				", anemia='" + anemia + '\'' +
				", hairThin='" + hairThin + '\'' +
				", hairFew='" + hairFew + '\'' +
				", hairchangeColor='" + hairchangeColor + '\'' +
				", hairEmbrittlement='" + hairEmbrittlement + '\'' +
				", hairCaducous='" + hairCaducous + '\'' +
				", hairBaldness='" + hairBaldness + '\'' +
				", hairDry='" + hairDry + '\'' +
				", hairPressureAlopecia='" + hairPressureAlopecia + '\'' +
				", xerophthalmia='" + xerophthalmia + '\'' +
				", keratomalacia='" + keratomalacia + '\'' +
				", keratohelcosis='" + keratohelcosis + '\'' +
				", peeling='" + peeling + '\'' +
				", furfur='" + furfur + '\'' +
				", keratosisPilaris='" + keratosisPilaris + '\'' +
				", geographicTongue='" + geographicTongue + '\'' +
				", cankerSore='" + cankerSore + '\'' +
				", enamel='" + enamel + '\'' +
				", opsigenes='" + opsigenes + '\'' +
				", odontiasis='" + odontiasis + '\'' +
				", bleedingGums='" + bleedingGums + '\'' +
				'}';
	}
}
