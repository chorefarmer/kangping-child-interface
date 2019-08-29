package com.liang.spring.boot.child.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * 复合主键类 guardian_phone+inspectOrder构成复合主键
 * @Author: liliang
 * @Description:
 * @Date: Create in 14:07 2019/8/27
 */
//@Embeddable
public class PeopleKey implements Serializable {

    private Long guardian_phone;

    private Integer inspectOrder;

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

    public PeopleKey() {
    }

    public PeopleKey(Long guardian_phone, Integer inspectOrder) {
        this.guardian_phone = guardian_phone;
        this.inspectOrder = inspectOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleKey peopleKey = (PeopleKey) o;
        return guardian_phone.equals(peopleKey.guardian_phone) &&
                inspectOrder.equals(peopleKey.inspectOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guardian_phone, inspectOrder);
    }

    @Override
    public String toString() {
        return "PeopleKey{" +
                "guardian_phone=" + guardian_phone +
                ", inspectOrder=" + inspectOrder +
                '}';
    }


}
