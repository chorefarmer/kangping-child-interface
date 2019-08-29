package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.LaboratoryDetection;
import com.liang.spring.boot.child.domain.PeopleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * 实验室检测    仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface LaboratoryDetectionRepository extends JpaRepository<LaboratoryDetection, PeopleKey> {
}
