package com.liang.spring.boot.child.service.impl;

import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SystemImgUpload;
import com.liang.spring.boot.child.repository.SystemImgUploadRepository;
import com.liang.spring.boot.child.service.SystemImgUploadService;
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
@Service
public class SystemImgUploadServiceImpl implements SystemImgUploadService {

    @Autowired
    private SystemImgUploadRepository repository;


    public ResultMsg Upload(@RequestParam(value="file",required = false) MultipartFile file, SystemImgUpload systemImgUpload) {


        if(!file.isEmpty()) {

            String fileName = file.getOriginalFilename();


            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";


            try {

                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            try {
                InetAddress address=InetAddress.getLocalHost();
                String localhost=address.getHostAddress();

                systemImgUpload.setPath("http://"+localhost+":8080/"+fileName);
                repository.save(systemImgUpload);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }


        }
        return ResultUtil.success(systemImgUpload);

    }
}
