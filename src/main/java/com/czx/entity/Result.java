package com.czx.entity;

import lombok.Data;

/**
 * 封装返回的统一对象
 * @param <T>
 */
@Data
public class Result<T> {

    private Integer code;//错误码

    private String msg;//提示信息

    private T data;//返回的具体内容

}
