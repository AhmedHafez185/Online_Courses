<%-- 
    Document   : courses
    Created on : Jul 23, 2020, 2:21:56 PM
    Author     : Ahmed Hafez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/resources/header.jsp" %>
    </head>
    <body>

        <div id="page">
           <%@ include file="/resources/navbar.jsp" %>
            <!-- /header -->

            <main>
                <section id="hero_in" class="courses">
                    <div class="wrapper">
                        <div class="container">
                            <h1 class="fadeInUp"><span></span>${categoryDetails.name}</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->
               

                <div class="container margin_60_35">
                    <div class="row">
                        <c:forEach items="${categoryDetails.courses}" var="course">
                            
                            <div class="col-xl-4 col-lg-6 col-md-6">
                            <div class="box_grid wow">
                                <figure class="block-reveal">
                                    <div class="block-horizzontal"></div>
                                    <a href="#0" class="wish_bt"></a>
                                    <a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">
                                        <div class="preview"><span>Preview course</span></div><img src="${pageContext.request.contextPath}/resources/images/courses/${course.picture}" class="img-fluid" alt=""></a>
                                    <div class="price">${course.price}$</div>
                                </figure>
                                <div class="wrapper">
                                    <small>${categoryDetails.name}</small>
                                    <h3><a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">${course.title}</a></h3>
                                    <p>${fn:substring(course.description, 0, 100)}...</p>
                                    <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i> <small>(145)</small></div>
                                </div>
                                <ul>
                                    <li><i class="icon_clock_alt"></i> ${courseDuration.get(course.id)}</li>
                                    <li><button class="btn btn-info"  onclick="addCourseToCart('${pageContext.request.contextPath}/ajaxController/addToCard/','${course.id}')"> Add To Cart Now </button></li>
                                </ul>
                            </div>
                        </div>
                        </c:forEach>
                        </div>
                    </div>
                    <!-- /row -->
                <!-- /container -->
                <div class="bg_color_1">
                    <div class="container margin_60_35">
                        <div class="row">
                            <div class="col-md-4">
                                <a href="#0" class="boxed_list">
                                    <i class="pe-7s-help2"></i>
                                    <h4>Need Help? Contact us</h4>
                                    <p>Cum appareat maiestatis interpretaris et, et sit.</p>
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="#0" class="boxed_list">
                                    <i class="pe-7s-wallet"></i>
                                    <h4>Payments and Refunds</h4>
                                    <p>Qui ea nemore eruditi, magna prima possit eu mei.</p>
                                </a>
                            </div>
                            <div class="col-md-4">
                                <a href="#0" class="boxed_list">
                                    <i class="pe-7s-note2"></i>
                                    <h4>Quality Standards</h4>
                                    <p>Hinc vituperata sed ut, pro laudem nonumes ex.</p>
                                </a>
                            </div>
                        </div>
                        <!-- /row -->
                    </div>
                    <!-- /container -->
                </div>
                <!-- /bg_color_1 -->
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
</html>
