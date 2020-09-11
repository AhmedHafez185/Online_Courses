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
                <form:form class="well form-horizontal" modelAttribute="course"
                           action="${pageContext.request.contextPath}/courses/saveCourse " method="post" enctype="multipart/form-data">
                    <div class="box_general padding_bottom">
                        <div class="header_box version_2">
                            <h2><i class="fa fa-file"></i>New Course</h2>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Course title</label>
                                    <form:input type="text" path="title" class="form-control" placeholder="Course title" />
                                </div>
                                <form:errors path="title" cssStyle="color:#ff0000"/>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Course price</label>
                                    <form:input type="number" path="price" class="form-control" placeholder="Course Price In Dolar"/>
                                </div>
                                <form:errors path="price" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Start Date</label>

                                    <form:input type="date" path="startDate" class="form-control" placeholder="Course Start Date" />
                                </div>
                                <form:errors path="startDate" cssStyle="color:#ff0000"/>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Finish Date</label>
                                    <form:input type="date" path="endDate" class="form-control" placeholder="Course Finish Date" />
                                </div>
                                <form:errors path="endDate" cssStyle="color:#ff0000"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Course picture</label>
                                    <form:input name="photo" path="coursePic" class="form-control" type="file" accept="image/gif, image/jpeg, image/png"  />
                                </div>
                                <form:errors path="coursePic" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                    </div>
                    <!-- /box_general-->

                    <div class="box_general padding_bottom">
                        <div class="header_box version_2">
                            <h2><i class="fa fa-file-text"></i>Description</h2>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Course description</label>
                                    <form:textarea path="description" rows="5" class="form-control" style="height:100px;" placeholder="Description" />
                                </div>
                                <form:errors path="description" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Category <a href="#0" data-toggle="tooltip" data-placement="top" title="Separated by commas"><i class="fa fa-fw fa-question-circle"></i></a></label>
                                            <form:select path="category" 
                                                         class="form-control selectpicker" >
                                                <form:option value="" label="-- Select -- " />
                                                <c:forEach items="${categories}" var="category">
                                                    <form:option value="${category.id}" label="${category.name}" />
                                                </c:forEach>
                                            </form:select>
                                </div>
                                <form:errors path="category" cssStyle="color:#ff0000"/>
                            </div>
                        </div>
                        <!-- /row-->
                    </div>
                    <!-- /box_general-->
                    <div class="box_general padding_bottom">
                        <div class="header_box version_2">
                            <h2><i class="fa fa-video-camera"></i>Course Outlines</h2>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <h6>Outline</h6>
                                <table id="pricing-list-container" style="width:100%;">
                                    <tr class="pricing-list-item">
                                        <td>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <form:input type="text" path="listOfOutlines" class="form-control"  placeholder="Video title"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="form-group">
                                                        <a class="delete" href="#"><i class="fa fa-fw fa-remove"></i></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                                <a href="#0" class="btn_1 gray add-pricing-list-item"><i class="fa fa-fw fa-plus-circle"></i>Add Item</a>
                            </div>
                        </div>
                        <!-- /row-->
                    </div>
                    <!-- /box_general-->
                    <button type="submit" class="btn btn-success">
                        Save <span class="glyphicon glyphicon-send"></span>
                    </button>
                </form:form>
            </div>
            <!-- /.container-fluid-->
        </div>
        <!-- /.container-wrapper-->
        <!-- page -->
        <%@ include file="/resources/scriptAdmin.jsp" %>  
        <!-- COMMON SCRIPTS -->
    </body>
</html>