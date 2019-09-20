package com.liang.spring.boot.child.service.impl;

import com.liang.spring.boot.child.domain.Hospital;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.HospitalRepository;
import com.liang.spring.boot.child.service.HospitalService;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 医院信息管理 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:15 2019/9/4
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * 提交医院管理信息
     * @param hospital
     * @return
     */
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
    public ResultMsg getListById( ) {

        return ResultUtil.success(hospitalRepository.findAll().get(0));

    }
}
