<%-- 
    Document   : login
    Created on : Jun 3, 2024, 9:12:46 PM
    Author     : DUCDUY2003
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Academic Portal</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: "Helvetica Neue", "Open Sans", sans-serif;
            background-color: #282c34;
            background-image: linear-gradient(to top left, #a802e0, #f7676a);
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            backdrop-filter: blur(10px);
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        .input-container {
            position: relative;
            margin: 10px 0;
        }
        .input-container i {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: #aaa;
        }
        input[type="text"],
        input[type="password"],
        select {
            padding: 10px;
            padding-left: 40px; /* Adjust padding to make space for icon */
            border: none;
            border-radius: 5px;
            width: 100%;
            box-sizing: border-box;
            background: rgba(255, 255, 255, 0.2);
            color: white;
        }
        input[type="submit"] {
            background-color: #f7676a;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #d55654;
        }
        .footer {
            margin-top: 20px;
        }
        .footer a {
            color: white;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login to Academic Portal</h1>
        <form action="login" method="POST">
            <div class="input-container">
                <i class="fas fa-user"></i>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="input-container">
                <i class="fas fa-lock"></i>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <select id="department" name="department">
                <option value="Lecturers">Lecturers</option>
                <option value="Student">Student</option>
                <option value="Parents">Parents</option>
                <option value="Training">Training</option>
            </select>
            <input type="submit" value="Login">
        </form>
        <div class="footer">
            <p>Forgotten password? <a href="#">Sign up</a></p>
            <p>&copy; Powered by Duc Duy</p>
        </div>
    </div>
</body>
</html>
