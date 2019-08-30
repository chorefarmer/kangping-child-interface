package com.liang.spring.boot.child.controller;


import com.liang.spring.boot.child.calculate.CalcuBMRBetweenOneAndSix;
import com.liang.spring.boot.child.calculate.CalcuEER;
import com.liang.spring.boot.child.calculate.CalcuPAL;
import com.liang.spring.boot.child.domain.*;
import com.liang.spring.boot.child.repository.*;
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
import javax.sound.midi.Soundbank;
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

    @Autowired
    private SportsSurveyRepository sportsSurveyRepository;

    @Autowired
    private DietarySurveyRepository dietarySurveyRepository;

    @Autowired
    private BodyCompositionTestRepository bodyCompositionTestRepository;

    @Autowired
    private DietaryGuideRepository dietaryGuideRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private MealTimesRepository mealTimesRepository;

    /**
     * pdf预览
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    @GetMapping("/preview")
    public void preview(PeopleKey peopleKey, HttpServletRequest request, HttpServletResponse response) {

        //局部变量基础代谢率和每日建议摄入能量初始化
         Double BMR=null;
         Double EER=null;

         String EER_=null;

        // 构造freemarker模板引擎参数,listVars.size()个数对应pdf页数
        List<Map<String,Object>> listVars = new ArrayList<>();
        Map<String,Object> variables = new HashMap<>();



        //根据id查询到医院科室基本信息
        Hospital hospital=hospitalRepository.findOne(peopleKey.getGuardian_phone());



        variables.put("hospital",hospital);

        System.out.println("科室基本信息"+hospital.getHospitalName());

        //根据id查询到基本信息
        Information information=informationRepository.findOne(peopleKey);

            variables.put("information",information);

        System.out.println("当前id号"+information.getGuardian_phone());

            //处理报告性别数据显示
            Integer sex=information.getSex();
            if(sex==1){
                variables.put("sex","男");
            }else if(sex==0){
                variables.put("sex","女");
            }

            //处理报告年龄显示

            Date birth=information.getBirth();

            int age=GetAgeByBirth.getAgeFromBirthTime(birth);

            System.out.println("年龄为"+age);

            //根据id查询到它体成分检测结果
        BodyCompositionTest bodyCompositionTest=bodyCompositionTestRepository.findOne(peopleKey);

        variables.put("bodyCompositionTest",bodyCompositionTest);

        variables.put("Protein",bodyCompositionTest.getProtein());//蛋白质

        variables.put("FatfreeBodyWeight",bodyCompositionTest.getFatfreeBodyWeight());//瘦体重

        variables.put("Fat",bodyCompositionTest.getFat());//脂肪

        variables.put("Weight",bodyCompositionTest.getWeight());//体重
        //计算运动对应的能量

            //根据id查询到运动情况
        SportsSurvey sportsSurvey=sportsSurveyRepository.findOne(peopleKey);

        int sport_status=sportsSurvey.getSport_status();

        //计算PAL
        Double PAL=CalcuPAL.caluPAL(age,sport_status);
        System.out.println("运动PAL计算结果为:"+PAL);

        //计算基础代谢   做了体成分检测的采用体成分检测的体重数据  没做体成分检测的采用个人基本信息的体重
        if(bodyCompositionTest.getMetabolicRate()==null){
            if (bodyCompositionTest.getWeight()!=null){
                BMR= CalcuBMRBetweenOneAndSix.calcuBMR(age,sex,bodyCompositionTest.getWeight());
                System.out.println("基础代谢计算结果为："+BMR);
            }else{
                BMR= CalcuBMRBetweenOneAndSix.calcuBMR(age,sex,information.getWeight());
                System.out.println("基础代谢计算结果为："+BMR);
            }
        }else {
            BMR=bodyCompositionTest.getMetabolicRate();
            System.out.println("基础代谢计算结果为："+BMR);
        }



        //计算总能量
            //年龄1-6个月
            //年龄7-12月
            //年龄1-6岁

        //年龄小于一岁  分为两种情况  年龄1-6个月和 年龄7-12个月
        if(age<1){
            int month=GetAgeByBirth.getMonthFromBirthTime(birth);

            EER= CalcuEER.calcuEEROfFirstYear(sex,month);
            EER_=String.format("%.0f",EER);
            System.out.println(age+"岁儿童每日所需能量为"+EER_);
        }
        if (age>=1&&age<6){

            EER=CalcuEER.calcuEERBetweenFirstAndSix(sex,information.getWeight(),sport_status,age,PAL);
            EER_=String.format("%.0f",EER);
            System.out.println(age+"岁儿童每日所需能量为"+EER_);
        }
        if (age>=6&&age<=18){

            EER=CalcuEER.calcuEERreaterThanSix(bodyCompositionTest.getMetabolicRate(),age,sport_status);
            EER_=String.format("%.0f",EER);
            System.out.println(age+"岁儿童每日所需能量为"+EER_);
        }

        //处理计算出来的能量结果取整后获取数据库对应kcal食谱

        int kcal_low=Integer.parseInt(EER_)-50;

        int kcal_high=Integer.parseInt(EER_)+50;

        variables.put("kcal_low",kcal_low);

        variables.put("kcal_high",kcal_high);

        Long kcal_=(Long.parseLong(EER_)/100)*100;
        System.out.println("取整后能量结果为:"+kcal_);

        DietaryGuide dietaryGuide=dietaryGuideRepository.findOne(kcal_);

        System.out.println("推荐份数为："+dietaryGuide.getAquaticProductG());


        variables.put("dietaryGuide",dietaryGuide);

        //根据计算出来的kcal能量查询对应的餐次推荐
        if(kcal_>=1000&&kcal_<=3000){
            MealTimes mealTimes=mealTimesRepository.findOne(kcal_);
            variables.put("mealTimes",mealTimes);
            System.out.println("推荐摄入能量为"+kcal_+"早餐谷物食物量"+mealTimes.getBreakfastCerealQuantity());
        }else if(kcal_>3000){
            MealTimes mealTimes=mealTimesRepository.findOne(kcal_);
            variables.put("mealTimes",mealTimes);
        }


        //计算膳食营养素分析结果
        //根据id查询到膳食调查情况
//        DietarySurvey dietarySurvey=dietarySurveyRepository.findOne(id);

        variables.put("title","儿童营养监测分析报告");
        listVars.add(variables);

        if(age>0&&age<1){
            PdfUtils.preview(configurer,"pdfPageOne.ftl",listVars,response);
        }else if(age>=1&&age<3){
            PdfUtils.preview(configurer,"pdfPageOneToThree.ftl",listVars,response);
        }else if(age>=3&&age<18){
            PdfUtils.preview(configurer,"pdfPage.ftl",listVars,response);
        }

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