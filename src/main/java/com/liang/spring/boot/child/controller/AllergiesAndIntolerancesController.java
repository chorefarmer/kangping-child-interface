package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.service.AllergiesAndIntolerancesService;
import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.AllergiesAndIntolerancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 儿童 食物过敏与不耐受 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/allergiesAndIntolerances")
public class AllergiesAndIntolerancesController {

	@Autowired
	private AllergiesAndIntolerancesService allergiesAndIntolerancesService;

	/**
	 * 根据id查询食物过敏与不耐受
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	public ResultMsg getListById(@Valid PeopleKey peopleKey) throws Exception{

		return allergiesAndIntolerancesService.getListById(peopleKey);

	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg AllergiesAndIntolerancesList( ) {

		return allergiesAndIntolerancesService.AllergiesAndIntolerancesList();

	}

	/**
	 * 新建保存食物过敏与不耐受
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<AllergiesAndIntolerances> allergiesAndIntolerancesAdd(AllergiesAndIntolerances allergiesAndIntolerances) {

		return allergiesAndIntolerancesService.allergiesAndIntolerancesAdd(allergiesAndIntolerances);

	}

	/**
	 * 删除食物过敏与不耐受
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete")
	public ResultMsg deleteAllergiesAndIntolerances(PeopleKey id) {

		return allergiesAndIntolerancesService.deleteAllergiesAndIntolerances(id);

	}

	/**
	 * 修改食物过敏与不耐受
	 * @param allergiesAndIntolerances
	 * @return
	 */
	@PostMapping("/modify")
	public ResultMsg modifyAllergiesAndIntolerances(AllergiesAndIntolerances allergiesAndIntolerances) {

		return allergiesAndIntolerancesService.modifyAllergiesAndIntolerances(allergiesAndIntolerances);

	}

}
