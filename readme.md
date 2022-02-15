# 网上书店系统
## 项目简述
&emsp;在B站尚硅谷Javaweb视频中学习了网上书店系统，但是所给的项目并没有完全实现，自己实现了整个完整的项目，并且添加了不少的功能（项目语言为Java，框架为**MVC**，服务器Tomcat，数据库MySQL）。
&emsp;快速搭建：clone之后，在IDEA中打开，配置Tomcat服务器（Tomcat7/8/9及最新的均可），找到sql文件夹并在MySQL（MySQL的版本最好是5.x避免出现问题）中导入文件bookstore.sql，此时会创建名为book的数据库数据，找到jdbc.properties文件，将其中的username和password更改为自己的数据库的用户名和密码。之后在MySQL数据库管理系统可以查看关于账户密码问题（管理员账号和密码均为yangjie，其它为普通用户），之后运行即可。

## 项目的设计报告如下（文件夹report中提供了word版的详细设计报告可以参考）
## 【详细设计】

### （一）开发平台及工具

**开发工具：**

后端java、使用IDEA编写

前端HTML、CSS、JavaScript、JSP

服务器：Tomcat

**DBMS**：MySQL（图形化界面MySQLworkbench/SQLyog/navicat）

**建模工具**：Sybase PowerDesigner
![image](https://user-images.githubusercontent.com/60840921/153998463-e400b161-75a0-4b30-9abc-a496251b7144.png)

---

### （二）用户界面设计

**1、首页**

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image048.jpg)

**2、登录页面** 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image050.jpg) |

**3、注册页面** 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image052.jpg) |

**4、用户购物车页面**

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image054.jpg)
**5、 我的订单页面**

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image056.jpg) |


****

**6、图书管理页面**

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image058.jpg)

**7、订单管理页面**

 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image060.jpg) |

**8、榜单**

![image-20220215131834656](C:\Users\jhu\AppData\Roaming\Typora\typora-user-images\image-20220215131834656.png)

**9、总账单页面**

<img src="C:\Users\jhu\AppData\Roaming\Typora\typora-user-images\image-20220215131957485.png" alt="image-20220215131957485" style="zoom:100%;" />



**10、个人信息页面**

![image-20220215132131909](C:\Users\jhu\AppData\Roaming\Typora\typora-user-images\image-20220215132131909.png)

---



### （三）数据库存储设计

 根据前端页面以及之前大实验的分析，我们决定创建book数据库，建库语句如下：

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![文本框: drop database if exists book;  #如果原来的数据库存在，就删除 create database book;         #创建数据库 use book;               # 切换到数据库  ](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image061.gif) |


并决定创建4张表如下： 

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image063.jpg) |

<center>图为navicat for mysql提供</center>

建表语句如下：

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![文本框: 用户表： create table t_user(    `id` int primary key auto_increment,    `username` varchar(50) not null unique,    `password` varchar(32) not null,    `email` varchar(50)  );  ](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image064.gif) |

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![文本框: 图书表： create table t_book(     `id` int primary key auto_increment,     `name` varchar(100),     `price` decimal(11,2),     `author` varchar(100),     `sales` int,     `stock` int,     `img_path` varchar(200) );  ](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image065.gif) |

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![文本框: 订单表： create table t_order(    `order_id` varchar(50) primary key,    ##订单号    `create_time` datetime not null,   ##订单时间    `total_money` decimal(11,2) not null,  ##总金额     `status` int not null default 0,   ##物流状态：0-未发货、1-等待用户签收、2-用户已签收    `user_id` int not null,          ##用户编号    foreign key (`user_id`) references t_user(`id`) );  ](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image066.gif) |

                ![文本框: 订单项： create table t_order_item(    `id` int primary key auto_increment,    `name` varchar(30) not null,      ##商品名    `price` decimal(11,2),       ##商品单价    `total_money` decimal(11,2),      ##商品总金额    `count` int not null,        ##商品数量    `order_id` varchar(50) not null,   ##订单号    foreign key (`order_id`) references t_order(`order_id`) );  ](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image067.gif)

说明：

 &emsp;创建数据库表之后，插入部分图书的信息，然后开始java后端的设计。

---

### （四）java后端设计

 &emsp;首先我们确定总的设计模式为MVC（没有选用当下流行的SSM或SpringBoot设计，选用java web设计中简单的MVC模式），选好总体设计模式之后，在IDEA项目中创建好java ee项目，将项目框架的文件夹创建好：web层、service层、dao层、javabean。

&emsp; java后端开发分为前台模块和后台模块两大部分，其中又可以分为用户模块、图书模块、购物车模块、订单模块和权限管理以及事务管理设计。这里我们就按照后者进行设计，在权限管理部分再将前后台设置清楚。

**用户模块：**

根据数据库表的设计创建我们的javaBean，创建User类，数据与数据库t_user表相对应。之后要设计我们的数据库层面的连接，这里导入数据库连接的jar包，已经测试包：

|      |                                                              |
| ---- | ------------------------------------------------------------ |
|      | ![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image069.jpg) |



 编写基本的数据库连接操作，这里使用JDBCUtils，创建基本的配置文件，在JDBCUtils中编写代码：

```java
static {
   try {
     Properties properties = new Properties();
     //读取jdbc.properties属性配置文件
     InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties" );
     //从流中加载数据
     properties.load(inputStream);
     //创建数据库连接池
     dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

   } catch (Exception e) {
     e.printStackTrace();
   }

 }
```

 &emsp;可以进行打印连接进行测试，看看是否连接到了数据库。之后我们编写baseDao类，在里面增加一些增删改查的方法，以便之后连接继承使用。

 配置好环境之后，我们编写UserDao接口，在其中添加根据用户名查询用户、根据用户名和密码查询用户、保存用户等方法，然后在UserDaoImpl中实现这个接口。主要为编写sql语句并返回，部分语句如下：

```java
public class UserDaoImpl extends BaseDao implements UserDao {
   @Override
   public User querybyUsername(String username) {
     String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
     return queryForOne(User.class,sql,username);
   }
 }
```

&emsp; 编写完Dao层之后，我们观看前端关于用户页面的服务就有登录、注册等服务，所以我们编写service层，service层用来调用Dao，例如登录的时候调用UserDao中的根据用户名和密码查询用户的方法，通过得到的User类对象是否为空来判断用户登录是否成功，而相应我们前端请求的自然就是Web层的servlet代码。所以我们编写完service层之后要去web层编写相应的UserServlet，并记得在web.xml配置，以便在前端页面引用。这个时候我们可以将之前的前端HTML5页面全部替换为JSP动态页面，其实很简单，就是在前面加上

``<%@ page contentType="text/html;charset=UTF-8" language="java" %>``一行代码即可，方便后续我们进行动态引入从servlet来的数据，动态的显示。

 &emsp;关于用户登录的模块也就是：

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image071.jpg)

其中在Dao层要进行一次test，在service层也要进行测试，如果出现错误，那么分层开发的优势就可以显示出来，我们可以很快的找出是哪一层出现了错误。在servlet层中我们用到了HTTP的相关知识，使用了doPost或者doGet方法，因此我们将servlet层中复用的代码放到baseServlet中，并利用反射技术去调用我们响应的方法（即通过类找到方法）。

 &emsp;那么用户注册的模块也和登录一致，其中DAO、service层是一至的，我们只需要在servlet层中添加注册的方法即可。



**图书模块**

 &emsp;根据数据库设计javabean，并在book中添加get()、set()方法、toSting()方法以及有参无参构造函数。

 然后设计我们的bookDao层，因为我们书籍一般都有增删改查的操作，所以在bookDao中我们有通过id查询图书、删除图书、改变图书的操作，之后测试sql语句是否正确，例如查询操作：

```java
public Book queryBookById(Integer id) {
   String sql = "select * from t_book where id = ?";
   return queryForOne(Book.class,sql,id);
 }
```

就是一个简单的sql语句，然后利用我们的数据库编程类库，之间得到我们查询之后的图书对象。之后的service层也是通过dao层来实现方法，而我们的servlet层也是如此，这个时候我们要去管理员的图书管理页面去设置我们数据显示。这里就用到了JSP技术，也就是为什么之前要将HTML换位JSP页面的原因，可以动态的显示书籍信息，例如：

<div id="main">    <table style="height: 350px">       <tr>          <td>名称</td>          <td>价格</td>          <td>作者</td>          <td>销量</td>          <td>库存</td>          <td colspan="2">操作</td>       </tr>       <c:forEach items="${requestScope.page.items}" var="book">          <tr>             <td>${book.name}</td>             <td>${book.price}</td>             <td>${book.author}</td>             <td>${book.sales}</td>             <td>${book.stock}</td>             <td><a href="manager/bookServlet?&action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>             <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>          </tr>       </c:forEach>

 而整个的逻辑也是很好理解的：

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image073.jpg)

 以上我们就可以试下图书的增加、删除和修改操作，在删除操作中我们需要在web页面上添加提示，避免用户不小心删除了数据。

**购物车模块**

 &emsp;购物车模块可以用session来设计，也可以用mysql来设计，或者用redis缓存技术。这里我们小组商量之后决定使用session技术，它的生命周期也就是浏览器的生命周期，即关闭浏览器购物车生命结束，不会保存用户购物车的信息。

 &emsp;选用了session之后，我们直接创建相应的servlet，在里面实现增加、删除的方法。从前端获得数据之后直接保存到session域中，所以我们的增删操作也就是session信息的操作，但是在结账操的时候，就使用数据库操作，将购物车里面的item和order保存在数据库中。这一块和订单模块相连接。

**订单模块**

 &emsp;为了保存用户购买书籍的信息和订单信息，我们依旧和之前一样，这里我们可以从servlet开始，反向操作。我们在servlet中的操作逆行逻辑如下：

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image075.jpg)

**事务处理**

 &emsp;从上面我们小组分析得到创建订单的同时（也就是用户付款完毕之后），我们需要同时对图书的销售量和存储量进行操作，这一步必须一起执行，或者一起失败，所以这里我们要用事务处理机制。这里我们没有选择在数据库中使用触发器或者设置事务操作。我们选择用ThreadLocal，也就是线程。这里我们首先设想的是利用一个线程关联一个数据的特性，手动的设置事务，成功则提交事务，失败则回滚事务，并在相应操作，也就会上面所说的创建订单+库存销售的修改上加上try-catch操作来实现事务。后面发现是可行的，但是如果后面有更多需要事务的地方就不好处理，所以我们利用Filter来进行过滤，在doFiltr()方法中进行ThreadLocal操作来实现整个的事务处理。

**权限控制**

 &emsp;编写好基础页面之后，小组进行讨论，需要实现前后台的功能，也就是说用户的权限是不能涉及后台管理的，所以我们使用了Filter来控制。我们利用session域来获得登录的对象（如果没有登录那么跳转登录页面），对登录对象进行管理员用户的检测，以此实现权限管理（并在web.xml中进行配置）。

逻辑也就是

![img](file:///C:/Users/jhu/AppData/Local/Temp/msohtmlclip1/01/clip_image077.jpg)

 *那么我们的网上书店就完成了！*

---



## 联系我

&emsp;如果有什么问题欢迎联系我~

&emsp;邮箱：yang2251335663@qq.com

&emsp;CSDN：[threecat.up](https://blog.csdn.net/qq_43919400?spm=1000.2115.3001.5343)

##  