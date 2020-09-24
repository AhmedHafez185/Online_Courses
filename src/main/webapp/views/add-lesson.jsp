<%-- 
    Document   : login
    Created on : Jul 23, 2020, 3:08:12 PM
    Author     : Ahmed Hafez
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="/resources/headerAdmin.jsp" %>
    </head>
    <body class="fixed-nav sticky-footer" id="page-top">
        <%@ include file="/resources/navbarFixed.jsp" %>
        <div class="content-wrapper">
            <div class="container-fluid">
                <form:form class="well form-horizontal" modelAttribute="content"
                           action="${pageContext.request.contextPath}/courses/saveLesson" method="post" enctype="multipart/form-data">
                    <div class="box_general padding_bottom">
                        <div class="header_box version_2">
                            <form:hidden path="CourseId" value="${course.id}"/>
                            <h2><i class="fa fa-file"></i>${course.title} Course </h2>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Lesson Title</label>
                                    <form:input name="title" path="title" class="form-control" type="text"  />
                                </div>
                                <form:errors path="title" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                         <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Lesson Video</label>
                                    <form:input id="uploadedLesson" name="video" path="lessonVideo" class="form-control" type="file" accept="video/*"  />
                                </div>
                                <form:errors path="lessonVideo" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                                <form:hidden path="period" id="vidDuration" value="0"/>
                        <!-- /row-->
                    </div>
                    <!-- /box_general-->

                    <div class="box_general padding_bottom">
                        <div class="header_box version_2">
                            <h2><i class="fa fa-file-text"></i>More Info</h2>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Lesson description</label>
                                    <form:textarea path="description" rows="5" class="form-control" style="height:100px;" placeholder="Description" />
                                </div>
                                <form:errors path="description" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Lesson Outline <a href="#0" data-toggle="tooltip" data-placement="top" title="Separated by commas"><i class="fa fa-fw fa-question-circle"></i></a></label>
                                            <form:select path="topicId" 
                                                         class="form-control selectpicker" >
                                                <form:option value="" label="-- Select -- " />
                                                <c:forEach items="${course.outlines}" var="topic">
                                                    <form:option value="${topic.id}">${topic.outline}</form:option>
                                                </c:forEach>
                                    </form:select>
                                </div>
                                <form:errors path="topicId" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                    </div>                   
                    <!-- /box_general-->
                    <button type="submit" class="btn btn-success">Save Lesson</button>
                </form:form>
            </div>
            <!-- /.container-fluid-->
        </div>
        <!-- /.container-wrapper-->
        <!-- page -->
        <%@ include file="/resources/scriptAdmin.jsp" %>  
        <!-- COMMON SCRIPTS -->
        <script src="${pageContext.request.contextPath}/resources/js/addLesson.js"></script>

    </body>
</html>