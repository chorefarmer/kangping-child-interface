package com.liang.spring.boot.child.controller;


import com.alibaba.fastjson.JSON;
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
import java.security.PrivateKey;
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
        Double BMR = null;
        Double EER = null;

        String EER_ = null;

        DietaryGuide dietaryGuide = null;

        // 构造freemarker模板引擎参数,listVars.size()个数对应pdf页数
        List<Map<String, Object>> listVars = new ArrayList<>();
        Map<String, Object> variables = new HashMap<>();


        //根据id查询到医院科室基本信息


        List<Hospital> hospital = hospitalRepository.findAll();


        variables.put("hospital", hospital.get(0));
        //System.out.println("处理后医院基本信息"+ hospital);

        //System.out.println("取出数组中第一条医院记录"+hospital.get(0));

        //System.out.println("科室基本信息"+hospital.getHospitalName());

        //根据id查询到基本信息
        Information information = informationRepository.findOne(peopleKey);


        //System.out.println("处理后个人基本信息"+information);
        variables.put("information", information);

        //System.out.println("当前id号"+information.getGuardian_phone());

        //处理报告性别数据显示
        Integer sex = information.getSex();
        if (sex == 1) {
            variables.put("sex", "男");
        } else if (sex == 0) {
            variables.put("sex", "女");
        }

        //处理报告年龄显示

        Date birth = information.getBirth();

        int age = GetAgeByBirth.getAgeFromBirthTime(birth);

        //liang-2019-9-15 处理报告显示年龄的具体描述
        String ageActual=GetAgeByBirth.getActualAgeFromBirthTime(birth);
        System.out.println("报告显示年龄的具体描述"+ageActual);

        variables.put("ageActual", ageActual);
        System.out.println("年龄为" + age);

        //根据id查询到它体成分检测结果
        BodyCompositionTest bodyCompositionTest = bodyCompositionTestRepository.findOne(peopleKey);

        //判断体成分里面是否有身高
        if (bodyCompositionTest != null) {
            variables.put("height", bodyCompositionTest.getHeight());
        } else {
            variables.put("height", information.getHeight());
        }

        variables.put("bodyCompositionTest", bodyCompositionTest);

//        variables.put("Protein",bodyCompositionTest.getProtein());//蛋白质
//
//        variables.put("FatfreeBodyWeight",bodyCompositionTest.getFatfreeBodyWeight());//瘦体重
//
//        variables.put("Fat",bodyCompositionTest.getFat());//脂肪
//
//        variables.put("Weight",bodyCompositionTest.getWeight());//体重
        //计算运动对应的能量

        //根据id查询到运动情况
        SportsSurvey sportsSurvey = sportsSurveyRepository.findOne(peopleKey);

        int sport_status = sportsSurvey.getSport_status();

        //计算PAL
        Double PAL = CalcuPAL.caluPAL(age, sport_status);
        System.out.println("运动PAL计算结果为:" + PAL);

        //计算基础代谢   做了体成分检测的采用体成分检测的体重数据  没做体成分检测的采用个人基本信息的体重

        if (bodyCompositionTest != null) {
            BMR = bodyCompositionTest.getMetabolicRate();
            System.out.println("基础代谢计算结果为：" + BMR);
        } else {
            BMR = CalcuBMRBetweenOneAndSix.calcuBMR(age, sex, information.getWeight());
            System.out.println("基础代谢计算结果为：" + BMR);
        }


        //计算总能量
        //年龄1-6个月
        //年龄7-12月
        //年龄1-6岁

        //年龄小于一岁  分为两种情况  年龄1-6个月和 年龄7-12个月
        if (age < 1) {
            int month = GetAgeByBirth.getMonthFromBirthTime(birth);
            System.out.println("一岁以下月份为" + month);
            EER = CalcuEER.calcuEEROfFirstYear(sex, month, information.getWeight());
            EER_ = String.format("%.0f", EER);
            variables.put("EER_", Integer.parseInt(EER_));
            //七月孩子食谱调用回显数据
            if (month > 6 && month <= 7) {
                System.out.println("七月孩子能量为:" + EER_);
                //减去900ml奶的能量  剩下的辅食提供
                Integer FoodSupplementKcal = Integer.parseInt(EER_) - 585;
                System.out.println("七月孩子需要辅食提供能量为:" + FoodSupplementKcal);
                if (FoodSupplementKcal >= 0 && FoodSupplementKcal <= 30) {
                    variables.put("planA1", "15g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "8g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "半个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "/");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "半个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "/");
                    variables.put("planD2", "/");
                    variables.put("planD3", "半个");
                    variables.put("planD4", "70g");

                } else if (FoodSupplementKcal > 60 && FoodSupplementKcal <= 90) {
                    variables.put("planA1", "25g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "8g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "/");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "/");
                    variables.put("planD2", "/");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 90 && FoodSupplementKcal <= 120) {
                    variables.put("planA1", "30g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "15g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "15g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "8g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 120 && FoodSupplementKcal <= 150) {
                    variables.put("planA1", "40g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "25g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "8g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "8g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 150 && FoodSupplementKcal <= 180) {
                    variables.put("planA1", "45g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "30g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "25g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "15g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 180 && FoodSupplementKcal <= 210) {
                    variables.put("planA1", "55g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "45g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "30g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "25g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 210 && FoodSupplementKcal <= 240) {
                    variables.put("planA1", "65g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "55g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "30g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "25g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 240 && FoodSupplementKcal <= 270) {
                    variables.put("planA1", "70g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "65g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "40g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "30g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 270) {
                    variables.put("planA1", "80g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "70g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "50g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "40g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                }
            }

            //8-12月食谱调用回显数据

            if (month > 7 && month < 12) {
                System.out.println("8-12月孩子能量为:" + EER_);
                //减去900ml奶的能量  剩下的辅食提供
                Integer FoodSupplementKcal = Integer.parseInt(EER_) - 585;
                System.out.println("8-12月孩子需要辅食提供能量为:" + FoodSupplementKcal);
                if (FoodSupplementKcal >= 0 && FoodSupplementKcal <= 30) {
                    variables.put("planA1", "15g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "8g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "半个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "/");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "半个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "/");
                    variables.put("planD2", "/");
                    variables.put("planD3", "半个");
                    variables.put("planD4", "70g");

                } else if (FoodSupplementKcal > 60 && FoodSupplementKcal <= 90) {
                    variables.put("planA1", "25g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "8g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "/");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "/");
                    variables.put("planD2", "/");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 90 && FoodSupplementKcal <= 120) {
                    variables.put("planA1", "30g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "15g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "15g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "8g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 120 && FoodSupplementKcal <= 150) {
                    variables.put("planA1", "40g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "25g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "8g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "8g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 150 && FoodSupplementKcal <= 180) {
                    variables.put("planA1", "45g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "30g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "25g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "15g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 180 && FoodSupplementKcal <= 210) {
                    variables.put("planA1", "55g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "45g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "30g");
                    variables.put("planC2", "25g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "25g");
                    variables.put("planD2", "25g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 210 && FoodSupplementKcal <= 240) {
                    variables.put("planA1", "65g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "55g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "30g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "25g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 240 && FoodSupplementKcal <= 270) {
                    variables.put("planA1", "70g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "65g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "40g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "30g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 270 && FoodSupplementKcal <= 300) {
                    variables.put("planA1", "80g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "70g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "50g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "40g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "70g");
                } else if (FoodSupplementKcal > 300 && FoodSupplementKcal <= 350) {
                    variables.put("planA1", "90g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "75g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "55g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "35g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "140g");
                } else if (FoodSupplementKcal > 350 && FoodSupplementKcal <= 400) {
                    variables.put("planA1", "105g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "90g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "65g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "50g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "140g");
                } else if (FoodSupplementKcal > 400 && FoodSupplementKcal <= 450) {
                    variables.put("planA1", "120g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "100g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "80g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "65g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "140g");
                } else if (FoodSupplementKcal > 450 && FoodSupplementKcal <= 500) {
                    variables.put("planA1", "130g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "115g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "90g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "75g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "140g");
                } else if (FoodSupplementKcal > 500 && FoodSupplementKcal <= 550) {
                    variables.put("planA1", "145g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "130g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "105g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "80g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                } else if (FoodSupplementKcal > 550 && FoodSupplementKcal <= 600) {
                    variables.put("planA1", "155g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "140g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "120g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "95g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                } else if (FoodSupplementKcal > 600 && FoodSupplementKcal <= 650) {
                    variables.put("planA1", "170g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "155g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "130g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "105g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                } else if (FoodSupplementKcal > 650 && FoodSupplementKcal <= 700) {
                    variables.put("planA1", "180g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "165g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "145g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "120g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                } else if (FoodSupplementKcal > 700 && FoodSupplementKcal <= 750) {
                    variables.put("planA1", "195g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "180g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "155g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "135g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                } else if (FoodSupplementKcal > 750) {
                    variables.put("planA1", "210g");
                    variables.put("planA2", "/");
                    variables.put("planA3", "/");
                    variables.put("planA4", "/");

                    variables.put("planB1", "195g");
                    variables.put("planB2", "/");
                    variables.put("planB3", "一个");
                    variables.put("planB4", "/");

                    variables.put("planC1", "170g");
                    variables.put("planC2", "50g");
                    variables.put("planC3", "一个");
                    variables.put("planC4", "/");

                    variables.put("planD1", "145g");
                    variables.put("planD2", "50g");
                    variables.put("planD3", "一个");
                    variables.put("planD4", "200g");
                }
            }

            System.out.println(age + "岁儿童每日所需能量为" + EER_);
        }
        if (age >= 1 && age < 6) {

            EER = CalcuEER.calcuEERBetweenFirstAndSix(sex, information.getWeight(), sport_status, age, PAL);
            EER_ = String.format("%.0f", EER);
            variables.put("EER_", Integer.parseInt(EER_));
            System.out.println(age + "岁儿童每日所需能量为" + EER_);
        }
        if (age >= 6 && age <= 18) {

            EER = CalcuEER.calcuEERreaterThanSix(bodyCompositionTest.getMetabolicRate(), age, sport_status);
            EER_ = String.format("%.0f", EER);
            variables.put("EER_", Integer.parseInt(EER_));
            System.out.println(age + "岁儿童每日所需能量为" + EER_);
        }

        //处理计算出来的能量结果取整后获取数据库对应kcal食谱

        int kcal_low = Integer.parseInt(EER_) - 50;

        int kcal_high = Integer.parseInt(EER_) + 50;

        variables.put("kcal_low", kcal_low);

        variables.put("kcal_high", kcal_high);

        Long kcal_ = (Long.parseLong(EER_) / 100) * 100;
        System.out.println("取整后能量结果为:" + kcal_);

        if (kcal_ < 1000)
            dietaryGuide = dietaryGuideRepository.findOne(Long.valueOf(1000));
        if (kcal_ > 3000)
            dietaryGuide = dietaryGuideRepository.findOne(Long.valueOf(3000));
        if (kcal_ >= 1000 && kcal_ <= 3000)
            dietaryGuide = dietaryGuideRepository.findOne(kcal_);

        //System.out.println("推荐份数为："+dietaryGuide.getAquaticProductG());


        variables.put("dietaryGuide", dietaryGuide);

        //根据计算出来的kcal能量查询对应的餐次推荐
        if (kcal_ >= 1000 && kcal_ <= 3000) {
            MealTimes mealTimes = mealTimesRepository.findOne(kcal_);
            variables.put("mealTimes", mealTimes);
            System.out.println("推荐摄入能量为" + kcal_ + "早餐谷物食物量" + mealTimes.getBreakfastCerealQuantity());
        } else if (kcal_ > 3000) {
            MealTimes mealTimes = mealTimesRepository.findOne(Long.valueOf(3000));
            variables.put("mealTimes", mealTimes);
        } else if (kcal_ < 1000) {
            MealTimes mealTimes = mealTimesRepository.findOne(Long.valueOf(1000));
            variables.put("mealTimes", mealTimes);
        }


        //计算膳食营养素分析结果
        //根据id查询到膳食调查情况
        DietarySurvey dietarySurvey = dietarySurveyRepository.findOne(peopleKey);
        //System.out.println("膳食调查分析结果为"+dietarySurvey);
        //计算每天谷薯类摄入量
        Double stapleFoodG = dietaryGuide.getStapleFoodG();//谷薯类推荐摄入值
        //System.out.println("谷薯类膳食调查勾选结果为"+dietarySurvey.getStapleFood());
        if (dietarySurvey != null) {

        if (dietarySurvey.getStapleFood() == 1 || dietarySurvey.getStapleFood() == 2) {
            variables.put("StapleFoodIntake", "偏低");
        } else if (dietarySurvey.getStapleFood() == 3) {
            if (stapleFoodG >= 100 || stapleFoodG < 150) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 150) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 100) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 4) {
            if (stapleFoodG >= 150 || stapleFoodG < 200) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 200) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 150) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 5) {
            if (stapleFoodG >= 200 || stapleFoodG < 250) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 250) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 200) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 6) {
            if (stapleFoodG >= 250 || stapleFoodG < 300) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 300) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 250) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 7) {
            if (stapleFoodG >= 300 || stapleFoodG < 350) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 350) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 300) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 8) {
            if (stapleFoodG >= 350 || stapleFoodG < 400) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 400) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 350) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 9) {
            if (stapleFoodG >= 400 || stapleFoodG < 450) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 450) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 400) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 10) {
            if (stapleFoodG >= 450 || stapleFoodG < 500) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 500) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 450) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 11) {
            if (stapleFoodG >= 500 || stapleFoodG < 550) {
                variables.put("StapleFoodIntake", "适宜");
            } else if (stapleFoodG > 550) {
                variables.put("StapleFoodIntake", "偏低");
            } else if (stapleFoodG < 500) {
                variables.put("StapleFoodIntake", "偏高");
            }
        } else if (dietarySurvey.getStapleFood() == 12) {
            if (stapleFoodG < 550) {
                variables.put("StapleFoodIntake", "偏高");
            }
        }
    }

        //计算每天蔬菜类摄入量
        Double vegetablesG=dietaryGuide.getVegetablesG();//蔬菜类推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getVegetables()==1||dietarySurvey.getVegetables()==2){
            variables.put("VegetablesIntake","偏低");
        }else if(dietarySurvey.getVegetables()==3){
            if(vegetablesG>=200||vegetablesG<300){
                variables.put("VegetablesIntake","适宜");
            }else if(vegetablesG>300){
                variables.put("VegetablesIntake","偏低");
            }else if(vegetablesG<200){
                variables.put("VegetablesIntake","偏高");
            }
        }else if(dietarySurvey.getVegetables()==4){
            if(vegetablesG>=300||vegetablesG<400){
                variables.put("VegetablesIntake","适宜");
            }else if(vegetablesG>400){
                variables.put("VegetablesIntake","偏低");
            }else if(vegetablesG<300){
                variables.put("VegetablesIntake","偏高");
            }
        }else if(dietarySurvey.getVegetables()==5){
            if(vegetablesG>=400||vegetablesG<500){
                variables.put("VegetablesIntake","适宜");
            }else if(vegetablesG>500){
                variables.put("VegetablesIntake","偏低");
            }else if(vegetablesG<400){
                variables.put("VegetablesIntake","偏高");
            }
        }else if(dietarySurvey.getVegetables()==6){
            if(vegetablesG>=500||vegetablesG<1000){
                variables.put("VegetablesIntake","适宜");
            }else if(vegetablesG>1000){
                variables.put("VegetablesIntake","偏低");
            }else if(vegetablesG<500){
                variables.put("VegetablesIntake","偏高");
            }
        }else if(dietarySurvey.getVegetables()==7){
            if(vegetablesG<1000){
                variables.put("VegetablesIntake","偏高");
            }
        }

        }
        //计算每天水果类摄入量
        Double fruitsG=dietaryGuide.getFruitsG();//每天水果类推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getFruits()==1||dietarySurvey.getFruits()==2){
            variables.put("FruitsIntake","偏低");
        }else if(dietarySurvey.getFruits()==3){
            if(fruitsG>=100||fruitsG<200){
                variables.put("FruitsIntake","适宜");
            }else if(fruitsG>200){
                variables.put("FruitsIntake","偏低");
            }else if(fruitsG<100){
                variables.put("FruitsIntake","偏高");
            }
        }else if(dietarySurvey.getFruits()==4){
            if(fruitsG>=200||fruitsG<300){
                variables.put("FruitsIntake","适宜");
            }else if(fruitsG>300){
                variables.put("FruitsIntake","偏低");
            }else if(fruitsG<200){
                variables.put("FruitsIntake","偏高");
            }
        }else if(dietarySurvey.getFruits()==5){
            if(fruitsG>=300||fruitsG<400){
                variables.put("FruitsIntake","适宜");
            }else if(fruitsG>400){
                variables.put("FruitsIntake","偏低");
            }else if(fruitsG<300){
                variables.put("FruitsIntake","偏高");
            }
        }else if(dietarySurvey.getFruits()==6){
            if(fruitsG>=400||fruitsG<500){
                variables.put("FruitsIntake","适宜");
            }else if(fruitsG>500){
                variables.put("FruitsIntake","偏低");
            }else if(fruitsG<400){
                variables.put("FruitsIntake","偏高");
            }
        }else if(dietarySurvey.getFruits()==7){
            if(fruitsG<500){
                variables.put("FruitsIntake","偏高");
            }
        }

        }
        //计算每周禽畜肉摄入量
        Double livestockG=(dietaryGuide.getLivestockG())*7;//推荐摄入值
        if(dietarySurvey!=null){


        if(dietarySurvey.getPoultryMeat()==1||dietarySurvey.getPoultryMeat()==2){
            variables.put("livestockGIntake","偏低");
        }else if(dietarySurvey.getPoultryMeat()==3){
            if(livestockG>=150||livestockG<250){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>250){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<150){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==4){
            if(livestockG>=250||livestockG<350){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>350){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<250){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==5){
            if(livestockG>=350||livestockG<450){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>450){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<350){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==6){
            if(livestockG>=450||livestockG<550){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>550){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<450){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==7){
            if(livestockG>=550||livestockG<650){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>650){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<550){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==8){
            if(livestockG>=650||livestockG<750){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>750){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<650){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==9){
            if(livestockG>=750||livestockG<850){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>850){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<750){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==10){
            if(livestockG>=850||livestockG<950){
                variables.put("livestockGIntake","适宜");
            }else if(livestockG>950){
                variables.put("livestockGIntake","偏低");
            }else if(livestockG<850){
                variables.put("livestockGIntake","偏高");
            }
        }else if(dietarySurvey.getPoultryMeat()==11){
            if(livestockG<1000){
                variables.put("livestockGIntake","偏高");
            }
        }
        }
        //计算每周海产品摄入量
        Double aquaticProductG=(dietaryGuide.getAquaticProductG())*7;//推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getMarineProducts()==1||dietarySurvey.getMarineProducts()==2){
            variables.put("aquaticProductGIntake","偏低");
        }else if(dietarySurvey.getMarineProducts()==3){
            if(aquaticProductG>=150||aquaticProductG<250){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>250){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<150){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==4){
            if(aquaticProductG>=250||aquaticProductG<350){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>350){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<250){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==5){
            if(aquaticProductG>=350||aquaticProductG<450){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>450){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<350){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==6){
            if(aquaticProductG>=450||aquaticProductG<550){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>550){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<450){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==7){
            if(aquaticProductG>=550||aquaticProductG<650){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>650){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<550){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==8){
            if(aquaticProductG>=650||aquaticProductG<750){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>750){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<650){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==9){
            if(aquaticProductG>=750||aquaticProductG<850){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>850){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<750){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==10){
            if(aquaticProductG>=850||aquaticProductG<950){
                variables.put("aquaticProductGIntake","适宜");
            }else if(aquaticProductG>950){
                variables.put("aquaticProductGIntake","偏低");
            }else if(aquaticProductG<850){
                variables.put("aquaticProductGIntake","偏高");
            }
        }else if(dietarySurvey.getMarineProducts()==11){
            if(aquaticProductG<1000){
                variables.put("aquaticProductGIntake","偏高");
            }
        }

        }
        //计算每周奶量摄入量
        Double milkG=(dietaryGuide.getMilkG())*7;//推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getMilk()==1||dietarySurvey.getMilk()==2){
            variables.put("milkGIntake","偏低");
        }else if(dietarySurvey.getMilk()==3){
            if(milkG>=1500||milkG<2000){
                variables.put("milkGIntake","适宜");
            }else if(milkG>2000){
                variables.put("milkGIntake","偏低");
            }else if(milkG<1500){
                variables.put("milkGIntake","偏高");
            }
        }else if(dietarySurvey.getMilk()==4){
            if(milkG>=2000||milkG<2500){
                variables.put("milkGIntake","适宜");
            }else if(milkG>2500){
                variables.put("milkGIntake","偏低");
            }else if(milkG<2000){
                variables.put("milkGIntake","偏高");
            }
        }else if(dietarySurvey.getMilk()==5){
            if(milkG>=2500||milkG<3000){
                variables.put("milkGIntake","适宜");
            }else if(milkG>3000){
                variables.put("milkGIntake","偏低");
            }else if(milkG<2500){
                variables.put("milkGIntake","偏高");
            }
        }else if(dietarySurvey.getMilk()==6){
            if(milkG>=3000||milkG<3500){
                variables.put("milkGIntake","适宜");
            }else if(milkG>3500){
                variables.put("milkGIntake","偏低");
            }else if(milkG<3000){
                variables.put("milkGIntake","偏高");
            }
        }else if(dietarySurvey.getMilk()==11){
            if(milkG<3500){
                variables.put("milkGIntake","偏高");
            }
        }

        }
        //计算每周鸡蛋摄入量
        Double eggG=(dietaryGuide.getEggG())*7;//推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getEgg()==1||dietarySurvey.getEgg()==2){
            variables.put("eggGIntake","偏低");
        }else if(dietarySurvey.getEgg()==3){
            if(eggG>=150||eggG<250){
                variables.put("eggGIntake","适宜");
            }else if(eggG>250){
                variables.put("eggGIntake","偏低");
            }else if(eggG<150){
                variables.put("eggGIntake","偏高");
            }
        }else if(dietarySurvey.getEgg()==4){
            if(eggG>=250||eggG<350){
                variables.put("eggGIntake","适宜");
            }else if(eggG>350){
                variables.put("eggGIntake","偏低");
            }else if(eggG<250){
                variables.put("eggGIntake","偏高");
            }
        }else if(dietarySurvey.getEgg()==5){
            if(eggG<350){
                variables.put("eggGIntake","偏高");
            }
        }

        }
        //计算每周坚果摄入量
        Double nutG=(dietaryGuide.getNutG())*7;//推荐摄入值
        if(dietarySurvey!=null){

        if(dietarySurvey.getNut()==1){
            variables.put("nutGIntake","偏低");
        }else if(dietarySurvey.getNut()==2){
            if(nutG>=50||nutG<70){
                variables.put("nutGIntake","适宜");
            }else if(nutG>70){
                variables.put("nutGIntake","偏低");
            }else if(nutG<50){
                variables.put("nutGIntake","偏高");
            }
        }else if(dietarySurvey.getNut()==3){
            if(nutG>=70||nutG<90){
                variables.put("nutGIntake","适宜");
            }else if(nutG>90){
                variables.put("nutGIntake","偏低");
            }else if(nutG<70){
                variables.put("nutGIntake","偏高");
            }
        }else if(dietarySurvey.getNut()==4){
            if(nutG>=90||nutG<110){
                variables.put("nutGIntake","适宜");
            }else if(nutG>110){
                variables.put("nutGIntake","偏低");
            }else if(nutG<90){
                variables.put("nutGIntake","偏高");
            }
        }else if(dietarySurvey.getNut()==5){
            if(nutG>=110||nutG<130){
                variables.put("nutGIntake","适宜");
            }else if(nutG>130){
                variables.put("nutGIntake","偏低");
            }else if(nutG<110){
                variables.put("nutGIntake","偏高");
            }
        }else if(dietarySurvey.getNut()==6){
            if(nutG>=130||nutG<150){
                variables.put("nutGIntake","适宜");
            }else if(nutG>150){
                                                                                                    variables.put("nutGIntake","偏低");
            }else if(nutG<130){
                variables.put("nutGIntake","偏高");
            }
        }else if(dietarySurvey.getNut()==6){
            if(nutG<150){
                variables.put("nutGIntake","偏高");
            }
        }

        }
        variables.put("title","儿童营养监测分析报告");
        listVars.add(variables);

        if(age>=0&&age<1){
            int month=GetAgeByBirth.getMonthFromBirthTime(birth);
            System.out.println("小于一岁通过月计算:"+month);
            if(month>0&month<=6){
                PdfUtils.preview(configurer,"pdfPageOneToSixMonth.ftl",listVars,response);
            }else if(month>6&month<=7){
                System.out.println("7月报告开始调用。。。。");
                PdfUtils.preview(configurer,"pdfPageSeven.ftl",listVars,response);
            } else if(month>7&month<12){
                PdfUtils.preview(configurer,"pdfPageEightMore.ftl",listVars,response);
            }

        }else if(age>=1&&age<3){
            //System.out.println("一到三岁报告开始调用");
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