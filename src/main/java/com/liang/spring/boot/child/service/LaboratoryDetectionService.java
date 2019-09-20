package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.LaboratoryDetection;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.LaboratoryDetectionRepository;
import com.liang.spring.boot.child.untils.FileUtil;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 文件上传业务层
 * Created by: elvis(李亮)
 * 2019-04-18 10:18
 * Version: 1.0
 */

public interface LaboratoryDetectionService {

    ResultMsg Upload(@RequestParam(value="file",required = false) MultipartFile file,LaboratoryDetection laboratoryDetection);
}
