package com.yj.bean;

import java.math.BigDecimal;

/**
 * @author yj
 * @create 2020-10-02 19:51
 */
public class Book {
    private Integer id;//id
    private String name;//姓名
    private String author;//作者
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String classification;
    private String imgPath="static/img/default.jpg";

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        if(stock<0) stock=0;return stock;
    }

    public void setStock(Integer stock) {
        if(stock<0) stock=0;
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        if(imgPath==null||"".equals(imgPath)) {
            this.imgPath = "static/img/default.jpg";
        } else {
            this.imgPath = imgPath;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", classification='" + classification + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock, String classification, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.classification = classification;
        this.imgPath = imgPath;
    }
}
