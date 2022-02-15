package com.yj.test;

import com.yj.bean.Book;
import com.yj.dao.BookDao;
import com.yj.dao.impl.BookDaoImpl;
import com.yj.service.BookService;
import com.yj.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yj
 * @create 2020-08-24 14:57
 */
public class BookServiceTest {

    private BookDao bookDao = new BookDaoImpl();
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"舌尖上的中国","yj",new BigDecimal("5"),100,23,"文学",""));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(null,"舌尖上的中国","yj",new BigDecimal("5"),100,23,"文学",""));
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

    @Test
    public void queryTotalMoney() {
        System.out.println(bookDao.queryTotalMoney());
    }
}