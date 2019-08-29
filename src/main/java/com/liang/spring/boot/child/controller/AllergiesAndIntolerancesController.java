package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.PeopleKey;
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
	private AllergiesAndIntolerancesRepository allergiesAndIntolerancesRepository;

	/**
	 * 从 食物过敏与不耐受存储库 获取食物过敏与不耐受列表
	 * @return
	 */
	private List<AllergiesAndIntolerances> getAllergiesAndIntolerancesList() {
		List<AllergiesAndIntolerances> allergiesAndIntolerancess = new ArrayList<>();
		for (AllergiesAndIntolerances allergiesAndIntolerances : allergiesAndIntolerancesRepository.findAll()) {
			allergiesAndIntolerancess.add(allergiesAndIntolerances);
		}
 		return allergiesAndIntolerancess;
	}

 
	/**
	 * 根据id查询食物过敏与不耐受
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	public ResultMsg getListById(Model model, @Valid PeopleKey peopleKey, BindingResult result) throws Exception{
		return ResultUtil.success(allergiesAndIntolerancesRepository.findOne(peopleKey));
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg AllergiesAndIntolerancesList( ) {
		return ResultUtil.success(getAllergiesAndIntolerancesList());
	}

	/**
	 * 新建保存食物过敏与不耐受
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<AllergiesAndIntolerances> allergiesAndIntolerancesAdd(AllergiesAndIntolerances allergiesAndIntolerances) {
		return ResultUtil.success(allergiesAndIntolerancesRepository.save(allergiesAndIntolerances));
	}

	/**
	 * 删除食物过敏与不耐受
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete")
	public ResultMsg deleteAllergiesAndIntolerances(PeopleKey id) {
		allergiesAndIntolerancesRepository.delete(id);
		return ResultUtil.success();
	}

	/**
	 * 修改食物过敏与不耐受
	 * @param allergiesAndIntolerances
	 * @return
	 */
	@PostMapping("/modify")
	public ResultMsg modifyAllergiesAndIntolerances(AllergiesAndIntolerances allergiesAndIntolerances) {
		return ResultUtil.success(allergiesAndIntolerancesRepository.save(allergiesAndIntolerances));
	}

}
