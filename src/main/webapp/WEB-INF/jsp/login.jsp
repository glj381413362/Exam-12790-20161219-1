<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String serverUrl = request.getContextPath();
	request.setAttribute("serverUrl", serverUrl);
 %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <link href="<%=path%>/css/bootstrap.min.css"  rel="stylesheet">
    <link href="<%=path%>/css/font-awesome.min.css-v=4.4.0.css" rel="stylesheet">
    <link href="<%=path%>/css/animate.min.css"  rel="stylesheet">
    <link href="<%=path%>/css/style.min.css"  rel="stylesheet">
    <link href="<%=path%>/css/login.min.css"  rel="stylesheet">
   	
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>
    
</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ H+ ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>H+ 后台主题UI框架</strong></h4>
                   <!--  <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul> -->
                    
                    <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="login/login.do">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md"><h3>登录服务</h3></p>
                   	<c:if test="${not empty errorMsg }">
                    	<p class="m-t-md" style="color:red;">${errorMsg }</p>
                    </c:if>
                    <input type="text" class="form-control uname" name="username" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" name="pwd" placeholder="密码" />
                    <a href="">忘记密码了？</a>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
            </div>
        </div>
    </div>
</body>
<script src="<%=path%>/js/jquery.min.js-v=2.1.4.js"></script>
</html>