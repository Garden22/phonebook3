<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정폼</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>수정폼</h2>
	<p>
		전화번호를 등록하려면<br>
		아래 항목을 기입하고 '등록' 버튼을 클릭하세요.
	</p>
	
	<form action="/phonebook3/modify" method="get">
		<label for="name">이름(name)</label>
		<input id="name" type="text" name="name" value="${personVo.name}"><br>
		<label for="hp">휴대폰(hp)</label>
		<input id="hp" type="text" name="hp" value="${personVo.hp}"><br>
		<label for="company">직장(company)</label>
		<input id="company" type="text" name="company" value="${personVo.company}"><br>
		<input type="hidden" name="personId" value="${personVo.personId}">
		<button type="submit">등록</button>
	</form>
</body>
</html>