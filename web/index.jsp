<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/21
  Time: 20:00
  To change this template use File | Settings | File Templates.

  网站首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <title>水果购物网站</title>
    <link rel="stylesheet" href="./css/index copy.css">
    <script type="text/javascript">
        function deletefruit(fruitid){
            var select = confirm("您确认要删除当前选中的商品吗")
            if (select == true){
                // alert(fruitid);
                document.location.href = "deletefruit.do?fruitid=" + fruitid;
            }
        }
    </script>
</head>

<body>
<%@ include file="sysmenu.jsp" %>
<%--  商品信息 --%>
<div class="commodity">
    <c:forEach items="${fruitList}" var="obj">

        <div class="product">
            <a href="fruitinfo.do?fruitid=${obj.fruitid}">
                <img src="/upload/${obj.imgs}" alt="${obj.fruitname}">
            </a>
            <a style="color: #181818;font-size: 15px;margin-top: 25px;line-height: 2;" href="fruitinfo.do?fruitid=${obj.fruitid}"><h3>${obj.fruitname}</h3></a>
            <p>库存： ${obj.count}</p>
            <span>￥${obj.price}</span>
            <button>添加至购物车</button>
            <c:if test="${loginuser != null && loginuser.rolecode == 1}">
                <a href="editfruit.do?fruitid=${obj.fruitid}"
                   style="color: #181818;font-size: 15px;margin-top: 25px;border-bottom: 1px solid #a0a5a8;line-height: 2;">编辑</a>
                <a href="javascript:deletefruit(${obj.fruitid});"
                   style="color: #181818;font-size: 15px;margin-top: 25px;border-bottom: 1px solid #a0a5a8;line-height: 2;">删除</a>
            </c:if>
        </div>

        <!-- 在此添加更多商品 -->
        </main>
    </c:forEach>
</div>


<%@ include file="footer.jsp" %>
</body>

</html>
