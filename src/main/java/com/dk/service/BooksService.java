package com.dk.service;

import com.dk.pojo.Books;

import java.util.List;

public interface BooksService {
    List<Books> getInfo(Books books,Integer pageNum,Integer pageSize);

    int addBookInfo(Books books);

    Books toUpdateBook(Integer id);

    int updateBook(Books books);

    int deleteBatch(Long[] ids);
}
