package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.BodyCompositionTest;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.BodyCompositionTestRepository;
import com.liang.spring.boot.child.service.BodyCompositionTestService;
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
    private BodyCompositionTestService bodyCompositionTestService;

    @ResponseBody
    @PostMapping
    public ResultMsg saveBodyCompositionTest(BodyCompositionTest bodyCompositionTest){

        return bodyCompositionTestService.saveBodyCompositionTest(bodyCompositionTest);

    }

    @GetMapping("/search")
    public ResultMsg findBodyCompositionTestById(PeopleKey peopleKey){

        return bodyCompositionTestService.findBodyCompositionTestById(peopleKey);

    }
}
