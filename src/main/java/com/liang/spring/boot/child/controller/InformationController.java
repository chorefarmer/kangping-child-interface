package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.InformationRepository;
import com.liang.spring.boot.child.untils.GetAgeByBirth;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 儿童 基本信息 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/information")
public class InformationController {
	
	@Autowired 
	private InformationRepository informationRepository;

	/**
	 * 从 基本信息存储库 获取基本信息列表
	 * @return
	 */
	private List<Information> getInformationList() {
		List<Information> informations = new ArrayList<>();
		for (Information information : informationRepository.findAll()) {
			informations.add(information);
		}
 		return informations;
	}

 
	/**
	 * 根据id查询基本信息
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public ResultMsg getListById(Model model,
								 @PathVariable("id") Long id) {
		Information information=informationRepository.findOne(id);
		Date birth=information.getBirth();
		String age= GetAgeByBirth.getAgeFromBirthTime(birth);

		model.addAttribute("age",age);
		model.addAttribute(information);

		return ResultUtil.success(model);
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg InformationList( ) {
		return ResultUtil.success(getInformationList());
	}

	/**
	 * 新建保存基本信息
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<Information> informationAdd(Information information) {
		Long id=information.getGuardian_phone();
		if(informationRepository.findOne(id)!=null){
			return ResultUtil.error(1,"该档案号已经注册过");
		}
		return ResultUtil.success(informationRepository.save(information));
	}

	/**
	 * 删除基本信息
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ResultMsg deleteInformation(@PathVariable("id") Long id) {
		informationRepository.delete(id);
		return ResultUtil.success();
	}

	/**
	 * 修改基本信息提交
	 * @param
	 * @return
	 */
	@PostMapping(value = "/modify")
	public ResultMsg modifyInformation(Information information) {
		return ResultUtil.success(informationRepository.save(information));
	}

	/**
	 *分页实现
	 */

	@RequestMapping("/listInformation")   //查询所有分类
	public ResultMsg listInformation(Model m,
							   @RequestParam(value="start",defaultValue="0")int start,
							   @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {

		//start = start < 0 ? 0:start;
		//Sort sort = new Sort(Sort.Direction.DESC,"guardian_phone"); //设置根据id倒序排列
		//Pageable pageable = new PageRequest(start, size,sort); //根据start、size、sort创建分页对象

		Pageable pageable = new PageRequest(start, size);
		Page<Information> page = informationRepository.findAll(pageable);    //根据这个分页对象获取分页对象

		m.addAttribute("Number",page.getNumber());//当前为第几页
		m.addAttribute("NumberOfElements",page.getNumberOfElements());//当前页有多少条数据
		m.addAttribute("Size",page.getSize());//每页有多少条数据
		m.addAttribute("TotalElements",page.getTotalElements());//总共有多少条数据
		m.addAttribute("TotalPage",page.getTotalPages());//总共有多少页
		m.addAttribute("content",page.getContent());//数据的内容

		return ResultUtil.success(m);

	}

	/**
	 *多条件 分页实现
	 */

	@RequestMapping("/findByPageAndParams")   //查询所有分类
	public Page<Information> findByPageAndParams(Model m,
												final Information information,
									 @RequestParam(value="start",defaultValue="0")int start,
									 @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {

		Pageable pageable=new PageRequest(start, size);  //分页信息

		Specification<Information> spec = new Specification<Information>() {

			@Override
			public Predicate toPredicate(Root<Information> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Path<String> name = root.get("name");
				System.out.println("name："+information.getName());

				Path<Long> guardian_phone = root.get("guardian_phone");
				System.out.println("phone："+information.getGuardian_phone());

				Predicate p1 = cb.like(name, "%"+information.getName()+"%");

				Predicate p2 = cb.equal(guardian_phone, information.getGuardian_phone());

				Predicate p = cb.or(p1, p2);


				return p;

			}
		};


		if(information.getName()==null&&information.getGuardian_phone()==null){
			return informationRepository.findAll(pageable);
		}
		return informationRepository.findAll(spec, pageable);
//		Page<Information> page=informationRepository.findAll(spec, pageable);
//
//		m.addAttribute("Number",page.getNumber());//当前为第几页
//		m.addAttribute("NumberOfElements",page.getNumberOfElements());//当前页有多少条数据
//		m.addAttribute("Size",page.getSize());//每页有多少条数据
//		m.addAttribute("TotalElements",page.getTotalElements());//总共有多少条数据
//		m.addAttribute("TotalPage",page.getTotalPages());//总共有多少页
//		m.addAttribute("content",page.getContent());//数据的内容
//
//		return ResultUtil.success(m);
	}


}
