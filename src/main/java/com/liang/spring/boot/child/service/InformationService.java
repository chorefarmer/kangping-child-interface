package com.liang.spring.boot.child.service;

import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.repository.InformationRepository;
import com.liang.spring.boot.child.untils.GetAgeByBirth;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 儿童基本信息 业务层
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:19 2019/9/4
 */
public interface InformationService {

    List<Information> getInformationList();

    ResultMsg getListById (@Valid PeopleKey peopleKey) throws Exception;

    ResultMsg InformationList( );

    ResultMsg<Information> informationAdd(Information information);

    ResultMsg deleteInformation(PeopleKey id);

    ResultMsg modifyInformation(Information information);

    ResultMsg listInformation(Model m,
                                     @RequestParam(value="start",defaultValue="0")int start,
                                     @RequestParam(value = "size", defaultValue = "5") int size) throws Exception;

    Page<Information> findByPageAndParams(Model m,
                                                 final Information information,
                                                 @RequestParam(value="start",defaultValue="0")int start,
                                                 @RequestParam(value = "size", defaultValue = "20") int size) throws Exception;

    ResultMsg addInspectById (Model model, Information information, BindingResult result,Integer status) throws Exception;

}
