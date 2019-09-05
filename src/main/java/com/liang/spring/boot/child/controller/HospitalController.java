package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.Hospital;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.HospitalRepository;
import com.liang.spring.boot.child.service.HospitalService;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 医院信息管理 控制层
 * Created by: elvis(李亮)
 * 2019-05-07 14:09
 * Version: 1.0
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    /**
     * 提交医院管理信息
     * @param hospital
     * @return
     */
    @PostMapping
    public ResultMsg saveHospital(Hospital hospital) {

        return hospitalService.saveHospital(hospital);

    }

    /**
     * 根据id查询医院管理
     * @return
     */
    @ResponseBody
    @GetMapping("/search")
    public ResultMsg getListById( ) {

        return hospitalService.getListById();

    }

}
