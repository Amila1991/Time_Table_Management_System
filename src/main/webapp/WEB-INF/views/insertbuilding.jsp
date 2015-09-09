<%-- 
    Document   : insertbuilding
    Created on : Aug 12, 2015, 2:54:11 PM
    Author     : Amila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />"
	rel="stylesheet" />
	<script src="<c:url value="/resources/JQuery/jquery-1.11.0.min.js" />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<title>Insert Building</title>
</head>
<body>
	<div id="page-wrapper"
		style="margin-top: 10px; margin-left: 10px; margin-right: 20px">
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">Add Building</h1>
			</div>
			<!-- /.col-md-12 -->
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<h3>Insert Building Form</h3>
				<div class="row">
					<div class="col-md-6">
						<form action="/University_Time_Table_Management_System/building/addBuilding" id="aa" method="POST" onsubmit="return validateForm()">
							<div class="form-group">
								<label for="buildingID">Building ID</label> <input type="text"
									class="form-control" id="buildingId" name="buildingId"
									value="${BuildingID}" readonly>
							</div>
							<div class="form-group">
								<label for="buildingName">Building Name<font color="red">*</font></label> <input
									type="text" class="form-control" id="buildingName"
									name="buildingName" placeholder="Building Name">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
							<br><font color="red">*required detail</font>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	function validateForm() {
		var wrapper0 = $("#buildingName");
		var wrapper1 = $("#aa");
	    var x = document.getElementById('buildingName').value;
	    $("#warning").remove();
	    if (x == null || x == "") {
	    	$(wrapper0).after('<font color="red" id="warning">* required</font> '); //add input box
	       // alert("Name must be filled out");
	        return false;
	    }
	}
	</script>
</body>
</html>
