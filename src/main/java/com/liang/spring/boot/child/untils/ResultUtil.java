package com.liang.spring.boot.child.untils;

import com.liang.spring.boot.child.domain.ResultMsg;

public class ResultUtil {
    /**
     * 请求成功返回
     * @param object
     * @return
     */
    public static ResultMsg success(Object object){
        ResultMsg resultMsg =new ResultMsg();
        resultMsg.setCode(200);
        resultMsg.setMsg("请求成功");
        resultMsg.setData(object);
        return resultMsg;
    }
    public static ResultMsg success(){
        return success(null);
    }

    public static ResultMsg error(Integer code, String resultmsg){
        ResultMsg resultMsg =new ResultMsg();
        resultMsg.setCode(code);
        resultMsg.setMsg(resultmsg);
        return resultMsg;
    }


}