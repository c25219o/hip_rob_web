<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>しりとりしよう⊂二二二（ ＾ω＾）二⊃</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/commonStyle.css">
</head>
<body>
    <div class="screen_id"></div>
    <%@include file="parts/header.jsp"%>
    <div class="content">
        <h2>しりとりーず</h2>
        <a href="/rob/standard.html" class="menuButton">ふつうのしりとり</a>
        <a href="/rob/lengthLimit.html" class="menuButton">じすうせいげんしりとり</a>
        <a href="/yet.html" class="menuButton">こゆうめいししりとり</a>


    </div>
    <%@include file="parts/footer.jsp"%>
</body>
</html>