package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.Hospital;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.HospitalRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * 医院信息管理 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:15 2019/9/4
 */
public interface HospitalService {

    ResultMsg saveHospital(Hospital hospital);

    ResultMsg getListById( );
}
