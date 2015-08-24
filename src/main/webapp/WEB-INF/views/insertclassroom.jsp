<%-- 
    Document   : insertclassroom
    Created on : Aug 12, 2015, 2:54:11 PM
    Author     : Amila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/controller/classroom/addClassroom" method="POST">
            <div class="form-group">
            <label for="classroomID">Building ID</label>
            <input type="text" class="form-control" id="classroomId" name="classroomId" value="${ClassroomID}">
            </div>
            <div class="form-group">
                <label for="classroomName">Classroom Name</label>
                <input type="text" class="form-control" id="classroomName" name="classroomName" placeholder="classroom Name">
            </div>
            <div class="form-group">
                <label for="classroomSize">Classroom Size</label>
                <input type="text" class="form-control" id="classroomSize" name="classroomSize" placeholder="classroom Name">
            </div>
            <div class="form-group">
            <select name="selectedBuilding">
            <label for="buildingName">Building Name</label>
              <c:forEach var="building" items="${BuildingList}" varStatus="status">
           		 <option value="${building.buildingName}">${building.buildingName}</option> 
              </c:forEach>

			</select>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </body>
</html>
