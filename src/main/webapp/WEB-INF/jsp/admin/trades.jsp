<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ctx}/resource/admin/assets/css/normalize.css">
    <link rel="stylesheet" href="${ctx}/resource/admin/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/resource/admin/assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/resource/admin/assets/css/style.css">
    <style>
    @page { margin: 0; }
    </style>
</head>

<body>
<!-- Left Panel -->
<aside id="left-panel" class="left-panel">
    <nav class="navbar navbar-expand-sm navbar-default">
        <div id="main-menu" class="main-menu collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${ctx}/admin/students"><i class="menu-icon fa fa-calendar"></i>用户信息管理</a>
                </li>
                <li>
                    <a href="${ctx}/admin/skills"> <i class="menu-icon fa fa-clipboard"></i>供求信息管理</a>
                </li>
                <li class="active">
                    <a href="${ctx}/admin/trades"> <i class="menu-icon fa fa-clipboard"></i>技能交换管理</a>
                </li>
                <li>
                    <a href="${ctx}/admin/news"> <i class="menu-icon fa fa-clipboard"></i>站内新闻管理</a>
                </li>
                <li>
                    <a href="${ctx}/admin/messages"> <i class="menu-icon fa fa-clipboard"></i>留言管理</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </nav>
</aside>
<!-- /#left-panel -->
<!-- Right Panel -->
<div id="right-panel" class="right-panel">
    <!-- Header-->
    <header id="header" class="header">
        <div class="top-left">
            <div class="navbar-header">
                <a class="navbar-brand" href="./"><img src="${ctx}/resource/admin/images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="./"><img src="${ctx}/resource/admin/images/logo2.png"
                                                              alt="Logo"></a>
                <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
            </div>
        </div>
        <div class="top-right">
            <div class="header-menu">
                <div class="user-area dropdown float-right">
                    <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <img class="user-avatar rounded-circle" src="${ctx}/resource/admin/images/admin.jpg"
                             alt="User Avatar">
                    </a>
                    <div class="user-menu dropdown-menu">
                        <a class="nav-link" href="${ctx}/logout"><i class="fa fa-power -off"></i>Logout</a>
                    </div>
                </div>

            </div>
        </div>
    </header>
    <!-- /#header -->
    <!-- Content -->
    <div class="content">
        <div class="animated fadeIn">
            <div class="clearfix"></div>
            <div class="orders">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">供求信息管理</strong>
                            </div>
                            <div class="table-stats order-table ov-h">
                                <table class="table" style="margin-bottom: 0;">
                                    <thead>
                                    <tr>
                                        <th class="serial">#</th>
                                        <th class="avatar">发起者</th>
                                        <th>发起者学号</th>
                                        <th>发起者技能</th>
                                        <th>接受者</th>
                                        <th>接受者学号</th>
                                        <th>接受者技能</th>
                                        <th>时间</th>
                                        <th>状态</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${trades}" var="trade" varStatus="index">
                                        <tr>
                                            <td class="serial">${index.index + 1}</td>
                                            <td>${trade.fromStudentRealName}</td>
                                            <td>${trade.fromStudentNum}</td>
                                            <td>${trade.fromSkillTitle}</td>
                                            <td>${trade.toStudentRealName}</td>
                                            <td>${trade.toStudentNum}</td>
                                            <td>${trade.toSkillTitle}</td>
                                            <td><f:formatDate value="${trade.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                            <td>${trade.state == 0 ? "请求交换" : "已同意"}</td>
                                            <td>
                                                <a href="${ctx}/trade/delete?id=${trade.id}" class="btn btn-danger">删除</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${ctx}/resource/admin/assets/js/vendor/jquery-2.1.4.min.js"></script>
<script src="${ctx}/resource/admin/assets/js/popper.min.js"></script>
<script src="${ctx}/resource/admin/assets/js/plugins.js"></script>
<script src="${ctx}/resource/admin/assets/js/main.js"></script>
</body>
</html>
