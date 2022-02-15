package com.yj.test;

import com.yj.bean.Book;
import com.yj.dao.BookDao;
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
        //`name`,`author`,`classification`,`price`,`sales`,`stock`,`img_path`
        //Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String classification, String imgPath)
        bookDao.addBook(new Book(null,"舌的中国","yjjj",new BigDecimal("5"),100,23,"",""));
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
        bookDao.updateBook(new Book(35,"舌尖的中国","yj",new BigDecimal("5"),100,23,"文学",""));
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

    @Test
    public void queryBooknums() {
        System.out.println(bookDao.queryBooknums());
    }
}
