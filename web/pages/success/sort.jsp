<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--使用JSTL遍历对象--%>
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
        .wel_word{
            font-size: 30px;
            float: left;
            margin-top: 30px;
        }
        .tb{
            width:130px;
            height: 40px;
            margin-top: 120px;
        }
        /*#main table{*/
        /*    margin: auto;*/
        /*    margin-top: 1px;*/
        /*    border-collapse: collapse;*/
        /*}*/
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

        });
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
    当前页面：<span id="function">按成绩排序</span>
    <center>
        <table align="center">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>成绩</th>
                <th>班级</th>
            </tr>
<%--            ${studentList}--%>

                <c:forEach items="${studentList}" var="stu">
                    <tr>
                        <td>${stu.no}</td>
                        <td>${stu.name}</td>
                        <td>${stu.score}</td>
                        <td>${stu.className}</td>
                    </tr>
                </c:forEach>
        </table>
    </center>
</div>

<div id="bottom">
		<span>
			AsajuHuishi 2021
		</span>
</div>
</body>
</html>

