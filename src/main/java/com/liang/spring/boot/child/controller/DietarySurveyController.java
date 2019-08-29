package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.DietarySurvey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.DietarySurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 儿童 膳食调查 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/dietarySurvey")
public class DietarySurveyController {
	
	@Autowired 
	private DietarySurveyRepository dietarySurveyRepository;

	/**
	 * 从 膳食调查存储库 获取膳食调查列表
	 * @return
	 */
	private List<DietarySurvey> getDietarySurveyList() {
		List<DietarySurvey> dietarySurveys = new ArrayList<>();
		for (DietarySurvey dietarySurvey : dietarySurveyRepository.findAll()) {
			dietarySurveys.add(dietarySurvey);
		}
 		return dietarySurveys;
	}

 
	/**
	 * 根据id查询膳食调查
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	public ResultMsg getListById(PeopleKey peopleKey) {
		return ResultUtil.success(dietarySurveyRepository.findOne(peopleKey));
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg DietarySurveyList( ) {
		return ResultUtil.success(getDietarySurveyList());
	}

	/**
	 * 新建保存膳食调查
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<DietarySurvey> dietarySurveyAdd(DietarySurvey dietarySurvey) {
		return ResultUtil.success(dietarySurveyRepository.save(dietarySurvey));
	}

	/**
	 * 删除膳食调查
	 * @return
	 */
	@GetMapping("/delete")
	public ResultMsg deleteDietarySurvey(PeopleKey peopleKey) {
		dietarySurveyRepository.delete(peopleKey);
		return ResultUtil.success();
	}

	/**
	 * 修改膳食调查
	 * @return
	 */
	@GetMapping("/modify")
	public ResultMsg modifyDietarySurvey(PeopleKey peopleKey) {
		return ResultUtil.success(dietarySurveyRepository.findOne(peopleKey));
	}

}
