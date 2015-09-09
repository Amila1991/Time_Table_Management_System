<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />" rel="stylesheet"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		  <script src="<c:url value="/resources/JQuery/jquery-1.11.0.min.js" />"></script>
		  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
		  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <title>Generated Time Table</title>
</head>
<body>

<div id="page-wrapper" style="margin-top: 10px; margin-left: 10px; margin-right: 20px">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Generated Time Table</h1>
                </div>
                <!-- /.col-md-12 -->
            </div>
    	<div class="panel panel-default">
	    	<div class="panel-body">
	    		<form action="/University_Time_Table_Management_System/timetable/savetimetable" method="POST">
	    		<h4>Department : </h4>
	    		<div class="row">
                  <table class="table table-bordered" style="margin-bottom: 5px ; margin-right: 5px; margin-left: 5px">
				  		<th></th>
		                <th>Monday</th>
		                <th>Tuesday</th>
		                <th>Wednesday</th>
		                <th>Thursday</th>
		                <th>Friday</th>


			                
			                <c:forEach begin="0" end="8" varStatus="loop">
			                	
			                	
			                	<c:choose>
								  <c:when test="${loop.index==4}">
								  <tr>
				                	<c:set var="time1" value="${loop.index + 8}"/>
									<c:set var="time2" value="${loop.index+ 9}"/>      
				                	<td align="center">${time1}.15 - ${time2}.15</td>
								    <td colspan="5" align="center"> Lunch Time</td>
								    </tr>
								    
								  </c:when>
								</c:choose>
			                	
								  <tr>
								  <c:choose>
								  <c:when test="${loop.index>=4}">
								  <tr>
				                	<c:set var="time1" value="${loop.index + 9}"/>
									<c:set var="time2" value="${loop.index+ 10}"/>      
								  </c:when>
								  <c:otherwise>
								    <c:set var="time1" value="${loop.index + 8}"/>
									<c:set var="time2" value="${loop.index+ 9}"/>  
								  </c:otherwise>
								</c:choose>
    			                <td align="center">${time1}.15 - ${time2}.15</td>    
								
			                	 <c:forEach begin="0" end="4" varStatus="loop1">
				                    <td align="center">${TimeTable[loop.index][loop1.index]}</td>
							</c:forEach>
								</tr>
							</c:forEach>
				  </table>
				  <div class="form-group" style="margin-bottom: 10px ; margin-left: 10px">
				   <button type="submit" class="btn btn-default">Save</button>
				   </div>
		        </div>
		        </form>
	   		</div>
   		</div>
   		</div>
</body>
</html>