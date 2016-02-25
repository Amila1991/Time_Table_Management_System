<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />" rel="stylesheet">
        
        <link href="<c:url value="/resources/htmlCSS/dashboard.css" />" rel="stylesheet">
        
        <link href="<c:url value="/resources/htmlCSS/sidebar.css" />" rel="stylesheet">
        
        <script src="<c:url value="/resources/JQuery/jquery-1.11.0.min.js" />"></script>
        
        <script src="<c:url value="/resources/htmlJS/sidebar.js" />"></script>
        
        <script src="<c:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />"></script>
        
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
            <li><a href="<%=request.getContextPath()%>/admin">Home</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<%=request.getContextPath()%>/">Sign out</a></li>
          </ul>
        </div>
      </div>
    </nav>
       

        <div class="row">
            <!-- uncomment code for absolute positioning tweek see top comment in css -->
            <!-- <div class="absolute-wrapper"> </div> -->
            <!-- Menu -->
            <div class="side-menu">

                <nav class="navbar navbar-default" role="navigation">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <div class="brand-wrapper">
                            <!-- Hamburger -->
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>

                            <!-- Brand -->
                            <div class="brand-name-wrapper">
                                <a class="navbar-brand" href="#">
                                    Brand
                                </a>
                            </div>

                            <!-- Search -->
                            <a data-toggle="collapse" href="#search" class="btn btn-default" id="search-trigger">
                                <span class="glyphicon glyphicon-search"></span>
                            </a>

                            <!-- Search body -->
                            <div id="search" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <form class="navbar-form" role="search">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                        <button type="submit" class="btn btn-default "><span class="glyphicon glyphicon-ok"></span></button>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Main Menu -->
                    <div class="side-menu-container">
                        <ul class="nav navbar-nav">

                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl11">
                                    <span class="glyphicon glyphicon-ok"></span> Building <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl11" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="<%=request.getContextPath()%>/building/insertBuilding" target="contentframe">Add Building</a></li>
                                            <li><a href="<%=request.getContextPath()%>/building/viewBuilding" target="contentframe">View Building</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl12">
                                    <span class="glyphicon glyphicon-ok"></span> Classroom <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl12" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="<%=request.getContextPath()%>/classroom/insertClassroom" target="contentframe">Add Classroom</a></li>
                                            <li><a href="<%=request.getContextPath()%>/classroom/viewClassroom" target="contentframe">View Classroom</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl13">
                                    <span class="glyphicon glyphicon-ok"></span> Module <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl13" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="<%=request.getContextPath()%>/module/insertModule" target="contentframe">Add Module</a></li>
                                            <li><a href="<%=request.getContextPath()%>/module/viewModule" target="contentframe">View Module</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl14">
                                    <span class="glyphicon glyphicon-ok"></span> Lecturer <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl14" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="<%=request.getContextPath()%>/lecturer/insertLecturer" target="contentframe">Add Lecturer</a></li>
                                            <li><a href="<%=request.getContextPath()%>/lecturer/viewLecturer" target="contentframe">View Lecturer</a></li>
                                            <li><a href="" target="contentframe">Link</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl15">
                                    <span class="glyphicon glyphicon-ok"></span> Department <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl15" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="<%=request.getContextPath()%>/department/insertDepartment" target="contentframe">Add Department</a></li>
                                            <li><a href="<%=request.getContextPath()%>/department/viewDepartment" target="contentframe">View Department</a></li>
                                            
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li><a href="<%=request.getContextPath()%>/timetable/timetablegeneration"><span class="glyphicon glyphicon-off"></span> Time Table Generation</a></li>
							<li><a href="<%=request.getContextPath()%>/timetable/timetableview" target="contentframe"><span class="glyphicon glyphicon-off"></span> View Time Table</a></li>
							
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
            </div>
        </div>
        <div class="container-fluid">
            <div class="side-body">
                    <iframe name="contentframe"  src="<%=request.getContextPath()%>/timetable/timetableview" style="border:none" width="100%" height="700px"></iframe>
            </div>
        </div>
    </body>
</html>