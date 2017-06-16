<%--
  Created by IntelliJ IDEA.
  User: Konul Gurbanli
  Date: 6/2/2017
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All the words</title>
</head>
<body>
<table>
    <c:forEach var="word" items="${words}">
        <tr>
            <td>${word.id}</td>
            <td>${word.content}</td>
            <td>${word.length}</td>
            <%--<td><a href="WordController?action=delete&userId=<c:out value="${user.userid}"/>">update</a></td>--%>
            <%--<td><a href="">delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
