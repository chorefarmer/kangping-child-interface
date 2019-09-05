package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.service.SportsSurveyService;
import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.SportsSurvey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.SportsSurveyRepository;
import org.aspectj.weaver.PerObjectInterfaceTypeMunger;
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
	private SportsSurveyService sportsSurveyService;

	/**
	 * 根据id查询运动调查
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	public ResultMsg getListById(PeopleKey peopleKey) {

		return sportsSurveyService.getListById(peopleKey);

	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg SportsSurveyList( ) {

		return sportsSurveyService.SportsSurveyList();

	}

	/**
	 * 新建保存运动调查
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<SportsSurvey> sportsSurveyAdd(SportsSurvey sportsSurvey) {

		return sportsSurveyService.sportsSurveyAdd(sportsSurvey);

	}

	/**
	 * 删除运动调查
	 * @return
	 */
	@GetMapping("/delete")
	public ResultMsg deleteSportsSurvey(PeopleKey peopleKey) {

		sportsSurveyService.deleteSportsSurvey(peopleKey);
		return ResultUtil.success();

	}

	/**
	 * 修改运动调查
	 * @return
	 */
	@GetMapping("/modify")
	public ResultMsg modifySportsSurvey(PeopleKey peopleKey) {

		return sportsSurveyService.modifySportsSurvey(peopleKey);

	}

}
