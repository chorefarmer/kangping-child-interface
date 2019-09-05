package com.liang.spring.boot.child.service;

import com.alibaba.fastjson.JSON;
import com.liang.spring.boot.child.domain.ResultMsg;
import com.liang.spring.boot.child.domain.SportsSurvey;
import com.liang.spring.boot.child.untils.ResultUtil;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 12:34 2019/9/4
 */
@Service
public class Xml2JsonService {

    public static JSONObject XmlToJson2(String  filepath) throws IOException {
        FileInputStream in = new FileInputStream(new File(filepath)) ;
        String xml = IOUtils.toString(in,"utf-8");
        JSONObject object =  XML.toJSONObject(xml);
        return  object;
    }


    public ResultMsg xml2Json(SportsSurvey sportsSurvey)throws JSONException, IOException {

        String path="C:\\oncom.xml";

        JSONObject xmlObject=XmlToJson2(path);

        JSON xmlJson=JSON.parseObject(xmlObject.toString());

        return ResultUtil.success(xmlJson);
    }
}
