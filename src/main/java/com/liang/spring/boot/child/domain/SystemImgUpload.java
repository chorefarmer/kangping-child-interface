package com.liang.spring.boot.child.domain;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

/**
 * 系统图片上传 实体
 * @Author: liliang
 * @Description:
 * @Date: Create in 15:15 2019/6/21
 */
@Entity
@DynamicUpdate
@IdClass(PeopleKey.class)
public class SystemImgUpload {

    @Id  // 主键
    //@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
    private Long guardian_phone; // 表关联字段 监护人联系方式

    @Id
    private Integer inspectOrder;

    @Transient
    private MultipartFile file;

    private String path;

    protected SystemImgUpload() {
    }

    public SystemImgUpload(Long guardian_phone, Integer inspectOrder, MultipartFile file, String path) {
        this.guardian_phone = guardian_phone;
        this.inspectOrder = inspectOrder;
        this.file = file;
        this.path = path;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "SystemImgUpload{" +
                "guardian_phone=" + guardian_phone +
                ", inspectOrder=" + inspectOrder +
                ", file=" + file +
                ", path='" + path + '\'' +
                '}';
    }
}
