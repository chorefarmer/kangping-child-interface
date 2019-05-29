package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.service.FilePathService;
//import com.liang.spring.boot.child.service.LaboratoryDetectionService;
import com.liang.spring.boot.child.service.LaboratoryDetectionService;
import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.LaboratoryDetection;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.LaboratoryDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 儿童 实验室检测 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/laboratoryDetection")
public class LaboratoryDetectionController {
	
	@Autowired 
	private LaboratoryDetectionRepository laboratoryDetectionRepository;

	@Autowired
	private FilePathService filePathService;

	@Autowired
	private LaboratoryDetectionService laboratoryDetectionService;

	//private LaboratoryDetectionService laboratoryDetectionService;
	/**
	 * 从 实验室检测存储库 获取实验室检测列表
	 * @return
	 */
	private List<LaboratoryDetection> getLaboratoryDetectionList() {
		List<LaboratoryDetection> laboratoryDetections = new ArrayList<>();
		for (LaboratoryDetection laboratoryDetection : laboratoryDetectionRepository.findAll()) {
			laboratoryDetections.add(laboratoryDetection);
		}
 		return laboratoryDetections;
	}

 
	/**
	 * 根据id查询实验室检测
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("{id}")
	public ResultMsg getListById(@PathVariable("id") Long id) {
		return ResultUtil.success(laboratoryDetectionRepository.findOne(id));
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg LaboratoryDetectionList( ) {
		return ResultUtil.success(getLaboratoryDetectionList());
	}

	/**
	 * 新建保存实验室检测
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<LaboratoryDetection> laboratoryDetectionAdd(LaboratoryDetection laboratoryDetection) {
		return ResultUtil.success(laboratoryDetectionRepository.save(laboratoryDetection));
	}

	/**
	 * 删除实验室检测
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ResultMsg deleteLaboratoryDetection(@PathVariable("id") Long id) {
		laboratoryDetectionRepository.delete(id);
		return ResultUtil.success();
	}

	/**
	 * 修改实验室检测
	 * @param id
	 * @return
	 */
	@GetMapping(value = "modify/{id}")
	public ResultMsg modifyLaboratoryDetection(@PathVariable("id") Long id, Model model) {
		return ResultUtil.success(laboratoryDetectionRepository.findOne(id));
	}

	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	public ResultMsg upload(@RequestParam(value = "file",required = false) MultipartFile file,LaboratoryDetection laboratoryDetection) {

		return filePathService.Upload(file);
	}

	/**
	 * 提交文件夹表单数据
	 */
	@PostMapping("/uploadAll")
	public ResultMsg uploadAll(@RequestParam(value="file",required = false) MultipartFile file,LaboratoryDetection laboratoryDetection) {

		return laboratoryDetectionService.Upload(file,laboratoryDetection);
	}
}
