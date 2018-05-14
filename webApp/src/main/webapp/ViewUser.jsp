<%@ page import="java.util.List" %>
<%@ page import="com.jet.web.ViewUsers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    Список пользователей:
    <table>
        <tr><th>Фамилия</th><th>Имя</th><th>Возраст</th></tr>
        <jsp:useBean id="users" scope="request" type="java.util.List"/>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.surname}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
