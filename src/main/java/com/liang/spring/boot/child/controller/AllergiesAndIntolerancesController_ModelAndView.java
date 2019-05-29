package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.AllergiesAndIntolerances;
import com.liang.spring.boot.child.repository.AllergiesAndIntolerancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

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
@RequestMapping("/allergiesAndIntolerances_")
public class AllergiesAndIntolerancesController_ModelAndView {
	
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
	 * 查询所用食物过敏与不耐受
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("AllergiesAndIntolerancesList", getAllergiesAndIntolerancesList());
		mav.addObject("title", "查看食物过敏与不耐受列表");
		return mav;
	}
 
	/**
	 * 根据id查询食物过敏与不耐受
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		AllergiesAndIntolerances allergiesAndIntolerances = allergiesAndIntolerancesRepository.findOne(id);
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("allergiesAndIntolerances", allergiesAndIntolerances);
		mav.addObject("title", "根据id查询食物过敏与不耐受");
		return mav;
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("allergiesAndIntolerances",getAllergiesAndIntolerancesList() );
		mav.addObject("title", "查看食物过敏与不耐受列表");
		return mav;
	}

	/**
	 * 新建保存食物过敏与不耐受
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ModelAndView create(AllergiesAndIntolerances allergiesAndIntolerances) {
		//System.out.println("userName:"+allergiesAndIntolerances.getName());
		allergiesAndIntolerancesRepository.save(allergiesAndIntolerances);
		return new ModelAndView(new MappingJackson2JsonView());
	}

	/**
	 * 删除食物过敏与不耐受
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		allergiesAndIntolerancesRepository.delete(id);
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("allergiesAndIntolerances",getAllergiesAndIntolerancesList());
		mav.addObject("title", "删除食物过敏与不耐受");
		return mav;
	}

	/**
	 * 修改食物过敏与不耐受
	 * @param id
	 * @return
	 */
	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		AllergiesAndIntolerances allergiesAndIntolerances = allergiesAndIntolerancesRepository.findOne(id);
		ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
		mav.addObject("allergiesAndIntolerances",allergiesAndIntolerances);
		mav.addObject("title", "修改食物过敏与不耐受");
		return mav;
	}

}
