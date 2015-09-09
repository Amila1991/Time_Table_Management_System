<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link
	href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />"
	rel="stylesheet">


<link href="<c:url value="/resources/htmlCSS/dashboard.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/htmlCSS/sidebar.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/JQuery/jquery-1.11.0.min.js" />"></script>

<script src="<c:url value="/resources/htmlJS/sidebar.js" />"></script>

<script
	src="<c:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />"></script>
<link type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	
</script>

<title>Time Table Generator</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Time Table Management System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="#">Home</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Sign out</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

	<div class="panel panel-primary" style="margin-top: 20px; margin-left: 10px; margin-right: 10px">
		<div class="panel-heading"><h3>Time Table Generator</h3></div>
		<div class="panel-body">
			<form action="/University_Time_Table_Management_System/timetable/generatetimetable" method="POST" id="modulepanel">
				<div class="form-inline" style="margin-bottom: 10px">
					<div class="form-group" style="margin-bottom: 10px ; margin-right: 20px">
						<label for="department">Department</label> <input type="text"
							class="form-control" id="department0" name="department0"
							placeholder="Department" style="width: 300px">
					</div>
					<div class="form-group" style="margin-bottom: 10px; margin-right: 20px">
						<label for="batch">Batch</label> <input type="text"
							class="form-control" id="batch" name="batch"
							placeholder="Batch">
					</div>
					<div class="form-group" style="margin-bottom: 10px">
						<label for="semester">Semester</label> <input type="text"
							class="form-control" id="semester" name="semester"
							placeholder="Semester">
					</div>
				</div>
				<div class="row">
					<div class="col-md-6" id="modulepanel0">
						<div class="panel panel-default">
							<div class="panel-heading">Module 1</div>
							<div class="panel-body">
								<div class="form-group">
									<label for="department">Department</label> <input type="text"
										class="form-control" id="department1" name="schedules[0].departmentName"
										placeholder="Department">
								</div>
								<div class="form-group">
									<label for="module">Module</label> <input type="text"
										class="form-control" id="module1" name="schedules[0].moduleTitle"
										value="${Module}" placeholder="Module">
								</div>
								<div class="form-group">
									<label for="classroom">Classroom</label> <input type="text"
										class="form-control" id="classroom1" name="schedules[0].classroomName"
										placeholder="Classroom">
								</div>

								<div class="form-group">
									<label for="lecturer1">Lecturer</label> 
									<br>
									<!--  <input type="text"
										class="form-control" id="lecturer" name="schedules[0].lecturers"
										placeholder="Lecturer">-->
										<select class="form-control" id="lecturer1" name="schedules[0].lecturerNames" multiple>
										</select>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6" id="modulepanel1"></div>
				</div>
				<div class="form-group">
					<button class="btn btn-default" id="add_field_button">Add More Modules</button>
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</form>
			
		</div>
	</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var max_fields = 15; //maximum input boxes allowed
							var wrapper0 = $("#modulepanel0"); //Fields wrapper
							var wrapper1 = $("#modulepanel1"); //Fields wrapper
							var add_button = $("#add_field_button"); //Add button ID

							var availableTags = [ "ActionScript",
									"AppleScript", "Asp", "BASIC", "C", "C++",
									"Clojure", "COBOL", "ColdFusion", "Erlang",
									"Fortran", "Groovy", "Haskell", "Java",
									"JavaScript", "Lisp", "Perl", "PHP",
									"Python", "Ruby", "Scala", "Scheme" ];
							
							var semesterList = [ "Semester 1",
													"Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6",
													"Semester 7", "Semester 8" ];
							var moduleList=[];
							
							$("#semester").autocomplete({
								source : semesterList
							});
							var departmentList = [];
						  	  <c:forEach var="department" items="${DepartmentList}" varStatus="status">
						  		departmentList.push("${department.departmentName}"); 
						   	  </c:forEach>
						   	  
						   	var classroomList = [];
						  	  <c:forEach var="classroom" items="${ClassroomList}" varStatus="status">
						  		classroomList.push("${classroom.classroomName}"); 
						   	  </c:forEach>
						   	  
						   	var batchList = [];
						  	  <c:forEach var="batch" items="${BatchList}" varStatus="status">
						  		batchList.push("${batch.batchName}"); 
						   	  </c:forEach>	  
						  
						   	  
						   	$("#department0").autocomplete({
								source : departmentList
							});  
						   	  
							$("#department1").autocomplete({
								source : departmentList
							});
							
							$("#classroom1").autocomplete({
								source : classroomList
							});
							
							$("#batch").autocomplete({
								source : batchList
							});

							var x = 1; //initlal text box count
							$(add_button)
									.click(
											function(e) { //on add input button click
												e.preventDefault();
												if (x < max_fields) { //max input box allowed
													x++; //text box increment
													if (x % 2 == 1) {
														$(wrapper0)
																.append(
																		'<div class="panel panel-default"><div class="panel-heading">Module '
																				+ x
																				+ '</div><div class="panel-body"><div class="form-group"><label for="department">Department</label><input type="text" class="form-control" id="department' +x+'" name="schedules[' +(x-1)+'].departmentName" placeholder="Department"></div><div class="form-group"><label for="module">Module</label><input type="text"class="form-control" id="module' +x+'" name="schedules[' +(x-1)+'].moduleTitle" value="${Module}" placeholder="Module"></div><div class="form-group"><label for="classroom">Classroom</label><input type="text" class="form-control" id="classroom' +x+'" name="schedules[' +(x-1)+'].classroomName" placeholder="Classroom"></div><div class="form-group"><label for="lecturer">Lecturer</label><br><select class="form-control" id="lecturer' +x+'" name="schedules[' +(x-1)+'].lecturerNames" multiple></select></div></div></div>'); //add input box
													} else {
														$(wrapper1)
																.append(
																		'<div class="panel panel-default"><div class="panel-heading">Module '
																				+ x
																				+ '</div><div class="panel-body"><div class="form-group"><label for="department">Department</label><input type="text" class="form-control" id="department' +x+'" name="schedules[' +(x-1)+'].departmentName" placeholder="Department"></div><div class="form-group"><label for="module">Module</label><input type="text"class="form-control" id="module' +x+'" name="schedules[' +(x-1)+'].moduleTitle" value="${Module}" placeholder="Module"></div><div class="form-group"><label for="classroom">Classroom</label><input type="text" class="form-control" id="classroom' +x+'" name="schedules[' +(x-1)+'].classroomName" placeholder="Classroom"></div><div class="form-group"><label for="lecturer">Lecturer</label><br><select class="form-control" id="lecturer' +x+'" name="schedules[' +(x-1)+'].lecturerNames" multiple></select></div></div></div>'); //add input box

													}
													$("#department" + x)
															.autocomplete(
																	{
																		source : departmentList
																	});
													
													$("#classroom"+x).autocomplete({
														source : classroomList
													});
													
													$("#department"+x).keydown(function(e) { //user click on remove text
														var dep=document.getElementById('department'+x).value;
														 $.ajax({
														        type : 'POST',
														        url : "/University_Time_Table_Management_System/timetable/abc",
														        //dataType : 'json',
														        data: { department: dep },
														        //contentType : 'application/json',
														        success : function(data) {
														           //here in data variable, you will get list of all users sent from 
														           // spring controller in json format, currently its object
														           // iterate it and show users on page
																	set=data.split("//");
																	list=set[0].split(",");
																	moduleList[x-1]=list;
																	//moduleList.push(list);
																	list=set[1].split(",");
																	var y = document.getElementById("lecturer"+x);
																	var len=$('#lecturer'+x+' > option').length;
																	for (var i = 0; i < len ; i++) {
																		y.remove(0);
																	}
																	for (var i = 0; i < list.length; i++) {
																		var option = document.createElement("option");
																		option.text = list[i];
																		y.add(option, y[i]);
																	}
																	
														        },
														        error : function(e) {
														            alert('error  '+e);
														        }
														    });
														})
														
														
														$("#module"+x).focusin(function(e) { //user click on remove text
															$("#module"+x).autocomplete({
																source : moduleList[x-1]
																});
														
														})
														

												}
												//return false;
							});

							$("#department1").keydown(function(e) { //user click on remove text
								var dep=document.getElementById('department1').value;
								 $.ajax({
								        type : 'POST',
								        url : "/University_Time_Table_Management_System/timetable/abc",
								        //dataType : 'json',
								        data: { department: dep },
								        //contentType : 'application/json',
								        success : function(data) {
								           //here in data variable, you will get list of all users sent from 
								           // spring controller in json format, currently its object
								           // iterate it and show users on page
											set=data.split("//");
											list=set[0].split(",");
											moduleList[0]=list;
											//moduleList.push(list);
											list=set[1].split(",");
											var y = document.getElementById("lecturer1");
											var len=$('#lecturer1 > option').length;
											for (var i = 0; i < len ; i++) {
												y.remove(0);
											}
											for (var i = 0; i < list.length; i++) {
												var option = document.createElement("option");
												option.text = list[i];
												y.add(option, y[i]);
											}
											
								        },
								        error : function(e) {
								            alert('error  '+e);
								        }
								    });
								})
								
								
								$("#module1").focusin(function(e) { //user click on remove text
									$("#module1").autocomplete({
										source : moduleList[0]
										});
								
								})
								/*$("#module1").on("click",
									function(e) { //user click on remove text
								 $.ajax({
								        type : 'POST',
								        url : '/University_Time_Table_Management_System/timetable/abc',
								        //dataType : 'json',
								        //data : JSON.stringify(user),
								        //contentType : 'application/json',
								        success : function(data) {
								           //here in data variable, you will get list of all users sent from 
								           // spring controller in json format, currently its object
								           // iterate it and show users on page
											$(wrapper1).append(data+'  ');
								           var list=data.split(",");
								           $(wrapper1).append(list.length+" , ");
								           for(var i=0;i<list.length;i++){
								        	   availableTags.push(list[i]);
								        	   $(wrapper1).append(list[i]+"/");
								           }
								        },
								        error : function(e) {
								            alert('error  '+e);
								        }
								    });

									$("#module1").autocomplete({
									source : availableTags
								});
								
								})*/
						});
	</script>



</body>
</html>