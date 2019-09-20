package com.liang.spring.boot.child.service.impl;

import com.liang.spring.boot.child.domain.PastMedicalHistory;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.PastMedicalHistoryRepository;
import com.liang.spring.boot.child.service.PastMedicalHistoryService;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 13:47 2019/9/4
 */
@Service
public class PastMedicalHistoryServiceImpl implements PastMedicalHistoryService {

    @Autowired
    private PastMedicalHistoryRepository pastMedicalHistoryRepository;

    /**
     * 从 既往病史存储库 获取既往病史列表
     * @return
     */
    public List<PastMedicalHistory> getPastMedicalHistoryList() {
        List<PastMedicalHistory> pastMedicalHistorys = new ArrayList<>();
        for (PastMedicalHistory pastMedicalHistory : pastMedicalHistoryRepository.findAll()) {
            pastMedicalHistorys.add(pastMedicalHistory);
        }
        return pastMedicalHistorys;
    }


    /**
     * 根据id查询既往病史
     * @return
     */
    @ResponseBody
    public ResultMsg getListById(PeopleKey peopleKey) {
        return ResultUtil.success(pastMedicalHistoryRepository.findOne(peopleKey));
    }

    /**
     * 获取 form 表单页面
     * @return
     */
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
     * @return
     */
    public ResultMsg deletePastMedicalHistory(PeopleKey peopleKey) {
        pastMedicalHistoryRepository.delete(peopleKey);
        return ResultUtil.success();
    }

    /**
     * 修改既往病史
     * @return
     */
    public ResultMsg modifyPastMedicalHistory(PastMedicalHistory pastMedicalHistory) {
        return ResultUtil.success(pastMedicalHistoryRepository.save(pastMedicalHistory));
    }
}
