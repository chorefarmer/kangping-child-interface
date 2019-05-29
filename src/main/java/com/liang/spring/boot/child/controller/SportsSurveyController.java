package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.SportsSurvey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.SportsSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 儿童 运动调查 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/sportsSurvey")
public class SportsSurveyController {
	
	@Autowired 
	private SportsSurveyRepository sportsSurveyRepository;

	/**
	 * 从 运动调查存储库 获取运动调查列表
	 * @return
	 */
	private List<SportsSurvey> getSportsSurveyList() {
		List<SportsSurvey> sportsSurveys = new ArrayList<>();
		for (SportsSurvey sportsSurvey : sportsSurveyRepository.findAll()) {
			sportsSurveys.add(sportsSurvey);
		}
 		return sportsSurveys;
	}

 
	/**
	 * 根据id查询运动调查
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("{id}")
	public ResultMsg getListById(@PathVariable("id") Long id) {
		return ResultUtil.success(sportsSurveyRepository.findOne(id));
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg SportsSurveyList( ) {
		return ResultUtil.success(getSportsSurveyList());
	}

	/**
	 * 新建保存运动调查
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<SportsSurvey> sportsSurveyAdd(SportsSurvey sportsSurvey) {
		return ResultUtil.success(sportsSurveyRepository.save(sportsSurvey));
	}

	/**
	 * 删除运动调查
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ResultMsg deleteSportsSurvey(@PathVariable("id") Long id) {
		sportsSurveyRepository.delete(id);
		return ResultUtil.success();
	}

	/**
	 * 修改运动调查
	 * @param id
	 * @return
	 */
	@GetMapping(value = "modify/{id}")
	public ResultMsg modifySportsSurvey(@PathVariable("id") Long id, Model model) {
		return ResultUtil.success(sportsSurveyRepository.findOne(id));
	}

}
