<%--
  Created by IntelliJ IDEA.
  User: 柒
  Date: 2023/12/22
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%--
  登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="importhead.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <style type="text/css">
        /* Border styles */
        .menu {
            width: 100%;
            height: 40px;
            border-bottom: #A9A9A9 1px solid;
            background: darkred;
            line-height: 40px;
            padding: 4px;
        }

        .logincard {
            width: 500px;
            height: 600px;
            background: #F5F5DC;
            border: 1px #eaeef1 solid;
            padding: 5px;
            border-radius: 5px 5px 5px 5px;
            border: 1px #66B3FF solid;
        }

        .loginhead {
            width: 100%;
            height: 40px;
            text-align: center;
            font-family: "黑体";
            font-size: 24px;
            font-weight: 400;
        }

        .loginbody {
            width: 400px;
            height: 350px;
            justify-content: center;
            background: darkred;
            margin: 50px;
            border: 1px #8B0000 solid;
            border-radius: 5px 5px 5px 5px;
            padding: 15px;
        }

        .title {
            width: 100px;
            color: white;
            font-family: "黑体";
            font-size: 20px;
            font-weight: 400;
        }

        table tr {
            line-height: 80px;
        }

        .editbox {
            background: #ffffff;
            border: 1px solid #b7b7b7;
            color: #003366;
            cursor: text;
            font-family: "arial";
            font-size: 11pt;
            width: 200px;
            height: 24px;
            font-size: 20px;
            padding: 3px;
            border-radius: 5px 5px 5px 5px;
            margin-top: 2px;
            margin-bottom: 2px;
            padding: 3px;
        }

        .btn1 {
            border: 0px #93bee2 solid;
            background-color: #93BEE2;
            color: darkred;
            cursor: hand;
            font-style: normal;
            width: 100%;
            height: 40px;
            border-radius: 5px 5px 5px 5px;
        }
    </style>
</head>
<body>
<center>
    <%@include file="sysmenu.jsp" %>

    <form action="login.do" method="post">
        <table border="0" width=80% style="margin-top:50px;">
            <tr>
                <td style="width:60%;height:400px;text-align: center;">

                </td>
                <td style="vertical-align:top">
                    <div class="logincard">
                        <div class="loginhead">密码登录</div>
                        <div class="loginbody">
                            <center>
                                <table width="95%" style="margin-top:10px">
                                    <tr>
                                        <td class="title">账号：</td>
                                        <td><input class="editbox" type="text" name="userid"/></td>
                                    </tr>
                                    <tr>
                                        <td class="title">密码：</td>
                                        <td><input class="editbox" type="password" name="password"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><input class="btn1" type="submit" value="登录"/></td>

                                    </tr>
                                </table>
                            </center>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</center>
<%@ include file="footer.jsp" %>
</body>
</html>

