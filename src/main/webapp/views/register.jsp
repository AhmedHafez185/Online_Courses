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
<title>Register</title>
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
<body id="register_bg">
	<div class="container">
		<form:form class="well form-horizontal" modelAttribute="student" 
			action="${pageContext.request.contextPath}/student/registerProcess " method="post" id="contact_form" enctype="multipart/form-data">
			<fieldset>
                            <center><h2 class="register-panel">
                                    <b style="text-align: center">SignUp</b>
                                </h2></center>
				
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">First Name</label>
					<div class="col-lg-6 col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i></span>
							<form:input name="firstName" path="firstName" placeholder="First Name" class="form-control" type="text"  />
							
						</div>
						<form:errors path="firstName" cssStyle="color:#ff0000"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">Last Name</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i></span>
							<form:input name="lastname" path="lastName" placeholder="Last Name" class="form-control" type="text"  />
							
						</div>
						<form:errors path="lastName" cssStyle="color:#ff0000"/>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">E Mail</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i class="glyphicon glyphicon-envelope"></i></span>
							<form:input path="email" name="email" placeholder="Email" class="form-control" type="email"  />
							
						</div>
						<form:errors path="email" cssStyle="color:#ff0000"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">Password</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i></span>
							<form:input name="password" path="password" placeholder="Password" class="form-control" type="password"  />
							
						</div>
						<form:errors path="password" cssStyle="color:#ff0000"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">Confirm Password</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group"> 
						<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i> </span>
							<form:input name="password" path="confirmPassword" placeholder="Confirm Password" class="form-control"
								type="password"  />
						</div>
						<form:errors path="confirmPassword" cssStyle="color:#ff0000"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">Birth Date</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i></span>
							<form:input name="birhdate" path="birthDate" placeholder="BirthDate" class="form-control" type="date"  />
							
						</div>
						<form:errors path="birthDate" cssStyle="color:#FF0000"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-lg-4 col-md-4 control-label">Upload Photo</label>
					<div class="col-lg-6 col-md-6 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<form:input path="profileImage" name="photo" class="form-control"
								type="file" accept="image/gif, image/jpeg, image/png"  />
							
						</div>
						<form:errors path="profileImage" cssStyle="color:#FF0000"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Gender</label>
					<div class="col-lg-6 col-md-6 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-list"></i>
							</span>
							<form:select path="gender"  name="gender"  class="form-control selectpicker" >
								<form:option value="" label="-- Select -- " />
                                                                <form:options items="${genderList}" />
							</form:select>
						</div>
						<form:errors path="gender" cssStyle="color:#FF0000"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label">Country</label>
					<div class="col-lg-6 col-md-6 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-list"></i>
							</span>
							<form:select path="country" name="country"
								class="form-control selectpicker" >
								<form:option value="" label="-- Select --"/>
								<%@include file="/resources/countries.html"%>
							</form:select>
						</div>
						<form:errors path="country" cssStyle="color:#FF0000"/>
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
			</fieldset>
		</form:form>
	</div>
</body>
</html>
