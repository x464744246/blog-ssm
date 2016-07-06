<%--
  Created by IntelliJ IDEA.
  User: lenov0
  Date: 2016/7/6
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>findUser</h1>
<table>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.userid}</td>
            <td>${u.username}</td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
