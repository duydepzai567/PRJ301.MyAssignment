<%-- 
    Document   : grade
    Created on : Jul 16, 2024, 1:03:50 AM
    Author     : DUCDUY2003
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Grades</title>
    </head>
    <body>
        <h1>Grades for Student</h1>

        <h2>Courses</h2>
        <ul>
            <c:forEach var="course" items="${courses}">
                <li>${course.name}</li>
            </c:forEach>
        </ul>

        <h2>Grades</h2>
    <c:if test="${not empty grades}">
        <table border="1">
            <thead>
                <tr>
                    <th>Exam id</th>
                    <th>Student id</th>
                    <th>Grade</th>

                </tr>
            </thead>
            <tbody>
            <c:forEach var="grade" items="${grades}">
                <tr>
                    <td>${grade.course.name}</td>
                    <td>${grade.grade}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
