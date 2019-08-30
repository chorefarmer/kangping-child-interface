package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.Hospital;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.HospitalRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by: elvis(李亮)
 * 2019-05-07 14:09
 * Version: 1.0
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * 提交医院管理信息
     * @param hospital
     * @return
     */
    @PostMapping
    public ResultMsg saveHospital(Hospital hospital) {

        if(hospital.getHospitalId()==null){
            hospital.setHospitalId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        }
        return ResultUtil.success(hospitalRepository.save(hospital));
    }

    /**
     * 根据id查询医院管理
     * @return
     */
    @ResponseBody
    @GetMapping
    public ResultMsg getListById( ) {


        System.out.println("医院信息："+hospitalRepository.findAll());

        return ResultUtil.success(hospitalRepository.findAll());

    }

}
