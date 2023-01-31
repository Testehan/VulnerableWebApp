<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login page</title>
    </head>
<body>
    <h2>Welcome to Chapter 2 of Vulnerable Application</h2>
    Login to continue.
    <form action ="../../chapter2" method="post">
        Enter username: <input type="text" name="username"> <br>
        Enter password: <input type="password" name="password"> <br>
        <input type="submit" value="login">
    </form>
    <br>
    <br>
    <p style="color:red">${loginMessage}</p>

</body>
</html