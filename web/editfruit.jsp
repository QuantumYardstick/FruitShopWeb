<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/23
  Time: 13:48
  To change this template use File | Settings | File Templates.

 -- 商品编辑页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加商品</title>
    <link href="./css/editfruit.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="js/editfruit.js"></script>
</head>

<body>
<center>
    <%@ include file="sysmenu.jsp" %>
    <div class="edit_box" style="width: 55%;">

        <form action="savefruit.do" method="post">
            <table border="0" style="margin-top:50px;" width=80%>
                <tr>
                    <td style="width:50%;height:300px;text-align: center;">
                        <ul style="margin-top:20px; list-style: none;">
                            <li>
                                <c:if test="${fruit.fruitid == 0}">
                                    <img id="fruitphoto" style="width:400px; height:400px;padding: 176px" title="添加图片"
                                         alt="添加图片" src="./imgs/ic_public_add_norm.png"/>
                                </c:if>
                                <c:if test="${fruit.fruitid != 0}">
                                    <img id="fruitphoto"  style="width:400px; height:400px " title="添加图片" alt="添加图片" src="/upload/${fruit.imgs}"/>
                                </c:if>
                            </li>
                            <li>
                                <input class="editbox" id="imgs" name="imgs" type="text" value="${fruit.imgs}"/>
                                <input class="button1" id="choicePhoto" type="button" value="选择图片"/>
                                <!---隐藏的file-->
                                <input id="fileToUpload" name="upfile" style="display:none;" type="file"/>
                            </li>
                        </ul>
                    </td>
                    <td style="vertical-align:top">
                        <table style="margin-top: 50px;">
                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title">商品编号：</span></td>
                                <td><input class="editbox" type="text" name="fruitid" readonly="readonly"
                                           value="${fruit.fruitid}"></td>
                            </tr>
                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title">商品名称：</span></td>
                                <td><input class="editbox" name="fruitname" type="text" value="${fruit.fruitname}"></td>
                            </tr>

                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title">产&nbsp;&nbsp;&nbsp;&nbsp;地：</span>
                                </td>
                                <td><input class="editbox" name="producer" type="text" value="${fruit.producer}"></td>
                            </tr>
                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title">当前售价：</span></td>
                                <td><input class="editbox" name="price" type="text" value="${fruit.price}"></td>
                            </tr>
                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title">库存数量：</span></td>
                                <td><input class="editbox" name="count" type="text" value="${fruit.count}"></td>
                            </tr>
                            <tr>
                                <td style="width:100px;text-align: right;"><span class="title"></span></td>
                                <td><input class="button1" type="submit" value="保存"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</center>

<%@ include file="footer.jsp" %>
</body>

</html>