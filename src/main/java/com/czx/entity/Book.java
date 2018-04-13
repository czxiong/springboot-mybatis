package com.czx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class Book {

    private Integer id;

    @NotBlank(message = "名称不能为空")
    private String name;

    @NotBlank(message = "价格不能为空")
    private String price;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date publishTime;

}
