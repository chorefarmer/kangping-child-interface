package com.liang.spring.boot.child.controller;


import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.repository.InformationRepository;
import com.liang.spring.boot.child.untils.GetAgeByBirth;
import com.liang.spring.boot.child.untils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 功能：pdf预览、下载
 *
 * @author qust
 * @version 1.0 2018/2/23 9:35
 */
@Controller
@RequestMapping(value = "/pdf")
public class PdfController {

    @Autowired
    private FreeMarkerConfigurer configurer;

    @Autowired
    private InformationRepository informationRepository;

    /**
     * pdf预览
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @GetMapping("/preview/{id}")
    public void preview(@PathVariable("id") Long id,HttpServletRequest request, HttpServletResponse response) {
        // 构造freemarker模板引擎参数,listVars.size()个数对应pdf页数
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();

        //根据id查询到基本信息
        Information information=informationRepository.getOne(id);

        variables.put("information",information);

        //处理报告性别数据显示
        Integer sex=information.getSex();
        if(sex==1){
            variables.put("sex","男");
        }else if(sex==2){
            variables.put("sex","女");
        }

        //处理报告年龄显示

        Date birth=information.getBirth();

        String age=GetAgeByBirth.getAgeFromBirthTime(birth);

        System.out.println(age);




        variables.put("title","儿童营养监测分析报告");
        listVars.add(variables);

        PdfUtils.preview(configurer,"pdfPage.ftl",listVars,response);
    }



    /**
     * pdf下载
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request, HttpServletResponse response) {
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();
        variables.put("title","测试下载ASGX!");
        listVars.add(variables);
        PdfUtils.download(configurer,"pdfPage.ftl",listVars,response,"测试中文.pdf");
    }


}
