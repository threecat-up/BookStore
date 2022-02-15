package com.yj.dao;

import com.yj.bean.Book;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-23 21:08
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

    Integer queryForPageTotalCountByNameOrAuthor(String nameorauthor);

    List<Book> queryForPageItemsByNameOrAuthor(int begin, int pageSize, String nameorauthor);

    List<Book> queryForPageItemsOrder();

    BigDecimal queryTotalMoney();

    public Integer queryBooknums();
}
