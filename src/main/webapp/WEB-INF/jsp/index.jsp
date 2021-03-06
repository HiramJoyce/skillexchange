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
                    <a class="nav-link" href="#">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${ctx}/message/">留言板</a>
                </li>
                <li>
                    <form action="${ctx}/skill/search" class="form-inline" method="post">
                        <input class="form-control mr-sm-2" type="search" name="keyWord" placeholder="Search" aria-label="Search">
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
    <div class="row">
        <div class="col-9">
            <div class="row">
                <c:forEach items="${skills}" var="skill">
                    <div class="card col-4">
                        <img class="card-img-top" src="${ctx}/resource/uploadImg/${skill.img}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${skill.title}</h5>
                            <p class="card-text">${skill.content}</p>
                            <p class="card-text">想要：${skill.askFor}</p>
                            <a href="${ctx}/skill/info?id=${skill.id}" class="btn btn-primary">交换</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-3">
            <div class="card col-12">
                <div class="card-body">
                    <h5 class="card-title">交换排行榜</h5>
                    <c:forEach items="${trades}" var="trade" varStatus="index">
                        <p class="card-text"><a href="${ctx}/skill/info?id=${trade.toSkillId}">${index.index + 1}. ${trade.toSkillTitle}</a></p>
                    </c:forEach>
                </div>
            </div>
            <div class="card col-12">
                <div class="card-body">
                    <h5 class="card-title">站内新闻</h5>
                    <c:forEach items="${news}" var="newss" varStatus="index">
                        <p class="card-text">${index.index + 1}. ${newss.title}<br>${newss.content}<br><fmt:formatDate value="${newss.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
