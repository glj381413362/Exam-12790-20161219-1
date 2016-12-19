<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="<%=path%>/js/jquery.min.js-v=2.1.4.js"></script>
<script
	src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="//cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script> -->
<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/init.css" rel="stylesheet">
</head>
<body>
	<script>
		(function($) {
			$('#myModal').modal('hide')
		}(jQuery));
	</script>
	<script>
		$(function() {
			$('#myModal').on('hide.bs.modal', function() {
				alert('嘿，我听说您喜欢模态框...');
			})
		});
	</script>
	<div class="container ">
		<div class=" row clearfix">
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column"></div>
			<div class="col-md-4 column">
				<c:choose>
					<c:when test="${not empty user }">
						<!--如果 -->
						<p class="class1" style="color: red;"><a href="<%=path%>/login/login_jsp.do">${user.first_name }</a></p>
					</c:when>
					<c:otherwise>
						<!--否则 -->
						<p class="class1"> 请<a href="<%=path%>/login/login_jsp.do">登录</a></p>
					</c:otherwise>
				</c:choose>
				<%-- <label class="class1">你好！</label> --%>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="class2  panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"></h3>
					</div>
					<div class="panel-body">
						<table class="table">
							<thead>
								<tr>
									<th>film_id</th>
									<th>title</th>
									<th>description</th>
									<th>language</th>
									<th>operate</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="film" items="${fList}">
									<c:set var="a" value="${a+1}" />
									<tr id='tr+${a}'>
										<td>${film.film_id}</td>
										<td>${film.title}</td>
										<td>${film.description}</td>
										<td>${film.language_id}</td>
										<td><a
											href='<%=path%>/film/delete.do?film_id=${film.film_id}' id="">删除</a>
											<a href='<%=path%>/film/update.do?film_id=${film.film_id}'>修改</a>
											<a href='<%=path%>/film/add.do'>增加</a>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<div class="row clearfix">
							<div class="col-md-4 column"></div>
							<div class="col-md-4 column"></div>
							<div class="col-md-4 column">
								<ul class="pagination">
									<li><a href="<%=path%>/film/changePage.do?nowPage=1"">Prev</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=1">1</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=2">2</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=3">3</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=4">4</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=5">5</a></li>
									<li><a href="<%=path%>/film/changePage.do?nowPage=12"">Next</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="<%=path%>/js/init.js"></script>
</html>
