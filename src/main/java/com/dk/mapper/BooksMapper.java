package com.dk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dk.pojo.Books;

/**
 * @program: mybatisplus_books
 * @description: 在对应的mapper上继承基本的类BaseMapper 泛型为操作的实体类
 * @author: Mr.XYH
 * @create: 2021-01-10 16:12
 **/
public interface BooksMapper extends BaseMapper<Books> {
    //所有的CRUD已经编写完成
    //不需要像以前一样配置一些xml文件
}
