package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.DietarySurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * 膳食调查  仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface DietarySurveyRepository extends JpaRepository<DietarySurvey, Long> {
}
