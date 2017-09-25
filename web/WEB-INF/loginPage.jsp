<%-- 
    Document   : loginPage
    Created on : Sep 18, 2017, 1:19:35 PM
    Author     : 727525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/header.html" />
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <form action="Login" method="post"> 
        Username:
        <input type="text" name="username" value="${user.username}">
        <br>Password:
        <input type="text" name="password" value="${user.password}">
        <br>
        <input type="submit" value="Login">
    </form>
    <br>${message}
<c:import url="/WEB-INF/footer.html" />
