<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/22
  Time: 14:32
  To change this template use File | Settings | File Templates.

  网站菜单
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp" %>
<link rel="stylesheet" href="./css/sysmenu.css">
<div class="shell">
    <header>
        <div class="logo-container">
            <a href="index.do">
                <img src="./imgs/logo小.png" alt="logo">
            </a>

            <%--            <div style="float:right; margin-right:40px;border:1px #040e1c solid; height:30px; margin-top:5px"></div>--%>
        </div>

        <div class="search">
            <form action="index.do" method="post">
                <input class="txtsearch form_input" type="text" name="keytopic"/>
                <input class="btnsearch form_input" type="submit" value="搜索"
                       style="width: 60px; text-align: center;padding-left: 0px;">
                <%--                <button class="btnsearch form_input" type="submit"style="width: 60px; text-align: center;padding-left: 0px;">搜索</button>--%>
            </form>
        </div>


        <div class="header-right">
            <%--如果用户登录且类型为网站用户--%>
            <c:if test="${loginuser!=null && loginuser.rolecode==2}">
                <a href="cartdetail.html">购物车</a>
                <a href="logout.do">退出登录</a>
            </c:if>
            <%--如果用户登录且类型为管理员用户--%>
            <c:if test="${loginuser!=null && loginuser.rolecode==1}">
                <a href="editfruit.do">添加商品</a>
                <a href="logout.do">退出登录</a>
            </c:if>
            <%--如果用户未登录--%>
            <c:if test="${loginuser==null || loginuser.userid==null}">
                <a href="login.jsp">登录</a>
            </c:if>
        </div>
        <c:if test="${loginuser!=null && loginuser.userid!=null}">
        <div>你好，${loginuser.username}（${loginuser.rolename}）</div>
        </c:if>
        <c:if test="${loginuser==null || loginuser.userid==null}">
        <div>你好，当前您还未登录</div>
        </c:if>
</div>
</header>
</div>

