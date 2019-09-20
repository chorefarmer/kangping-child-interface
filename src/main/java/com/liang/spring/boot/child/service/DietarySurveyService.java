package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.DietarySurvey;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.DietarySurveyRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 膳食调查 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:10 2019/9/4
 */
public interface DietarySurveyService {

    List<DietarySurvey> getDietarySurveyList();

    ResultMsg getListById(PeopleKey peopleKey);

    ResultMsg DietarySurveyList( );

    ResultMsg<DietarySurvey> dietarySurveyAdd(DietarySurvey dietarySurvey);

    ResultMsg deleteDietarySurvey(PeopleKey peopleKey);

    ResultMsg modifyDietarySurvey(PeopleKey peopleKey);

}
