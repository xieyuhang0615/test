package com.dk.controller;

import com.dk.pojo.Books;
import com.dk.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatisplus_books
 * @description: TODO
 * @author: Mr.XYH
 * @create: 2021-01-10 16:22
 **/
@Controller
@RequestMapping("books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("show")
    public String show() {
        return "books/show";
    }

    @RequestMapping("toAddBook")
    public String toAddBook() {
        return "books/add";
    }

    @RequestMapping("getInfo")
    @ResponseBody
    public Map<String,Object> getInfo(Books books, @RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "3")Integer pageSize) {
        List<Books> page = booksService.getInfo(books,pageNum,pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",page);
        map.put("total",books.getTotal());
        return map;
    }

    @RequestMapping("addBookInfo")
    @ResponseBody
    public Integer addBookInfo(Books books) {
        int i = booksService.addBookInfo(books);
        return i;
    }

    @RequestMapping("toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable("id")Integer id, Model model) {
        Books books = booksService.toUpdateBook(id);
        model.addAttribute("books",books);
        return "books/update";
    }

    @RequestMapping("updateBook")
    @ResponseBody
    public Integer updateBook(Books books) {
        int i = booksService.updateBook(books);
        return i;
    }

    @RequestMapping("deleteBatch")
    @ResponseBody
    public Integer deleteBatch(@RequestParam("ids[]")Long[] ids) {
        int i = booksService.deleteBatch(ids);
        return i;
    }
}
