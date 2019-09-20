package com.liang.spring.boot.child.service.impl;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.AllergiesAndIntolerancesRepository;
import com.liang.spring.boot.child.service.AllergiesAndIntolerancesService;
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
@Service
public class AllergiesAndIntolerancesServiceImpl implements AllergiesAndIntolerancesService {

    @Autowired
    private AllergiesAndIntolerancesRepository allergiesAndIntolerancesRepository;

    /**
     * 从 食物过敏与不耐受存储库 获取食物过敏与不耐受列表
     * @return
     */
    public List<AllergiesAndIntolerances> getAllergiesAndIntolerancesList() {
        List<AllergiesAndIntolerances> allergiesAndIntolerancess = new ArrayList<>();
        for (AllergiesAndIntolerances allergiesAndIntolerances : allergiesAndIntolerancesRepository.findAll()) {
            allergiesAndIntolerancess.add(allergiesAndIntolerances);
        }
        return allergiesAndIntolerancess;
    }

    public ResultMsg getListById(@Valid PeopleKey peopleKey){

        return ResultUtil.success(allergiesAndIntolerancesRepository.findOne(peopleKey));
    }

    /**
     * 获取 form 表单页面
     * @return
     */
    public ResultMsg AllergiesAndIntolerancesList( ) {
        return ResultUtil.success(getAllergiesAndIntolerancesList());
    }

    /**
     * 新建保存食物过敏与不耐受
     * @return
     */
    public ResultMsg<AllergiesAndIntolerances> allergiesAndIntolerancesAdd(AllergiesAndIntolerances allergiesAndIntolerances) {

        return ResultUtil.success(allergiesAndIntolerancesRepository.save(allergiesAndIntolerances));

    }

    /**
     * 删除食物过敏与不耐受
     * @param id
     * @return
     */
    public ResultMsg deleteAllergiesAndIntolerances(PeopleKey id) {
        allergiesAndIntolerancesRepository.delete(id);
        return ResultUtil.success();
    }

    /**
     * 修改食物过敏与不耐受
     * @param allergiesAndIntolerances
     * @return
     */
    public ResultMsg modifyAllergiesAndIntolerances(AllergiesAndIntolerances allergiesAndIntolerances) {

        return ResultUtil.success(allergiesAndIntolerancesRepository.save(allergiesAndIntolerances));

    }
}
