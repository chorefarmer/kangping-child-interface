package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 医院管理  仓库
 * Created by: elvis(李亮)
 * 2019-05-07 13:57
 * Version: 1.0
 */
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
