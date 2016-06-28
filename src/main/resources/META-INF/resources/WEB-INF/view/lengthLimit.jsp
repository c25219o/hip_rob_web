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

        <h2>じすうせいげんしりとり</h2>
        <span class="errorMessage">
            ${message}
            <form:errors path="inputWord.*"/>
        </span>
        <br>

        <c:if test="${computer ne null}">
           コンピュータ【${computer}】<br>
        </c:if>

        <form action="/rob/standard/do.html" class="inline">
            <input type="text" name="current" placeholder="ここにいれてね"><br>
            <input type="hidden" name="previous" value="${computer}">
            <input type="submit" value="これでどうだ！">
        </form>

        <form action="/rob/standard/giveup.html" class="inline">
            <input type="submit" value="こーさんする">
        </form>

        <form action="index.html" class="inline">
            <input type="submit" value="いりぐちにもどる">
        </form>

        <c:if test="${!empty list}">
            <p>
                ★いままででたことば★
                <br>
                <c:forEach var="word" items="${list}">
                    ${word}<br>
                </c:forEach>
            </p>
        </c:if>

    </div>
    <%@include file="parts/footer.jsp"%>
</body>
</html>