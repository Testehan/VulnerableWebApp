<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Create Message</title>
    </head>
<body>
    <h2>Welcome to Chapter 3 of Vulnerable Application</h2>
    <br>
    <form action ="../../chapter3" method="post">
        Enter message:
        <br>
        <br>
        <textarea rows="5" cols="50" name="message"></textarea>
        <br>
        <input type="submit" value="Save Message">
    </form>


</body>
</html