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
        <link type="text/css" href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />" rel="stylesheet"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		  <script src="<c:url value="/resources/JQuery/jquery-1.11.0.min.js" />"></script>
		  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
		  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <title>Insert Department</title>
       
        
    </head>
    <body>
    <div id="page-wrapper" style="margin-top: 10px; margin-left: 10px; margin-right: 20px">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Add Department</h1>
                </div>
                <!-- /.col-md-12 -->
            </div>
    	<div class="panel panel-default">
	    	<div class="panel-body">
	    		<h3>Insert Department Form</h3>
	    		<font color="blue"  id="warning2">${Success} <br> </font>
	    		<div class="row">
                  <div class="col-md-6"> 
		        <form action="/University_Time_Table_Management_System/department/addDepartment" method="POST" onsubmit="return validateForm()">
		            <div class="form-group">
		            <label for="departmentID">Department ID</label>
		            <input type="text" class="form-control" id="departmentId" name="departmentId" value="${DepartmentID}" readonly>
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="departmentName">Department Name</label>
		                <input type="text" class="form-control" id="departmentName" name="departmentName" placeholder="Department Name">
		            </div>
		            <br>
		            <div class="form-group">
		            <label for="buildingName">Building Name</label>
		            <input type="text" class="form-control" id="selectedBuilding" name="selectedBuilding" placeholder="Select Building">
		        	</div>
		            <button type="submit" class="btn btn-default">Submit</button>
		        </form>
		        </div>
		            </div>
	   		</div>
   		</div>
   		</div>
        
         <script>
			  $(function() {
				  var buildingList = [];
			  	  <c:forEach var="building" items="${BuildingList}" varStatus="status">
			  			buildingList.push("${building.buildingName}"); 
			   	  </c:forEach>
			
				  $( "#selectedBuilding" ).autocomplete({
				  		source: buildingList
				  });
			
			  });
			  function validateForm() {
					var feild1 = $("#departmentName");
					var feild2 = $("#selectedBuilding");
				    var x1 = document.getElementById('departmentName').value;
				    var x2 = document.getElementById('selectedBuilding').value;
				    var return1=true;
				    var return2=true;
				    $("#warning1").remove();
				    $("#warning2").remove();
				    if (x1 == null || x1 == "") {
				    	$(feild1).after('<font color="red"  id="warning1">* required </font> '); //add input box
				       // alert("Name must be filled out");
				    	return1=false;
				    }
				    if(x2 == null || x2 == "" || compareList(x2)){
				    	$(feild2).after('<font color="red"  id="warning2">* required or select  correct building </font> '); //add input box
				    	return2=false;
				    }
				    return return1 && return2 ;
				}
			  
			  function compareList(value) {
				  var buildingList = [];
			  	  <c:forEach var="building" items="${BuildingList}" varStatus="status">
			  			buildingList.push("${building.buildingName}"); 
			   	  </c:forEach>
				  for (var int = 0; int < buildingList.length; int++) {
					  if(buildingList[int]==value){
						  return false;
					  }
				  }
				  return true;
			  }
			  
			  function isPositiveInteger(n) {
				    return n >>> 0 === parseFloat(n);
				}
		</script>
        
    </body>
</html>
