package com.yj.service;

import com.yj.bean.Book;
import com.yj.bean.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-24 14:40
 */
public interface BookService {

    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteBookById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);

    Page<Book> pageByNameOrAuthor(int pageNo, int pageSize, String nameOrAuthor);

    Page<Book> pageOrder();

    public Integer queryTotalBooks();

    BigDecimal queryTotalMoney();
}
