package com.liang.spring.boot.child.controller;


import com.alibaba.fastjson.JSON;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SportsSurvey;
import com.liang.spring.boot.child.untils.ResultUtil;

import com.mysql.cj.x.json.JsonArray;
import org.apache.commons.io.IOUtils;

import org.json.JSONException;

import org.json.JSONObject;
import org.json.XML;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 16:10 2019/6/11
 */
@RestController
@RequestMapping("/xml2Json")
public class Xml2JsonController{

    public static JSONObject XmlToJson2(String  filepath) throws IOException {
        FileInputStream in = new FileInputStream(new File(filepath)) ;
        String xml = IOUtils.toString(in,"utf-8");
//        System.out.println(xml);
        JSONObject object =  XML.toJSONObject(xml);
        return  object;
    }


    @GetMapping
    public ResultMsg xml2Json(SportsSurvey sportsSurvey)throws JSONException, IOException {

        String path="C:\\oncom.xml";

        JSONObject xmlObject=XmlToJson2(path);

        JSON xmlJson=JSON.parseObject(xmlObject.toString());

//        System.out.println("返回结果："+xmlJson);
        return ResultUtil.success(xmlJson);
    }
}
