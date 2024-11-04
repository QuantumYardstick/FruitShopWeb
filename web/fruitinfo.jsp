<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/22
  Time: 14:10
  To change this template use File | Settings | File Templates.

  水果商品详细页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/fruitinfo.css">
    <title>详细信息</title>
</head>

<body>
<%@ include file="sysmenu.jsp"%>

<div class="shell">
    <div class="info_box">
        <img src="/upload/${fruit.imgs}" alt="">
        <div class="info_title">
            <h2>商品名：${fruit.fruitname}</h2>
            <p>产地：${fruit.producer}</p>
            <p>库存：${fruit.count}</p>
            <p>购买数量：<input class="info_input" type="text" name="keytopic" /></p>
            <span>售价：${fruit.price}</span>
            <button>添加至购物车</button>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>
</body>

</html>