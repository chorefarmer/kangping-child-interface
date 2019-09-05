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
@Service
public class SportsSurveyService {

    @Autowired
    private SportsSurveyRepository sportsSurveyRepository;

    /**
     * 从 运动调查存储库 获取运动调查列表
     * @return
     */
    private List<SportsSurvey> getSportsSurveyList() {
        List<SportsSurvey> sportsSurveys = new ArrayList<>();
        for (SportsSurvey sportsSurvey : sportsSurveyRepository.findAll()) {
            sportsSurveys.add(sportsSurvey);
        }
        return sportsSurveys;
    }


    /**
     * 根据id查询运动调查
     * @return
     */
    public ResultMsg getListById(PeopleKey peopleKey) {
        return ResultUtil.success(sportsSurveyRepository.findOne(peopleKey));
    }

    /**
     * 获取 form 表单页面
     * @return
     */
    public ResultMsg SportsSurveyList( ) {
        return ResultUtil.success(getSportsSurveyList());
    }

    /**
     * 新建保存运动调查
     * @return
     */
    public ResultMsg<SportsSurvey> sportsSurveyAdd(SportsSurvey sportsSurvey) {
        return ResultUtil.success(sportsSurveyRepository.save(sportsSurvey));
    }

    /**
     * 删除运动调查
     * @return
     */
    public ResultMsg deleteSportsSurvey(PeopleKey peopleKey) {
        sportsSurveyRepository.delete(peopleKey);
        return ResultUtil.success();
    }

    /**
     * 修改运动调查
     * @return
     */
    public ResultMsg modifySportsSurvey(PeopleKey peopleKey) {
        return ResultUtil.success(sportsSurveyRepository.findOne(peopleKey));
    }
}
