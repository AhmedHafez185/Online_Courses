<%-- 
    Document   : index
    Created on : Jul 22, 2020, 9:45:46 AM
    Author     : Ahmed Hafez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/resources/header.jsp" %>
    </head>
    <body>
        <div id="page">
            <%@ include file="/resources/navbar.jsp" %>


            <main>
                <section class="hero_single">
                    <div class="wrapper">
                        <div class="container">
                            <h3><strong>Top courses</strong><br>on Udema Accademy</h3>
                            <p>Eam fastidii erroribus corrumpit cu, in quo epicuri recusabo, <strong>est vocent eleifend</strong> inimicus at.</p>
                        </div>
                        <a href="#first_section" class="btn_explore hidden_tablet"><i class="ti-arrow-down"></i></a>
                    </div>
                </section>
                <!-- /hero_single -->

                <div class="features clearfix">
                    <div class="container">
                        <ul>
                            <li><i class="pe-7s-study"></i>
                                <h4>+200 courses</h4><span>Explore a variety of fresh topics</span>
                            </li>
                            <li><i class="pe-7s-cup"></i>
                                <h4>Expert teachers</h4><span>Find the right instructor for you</span>
                            </li>
                            <li><i class="pe-7s-target"></i>
                                <h4>Focus on target</h4><span>Increase your personal expertise</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /features -->

                <div class="container-fluid margin_120_0" id="first_section">
                    <div class="main_title_2">
                        <span><em></em></span>
                        <h2>Udema Popular Courses</h2>
                        <p>Cum doctus civibus efficiantur in imperdiet deterruisset.</p>
                    </div>
                    <div id="reccomended" class="owl-carousel owl-theme">
                        <c:forEach items="${courses}" var="course">
                            
                            <div class="item">
                            <div class="box_grid">
                                <figure>
                                    <a href="#0" class="wish_bt"></a>
                                    <a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">
                                        <div class="preview"><span>Preview course</span></div><img src="${pageContext.request.contextPath}/resources/images/courses/${course.picture}" class="img-fluid" alt=""></a>
                                    <div class="price">${course.price}$</div>

                                </figure>
                                <div class="wrapper">
                                    <small>${course.category.name}</small>
                                    <h3><a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">${course.title}</a></h3>
                                    <p>${course.instructor.firstName} ${course.instructor.lastName}</p>
                                    <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i> <small>(145)</small></div>
                                </div>
                                <ul>
                                    <li><i class="icon_clock_alt"></i> 1h 30min</li>
                                    <li><i class="icon_like"></i> 890</li>
                                    <li><a href="course-detail.html">Enroll now</a></li>
                                </ul>
                            </div>
                        </div>
                        </c:forEach>
                        
                        <!-- /item -->
                        
                        <!-- /item -->
                        
                        <!-- /item -->
                    </div>
                    <!-- /carousel -->
                    <div class="container">
                        <p class="btn_home_align"><a href="courses-grid.html" class="btn_1 rounded">View all courses</a></p>
                    </div>
                    <!-- /container -->
                    <hr>
                </div>
                <!-- /container -->

                <div class="container margin_30_95">
                    <div class="main_title_2">
                        <span><em></em></span>
                        <h2>Udema Categories Courses</h2>
                        <p>Cum doctus civibus efficiantur in imperdiet deterruisset.</p>
                    </div>
                    <div class="row">
                        <c:forEach items="${categories}" var="category">
                            <div class="col-lg-4 col-md-6 wow" data-wow-offset="150">
                                <a href="${pageContext.request.contextPath}/views/courses.jsp?catId=${category.id}" class="grid_item">
                                    <figure class="block-reveal">
                                        <div class="block-horizzontal"></div>
                                        <img src="${pageContext.request.contextPath}/resources/images/category/${category.picture}" class="category-img img-fluid" alt="">
                                        <div class="info">
                                            <small><i class="ti-layers"></i>15 Programmes</small>
                                            <h3>${category.name}</h3>
                                        </div>
                                    </figure>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->


                <div class="call_section">
                    <div class="container clearfix">
                        <div class="col-lg-5 col-md-6 float-right wow" data-wow-offset="250">
                            <div class="block-reveal">
                                <div class="block-vertical"></div>
                                <div class="box_1">
                                    <h3>Enjoy a great students community</h3>
                                    <p>Ius cu tamquam persequeris, eu veniam apeirian platonem qui, id aliquip voluptatibus pri. Ei mea primis ornatus disputationi. Menandri erroribus cu per, duo solet congue ut. </p>
                                    <a href="#0" class="btn_1 rounded">Read more</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/call_section-->
            </main>
            <!-- /main -->

            <!-- footer -->

            <%@ include file="/resources/footer.jsp" %>
            <!--/footer-->
        </div>
        <!-- page -->
        <%@ include file="/resources/scripts.jsp" %>  


        <!-- COMMON SCRIPTS -->

    </body>
</html>
