<%-- 
    Document   : success
    Created on : Jul 8, 2024, 1:15:14 AM
    Author     : DUCDUY2003
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Academic Portal</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/background.css" rel="stylesheet" type="text/css">
    <style>
        body {
            background-color: #f0f8ff; /* Light blue background color */
            font-family: Arial, sans-serif;
        }
        .container {
            background: #ffffff; /* White background for content area */
            border-radius: 15px; /* Rounded corners */
            padding: 30px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }
        h1 {
            color: #007bff; /* Bootstrap primary color */
        }
        .btn-link {
            color: #007bff; /* Bootstrap primary color */
        }
        .btn-link:hover {
            text-decoration: none; /* Remove underline on hover */
        }
        ul {
            list-style-type: disc; /* Bullet points */
            padding-left: 20px; /* Indentation for bullet points */
        }
    </style>
</head>
<body>
    <div class="container text-center mt-5">
        <h1>Have a nice day &#128525;</h1>
        <p>Welcome, <%= request.getAttribute("displayname") %>! |
            <a href="" class="btn btn-success btn-sm">Logout</a>
        </p>
        <div class="row">
            <div class="col-md-6 text-left">
                <h4>Reports</h4>
                <ul>
                    <li><a href="" class="btn btn-link"> Grade Transcript </a></li>
                </ul>
            </div>
            <div class="col-md-6 text-left">
                <h4>View Course By Lecturer</h4>
                <ul>
                    <li><a href="http://localhost:8080/Assignment/exam/lecturer" class="btn btn-link">Course</a></li>
                </ul>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
