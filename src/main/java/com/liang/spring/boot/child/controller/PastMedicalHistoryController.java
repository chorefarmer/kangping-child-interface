package com.liang.spring.boot.child.controller;

import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.service.PastMedicalHistoryService;
import com.liang.spring.boot.child.untils.ResultUtil;
import com.liang.spring.boot.child.domain.PastMedicalHistory;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.PastMedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 儿童既往病史 控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
@RestController
@RequestMapping("/pastMedicalHistory")
public class PastMedicalHistoryController {
	
	@Autowired 
	private PastMedicalHistoryService pastMedicalHistoryService;

	/**
	 * 根据id查询既往病史
	 * @return
	 */
	@ResponseBody
	@GetMapping("/search")
	public ResultMsg getListById(PeopleKey peopleKey) {

		return pastMedicalHistoryService.getListById(peopleKey);

	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg PastMedicalHistoryList( ) {

		return pastMedicalHistoryService.PastMedicalHistoryList();

	}

	/**
	 * 新建保存既往病史
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<PastMedicalHistory> pastMedicalHistoryAdd(PastMedicalHistory pastMedicalHistory) {

		return pastMedicalHistoryService.pastMedicalHistoryAdd(pastMedicalHistory);

	}

	/**
	 * 删除既往病史
	 * @return
	 */
	@GetMapping("/delete")
	public ResultMsg deletePastMedicalHistory(PeopleKey peopleKey) {

		pastMedicalHistoryService.deletePastMedicalHistory(peopleKey);
		return ResultUtil.success();

	}

	/**
	 * 修改既往病史
	 * @return
	 */
	@PostMapping("/modify")
	public ResultMsg modifyPastMedicalHistory(PastMedicalHistory pastMedicalHistory) {

		return pastMedicalHistoryService.modifyPastMedicalHistory(pastMedicalHistory);

	}

}
