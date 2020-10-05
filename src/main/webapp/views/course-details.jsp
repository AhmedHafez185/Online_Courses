<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/resources/header.jsp" %>

    </head> 
    <body>
        <div id="page" class="theia-exception">
            <%@ include file="/resources/navbar.jsp" %>
            <!-- /header -->

            <main>
                <section id="hero_in" class="courses">
                    <div class="wrapper">
                        <div class="container">
                            <h1 class="fadeInUp"><span></span>Online course detail</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->

                <div class="bg_color_1">
                    <nav class="secondary_nav sticky_horizontal">
                        <div class="container">
                            <ul class="clearfix">
                                <li><a href="#description" class="active">Description</a></li>
                                <li><a href="#lessons">Lessons</a></li>
                                <li><a href="#reviews">Reviews</a></li>
                                <li><a href="#instructor">Instructor</a></li>
                            </ul>
                        </div>
                    </nav>
                    <div class="container margin_60_35">
                        <div class="row">
                            <div class="col-lg-8">

                                <section id="description">
                                    <h2>${course.title}</h2>
                                    <p>${course.description}</p>
                                    <h5>What will you learn</h5>
                                    <ul class="list_ok">
                                        <c:forEach items="${course.outlines}" var="courseOutline">
                                            <li>
                                                <h6>${courseOutline.outline}</h6>
                                            </li>
                                        </c:forEach>
                                    </ul>                                   
                                    <!-- /row -->
                                </section>
                                <!-- /section -->

                                <section id="lessons">
                                    <div class="intro_title">
                                        <h2>Lessons</h2>
                                        <ul>
                                            <li>${noOfLessons} Lessons</li>
                                            <li>${totalDuration}</li>
                                        </ul>
                                    </div>
                                    <div id="accordion_lessons" role="tablist" class="add_bottom_45">
                                        <c:forEach items="${outlines}" var="courseOutline" varStatus="topicNo">
                                            <div class="card">
                                                <div class="card-header" role="tab" id="heading${courseOutline.id}">
                                                    <h5 class="mb-0">
                                                        <a class="collapsed" data-toggle="collapse" href="#collapse${courseOutline.id}" aria-expanded="false" aria-controls="collapse${courseOutline.id}">
                                                            <i class="indicator ti-plus"></i>${courseOutline.outline}
                                                        </a>
                                                    </h5>
                                                </div>
                                                <div id="collapse${courseOutline.id}" class="collapse" role="tabpanel" aria-labelledby="heading${courseOutline.id}" data-parent="#accordion_lessons">
                                                    <div class="card-body">
                                                        <div class="list_lessons">
                                                            <ul>
                                                                <c:forEach items="${courseOutline.contents}" var="content" varStatus="lessonNo">
                                                                    <c:if test="${topicNo.index == 0}">
                                                                        <li>
                                                                            <a href="${pageContext.request.contextPath}/resources/courses/${course.title}/lessons/${content.video}" class="video">${lessonNo.index+1}- ${content.title}</a><span >${content.duration}</span>
                                                                            <span  onclick="toggleShowDetails(${content.id})" class="detailsLink">Details</span>
                                                                            <p id="details${content.id}"  style="display:none;font-family: cursive;">${content.description}</p>
                                                                        </li>
                                                                    </c:if>
                                                                   <c:if test="${topicNo.index != 0}">
                                                                    <li>
                                                                        <sec:authorize access="isAuthenticated()">
                                                                            <sec:authentication var="userDetails" property="principal"/>
                                                                            <c:if test="${userDetails.user.userId == course.instructor.id}">
                                                                                <a  href="${pageContext.request.contextPath}/resources/courses/${course.title}/lessons/${content.video}" class="video">${lessonNo.index+1}- ${content.title}</a><span >${content.duration}</span>
                                                                                <span  onclick="toggleShowDetails(${content.id})" class="detailsLink">Details</span>
                                                                                <p id="details${content.id}"  style="display:none;font-family: cursive;">${content.description}</p>
                                                                            </c:if>
                                                                        </sec:authorize>
                                                                        <sec:authorize access="!isAuthenticated()">
                                                                            <a href="" class="video">${lessonNo.index+1}- ${content.title}</a><span >${content.duration}</span>
                                                                            <span  onclick="toggleShowDetails(${content.id})" class="detailsLink">Details</span>
                                                                            <p id="details${content.id}"  style="display:none;font-family: cursive;">${content.description}</p>
                                                                        </sec:authorize>
                                                                    </li> 
                                                                   </c:if>
                                                                </c:forEach>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </c:forEach>

                                        <!-- /card -->
                                    </div>
                                    <!-- /accordion -->
                                </section>
                                <!-- /section -->
                                <section id="instructor">
                                    <h5>${course.instructor.firstName} ${course.instructor.lastName}</h5>
                                    <div class="review-box clearfix">
                                        <figure class="rev-thumb"><img class="ins_photo" src="${pageContext.request.contextPath}/resources/images/users/${course.instructor.photo}" alt="">
                                        </figure>
                                        <div class="rev-content">

                                            <div class="rev-info" style="font-weight:bold">
                                                ${course.instructor.instructorField.name} - ${course.instructor.yearOfExp} Years of Experience
                                            </div>
                                            <div class="rev-text">
                                                <p>${course.instructor.description}</p>
                                            </div>
                                            <p class="more" style="font-weight:bold"><a onclick="toggleShow()">More Courses</a></p>
                                            <div id ="instructor_courses" class="wrapper_indent" style="display:none;">
                                                <table class="table table-responsive table-striped add_bottom_30">
                                                    <thead>
                                                        <tr>
                                                            <th>Category</th>
                                                            <th>Course name</th>
                                                            <th>Rate</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${course.instructor.courses}" var="instr_course">
                                                            <tr>
                                                                <td>${instr_course.category.name}</td>
                                                                <td><a href="${pageContext.request.contextPath}/courses/course-details?courseId=${course.id}">${instr_course.title}</a></td>
                                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star voted"></i></td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                                <section id="reviews">
                                    <h2>Reviews</h2>
                                    <div class="reviews-container">
                                        <div class="row">
                                            <div class="col-lg-3">
                                                <div id="review_summary">
                                                    <strong>4.7</strong>
                                                    <div class="rating">
                                                        <i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                                                    </div>
                                                    <small>Based on 4 reviews</small>
                                                </div>
                                            </div>
                                            <div class="col-lg-9">
                                                <div class="row">
                                                    <div class="col-lg-10 col-9">
                                                        <div class="progress">
                                                            <div class="progress-bar" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-3"><small><strong>5 stars</strong></small></div>
                                                </div>
                                                <!-- /row -->
                                                <div class="row">
                                                    <div class="col-lg-10 col-9">
                                                        <div class="progress">
                                                            <div class="progress-bar" role="progressbar" style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-3"><small><strong>4 stars</strong></small></div>
                                                </div>
                                                <!-- /row -->
                                                <div class="row">
                                                    <div class="col-lg-10 col-9">
                                                        <div class="progress">
                                                            <div class="progress-bar" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-3"><small><strong>3 stars</strong></small></div>
                                                </div>
                                                <!-- /row -->
                                                <div class="row">
                                                    <div class="col-lg-10 col-9">
                                                        <div class="progress">
                                                            <div class="progress-bar" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-3"><small><strong>2 stars</strong></small></div>
                                                </div>
                                                <!-- /row -->
                                                <div class="row">
                                                    <div class="col-lg-10 col-9">
                                                        <div class="progress">
                                                            <div class="progress-bar" role="progressbar" style="width: 0" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-2 col-3"><small><strong>1 stars</strong></small></div>
                                                </div>
                                                <!-- /row -->
                                            </div>
                                        </div>
                                        <!-- /row -->
                                    </div>
                                    <hr>
                                    <sec:authorize access="hasAuthority('Student')">
                                        <form action="${pageContext.request.contextPath}/ajaxController/addNewComment" method="post" id="form_review" name="reviewForm">
                                            <div class="card">
                                                <div class="card-header" style="background-color: #92278f; font-weight: bold;color: #FFF;font-size: 17px">
                                                    Your Feedback
                                                </div>
                                                <input type="hidden" id="courseId" value="${course.id}"/>
                                                <div class="card-body">
                                                    <textarea type="textarea" name="user_comment" id="comment" placeholder="Give your comment" style="resize: none;height: 100px;margin-bottom: 15px;" class="form-control"></textarea> 
                                                    <button id="save-comment" type="submit" class="btn btn-primary" style="float: right;width: 100px;">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                    </sec:authorize>
                                    <sec:authorize access="!hasAuthority('Student')">
                                        <div class="card">
                                            <div class="card-header" style="background-color: #92278f; font-weight: bold;color: #FFF;font-size: 17px">
                                                Your Feedback
                                            </div>
                                            <input type="hidden" id="courseId" value="${course.id}"/>
                                            <div class="card-body">
                                                <p style="font-size: large;font-family: fangsong;font-weight: 700">Sign in as a Student, That Only Student Can Give His Feedback </p>
                                            </div>
                                        </div>
                                    </sec:authorize>
                                    <div class="reviews-container">
                                        <!-- /review-box -->
                                        <div class="review-box clearfix" id="newComment" style="display:none;">
                                            <figure class="rev-thumb"><img src="" id="comment_image" alt="">
                                            </figure>
                                            <div class="rev-content">
                                                <h6 id="commentAuthor"></h6>
                                                <div class="rating">
                                                    <i class="icon-star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                                                </div>
                                                <div class="rev-info" id="review_date"></div>
                                                <div class="rev-text">
                                                    <p id="review_comment">
                                                    </p>
                                                </div>
                                            </div>
                                        </div>

                                        <c:forEach items="${reviews}" var="review">
                                            <div class="review-box clearfix">
                                                <figure class="rev-thumb"><img src="${pageContext.request.contextPath}/resources/images/users/${review.student.photo}" alt="">
                                                </figure>
                                                <div class="rev-content">
                                                    <h6>${review.student.firstName} ${review.student.lastName}</h6> 
                                                    <div class="rating">
                                                        <i class="icon-star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star voted"></i><i class="icon_star"></i>
                                                    </div>
                                                    <div class="rev-info">
                                                        ${review.date}
                                                    </div>
                                                    <div class="rev-text">
                                                        <p>
                                                            ${review.comment}
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <!-- /review-box -->
                                    </div>
                                    <!-- /review-container -->
                                </section>
                                <!-- /section -->
                            </div>
                            <!-- /col -->
                            <sec:authorize access="!hasAuthority('Instructor')">
                                <aside class="col-lg-4" id="sidebar">
                                    <div class="box_detail">
                                        <figure>
                                            <a href="${pageContext.request.contextPath}/resources/courses/${course.title}/lessons/${firstContent}" class="video"><i class="arrow_triangle-right"></i><img src="${pageContext.request.contextPath}/resources/images/courses/${course.picture}" alt="" class="img-fluid"><span>View course preview</span></a>
                                        </figure>
                                        <div class="price">
                                            $${course.price}
                                        </div>
                                        <a href="${pageContext.request.contextPath}/student/purchase" class="btn_1 full-width">Purchase</a>
                                        <button class="btn_1 full-width"  onclick="addCourseToCart('${pageContext.request.contextPath}/ajaxController/addToCard/','${course.id}')"> Add To Cart Now </button>
                                    </div>
                                </aside>
                            </sec:authorize>  
                            <sec:authorize access="hasAuthority('Instructor')">
                                <c:if test="${course.instructor.id == instructor.id}">
                                    <aside class="col-lg-4" id="sidebar">
                                        <div class="box_detail">
                                            <p>Price : $${course.price}</p>
                                            <a href="${pageContext.request.contextPath}/courses/addLesson?courseId=${course.id}" class="btn_1 full-width outline">Add Lesson</a>
                                            <a href="#0" class="btn_1 full-width outline"><i class="icon_heart"></i> Edit Course</a>
                                        </div>
                                    </aside>
                                </c:if>
                            </sec:authorize>     
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
        <script type="text/javascript">

            $('document').ready(function () {
                if ($("#comment").val() == "") {
                    $('#save-comment').attr("disabled", "disabled");
                }
                $("#comment").keyup(function () {
                    if ($("#comment").val().trim() !== "") {
                        $('#save-comment').removeAttr("disabled");
                    } else {
                        $('#save-comment').attr("disabled", "disabled");
                    }
                });
                $('#save-comment').click(function (event) {
                    event.preventDefault();
                    $.post($("#form_review").attr("action"),
                            {
                                comment: $("#comment").val(),
                                courseId: $("#courseId").val()
                            },
                            function (data) {
                                $("#comment").val("");
                                $("#review_comment").text(data.comment);
                                $("#commentAuthor").text(data.studentName);
                                $("#review_date").text(data.date);
                                $("#comment_image").attr("src", "/Online_Courses/resources/images/users/" + data.picture);
                                $("#newComment").removeAttr("style");
                            }
                    );
//
                });
            });
        </script>
        <!-- COMMON SCRIPTS -->
    </body>


</html>
</html>
