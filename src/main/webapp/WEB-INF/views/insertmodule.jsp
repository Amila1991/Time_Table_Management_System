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
                    <h1 class="page-header">Add Module</h1>
                </div>
                <!-- /.col-md-12 -->
            </div>
    	<div class="panel panel-default">
	    	<div class="panel-body">
	    		<h3>Insert Module Form</h3>
	    		<font color="blue"  id="warning2">${Success} <br> </font>
	    		<div class="row">
                  <div class="col-md-6"> 
		        <form action="/University_Time_Table_Management_System/module/addModule" method="POST" onsubmit="return validateForm()">
		            <div class="form-group">
		            <label for="moduleNo">Module No</label>
		            <input type="text" class="form-control" id="moduleNo" name="moduleNo" placeholder="Module No" >
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="moduleTitle">Module Title</label>
		                <input type="text" class="form-control" id="moduleTitle" name="moduleTitle" placeholder="Module Title">
		            </div>
		            <br>
		            <div class="form-group">
		                <label for="credits">Credits</label>
		                <input type="text" class="form-control" id="credit" name="credit" placeholder="Credits">
		                <div class="checkbox">
					      <label><input type="checkbox" id="isGpa" name="isGpa" value="true">Is GPA</label>
					    </div>
		            </div>
		            <br>
		            <div class="form-group">
		            <label for="lecturerHours">Lecture Hours</label>
		            <input type="text" class="form-control" id="lectureHours" name="lectureHours" placeholder="Lecture Hours">
		        	</div>
		        	<br>
		        	<div class="form-group">
		            <label for="practicalHours">Practical Hours</label>
		            <input type="text" class="form-control" id="practicalHours" name="practicalHours" placeholder="practical Hours">
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
					var feild1 = $("#moduleNo");
					var feild2 = $("#moduleTitle");
					var feild3 = $("#credit");
					var feild4 = $("#lectureHours");
					var feild5 = $("#practicalHours");
					var feild6 = $("#selectedDepartment");
				    var x1 = document.getElementById('moduleNo').value;
				    var x2 = document.getElementById('moduleTitle').value;
				    var x3 = document.getElementById('credit').value;
				    var x4 = document.getElementById('lectureHours').value;
				    var x5 = document.getElementById('practicalHours').value;
				    var x6 = document.getElementById('selectedDepartment').value;
				    var return1=true;
				    var return2=true;
				    var return3=true;
				    var return4=true;
				    var return5=true;
				    var return6=true;
				    $("#warning1").remove();
				    $("#warning2").remove();
				    $("#warning3").remove();
				    $("#warning4").remove();
				    $("#warning5").remove();
				    $("#warning6").remove();
				    if (x1 == null || x1 == "") {
				    	$(feild1).after('<font color="red"  id="warning1">* required </font> '); //add input box
				       // alert("Name must be filled out");
				    	return1=false;
				    }
				    
				    if (x2 == null || x2 == "") {
				    	$(feild2).after('<font color="red"  id="warning3">* required </font> '); //add input box
				       // alert("Name must be filled out");
				    	return2=false;
				    }
				    if(x3 == null || x3 == "" || isNaN(x3)){
				    	$(feild3).after('<font color="red"  id="warning3">* invalid </font> '); //add input box
				    	return3=false;
				    }
				    if(x4 == null || x4 == "" || !isPositiveInteger(x4)){
				    	$(feild4).after('<font color="red"  id="warning4">* invalid </font> '); //add input box
				    	return4=false;
				    }
				    if(x5 == null || x5 == "" || !isPositiveInteger(x5)){
				    	$(feild5).after('<font color="red"  id="warning5">* invalid </font> '); //add input box
				    	return5=false;
				    }
				    if(x6 == null || x6 == "" || compareList(x6)){
				    	$(feild6).after('<font color="red"  id="warning6">* select correct building </font> '); //add input box
				    	return6=false;
				    }
				    return return1 && return2 && return3 && return4 && return5 && return6 ;
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
