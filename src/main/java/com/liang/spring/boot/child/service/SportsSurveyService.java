package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SportsSurvey;
import com.liang.spring.boot.child.repository.SportsSurveyRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:30 2019/9/4
 */

public interface SportsSurveyService {

    List<SportsSurvey> getSportsSurveyList();

    ResultMsg getListById(PeopleKey peopleKey);

    ResultMsg SportsSurveyList( );

    ResultMsg<SportsSurvey> sportsSurveyAdd(SportsSurvey sportsSurvey);

    ResultMsg deleteSportsSurvey(PeopleKey peopleKey);

    ResultMsg modifySportsSurvey(PeopleKey peopleKey);
}
