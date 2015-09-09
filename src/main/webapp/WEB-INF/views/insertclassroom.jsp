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
        <title>Insert Classroom</title>
       
        
    </head>
    <body>
    <div id="page-wrapper" style="margin-top: 10px; margin-left: 10px; margin-right: 20px">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Add Classroom</h1>
                </div>
                <!-- /.col-md-12 -->
            </div>
    	<div class="panel panel-default">
	    	<div class="panel-body">
	    		<h3>Insert Classroom Form</h3>
	    		<div class="row">
                  <div class="col-md-6"> 
		        <form action="/University_Time_Table_Management_System/classroom/addClassroom" method="POST" onsubmit="return validateForm()">
		            <div class="form-group">
		            <label for="classroomID">Classroom ID</label>
		            <input type="text" class="form-control" id="classroomId" name="classroomId" value="${ClassroomID}" readonly>
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="classroomName">Classroom Name</label>
		                <input type="text" class="form-control" id="classroomName" name="classroomName" placeholder="Classroom Name">
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="classroomSize">Classroom Size</label>
		                <input type="text" class="form-control" id="classroomSize" name="classroomSize" placeholder="Classroom Size">
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
					var feild1 = $("#classroomName");
					var feild2 = $("#classroomSize");
					var feild3 = $("#selectedBuilding");
				    var x1 = document.getElementById('classroomName').value;
				    var x2 = document.getElementById('classroomSize').value;
				    var x3 = document.getElementById('selectedBuilding').value;
				    var return1=true;
				    var return2=true;
				    var return3=true;
				    $("#warning1").remove();
				    $("#warning2").remove();
				    $("#warning3").remove();
				    if (x1 == null || x1 == "") {
				    	$(feild1).after('<font color="red"  id="warning1">* required </font> '); //add input box
				       // alert("Name must be filled out");
				    	return1=false;
				    }
				    if(x2 == null || x2 == "" || !isPositiveInteger(x2)){
				    	$(feild2).after('<font color="red"  id="warning2">* required or select  correct size </font> '); //add input box
				    	return2=false;
				    }
				    if(x3 == null || x3 == "" || compareList(x3)){
				    	$(feild3).after('<font color="red"  id="warning3">* required or select  correct building </font> '); //add input box
				    	return3=false;
				    }
				    return return1 && return2 && return3 ;
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
