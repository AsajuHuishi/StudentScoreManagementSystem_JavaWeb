<%--
  Created by IntelliJ IDEA.
  User: 曾昕阳
  Date: 2021/3/14
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <base href="http://localhost:8080/shizuo/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" >
    <style type="text/css">
        #btnSubmit{
            color: red;
        }
        .tb{
            width:130px;
            height: 40px;
            margin-top: 60px;
        }
        .wel_word{
            font-size: 30px;
            float: left;
            margin-top: 30px;
        }
        #main table{
            margin: auto;
            margin-top: 20px;
            border-collapse: collapse;
        }
        #function {
            color: blue;
        }
        body {
            overflow: hidden;
            background-image: url("static/img/back.png");
        }
    </style>
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btnSubmit").click(function(){
                $(location).attr("href","pages/menu/queryById.html");
            });
        })
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo2.png" >
    <span class="wel_word">学生成绩管理系统</span>
    <div>
        <a href="index.html">返回主菜单</a>
        <!--        <a href="pages/user/regist.html">注册</a> &nbsp;&nbsp;-->
        <!--				<a href="pages/cart/cart.html">购物车</a>-->
        <!--				<a href="pages/manager/manager.html">后台管理</a>-->
    </div>
</div>
<div id="main">
    当前页面：<span id="function">查询学生记录</span> ${status}
    <table align="center" >
        <tr>
            <td>
                学号:
            </td>
            <td>
                ${student.no}
            </td>
        </tr>
        <tr>
            <td>
                姓名:
            </td>
            <td>
                ${student.name}
            </td>
        </tr>
        <tr>
            <td>
                成绩:
            </td>
            <td>
                ${student.score}
            </td>
        </tr>
        <tr>
            <td>
                班级:
            </td>
            <td>
                ${student.className}
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" align="center" id="btnSubmit" value="继续查询" class="tb" >
            </td>
        </tr>
    </table>

</div>

<div id="bottom">
		<span>
			AsajuHuishi 2021
		</span>
</div>
</body>
</html>