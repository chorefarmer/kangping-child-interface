package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.PastMedicalHistory;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.PastMedicalHistoryRepository;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 13:47 2019/9/4
 */

public interface PastMedicalHistoryService {

    List<PastMedicalHistory> getPastMedicalHistoryList();

    ResultMsg getListById(PeopleKey peopleKey);

    ResultMsg PastMedicalHistoryList( );

    ResultMsg<PastMedicalHistory> pastMedicalHistoryAdd(PastMedicalHistory pastMedicalHistory);

    ResultMsg deletePastMedicalHistory(PeopleKey peopleKey);

    ResultMsg modifyPastMedicalHistory(PastMedicalHistory pastMedicalHistory);
}
