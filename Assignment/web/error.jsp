<%-- 
    Document   : error
    Created on : Jul 3, 2024, 9:13:01 AM
    Author     : DUCDUY2003
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p><%= request.getAttribute("errorMessage") %></p>
    <a href="<%= request.getContextPath() %>/">Go to Home</a>
</body>
</html>
