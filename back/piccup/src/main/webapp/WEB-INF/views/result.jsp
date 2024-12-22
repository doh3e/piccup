<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 결과</title>
</head>
<body>
	<a href="/api/v1/img/${fileName}">${fileName}</a><br>
	<img src="/api/v1/img/${fileName}"><br>
	
	<a href="/api/v1/download?fileName=${fileName}">이미지다운로드</a>
</body>
</html>