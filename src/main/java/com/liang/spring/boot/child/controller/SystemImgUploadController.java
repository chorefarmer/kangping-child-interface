package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.LaboratoryDetection;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SystemImgUpload;
import com.liang.spring.boot.child.repository.LaboratoryDetectionRepository;
import com.liang.spring.boot.child.repository.SystemImgUploadRepository;
import com.liang.spring.boot.child.service.FilePathService;
import com.liang.spring.boot.child.service.LaboratoryDetectionService;
import com.liang.spring.boot.child.service.SystemImgUploadService;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

//import com.liang.spring.boot.child.service.LaboratoryDetectionService;

/**
 * 儿童 实验室检测 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/systemImgUpload")
public class SystemImgUploadController {
	
	@Autowired 
	private SystemImgUploadRepository systemImgUploadRepository;


	@Autowired
	private SystemImgUploadService systemImgUploadService;



	/**
	 * 提交文件夹表单数据
	 */
	@PostMapping("/uploadSystemImg")
	public ResultMsg uploadAll(@RequestParam(value="file",required = false) MultipartFile file,SystemImgUpload systemImgUpload) {

		return systemImgUploadService.Upload(file,systemImgUpload);
	}
}
