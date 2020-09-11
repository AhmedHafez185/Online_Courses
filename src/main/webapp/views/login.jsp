<%-- 
    Document   : login
    Created on : Jul 23, 2020, 3:08:12 PM
    Author     : Ahmed Hafez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description"
              content="Udema a modern educational site template">
        <meta name="author" content="Ansonika">
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/resources/css/style.css"
              rel="stylesheet" />
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/js/login/bootstrap.min.css" />
        <script
        src="${pageContext.request.contextPath}/resources/js/login/jquery.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/js/login/bootstrap.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/js/login/validator.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/js/login/bootstrap-validate.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/js/login/validator.js"></script>

        <link
            href="${pageContext.request.contextPath}/resources/css/edited-style.css"
            rel="stylesheet" />
    </head>
    <body id="login_bg">
        <div class="container">
            <form class="well form-horizontal" action="${pageContext.request.contextPath}/login " method="post" id="contact_form">
                <fieldset>
                    <h2 class="register-panel">
                        <b>Login Form</b>
                    </h2>			
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-lg-4 col-md-4 control-label">E Mail</label>
                        <div class="col-lg-6 col-md-6 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"> <i class="glyphicon glyphicon-envelope"></i></span>
                                <input  name="username" placeholder="Email" class="form-control" type="email"  />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-4 col-md-4 control-label">Password</label>
                        <div class="col-lg-6 col-md-6 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i></span>
                                <input name="password"  placeholder="Password" class="form-control" type="password"  />	
                            </div>
                        </div>
                    </div>	
                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-lg-4 col-md-4 control-label"></label>
                        <div class="col-lg-6 col-md-6">
                            <button type="submit" class="btn btn-success">
                                SUBMIT <span class="glyphicon glyphicon-send"></span>
                            </button>
                        </div>
                    </div>
                    <div class="text-center add_top_10">New to Udema? <strong><a href="${pageContext.request.contextPath}/instructor/register">Sign up!</a></strong></div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
