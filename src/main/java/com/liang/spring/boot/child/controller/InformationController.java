package com.liang.spring.boot.child.controller;

import com.alibaba.fastjson.JSON;
import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.InformationRepository;
import com.liang.spring.boot.child.service.InformationService;
import com.liang.spring.boot.child.untils.GetAgeByBirth;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 儿童 基本信息 控制器.
 * @author LiLiang
 * @date 2019年3月5日
 */
//@CrossOrigin(origins = "http://192.168.1.8:8080", maxAge = 3600)
@RestController
@RequestMapping("/information")
public class InformationController {
	
	@Autowired 
	private InformationService informationService;

	/**
	 * 根据id查询基本信息
	 * @return
	 */
	@GetMapping("/search")
	public ResultMsg getListById (@Valid PeopleKey peopleKey) throws Exception{

		return informationService.getListById(peopleKey);

	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg InformationList( ) {

	    return informationService.InformationList();

	}

	/**
	 * 新建保存基本信息
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<Information> informationAdd(Information information) {

		return informationService.informationAdd(information);

	}

	/**
	 * 删除基本信息
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete")
	public ResultMsg deleteInformation(PeopleKey id) {

		informationService.deleteInformation(id);
		return ResultUtil.success();

	}

	/**
	 * 修改基本信息提交
	 * @param
	 * @return
	 */
	@PostMapping(value = "/modify")
	public ResultMsg modifyInformation(Information information) {

		return informationService.modifyInformation(information);

	}

	/**
	 *分页实现
	 */
	@RequestMapping("/listInformation")   //查询所有分类
	public ResultMsg listInformation(Model m,
							   @RequestParam(value="start",defaultValue="0")int start,
							   @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {

		return informationService.listInformation(m, start, size);

	}

	/**
	 *多条件 分页实现
	 */

	@RequestMapping("/findByPageAndParams")   //查询所有分类
	public Page<Information> findByPageAndParams(Model m,
												final Information information,
									 @RequestParam(value="start",defaultValue="0")int start,
									 @RequestParam(value = "size", defaultValue = "20") int size) throws Exception {

		return informationService.findByPageAndParams(m, information, start, size);

	}


    /**
     * 新增检测提交数据 接口
     * @return
     */
    @PostMapping("/addInspect")
    public ResultMsg addInspectById (Model model, Information information, BindingResult result,Integer status) throws Exception{

        informationService.addInspectById(model, information, result, status);
        return ResultUtil.success(information);

    }

}
