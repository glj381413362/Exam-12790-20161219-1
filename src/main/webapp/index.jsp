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
						<p class="class1" class="m-t-md" style="color: red;">你好！${user.first_name }</p>
					</c:when>
					<c:otherwise>
						<!--否则 -->
						<p class="class1">登录</p>
					</c:otherwise>
				</c:choose>
				<%-- <label class="class1">你好！</label> <a
					href="<%=path%>/login/login_jsp.do"><c:if
						test="${not empty user }">
						<p class="m-t-md" style="color: red;">${user.first_name }</p>
					</c:if></a> --%>
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
										<td><input type="radio" name="Sex" id='rad+${a}'
											checked="checked" value='${item.todo_item_id}' />${a}<input
											disabled="disabled" style="background:; border: 0"
											type="text" id="${film.film_id}_id" value='${film.film_id}' /></td>
										<td><input type="text" disabled="disabled"
											style="background:; border: 0" id="${film.film_id}_title"
											value="${film.title}" /></td>
										<td><input type="text" disabled="disabled"
											style="background:; border: 0" id="${film.film_id}_desc"
											value="${film.description}" /></td>
										<td><input type="text" disabled="disabled"
											style="background:; border: 0" id="${film.film_id}_lang"
											value="${film.language_id}" /></td>
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
									<li><a href="#">Prev</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">Next</a></li>
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
