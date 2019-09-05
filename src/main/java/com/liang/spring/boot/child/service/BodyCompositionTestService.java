package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.BodyCompositionTest;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.BodyCompositionTestRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 体成分测试 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:03 2019/9/4
 */
@Service
public class BodyCompositionTestService {

    @Autowired
    private BodyCompositionTestRepository bodyCompositionTestRepository;

    public ResultMsg saveBodyCompositionTest(BodyCompositionTest bodyCompositionTest){

        return ResultUtil.success(bodyCompositionTestRepository.save(bodyCompositionTest));
    }

    public ResultMsg findBodyCompositionTestById(PeopleKey peopleKey){

        return ResultUtil.success(bodyCompositionTestRepository.findOne(peopleKey));
    }
}