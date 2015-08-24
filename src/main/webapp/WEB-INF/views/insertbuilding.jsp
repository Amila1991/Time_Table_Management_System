<%-- 
    Document   : insertbuilding
    Created on : Aug 12, 2015, 2:54:11 PM
    Author     : Amila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />" rel="stylesheet"/>
        <title>JSP Page</title>
        <h2>Insert New Building</h2>
    </head>
    <body>
        <form action="/controller/building/addBuilding" method="POST">
            <div class="form-group">
            <label for="buildingID">Building ID</label>
            <input type="text" class="form-control" id="buildingId" name="buildingId" value="${BuildingID}">
            </div>
            <div class="form-group">
                <label for="buildingName">Building Name</label>
                <input type="text" class="form-control" id="buildingName" name="buildingName" placeholder="${BuildingID}">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </body>
</html>
