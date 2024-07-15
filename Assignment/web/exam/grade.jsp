<%-- 
    Document   : grade
    Created on : Jul 16, 2024, 1:03:50 AM
    Author     : DUCDUY2003
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>View Grades</title>
    </head>
    <body>
        <h1>Grade Transcript</h1>
        <c:choose>
            <c:when test="${not empty grades}">
                <table border="1">
                    <tr>
                        <th>Exam ID</th>
                        <th>Student ID</th>
                        <th>Grade</th>
                    </tr>
                    <c:forEach var="grade" items="${grades}">
                        <tr>
                            <td>${grade.exam.id}</td>
                            <td>${grade.student.id}</td>
                            <td>${grade.score}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>No grades found for the specified exam and student.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
