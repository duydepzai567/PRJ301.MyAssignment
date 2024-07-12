<%-- 
    Document   : student
    Created on : Jul 7, 2024, 11:54:46 PM
    Author     : DUCDUY2003
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Student Scores</title>
    </head>
    <body>
        <h1>Exam Schedules</h1>
        <table border="1">
            <tr>
                <th>SUBID</th>
                <th>SUBNAME</th>
                <th>ANAME</th>
                <th>FROM</th>

            </tr>
            <c:forEach var="score" items="${scores}">
                <tr>
                    <td>${score.course.name}</td>
                    <td>${score.exam.name}</td>
                    <td>${score.value}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
