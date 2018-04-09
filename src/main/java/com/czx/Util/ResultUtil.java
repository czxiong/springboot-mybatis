package com.czx.Util;

import com.czx.entity.Result;

/**
 * 封装返回信息的工具类
 */
public class ResultUtil {

    /**
     * 成功 data有值得情况
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功 data没有值的情况
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static Result fail(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
