package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.MealTimes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 15:35 2019/7/12
 */
public interface MealTimesRepository extends JpaRepository<MealTimes,Long> {

}
