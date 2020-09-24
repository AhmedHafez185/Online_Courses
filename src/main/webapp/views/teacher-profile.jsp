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
                            <h1 class="fadeInUp"><span></span>Teacher detail</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->
                <div class="container margin_60_35">
                    <div class="row">
                        <aside class="col-lg-3" id="sidebar">
                            <div class="profile">
                                <figure><img src="${pageContext.request.contextPath}/resources/images/users/${instructor.photo}" alt="Teacher" class="profileImage rounded-circle"></figure>
                                <ul class="social_teacher">
                                    <li><a href="#"><i class="icon-facebook"></i></a></li>
                                    <li><a href="#"><i class="icon-twitter"></i></a></li>
                                    <li><a href="#"><i class="icon-linkedin"></i></a></li>
                                    <li><a href="#"><i class="icon-email"></i></a></li>
                                </ul>
                                <ul>
                                    <li>Name <span class="float-right">${instructor.firstName} ${instructor.lastName}</span> </li>
                                    <li>Students <span class="float-right">${noOfStudents}</span></li>
                                    <li>Courses <span class="float-right">${noOfCourses}</span></li>
                                </ul>
                            </div>
                        </aside>
                        <!--/aside -->

                        <div class="col-lg-9">
                            <div class="box_teacher">
                                <div class="indent_title_in">
                                    <i class="pe-7s-user"></i>
                                    <h3>Profile</h3>
                                    <p>${instructor.country}</p>
                                    <p>${instructor.instructorField.name}</p>
                                </div>
                                <div class="wrapper_indent">
                                    <p>${instructor.description}</p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <ul class="list_3">
                                                <li><strong>September 2009 - Bachelor Degree in Economics</strong>
                                                    <p>University of Cambrige - United Kingdom</p>
                                                </li>
                                                <li><strong>December 2012 - Master course in Economics</strong>
                                                    <p>University of Cambrige - United Kingdom</p>
                                                </li>
                                                <li><strong>October 2013 - Master's Degree in Statistic</strong>
                                                    <p>University of Oxford - United Kingdom</p>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="col-md-6">
                                            <ul class="list_3">
                                                <li><strong>September 2009 - Bachelor Degree in Economics</strong>
                                                    <p>University of Cambrige - United Kingdom</p>
                                                </li>
                                                <li><strong>December 2012 - Master course in Economics</strong>
                                                    <p>University of Cambrige - United Kingdom</p>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- End row-->
                                </div>
                                <!--wrapper_indent -->
                                <hr class="styled_2">
                                <div class="indent_title_in">
                                    <i class="pe-7s-display1"></i>
                                    <h3>My courses</h3>
                                    <p> <p>${instructor.instructorField.name}</p>.                                </div>
                                <div class="wrapper_indent">
                                        <table class="table table-responsive table-striped add_bottom_30">
                                        <thead>
                                            <tr>
                                                <th>Category</th>
                                                <th>Course name</th>
                                                <th>Rate</th>
                                                <th>Add Videos</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${instructor.courses}" var="course">
                                                <tr>
                                                    <td>${course.category.name}</td>
                                                    <td><a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">${course.title}</a></td>
                                                    <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star voted"></i></td>
                                                    <td><a href="${pageContext.request.contextPath}/courses/addLesson?courseId=${course.id}"> New Lesson</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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


        <!-- COMMON SCRIPTS -->
    </body>
</html>