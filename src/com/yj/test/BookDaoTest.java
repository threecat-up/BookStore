package com.yj.test;

import com.yj.bean.Book;
import com.yj.dao.BookDao;
import com.yj.dao.impl.BaseDao;
import com.yj.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yj
 * @create 2020-08-24 11:01
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "这个是什么？", "yj", new BigDecimal("3"), 45, 56, null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBookById(3);
    }

    @Test
    public void queryById() {
        System.out.println(bookDao.queryBookById(64));
    }

    @Test
    public void update() {
        bookDao.updateBook(new Book(5, "yk", "yjjj", new BigDecimal("8888"), 65, 798, ""));
    }

    @Test
    public void queryList() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(1,4));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDao.queryForPageItemsByPrice(1,4,10,50));
    }
}
