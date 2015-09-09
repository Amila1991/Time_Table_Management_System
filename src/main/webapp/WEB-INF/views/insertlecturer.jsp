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
                    <h1 class="page-header">Add Lecturer</h1>
                </div>
                <!-- /.col-md-12 -->
            </div>
    	<div class="panel panel-default">
	    	<div class="panel-body">
	    		<h3>Insert Lecturer Form</h3>
	    		<font color="blue"  id="warning2">${Success} <br> </font>
	    		<div class="row">
                  <div class="col-md-6"> 
		        <form action="/University_Time_Table_Management_System/lecturer/addLecturer" method="POST" onsubmit="return validateForm()">
		            <div class="form-group">
		            <label for="lecturerID">Lecturer ID</label>
		            <input type="text" class="form-control" id="lecturerId" name="lecturerId" value="${LecturerID}" readonly >
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="lecturerName">Lecturer Name</label>
		                <input type="text" class="form-control" id="lecturerName" name="lecturerName" placeholder="Lecturer Name">
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="contactNo">Contact No</label>
		                <input type="text" class="form-control" id="contactNo" name="contactNo" placeholder="Contact No">
		            </div>
		            <br>
		            <div class="form-group">
		            <label for="email">Email</label>
		            <input type="text" class="form-control" id="email" name="email" placeholder="Email">
		        	</div>
		        	<br>
		        	<div class="form-group">
		            <label for="departmentName">Department Name</label>
		            <input type="text" class="form-control" id="selectedDepartment" name="selectedDepartment" placeholder="Department Name">
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
				  var departmentList = [];
			  	  <c:forEach var="department" items="${DepartmentList}" varStatus="status">
			  			departmentList.push("${department.departmentName}"); 
			   	  </c:forEach>
			
				  $( "#selectedDepartment" ).autocomplete({
				  		source: departmentList
				  });
			
			  });
			  function validateForm() {
					var feild1 = $("#lecturerName");
					var feild2 = $("#contactNo");
					var feild3 = $("#email");
					var feild4 = $("#selectedDepartment");
				    var x1 = document.getElementById('lecturerName').value;
				    var x2 = document.getElementById('contactNo').value;
				    var x3 = document.getElementById('email').value;
				    var x4 = document.getElementById('selectedDepartment').value;
				    var return1=true;
				    var return2=true;
				    var return3=true;
				    var return4=true;
				    $("#warning1").remove();
				    $("#warning2").remove();
				    $("#warning3").remove();
				    $("#warning4").remove();
				    if (x1 == null || x1 == "") {
				    	$(feild1).after('<font color="red"  id="warning1">* required </font> '); //add input box
				       // alert("Name must be filled out");
				    	return1=false;
				    }
				    if(x2 == null || x2 == "" || !isPositiveInteger(x2)){
				    	$(feild2).after('<font color="red"  id="warning2">* invalid </font> '); //add input box
				    	return2=false;
				    }
				    if(x3 == null || x3 == ""){
				    	$(feild3).after('<font color="red"  id="warning3">* invalid </font> '); //add input box
				    	return3=false;
				    }
				    if(x4 == null || x4 == "" || compareList(x4)){
				    	$(feild4).after('<font color="red"  id="warning4">* select correct building </font> '); //add input box
				    	return4=false;
				    }
				    return return1 && return2 && return3 && return4 ;
				}
			  
			  function compareList(value) {
				  var departmentList = [];
			  	  <c:forEach var="department" items="${DepartmentList}" varStatus="status">
			  			departmentList.push("${department.departmentName}"); 
			   	  </c:forEach>
				  for (var int = 0; int < departmentList.length; int++) {
					  if(departmentList[int]==value){
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
