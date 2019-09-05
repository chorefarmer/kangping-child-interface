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
@Service
public class DietarySurveyService {

    @Autowired
    private DietarySurveyRepository dietarySurveyRepository;

    /**
     * 从 膳食调查存储库 获取膳食调查列表
     * @return
     */
    private List<DietarySurvey> getDietarySurveyList() {
        List<DietarySurvey> dietarySurveys = new ArrayList<>();
        for (DietarySurvey dietarySurvey : dietarySurveyRepository.findAll()) {
            dietarySurveys.add(dietarySurvey);
        }
        return dietarySurveys;
    }


    /**
     * 根据id查询膳食调查
     * @return
     */
    public ResultMsg getListById(PeopleKey peopleKey) {
        return ResultUtil.success(dietarySurveyRepository.findOne(peopleKey));
    }

    /**
     * 获取 form 表单页面
     * @return
     */
    public ResultMsg DietarySurveyList( ) {
        return ResultUtil.success(getDietarySurveyList());
    }

    /**
     * 新建保存膳食调查
     * @return
     */
    public ResultMsg<DietarySurvey> dietarySurveyAdd(DietarySurvey dietarySurvey) {
        return ResultUtil.success(dietarySurveyRepository.save(dietarySurvey));
    }

    /**
     * 删除膳食调查
     * @return
     */
    public ResultMsg deleteDietarySurvey(PeopleKey peopleKey) {
        dietarySurveyRepository.delete(peopleKey);
        return ResultUtil.success();
    }

    /**
     * 修改膳食调查
     * @return
     */
    public ResultMsg modifyDietarySurvey(PeopleKey peopleKey) {
        return ResultUtil.success(dietarySurveyRepository.findOne(peopleKey));
    }

}
