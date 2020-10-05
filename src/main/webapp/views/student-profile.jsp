<%-- 
    Document   : teacher-profile
    Created on : Jul 23, 2020, 3:10:08 PM
    Author     : Ahmed Hafez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="/resources/header.jsp" %>
    </head>
    <body>
        <div id="page" class="theia-exception">
            <%@ include file="/resources/navbar.jsp" %>
            <main>
                <section id="hero_in" class="general">
                    <div class="wrapper">
                        <div class="container">
                            <h1 class="fadeInUp"><span></span>Student detail</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->
                <div class="container margin_60_35">
                    <div class="row">
                        <aside class="col-lg-3" id="sidebar">
                            <div class="profile">
                                <figure><img src="${pageContext.request.contextPath}/resources/images/users/${student.photo}" alt="Student" class="profileImage rounded-circle"></figure>

                                <ul>
                                    <li>Name <span class="float-right">${user.fullName}</span> </li>
                                    <li>E-Mail <span class="float-right">${user.email}</span> </li>
                                    <li>Country <span class="float-right">${student.country}</span></li>
                                    <li>Birth Date <span class="float-right">${student.birthDate}</span></li>
                                </ul>
                            </div>
                        </aside>
                        <!--/aside -->
                        <div class="col-lg-9">
                            <div class="box_teacher">
                                <div class="indent_title_in">
                                    <i class="pe-7s-display1"></i>
                                    <h3>Enrolled Courses</h3>
                                </div>
                                <div class="wrapper_indent">
                                    <c:if test="${buyedEnrollment.size() <= 0}">
                                        <p class="alert alert-info">There is Not Enrolled Courses</p>
                                    </c:if>
                                    <c:if test="${buyedEnrollment.size() > 0}">
                                        <table class="table table-responsive table-striped add_bottom_30">
                                            <thead>
                                                <tr>
                                                    <th>Category</th>
                                                    <th>Course name</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="enrollment" items="${buyedEnrollment}">
                                                    <c:if test="${enrollment.status == 'ENROLL'}">
                                                        <tr>
                                                            <td>${enrollment.course.category.name}</td>
                                                            <td><a href="#">${enrollment.course.title}</a></td>
                                                            <td>${enrollment.course.price}</td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </c:if>
                                </div>
                                <div class="indent_title_in">
                                    <i class="pe-7s-display1"></i>
                                    <h3>My Card Courses</h3>
                                </div>
                                <div class="wrapper_indent">
                                    <c:if test="${cardEnrollment.size() <= 0}">
                                        <p class="alert alert-info">The Card Is Empty</p>
                                    </c:if>
                                    <c:if test="${cardEnrollment.size() > 0}">
                                        <table class="table table-responsive table-striped add_bottom_30">
                                            <thead>
                                                <tr>
                                                    <th>Category</th>
                                                    <th>Course name</th>
                                                    <th>Price</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="enrollment" items="${cardEnrollment}">
                                                    <c:if test="${enrollment.status == 'CARD'}">
                                                        <tr id="enrollCourse${enrollment.id}">
                                                            <td>${enrollment.course.category.name}</td>
                                                            <td><a href="#">${enrollment.course.title}</a></td>
                                                            <td>${enrollment.course.price}</td>
                                                            <td>
                                                                <button  onclick="deleteCartCourse('${pageContext.request.contextPath}/ajaxController/deleteCardItem/','${enrollment.id}')" class="btn btn-danger" >Delete</button>
                                                                <button id="buyCourse" class="btn btn-primary">Buy</button>
                                                            </td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </c:if>
                                </div>
                                <!--wrapper_indent -->
                            </div>
                        </div>
                        <!-- /col -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </main>	
            <!--/main-->

            <%@ include file="/resources/footer.jsp" %>
            <!--/footer-->
        </div>
        <!-- page -->
        <%@ include file="/resources/scripts.jsp" %>  
        <script type="text/javascript">
                function deleteCartCourse(u,id) {
                $.ajax({
                    type: "DELETE",
                    url: u+id,
                    success: function (data) {
                        if(data.messageType === "success"){
                            $('#enrollCourse' + id).remove();
                        }  
                        swal(data.message, data.messageTitle, data.messageType);

                    },
                    error: function (e) {
                        swal("Error", "Deleting Course", "error");
                    }
                });
                }
               
        </script>

        <!-- COMMON SCRIPTS -->
    </body>
</html>