<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/commonStyle.css">
</head>
<body>
    <div class="screen_id"></div>
    <%@include file="parts/header.jsp"%>
    <div class="content">
        <h2>なんもじいじょうのせいげんをつける？</h2>
        <c:if test="${errorMessage != null}">
            <p><span class="errorMessage">${errorMessage}</span></p>
        </c:if>
        <form action="/rob/lengthLimit/start.html" class="inline">
            <input type="text" name="limit" placeholder="すうじでいれてね"><br>
            <input type="submit" value="しりとりをはじめる">
        </form>

    </div>
    <%@include file="parts/footer.jsp"%>
</body>
</html>