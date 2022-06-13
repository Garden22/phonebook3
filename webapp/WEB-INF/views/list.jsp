<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>리스트</h2>
	<p>입력된 정보입니다.</p>
	
		<c:forEach items="${requestScope.personList}" var="person">
			<table border="1">
				<tr>
					<td>이름</td>
					<td>${person.name}</td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td>${person.hp}</td>
				</tr>
				<tr>
					<td>회사</td>
					<td>${person.company}</td>
				</tr>
				<tr>
					<td><a href="/phonebook3/modifyForm/${person.personId}">[수정폼]</a></td>
					<td><a href="/phonebook3/delete/${person.personId}">[삭제]</a></td>
				</tr>
			</table><br>
	    </c:forEach>
	    
	    <br>
	    <a href="/phonebook3/writeForm">추가번호 등록</a>
</body>
</html>