<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>在校大学生技能交换平台</title>
    <link rel="stylesheet" href="${ctx}/resource/bootstrap/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">在校大学生技能交换平台</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${ctx}/">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">留言板</a>
                </li>
                <li>
                    <form action="${ctx}/skill/search" class="form-inline" method="post">
                        <input class="form-control mr-sm-2" type="search" name="keyWord" placeholder="Search"
                               aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </li>
            </ul>
            <span class="navbar-text">
                <c:if test="${sessionScope.id == null}">
                    <a href="${ctx}/login">登录/注册</a>
                </c:if>
                <c:if test="${sessionScope.id != null}">
                    <a href="${ctx}/student/info?id=${sessionScope.id}">${sessionScope.realName}</a> |
                    <a href="${ctx}/logout">注销</a>
                </c:if>
            </span>
        </div>
    </div>
</nav>
<div class="container" style="margin-top: 10px;">
    <h3>留言板</h3>
    <ul class="list-group">
        <c:forEach items="${messages}" var="message">
            <li class="list-group-item">${message.content}
                <span style="float: right;">${message.studentRealName} <fmt:formatDate value="${message.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span></li>
        </c:forEach>
    </ul>
    <form action="${ctx}/message/create" method="post">
        <input type="hidden" name="studentId" value="${sessionScope.id}">
        <textarea id="content" name="content" class="form-control" style="margin-top: 10px;"></textarea>
        <button type="submit" class="btn btn-success btn-sm" style="margin-top: 10px;">提交</button>
    </form>
</div>
</body>
</html>
