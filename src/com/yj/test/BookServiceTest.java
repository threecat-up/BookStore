package com.yj.test;

import com.yj.bean.Book;
import com.yj.dao.BookDao;
import com.yj.dao.impl.BookDaoImpl;
import com.yj.service.BookService;
import com.yj.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author yj
 * @create 2020-08-24 14:57
 */
public class BookServiceTest {

    private BookDao bookDao = new BookDaoImpl();
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"舌尖上的美食23","tom",new BigDecimal(50),5000,50,""));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23,"舌尖上的美食","tom",new BigDecimal(50),5000,50,""));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(25));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void page() {
        System.out.println(bookDao.queryForPageTotalCount());
    }
}