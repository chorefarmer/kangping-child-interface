package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.BodyCompositionTest;
import com.liang.spring.boot.child.domain.DietarySurvey;
import com.liang.spring.boot.child.domain.PeopleKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 16:11 2019/6/14
 */
public interface BodyCompositionTestRepository extends JpaRepository<BodyCompositionTest, PeopleKey> {

}
