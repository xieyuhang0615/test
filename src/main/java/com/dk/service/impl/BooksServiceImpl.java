package com.dk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dk.mapper.BooksMapper;
import com.dk.pojo.Books;
import com.dk.service.BooksService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatisplus_books
 * @description: TODO
 * @author: Mr.XYH
 * @create: 2021-01-10 17:26
 **/
@Service
@Component
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksMapper booksMapper;



    @Override
    public List<Books> getInfo(Books books, Integer pageNum, Integer pageSize) {
        QueryWrapper<Books> queryWrapper = new QueryWrapper<Books>();
        if (books.getBookName() != null && !"".equals(books.getBookName())) {
            queryWrapper.like("book_name",books.getBookName());
        }
        //创建泛型为 TUser 的 Page<TUser> 有参构造
        // 第一个参数为当前页(pageNum),第二个参数为每页记录数(pageSize)
        Page<Books> booksPage = new Page<>(pageNum,pageSize);
        IPage<Books> booksIPage = booksMapper.selectPage(booksPage, queryWrapper);
        books.setTotal(booksIPage.getPages());
        //获取每页查询记录
        List<Books> records = booksIPage.getRecords();
        System.out.println("每页记录-------->");
        records.forEach(System.out::println);
        System.out.println("总页数---->" + booksIPage.getPages());
        System.out.println("总记录数---->" + booksIPage.getTotal());
        return records;
    }

    @Override
    public int addBookInfo(Books books) {
        return booksMapper.insert(books);
    }

    @Override
    public Books toUpdateBook(Integer id) {
        return booksMapper.selectById(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateById(books);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return booksMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
