<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
            <h1>Contact List</h1>
            <table border="1">
                <th>No</th>
                <th>Username</th>
                <th>Email</th>
                 <c:forEach var="lecturer" items="${LecturerList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${lecturer.lecturerId}</td>
                    <td>${lecturer.lecturerName}</td>
                             
                </tr>
                </c:forEach>
                 
            </table>
</body>
</html>