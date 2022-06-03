package com.yj.dao.impl;

import com.yj.bean.Book;
import com.yj.dao.BookDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-23 21:38
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`classification`,`price`,`sales`,`stock`,`imgpath`) values(?,?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getClassification(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`classification`=?,`price`=?,`sales`=?,`stock`=?,`imgpath`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getClassification(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from t_book where price between ? and ? limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByNameOrAuthor(String nameorauthor) {
        nameorauthor = "%" + nameorauthor + "%";
        String sql = "select count(*) from t_book where name like ? or author like ?";
        Number count = (Number) queryForSingleValue(sql,nameorauthor,nameorauthor);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByNameOrAuthor(int begin, int pageSize, String nameorauthor) {
        nameorauthor = "%" + nameorauthor + "%";
        String sql = "select * from t_book where name like ? or author like ? limit ?,?";
        return queryForList(Book.class,sql,nameorauthor,nameorauthor,begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItemsOrder() {
        String sql = "SELECT * FROM t_book ORDER BY `sales` DESC LIMIT 1,50";
        return queryForList(Book.class,sql);
    }

    @Override
    public BigDecimal queryTotalMoney() {
        String sql = "SELECT SUM(price*sales) from t_book";
        return (BigDecimal) queryForSingleValue(sql);
    }

    @Override
    public Integer queryBooknums() {
        String sql = "SELECT SUM(sales) FROM t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }


}
