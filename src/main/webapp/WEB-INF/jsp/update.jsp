<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateSave.do?id=7" method="post">
		<input type="hidden" name="film_id" value="${film_id}">
		<table border="1">
			<tr>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>
			<tr>
				<td><input type="text" name="title" value="${film.title}" /></td>
				<td><input type="text" name="description"
					value="${film.description}" /></td>
				<td><select id="language">
						<c:forEach var="language" items="${languages}">
							<option>${language}</option>
							<!-- <option>Italian</option>
							<option>Japanese</option>
							<option>Mandarin</option>
							<option>French</option>
							<option>German</option> -->
							</c:forEach>
				</select></td>
				
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>

</body>
</html>