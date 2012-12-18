<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/widget" prefix="widget" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todooz</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="navbar navbar-inverse">
        <div class="navbar-inner">
            <span class="brand">Todooz</span>
            <form class="navbar-search pull-left">
                <input type="text" class="search-query" placeholder="Search">
            </form>
            <a href="/add" class="btn btn-inverse pull-right"><i class="icon-plus icon-white"></i></a>
        </div>
    </div>
    <div class="row">
        <div class="span9">
            <legend>All tasks</legend>

			<c:forEach var="task" items="${tasks}">
				 <div>
					<p><fmt:formatDate value="${task.date}" pattern="dd MMM yyyy"/></p>
					<span class="lead">${task.title}</span> <span
						class="badge badge-info">${task.text}</span> <span class="badge badge-info">${task.tags}</span>
					<p>Read Effective Java before it's too late</p>
				</div>
			</c:forEach>
        </div>
        <div class="span3">
            <div>
                <legend>Quick links</legend>
                <ul>
                    <li><a href="/today">Today's</a></li>
                    <li><a href="/tomorrow">Tomorrow's</a></li>
                </ul>
            </div>

            <div>
                <legend>Tags</legend>
                <a href="/tag/java" style="font-size:14px">java</a>
                <a href="/tag/java" style="font-size:20px">java</a>
                <a href="/tag/java" style="font-size:16px">java</a>
                <a href="/tag/java" style="font-size:12px">java</a>
                <a href="/tag/java" style="font-size:10px">java</a>
                <a href="/tag/java" style="font-size:22px">java</a>
                <a href="/tag/java" style="font-size:12px">java</a>
                <a href="/tag/java" style="font-size:14px">java</a>
                <a href="/tag/java" style="font-size:18px">java</a>
                <a href="/tag/java" style="font-size:24px">java</a>
                <a href="/tag/java" style="font-size:12px">java</a>
                <a href="/tag/java" style="font-size:10px">java</a>
                <a href="/tag/java" style="font-size:14px">java</a>
            </div>
        </div>
    </div>
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>