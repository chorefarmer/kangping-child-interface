package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.LaboratoryDetection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * 食物过敏与不耐受  仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface AllergiesAndIntolerancesRepository extends JpaRepository<AllergiesAndIntolerances, Long> {
}
