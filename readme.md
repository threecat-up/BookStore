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
**注意Tomcat的配置**
![image](https://user-images.githubusercontent.com/60840921/153998463-e400b161-75a0-4b30-9abc-a496251b7144.png)
![SIUSS(SFDAF6$D(V N7ZY1S](https://user-images.githubusercontent.com/60840921/154036794-41637771-afc1-42fa-90d2-e4962123590d.png)

---

### （二）用户界面设计

**1、首页**

![image](https://user-images.githubusercontent.com/60840921/154052790-c51f95ec-0629-4dea-ba42-1e4a147aa24d.png)

**2、登录页面** 
![image](https://user-images.githubusercontent.com/60840921/154052849-c4205af2-436d-4f86-a242-b64acf3e5997.png)


**3、注册页面** 
![image](https://user-images.githubusercontent.com/60840921/154052894-eb085e08-94a3-42b9-b707-8aa64c622ba7.png)


**4、用户购物车页面**
![image](https://user-images.githubusercontent.com/60840921/154052926-447254de-4a1d-4052-8ad4-cc35e2b59a8f.png)

**5、 我的订单页面**
![image](https://user-images.githubusercontent.com/60840921/154052947-eb82ca76-4fb0-4d26-97b8-fcf75b0d8a1e.png)


**6、图书管理页面**
![image](https://user-images.githubusercontent.com/60840921/154052991-29ceb319-1dd5-4f8d-ad53-dbc4c824449a.png)


**7、订单管理页面**
![image](https://user-images.githubusercontent.com/60840921/154053011-4a6d6e69-8a9a-4393-a837-6f07b5885e8c.png)


**8、榜单**

![image](https://user-images.githubusercontent.com/60840921/154053203-4912d0e0-3cb6-4547-8e34-5eaed27cd254.png)

**9、总账单页面**

![image](https://user-images.githubusercontent.com/60840921/154053247-e4ce4084-6cf6-4b2d-a589-15dd76e89eee.png)



**10、个人信息页面**

![image](https://user-images.githubusercontent.com/60840921/154053278-0406861d-c2de-4b6c-8fc9-283b74bdac0d.png)

---



### （三）数据库存储设计

 根据前端页面以及之前大实验的分析，我们决定创建book数据库，建库语句如下：
![image](https://user-images.githubusercontent.com/60840921/154053614-e54b2fa4-ed49-4c22-9370-f55cfeb8ba42.png)

并决定创建4张表如下： 

![image](https://user-images.githubusercontent.com/60840921/154053653-afb6e182-18a9-472a-8895-73a6a0477e73.png)

<center>图为navicat for mysql提供</center>

建表语句如下：
![image](https://user-images.githubusercontent.com/60840921/154053765-6a87677c-352f-46a0-b85b-c1c05a315c83.png)
![image](https://user-images.githubusercontent.com/60840921/154053780-b7368f19-db58-48ee-8dbc-b8f4ca42f51c.png)
![image](https://user-images.githubusercontent.com/60840921/154053802-f122893d-4e5b-4a22-981f-39e194769de9.png)
![image](https://user-images.githubusercontent.com/60840921/154053828-10a32479-8e30-4fb4-a93e-8d5c5e7eefd1.png)

说明：

 &emsp;创建数据库表之后，插入部分图书的信息，然后开始java后端的设计。

---

### （四）java后端设计

 &emsp;首先我们确定总的设计模式为MVC（没有选用当下流行的SSM或SpringBoot设计，选用java web设计中简单的MVC模式），选好总体设计模式之后，在IDEA项目中创建好java ee项目，将项目框架的文件夹创建好：web层、service层、dao层、javabean。

&emsp; java后端开发分为前台模块和后台模块两大部分，其中又可以分为用户模块、图书模块、购物车模块、订单模块和权限管理以及事务管理设计。这里我们就按照后者进行设计，在权限管理部分再将前后台设置清楚。

**用户模块：**

根据数据库表的设计创建我们的javaBean，创建User类，数据与数据库t_user表相对应。之后要设计我们的数据库层面的连接，这里导入数据库连接的jar包，已经测试包：
![image](https://user-images.githubusercontent.com/60840921/154053876-39812b46-ae35-472d-86d7-909ec0508d4e.png)

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

![image](https://user-images.githubusercontent.com/60840921/154053914-ca103a3e-dc6d-4fd0-a74d-4349b8688c4a.png)

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
```html
<c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId=${book.id} class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
</c:forEach>
```
 而整个的逻辑也是很好理解的：

![image](https://user-images.githubusercontent.com/60840921/154054726-f1f507b6-d935-47f8-b236-0afd53a8793c.png)

 以上我们就可以试下图书的增加、删除和修改操作，在删除操作中我们需要在web页面上添加提示，避免用户不小心删除了数据。

**购物车模块**

 &emsp;购物车模块可以用session来设计，也可以用mysql来设计，或者用redis缓存技术。这里我们小组商量之后决定使用session技术，它的生命周期也就是浏览器的生命周期，即关闭浏览器购物车生命结束，不会保存用户购物车的信息。

 &emsp;选用了session之后，我们直接创建相应的servlet，在里面实现增加、删除的方法。从前端获得数据之后直接保存到session域中，所以我们的增删操作也就是session信息的操作，但是在结账操的时候，就使用数据库操作，将购物车里面的item和order保存在数据库中。这一块和订单模块相连接。

**订单模块**

 &emsp;为了保存用户购买书籍的信息和订单信息，我们依旧和之前一样，这里我们可以从servlet开始，反向操作。我们在servlet中的操作逆行逻辑如下：

![image](https://user-images.githubusercontent.com/60840921/154054749-e17702aa-6ef3-4cf1-aba1-8b6d744bce10.png)

**事务处理**

 &emsp;从上面我们小组分析得到创建订单的同时（也就是用户付款完毕之后），我们需要同时对图书的销售量和存储量进行操作，这一步必须一起执行，或者一起失败，所以这里我们要用事务处理机制。这里我们没有选择在数据库中使用触发器或者设置事务操作。我们选择用ThreadLocal，也就是线程。这里我们首先设想的是利用一个线程关联一个数据的特性，手动的设置事务，成功则提交事务，失败则回滚事务，并在相应操作，也就会上面所说的创建订单+库存销售的修改上加上try-catch操作来实现事务。后面发现是可行的，但是如果后面有更多需要事务的地方就不好处理，所以我们利用Filter来进行过滤，在doFiltr()方法中进行ThreadLocal操作来实现整个的事务处理。

**权限控制**

 &emsp;编写好基础页面之后，小组进行讨论，需要实现前后台的功能，也就是说用户的权限是不能涉及后台管理的，所以我们使用了Filter来控制。我们利用session域来获得登录的对象（如果没有登录那么跳转登录页面），对登录对象进行管理员用户的检测，以此实现权限管理（并在web.xml中进行配置）。

逻辑也就是

![image](https://user-images.githubusercontent.com/60840921/154054762-8f47322a-2353-478f-ac8b-7b71f394e5b4.png)

 *那么我们的网上书店就完成了！*

---



## 联系我

&emsp;如果有什么问题欢迎联系我~

&emsp;邮箱：yang2251335663@qq.com

&emsp;CSDN：[threecat.up](https://blog.csdn.net/qq_43919400?spm=1000.2115.3001.5343)
