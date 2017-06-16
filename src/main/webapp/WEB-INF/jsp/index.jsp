<%--
  Created by IntelliJ IDEA.
  User: Konul Gurbanli
  Date: 6/1/2017
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <link href="<c:url value="/static/css/game.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/static/js/jquery-3.1.0.min.js" />"></script>
    <script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="Center-Container">
    <div class="Absolute-Center" style="text-align: center">
        <p class="large">Xoş gəlmişsiniz! Oyuna başlamağa hazırsınız?</p>
        <%--<button> <a href="/words/play">Başla </a></button>--%>
        <form action="/words/play">
            <input type="submit" value="Başla">
        </form>
    </div>
</div>
</body>
</html>
