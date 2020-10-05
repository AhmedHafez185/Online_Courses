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
                            <h1 class="fadeInUp"><span></span>Search</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->
                <div class="container margin_60_35">
                    <c:if test="${test == 1}">
                        <p class="alert alert-danger">${message}</p>
                    </c:if>
                    <c:if test="${test != 1}">
                        <p class="alert alert-success">${message}</p>
                        <c:if test="${courses.size() > 0}">
                            <c:forEach items="${courses}" var="course">
                                <div class="box_list wow">
                                    <div class="row no-gutters">
                                        <div class="col-lg-5">
                                            <figure class="block-reveal">
                                                <div class="block-horizzontal"></div>
                                                <a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}"><img src="${pageContext.request.contextPath}/resources/images/courses/${course.picture}" style="width: 100%;height: 100%" class="img-fluid" alt=""></a>
                                                <div class="preview"><span>Preview course</span></div>
                                            </figure>
                                        </div>
                                        <div class="col-lg-7">
                                            <div class="wrapper">
                                                <a href="#0" class="wish_bt"></a>
                                                <div class="price">$${course.price}</div>
                                                <small>${course.category.name}</small>
                                                <h3><a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">${course.title}</a></h3>
                                                <p>${fn:substring(course.description, 0, 200)} ...</p>
                                                <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i> <small>(145)</small></div>
                                            </div>
                                            <ul>
                                                <li><i class="icon_clock_alt"></i> ${coursePeriod.get(course.id)}</li>
                                                <li><button class="btn btn-info"  onclick="addCourseToCart('${pageContext.request.contextPath}/ajaxController/addToCard/', '${course.id}')"> Add To Cart Now </button></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </c:if>
                </div>
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
