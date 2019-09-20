package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.LaboratoryDetection;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SystemImgUpload;
import com.liang.spring.boot.child.repository.LaboratoryDetectionRepository;
import com.liang.spring.boot.child.repository.SystemImgUploadRepository;
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
 * @Author: liliang
 * @Description:
 * @Date: Create in 15:25 2019/6/21
 */

public interface SystemImgUploadService  {

    ResultMsg Upload(@RequestParam(value="file",required = false) MultipartFile file, SystemImgUpload systemImgUpload);
}
