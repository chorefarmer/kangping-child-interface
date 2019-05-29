package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 医院管理 实体类
 * Created by: elvis(李亮)
 * 2019-05-07 13:51
 * Version: 1.0
 */
@Entity
@DynamicUpdate
public class Hospital {

    @Id  // 主键
    private Long hospotialPhone;//联系电话

    private String hospitalName;//医院名称

    private String officeName;//科室名称

    private String contacts;//联系人

    private String email;//联系邮箱


    protected Hospital() {
    }

    public Hospital(Long hospotialPhone, String hospitalName, String officeName, String contacts, String email) {
        this.hospotialPhone = hospotialPhone;
        this.hospitalName = hospitalName;
        this.officeName = officeName;
        this.contacts = contacts;
        this.email = email;
    }

    public Long getHospotialPhone() {
        return hospotialPhone;
    }

    public void setHospotialPhone(Long hospotialPhone) {
        this.hospotialPhone = hospotialPhone;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospotialPhone=" + hospotialPhone +
                ", hospitalName='" + hospitalName + '\'' +
                ", officeName='" + officeName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
