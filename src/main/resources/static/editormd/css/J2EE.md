[toc]

## 第一章

### 1.1传统应用程序模型

由三种逻辑成分组成：

a.表示逻辑 格式化页面的内容 使得人机交互更好

b.业务处理逻辑 

c.数据管理逻辑 存储/查询历史数据 输入输出的数据 数据的管理部分



C/S模型 客户端服务器

三种结构

B/S模型 浏览器服务器

表示逻辑、业务处理逻辑和数据处理逻辑集中



### 1.2 分布式多层应用程序模型

客户层                     客户机



web层   前端                   J2EE服务器

商业逻辑层   后台



企业信息系统层       EIS服务器



### 1.3.1 J2EE组件

由相关的类和文件一起组成

不同的组件构成了一个整体J2EE程序

#### EJB组件（business组件）

业务逻辑层的构造块

会话 实体 消息驱动

#### Web组件

前端 既可以是servlet（一个JAVA类）也可以是JSP（一个基于文本的文档）

#### 客户层组件

##### Web客户端(瘦客户端)

由**动态Web页面**和Web浏览器组成

动态Web页面的本质特征：包含了能在服务器端执行的代码 具有交互性 自动更新和因时因人而变的特性

##### Applets

在安装在Web浏览器中的JAVA虚拟机中运行

##### Application客户端

可以直接和商业层的EJB联系 因为具有表示逻辑（C/S）

#### EIS层

### 1.3.2 J2EE容器

容器充当组件与支持组件的底层特定于平台的功能之间的接口

J2EE服务器以容器的形式为每一个组件类型提供底层服务 如事务处理、状态管理、多线程、资源池等

组件和部署描述符像结合的过程称为装配

#### 可配置的服务

因人而异 根据组件被部署在什么地方在实际运行时会不同

#### 不能配置的服务

#### Web容器

#### EJB容器

### 1.4 J2EE核心技术

需要掌握的有：

Java Servlet技术

Java Server Pages 技术

JDBC技术

### 1.5 开发、封装和部署J2EE应用程序

#### 开发环境搭建

操作系统平台 Windows 10

应用服务器的选择 tomcat

数据库服务器的选择 MySQL

开发工具的选择 My Eclipse

### 1.6 Web应用程序

是servlets,HTML页面类和其他资源等的集合

Web应用程序的实例必须运行在一个JVM中

以两种方式存在于文件系统：Web归档文件.war Web归档文件展开后的目录结构

部署描述符-web.xml

### 1.7 HTTP协议

用于在Internet上发送和接收信息

请求-应答式协议：无连接、无状态、媒体独立

#### MIME-type

多用途的互联网邮件扩展类型

#### HTTP请求包

方法-URL-协议/版本 eg ：GET/index.jsp HTTP/1.1

请求头：包括若干行 key : value

请求正文



方法

HTTP 1.1 支持八种请求方法 最广泛的是GET和POST 一共有GET、POST、HEAD、OPTIONS、PUT、DELETE、TRACE、CONNECT等八种 其中GET为请求一个页面 POST要求服务器接受大量的信息



URI（相对路径和绝对路径均可）标记的是一个资源

统一资源标识符 标识某一资源名称的字符串

访问资源的命名机制/存放资源的主机名/资源自身的名称

URL（绝对路径）标记的是一个互联网资源

统一资源定义符 是一种URI 

协议/存有该资源的主机IP地址/主机资源的具体地址



#### HTTP应答包

协议-状态代码-描述/应答头/应答正文

状态代码

1XX 服务器收到请求

2XX 成功处理请求

3XX 服务器需要重定向请求 发送向下一个资源

4XX 请求中包含某种错误

400 语法错误

401 客户试图未经授权访问受密码保护的页面

403 资源不可用

404 无法找到指定位置的资源/是否正确部署？

5XX 服务器端发生错误

500 遇到了意想不到的情况

501 服务器不支持请求所需要的功能



## 第二章 servlet

### 2.1 servlet工作原理

通过创建一个框架来扩展服务器的能力，以提供在Web服务器上进行请求和响应服务

是基于Java技术的Web组件 用来扩展以请求/响应为模型的服务器的能力

由servlet容器管理，也叫servlet引擎 servlet容器是web服务器或应用服务器的一部分/

### 2.2 servlet编程接口

有三种方式开发应用程序

自定义类implement **servlet**接口

定义在javax.servlet(包名).Servlet(接口） 

和http协议有关的在javax.servlet.http.HttpServlet

```c++
       <<接口>> servlet
    +init()//扩展一下
    public void init(ServletConfig config)throws ServletException
    对servlet实例化之后，调用此方法，负责初始化（并不是实例化）
    抛出异常后对此servlet实例的调用会导致容器对它重新载入并再次运行此方法
    只能被调用一次
    
    +destroy()
    public void destroy()
    申请销毁 啥时候执行容器决定
    
    +getServletConfig()
    public ServletConfig getServletConfig()
    此方法可以让servlet在任何时候获得该对象及配置信息
    
    +getServletInfo()
    返回一个String 是servlet的信息
    
    +service()//扩展一下
    public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
    初始化此方法后才能被调用处理用户的请求 前一个参数提供访问初始请求数据的方法和字段 后一个提供servlet构造响应的方法
```

自定义类然后extends **GenericServlet**类 这是一个基类 扩展了servlet接口

```
    GenericServlet
    +init()
    +destroy()
    +log()//日志
    +getServletConfig()
    +getServletContext()//返回一个对象
    +getServletInfo()
    +getServletName()
    //缺两个没写
    +service()
```

自定义类然后extends **Http Servlet**（继承GenericServlet类）

天然支持HTTP协议的处理和应答

```c++
     HttpServlet//想要采用任何一种功能 必须在每个do方法中放入逻辑代码块
     +doGet()
     +doPost()
     +doHead()
     +doDelete()
     +doOptions()
     +doPut()
     +doTrace()
     +getLastModified()
     
     +service()//委托具体的do方法 重载了GS的service方法
     protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     作为HTTP请求的分发器
     
```

#### 编程接口 - javax.servlet、javax.servlet.http

看ppt 来不及记了 查阅这两个包

### 2.3 Servlet部署描述符

<servlet></servlet>元素

必须含有servlet-name元素 唯一不能重复 和一个程序里的函数名一样

提供servlet-class 给出全称类名 也可以提供JSP-FIRE

init-param为可选元素 是设定部署描述符参数的 通过ServletConfig来获取访问

<servlet-mapping></servlet-mapping>元素

为一个servlet实例提供一个URL pattern

包含两个元素 <servlet-name>和<url-pattern>（大小写敏感）元素 名称和对应的servlet相同

其中<url-pattern>有四种方式

1. 一个以'/'开始以'/*'结束的字符串来映射路径
2. 一个以'*.E'为前缀的字符串来映射扩展名，E为任意扩展名
3. 一个只包含'/'的字符串 用于缺省匹配（缺省的资源是一个servlet）
4. 所有其他的字符只用来精确匹配

#### URL路径解析和匹配规则

路径解析看PPT 来不及记了

按优先级分为

精确匹配规则

最长路径匹配规则

扩展名匹配规则

缺省匹配规则

### 2.4 Servlet的生命周期

实例化         - 创建Servlet的实例

初始化         -调用init()方法

服务             -调用service()方法

销毁             -销毁实例之前调用destroy()方法

不可用         -销毁实例并标记为垃圾收集

对于编程人员 能实现的操作为以上提到的三个方法

**实例化**

容器负责**加载和实例化**一个servlet 可以发生在**引擎启动**的时候 也可以发生在**客户请求service()**的时候

Java类加载工具 ClassLoader 加载可以从本地文件系统，也可以是从远程文件系统甚至其他的网络服务

容器加载servlet类以后，它会实例化一个或多个实例

 **初始化**

读取永久的配置信息 昂贵资源及其他仅需要执行一次的任务

抛出**Unavailable异常**或**Servlet异常**后 destroy方法不会被调用因为初始化没有成功完成 destroy只为初始化后的实例服务

**服务**

请求由Servlet Request代表 回应为SResponse

开发者必须确保编写的servlet可以处理并发问题 synchronized关键字定义service之后 容器将排队处理请求 这是底层的java运行时要求的

抛出以上两种异常时 SE表示处理请求的过程中发生了错误 容器应该使用合适的方法清楚请求

UE表示servlet不能对请求进行处理 可能是**暂时**的 也可以能是永久的

**销毁**

调用destroy后 容器必须释放servlet实例以便它能够被垃圾回收

### 2.5 Servlet Context

一个接口 用于访问容器内部的初始化参数和环境属性和资源

#### ServletContext接口

两分钟的时候有教你怎么看包

在javax.servlet包内 该接口定义了一系列方法用于与相应的servlet容器通信

一个JVM中的每一个web-app只能有一个SC

#### 初始化参数

调用ServletContext.getInitParameterNames()返回一个枚举对象

调用ServletContext.getInitParameter(string) 返回一个特定对象的初始参数

参数分为应用程序参数和servlet自带的参数 要有所区分 一个在Context Parameters 一个在servlet自带的里 在代码中 一个用ServletContext取出 一个用ServletConfig取出

#### 环境属性

把对象通过名称绑定到环境中 将object对象绑定到name 放在servlet环境中 可供其他的servlet共享

`context.setAttribute(String name,Object obj)`

如果名字重复 后放置的会覆盖前面的

servlet用`getAttribute(String name)`调用

#### 访问资源

getResourcePaths(形式)和getRsource(path)

前者返回一个所有路径的集合 空返回null 只能获得静态资源

### 2.6 会话

#### 会话

概念：与服务器多次交互最后退出的全过程

会话HTTP是一种**无状态**的协议 容器必须支持**HTTP**协议

#### 会话追踪机制

是一种服务器端的机制

服务器使用一种类似**散列表**的结构来保存信息

**客户端发送会话标识**

会话识别过程

会话状态保存和获取

**会话标识发送给客户端**



常用的会话追踪机制：

**cookies**

最常用的会话跟踪机制 所有的servlet引擎都必须支持这种方法 

SSL Sessions 

是HTTP协议采用的一种加密技术 内建了会话跟踪功能

**URL重写**

最低性能的通用会话跟踪方法 当用户不能接受cookie时 URL重写就会作为基本的会话跟踪方法

把session id写入URL中 引擎解析为和某个session相关联

#### 会话管理的范型

概念：会话过程中状态和信息的管理 大部分发生在web服务器内

创建会话

通过**HttpSession接口** 实现会话跟踪

调用httpServletRequest的getSession()方法返回当前会话 若null 创建对话

`HttpSession session = requset.getSession(true)`

若写false 没有时返回空



存储和访问会话属性

HttpSession提供了存储和访问标准会话属性的方法 

在会话中保存数据的方法`setAttribute(String s,Object o)`



关闭会话

显示关闭 `HttpSession.invalidate()`

隐式关闭 会话超时 设置**负值**可以确保会话永远不会超时 缺省1800秒 也可以自己设置

## 第三章 JSP

### 3.1 JSP简介和生命周期

在servlet中 静态代码和动态代码是混合在一起的 从便捷性来看 JSP是优于servlet的 

在HTML页面中通过JSP元素嵌入可在服务器端执行的JAVA代码

JSP： Java Server Page

JSP的优点：将内容和表示分离（分离静态内容和动态内容）；实现组件的重复利用；基于**标签库**(taglib)的同意表达 

-操作教程19：00

### 3.2 JSP页面的生命周期

-操作教程8:00

jsp文件在用户第一次请求时，会被编译成Servlet，然后由这个Servlet处理用户的请求 jsp在项目中以源文件存在 当jsp执行时其生命周期和servlet完全一致 所以重点在于翻译和编译阶段。

**翻译和编译（转换阶段）**

对jsp页面进行请求时 由容器判断jsp页面的语法是否正确 若正确转换为servlet源文件 再由Javac编译  jsp的包是servlet的子包 包内的_jspService方法相当于servlet的service方法

**执行阶段**

和servlet相同

### 3.3 JSP元素的构成元素

JSP页面由元素、模板数据和注释组成 元素由jsp处理 模板由浏览器解释 是静态的内容

| 序号 | 元素名称 |             元素内容              |
| :--: | :------: | :-------------------------------: |
|  1   | 静态内容 |           HTML静态文本            |
|  2   |   指令   |        以<%@开始 以%>结束         |
|  3   |  表达式  |          <%=Java表达式%>          |
|  4   |  脚本段  |        <%Java代码%>代码块         |
|  5   |   声明   |    <%!函数或方法%>定义类或方法    |
|  6   |   动作   | <jsp:动作名:开始 </jsp:动作名结束 |
|  7   |   注释   | <!--可见注释--><%--不可见注释--%> |

表达式、脚本段、声明为脚本元素

**声明**：定义其他脚本元素中可以使用的变量和方法

因此用声明定义的变量是全局变量 作用域为本JSP页面 任何JSP脚本元素都可以访问

对应servlet的fields（？啥时候学了这个 查阅）

**脚本段**：在脚本段中定义的变量为局部变量 任何脚本段的代码都可以访问 对应于_jspService方法中定义的变量

**表达式**：不能以分号结尾 最终在应用程序中输出表达式的值



指令元素：在**转换阶段**提供整个jsp页面的相关信息，指令**不会**产生任何的输出到当前的输出流中

<%@指令名称 属性1=“x" 属性2=”y" %>

**page**: 设置JSP页面的属性

language(java) import(引用第三方的库) isErrorPage（页面能否支持错误处理） errorPage（出现错误后指定错误处理页面） buffer（页面缓冲区大小）…

page_directive_attr_list：限定了程序员可以设置的page属性类型和设定的值的类型 

import属性可以多次出现 每个pageEncoding最多出现一次

数值不匹配或多次设置（除了import）或自定义属性都会出现致命翻译错误 

**include**: 用于在jsp页面中静态的包含一个文件 可以是jsp页面 HTML页面和文本文件 这些文件的内容在转换过程中会转码编译进Java文件中

<%@ include file ="/test.html"%> 绝对路径写法 /表示根目录

<%@ include file="head.jsp"%> 相对路径写法

//自己上手写一下相对路径和绝对路径在include里面的区别

taglib:



### 3.4 JavaBean编程

遵循某些特定约定的JAVA类

1.需要特定的命名空间

2.必须具备一个无参数（空）的构造函数

3.不应该有public的类属性（字段），提供相应的get和set

接下来解释每一步如何做

无参构造函数的实现

### 3.5 JSP隐式对象

是Web容器加载的一组类

隐式对象的名字是JSP的保留字

1.输入输出 request response out

request：表示客户端对网页的请求 使用HTTP协议处理客户端的请求 

实现javax.servlet.http.HttpServletRequest接口

response：处理JSP生成的响应

常用方法setContentType() 规定形式和字符编码格式

out:表示输出流 字符流输出数据 使用write print 和 println等方法

2.作用域通信对象 session application pageContext

pageContext:存取隐式对象的值

session:会话中包含多个请求

application:表示JSP页面所属的应用程序

3.Servlet对象 page config

page:访问变量

config:访问配置信息

4.错误对象 exception

### 3.7 JSP Action元素

标准动作是一些标签，他们影响JSP运行时行为和对客户端请求的响应

从效果上来说，一个标准动作是嵌入到jsp页面中的一个标签



< jsp:useBean > 实例化JavaBean的对象 也可以定位一个已经存在的JavaBean实例

< jsp:useBean id="beanID" class="com.MyBean(全称类名)" scope="page(作用域)"/>

scope=page bean存放在PageContext里

scope=request bean存放在ServletRequest里

scope=session bean存放在HttpSession里

scope=application bean存放在ServletContext里

< jsp:setProperty >和useBean一起使用 ##有点不清楚 实践时再看看##

name - 实例名称     property - 属性名称   param - 指定参数名字 可改  value - 值 不可以改

< jsp:getProperty > 用来访问一个useBean

元素有name和property

useBean隐藏了java的语法 更加简便



< jsp:forward > 将用户的请求转发给其他页面 不能跨应用 也不能跨站点 转向资源类型多样 

page 相对于当前jsp页面的URL 以斜杠开头的是绝对路径 没有斜杠的是相对路径



< jsp:include > 将其他页面的内容嵌入当前页面 若动态嵌入结果 若静态嵌入资源 包含完毕后再执行调用页面 

page - 相对路径 flush - true(刷新缓冲区) 将包含页面产生结果之前将当前页面已经产生的输出刷新到客户端上 false(不刷新)

和include指令的区别：指令是静态包含 发生在转译阶段 动作是动态包含 发生在请求时 最终servlet个数不同 动作是分开两个servlet 指令会合并代码产生一个servlet



空标签和容器标签

### 3.8 注释

JSP注释

<%--comment--%> 网页源码中不可见

HTML注释

<!--comment-->

输出的注释 直接出现在HTML文档中 标记内所有的JSP脚本元素、指令和动作正常执行 执行结果插入到注释中

### 3.9 EL表达式和JSTL

#### EL表达式

表达式语言 通常用于在某个作用域内取得属性值 或简单的运算

不用对对象进行强制类型转换

${EL表达式}    EL表达式由对象和属性组成 由点操作符和中括号操作符两种 用后者的时候要用双引号引起来对象属性 obj["xxx"] 这样

算数运算符：+、-、*、、\or div、%或mod

关系运算符：==/eq、!=/ne、</lt、>/gt、<=/le、>=/ge

**隐式内置对象**

作用域访问对象 pageScope、requestScope、sessionScope、applicationScope

参数访问对象 param paramValues

pageContext 是JSP和EL的公共对象

#### JSTL标签

通用标签 

<c:set > 

<c:set var="xx" value="v" scope="xx" /> <c:set value="xx" target="target" property="property" />

<c:remove > 

<c:remove var="xx" scope="xx" />

<c:out >

<c:out value="xx" > 若有默认值xx再加入default="xx"

条件判断标签<c:if >

<c:if test="condition" var="varName" scope="scope"> var可以省略

迭代标签<c:forEach >

<c:forEach var="varName" items="collectionName" varStatus="varStatusName" begin="beginIndex" end="endIndex" step="step">指定循环的集合

<c:forEach var="varName" varStatus="varStatusName" begin="beginIndex" end="endIndex" step="step">指定次数

**如何使用？**

引入两个jar包和标签库描述符文件.tld

在需要使用JSTL的JSP页面上使用taglib导入标签库描述符文件

## 第四章

#### 4.1JDBC概述

一种用于执行SQL语句的Java API 

JDBC驱动程序管理器（manager）确保正确的驱动程序访问每个数据源，支持同时访问不同数据库

JDBC Driver真正实现数据库交互

#### 4.2 JDBC编程接口和步骤

主要研究JDBC manager

是一种低级API 是高级API基础

包：java.sql  javax.sql

#### 4.3 安装、加载JDBC驱动程序

四种驱动程序

JDBC-ODBC Bridge 映射桥的两端

Native-API Bridge 比上一种更高效

JDBC-middleware 

Pure Java Driver 无中转 直接去DBMS 推荐

#### 4.4 建立连接

建立连接所需特定的URL 有两种连接的方式：DriverManager DataSource 

连接-Connection-对象

**URL编写方式**

jdbc:<subprotocol >:<subname > subprotocol标识一种特定种类的数据库连接机制

jdbc: odbc:<数据资源名称 >[;<属性名 >=<属性值 >]（带的属性个数任意）

**DriverManager**

建立连接必要：数据库URL 数据库用户名密码

加载驱动 Class.forName(”全称限定类名“) 会抛异常 要放异常处理模块中

**DataSource**

对象表示一个数据源，并且提供了该数据源的连接 可移植性很好 DataSource的属性对于JDBC客户端来说不是可以直接访问的

#### 4.5执行SQL语句

**Connection类**-所有的方法都会抛异常

Statement是对能够执行sql语句的一些对象的封装 Statement依赖于Connection

创建statement的函数会抛出异常 有有参数和无参数两种

PreparedStatement 带参数批量插入  

getMetaData 得到实例获得数据库特性



commit() 用于执行对数据库的操作 取消是rollback() 

close() 结束connection对象对数据库的联机

isClosed() 判断Connection是否存在

创建statements对象

```java
Connection com=dataSource.getConnection(user,passwd);
Statement stmt = com.createStatement();//可创建多个Statements对象
```

execute方法

executeQuery 不会对数据库状态有影响的语句

```java
ResultSet executeQuery(String sql)throws SQL Exception
//SELECT
```

executeUpdate  对数据库状态有影响的语句

```java
int executeUpdate(String sql)throws SQLException//=0 无影响 >0 有影响
```

execute 无法确定是否会影响



PreparedStatement执行SQL语句

PreparedStatement是Statement的子类 该类对象都是带输入参数的

```java
 ResultSetMetaData getMetaData() throws SQLException
     //取得ResultSet类对象有关字段的相关信息
 void setInt(int parameterIndex,int x)throws SQLException//类似的还有一系列 注意映射关系的表
```

通过CallableStatement执行SQL语句

为DBMS提供了一种以标准形式调用储存过程的方法。储存过程储存在数据库中

#### 4.6 处理SQL语句的返回结果集

ResultSet 负责储存查询的结果

Cursor指向结果集中的某个记录

光标的方法有

```java
public boolean first() throws SQLException
public void last() throws SQLException
public boolean previous() throws SQLException
public boolean next() throws SQLException
   //relative(int x) absolute(int x)等
```

新建光标时 定位在结果集首行的上一行

获取结果的数据

```java
public int getInt(String columnName) throws SQLException
    //和ptmt set用法相似 以及一系列 用数字代表列也可
```

更改得到的数据

```java
public void updateString(int columnIndex,String s) throws SQLException
    //未更新至数据库
```

更新结果及数据到后台数据库 eg

```java
rs.absolute(3);
rs.updateString("author","xiaozhang");
rs.updaterow();

//除此之外还有 deleteRow(),refreshRow(),insertRow()...
```

