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
                    <a class="navbar-brand" href="#">
                        Time Table Management System
                    </a>
                </div>
                <form class="navbar-form navbar-right">
                    <button type="submit" class="btn btn-default"><i class="">Sign out</button>
                </form>
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
                                    <span class="glyphicon glyphicon-user"></span> Building <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl11" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="/controller/building/insertBuilding" target="contentframe">Add Building</a></li>
                                            <li><a href="/controller/building/viewBuilding" target="contentframe">View Building</a></li>
                                            <li><a href="/controller/classroom/insertClassroom" target="contentframe">Link</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-plane"></span> Active Link</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-cloud"></span> Link</a></li>

                            <!-- Dropdown-->
                            <li class="panel panel-default" id="dropdown">
                                <a data-toggle="collapse" href="#dropdown-lvl1">
                                    <span class="glyphicon glyphicon-user"></span> Sub Level <span class="caret"></span>
                                </a>

                                <!-- Dropdown level 1 -->
                                <div id="dropdown-lvl1" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul class="nav navbar-nav">
                                            <li><a href="#">Link</a></li>
                                            <li><a href="#">Link</a></li>
                                            <li><a href="#">Link</a></li>

                                            <!-- Dropdown level 2 -->
                                            <li class="panel panel-default" id="dropdown">
                                                <a data-toggle="collapse" href="#dropdown-lvl2">
                                                    <span class="glyphicon glyphicon-off"></span> Sub Level <span class="caret"></span>
                                                </a>
                                                <div id="dropdown-lvl2" class="panel-collapse collapse">
                                                    <div class="panel-body">
                                                        <ul class="nav navbar-nav">
                                                            <li><a href="#">Link</a></li>
                                                            <li><a href="#">Link</a></li>
                                                            <li><a href="#">Link</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li><a href="#"><span class="glyphicon glyphicon-signal"></span> Link</a></li>

                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
            </div>
        </div>
        <div class="container-fluid">
            <div class="side-body">
                    <iframe name="contentframe" src="" style="border:none" width="100%" height="700px"></iframe>
            </div>
        </div>
    </body>
</html>