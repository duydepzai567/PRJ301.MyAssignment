<%-- 
    Document   : login
    Created on : Jun 3, 2024, 9:12:46 PM
    Author     : DUCDUY2003
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login web page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="text-align-last: center">
        <h1>Login to check in attended</h1>
        <form action="action" method="POST">
            Username: <input type="text" name="username" required><br><br>
            Password: <input type="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
        <p>
            © Powered by Duc Duy 
        <p>Forgotten password? <a href="">sign up.</a></p>
        </p>
        <style>
            body{
                ont-family: "Helvetica Neue", "Open sans", sans-serif;
                background-color: gray;
                background-image: -webkit-linear-gradient(top left, #a802e0, #f7676a);
                color: white;
            }
        </style>
    </body>
</html>
