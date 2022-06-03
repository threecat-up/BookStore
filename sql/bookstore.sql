DROP DATABASE IF EXISTS book;	## 如果原来的数据库存在，就删除

CREATE DATABASE book DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;			## 创建数据库

USE book;					## 切换到数据库


##创建表t_user
CREATE TABLE t_user(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL UNIQUE,
	`password` VARCHAR(32) NOT NULL,
	`email` VARCHAR(50),
	`address` VARCHAR(200)
);

##插入初始数据
INSERT INTO t_user(username,`password`,email,address) VALUES('admin','admin','admin@admin.com','湖北武汉');

## 查询表
SELECT * FROM t_user;

CREATE TABLE t_book(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100),
    `price` DECIMAL(11,2),
    `author` VARCHAR(100),
    `classification` VARCHAR(20),
    `sales` INT,
    `stock` INT,
    `imgpath` VARCHAR(200)
);

INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('解忧杂货店','东野圭吾','文学',27.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('边城','沈从文','文学',23.00,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('中国哲学史','冯友兰','文学',44.5,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('苏东坡传','林语堂','文学',19.30,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('百年孤独','马尔克斯','文学',29.50,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('扶桑','严歌苓','文学',19.8,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('给孩子的诗','北岛','文学',22.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('为奴十二年','所罗门','文学',16.5,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('平凡的世界','路遥','文学',55.00,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('悟空传','今何在','文学',14.00,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('硬派健身','斌卡','文学',31.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('从晚清到民国','唐德刚','文学',39.90,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('三体','刘慈欣','文学',56.5,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('看见','柴静','文学',19.50,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('活着','余华','文学',11.00,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('小王子','安托万','文学',19.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('我们仨','杨绛','文学',11.30,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification,price, sales , stock , imgpath) VALUES('生命不息,折腾不止','罗永浩','文学',25.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification,price, sales , stock , imgpath) VALUES('皮囊','蔡崇达','文学',23.90,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('恰到好处的幸福','毕淑敏','文学',16.40,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('大数据预测','埃里克','文学',37.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('人月神话','布鲁克斯','文学',55.90,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('C语言入门经典','霍尔顿','文学',45.00,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('数学之美','吴军','文学',29.90,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('Java编程思想','埃史尔','文学',70.50,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('设计模式之禅','秦小波','文学',20.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('图解机器学习','杉山将','文学',33.80,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('艾伦图灵传','安德鲁','文学',47.20,100,100,'static/img/default.jpg');
INSERT INTO t_book (name, author, classification, price, sales , stock , imgpath) VALUES('教父','马里奥普佐','文学',29.00,100,100,'static/img/default.jpg');

CREATE TABLE t_order(
	`order_id` VARCHAR(50) PRIMARY KEY,
	`create_time` DATETIME,
	`price` DECIMAL(11,2),
	`status` INT,
	`user_id` INT,
	FOREIGN KEY(`user_id`) REFERENCES t_user(`id`)
);

CREATE TABLE t_order_item(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`count` INT,
	`price` DECIMAL(11,2),
	`total_price` DECIMAL(11,2),
	`order_id` VARCHAR(50),
	FOREIGN KEY(`order_id`) REFERENCES t_order(`order_id`)
);
