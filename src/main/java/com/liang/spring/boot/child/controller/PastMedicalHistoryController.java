package com.liang.spring.boot.child.controller;

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
 * 儿童既往病史控制器.
 * 
 * @author LiLiang
 * @date 2019年3月5日
 */
@RestController
@RequestMapping("/pastMedicalHistory")
public class PastMedicalHistoryController {
	
	@Autowired 
	private PastMedicalHistoryRepository pastMedicalHistoryRepository;

	/**
	 * 从 既往病史存储库 获取既往病史列表
	 * @return
	 */
	private List<PastMedicalHistory> getPastMedicalHistoryList() {
		List<PastMedicalHistory> pastMedicalHistorys = new ArrayList<>();
		for (PastMedicalHistory pastMedicalHistory : pastMedicalHistoryRepository.findAll()) {
			pastMedicalHistorys.add(pastMedicalHistory);
		}
 		return pastMedicalHistorys;
	}

 
	/**
	 * 根据id查询既往病史
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("{id}")
	public ResultMsg getListById(@PathVariable("id") Long id) {
		return ResultUtil.success(pastMedicalHistoryRepository.findOne(id));
	}

	/**
	 * 获取 form 表单页面
	 * @return
	 */
	@GetMapping("/form")
	public ResultMsg PastMedicalHistoryList( ) {
		return ResultUtil.success(getPastMedicalHistoryList());
	}

	/**
	 * 新建保存既往病史
	 * @return
	 */
	@ResponseBody
	@PostMapping
	public ResultMsg<PastMedicalHistory> pastMedicalHistoryAdd(PastMedicalHistory pastMedicalHistory) {
		return ResultUtil.success(pastMedicalHistoryRepository.save(pastMedicalHistory));
	}

	/**
	 * 删除既往病史
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete/{id}")
	public ResultMsg deletePastMedicalHistory(@PathVariable("id") Long id) {
		pastMedicalHistoryRepository.delete(id);
		return ResultUtil.success();
	}

	/**
	 * 修改既往病史
	 * @param id
	 * @return
	 */
	@GetMapping(value = "modify/{id}")
	public ResultMsg modifyPastMedicalHistory(@PathVariable("id") Long id, Model model) {
		return ResultUtil.success(pastMedicalHistoryRepository.findOne(id));
	}

}
