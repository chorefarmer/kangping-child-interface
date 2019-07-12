package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.DietaryGuide;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 膳食指导 资源库
 * @Author: liliang
 * @Description:
 * @Date: Create in 14:26 2019/7/10
 */
public interface DietaryGuideRepository extends JpaRepository<DietaryGuide, Long> {

}
