package com.dk.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: mybatisplus_books
 * @description: books实体类
 * @author: Mr.XYH
 * @create: 2021-01-10 16:09
 **/
@Data
public class Books implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String bookName;
    private String bookAuthor;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date launchTime;
    @TableField(exist = false)
    private Long total;
}
