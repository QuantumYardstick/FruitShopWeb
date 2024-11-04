<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/22
  Time: 15:30
  To change this template use File | Settings | File Templates.

  错误信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/errors.css">
    <link rel="stylesheet" href="./css/button.css">
    <title>网页被吃了</title>
</head>
<body>
<%@ include file="sysmenu.jsp"%>

<div class="shell">
    <div class="info_box">
        <div class="button_style"><a href="${backUrl}" class="button" style="">点我返回</a></div>
        <h1 style="margin: 400px;height: 500px;font-size: 100px; ">${errMsg}</h1>
        <div class="button_style"><a href="index.do" class="button" style="">点我回家</a></div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>

</body>
</html>