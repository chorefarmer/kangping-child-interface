package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.AllergiesAndIntolerancesRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 食物过敏与不耐受 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 11:20 2019/9/4
 */
public interface AllergiesAndIntolerancesService {


    List<AllergiesAndIntolerances> getAllergiesAndIntolerancesList();

    ResultMsg getListById(PeopleKey peopleKey);

    ResultMsg AllergiesAndIntolerancesList( );

    ResultMsg<AllergiesAndIntolerances> allergiesAndIntolerancesAdd(AllergiesAndIntolerances allergiesAndIntolerances);

    ResultMsg deleteAllergiesAndIntolerances(PeopleKey id);

    ResultMsg modifyAllergiesAndIntolerances(AllergiesAndIntolerances allergiesAndIntolerances);
}
