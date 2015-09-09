<%-- 
    Document   : login
    Created on : Jul 14, 2015, 4:32:08 PM
    Author     : Amila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="<c:url value="/resources/htmlCSS/signin.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.css" />" rel="stylesheet">
        <link type="text/css" href="<c:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />" rel="stylesheet">
        <link type="text/css" href="htmlCSS/signin.css" rel="stylesheet"/>
        <link type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet"/>
        <link type="text/css" href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>

        <div class="container" style="width: 500px; height: 1000px; ">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-signin">
                        <h2 class="form-signin-heading">Please sign in</h2>
                        <label for="inputUsername" class="sr-only">User Name</label>
                        <input type="text" id="inputUserName" class="form-control" placeholder="User Name" required autofocus>
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
