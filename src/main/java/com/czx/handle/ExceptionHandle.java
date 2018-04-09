package com.czx.handle;

import com.czx.Util.CustomExceptionUtil;
import com.czx.Util.ResultUtil;
import com.czx.entity.Result;
import com.czx.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获工具类
 */
@ControllerAdvice //定义该类是异常处理类
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class) //指定捕获的具体是哪个异常类
    @ResponseBody //以json格式数据返回
    public Result handle(Exception e){
        if(e instanceof CustomExceptionUtil){
            //判断是否是自定义的异常
            CustomExceptionUtil customExceptionUtil = (CustomExceptionUtil) e;
            return ResultUtil.fail(customExceptionUtil.getCode(),customExceptionUtil.getMessage());
        }else{
            return ResultUtil.fail(ResultEnum.UNKOUW_ERROR.getCode(),ResultEnum.UNKOUW_ERROR.getMsg());
        }
    }

}
