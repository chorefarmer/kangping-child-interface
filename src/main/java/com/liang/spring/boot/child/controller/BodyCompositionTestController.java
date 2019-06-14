package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.BodyCompositionTest;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.BodyCompositionTestRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 16:13 2019/6/14
 */
@RestController
@RequestMapping("/bodyCompositionTest")
public class BodyCompositionTestController {

    @Autowired
    private BodyCompositionTestRepository bodyCompositionTestRepository;

    @PostMapping
    public ResultMsg saveBodyCompositionTest(BodyCompositionTest bodyCompositionTest){

        return ResultUtil.success(bodyCompositionTestRepository.save(bodyCompositionTest));
    }

    @GetMapping("{id}")
    public ResultMsg findBodyCompositionTestById(@PathVariable("id") Long id){

        return ResultUtil.success(bodyCompositionTestRepository.findOne(id));
    }
}
