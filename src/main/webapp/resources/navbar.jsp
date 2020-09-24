<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header class="header menu_2 ">
    <div id="preloader"><div data-loader="circle-side"></div></div><!-- /Preload -->
    <div id="logo">
        <a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/resources/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
    </div>
    <ul id="top_menu" style="margin-right: 90px;">
        <li><a href="#0" class="search-overlay-menu-btn">Search</a></li>
            
            <sec:authorize access="!isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/views/login.jsp" class="login">Login</a></li>
            <li class="hidden_tablet"><a href="${pageContext.request.contextPath}/student/register" class="btn_1 rounded">Register</a></li>
            </sec:authorize>
    </ul>

    <!-- /top_menu -->
    <a href="#menu" class="btn_mobile">
        <div class="hamburger hamburger--spin" id="hamburger">
            <div class="hamburger-box">
                <div class="hamburger-inner"></div>
            </div>
        </div>
    </a>
    <nav id="menu" class="main-menu">
        <ul>
            <li><span><a href="${pageContext.request.contextPath}/index">Home</a></span>
            <li><span><a href="${pageContext.request.contextPath}/redirect">Redirect</a></span>
            </li>
            <li><span><a href="#0">Courses</a></span>
                <ul>
                    <c:forEach items="${categories}" var="category">
                        <li><a href="${pageContext.request.contextPath}/categories/category-details?cat_id=${category.id}">${category.name}</a></li>
                        </c:forEach>
                </ul>
            </li>
            <li><span><a href="#0">About US</a></span>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/aboutUs">About Udema</a></li>
                    <li><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
                </ul>
            </li>
            <li><span><a href="#0">Teach With Us</a></span>
                <ul>
                    <sec:authorize access="hasAuthority('Instructor')">
                        <li><a href="${pageContext.request.contextPath}/instructor/myProfile">Profile</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                        <li><a href="${pageContext.request.contextPath}/courses/addCourse">Add New Course</a></li>
                        </sec:authorize>
                        <sec:authorize access="!hasAuthority('Instructor')">
                        <li><a href="${pageContext.request.contextPath}/instructor/register">Join US</a></li>
                        </sec:authorize>
                </ul>
            </li>
            <sec:authorize access="hasAuthority('Student')">
                <li><span><a href="#0"><image src="https://via.placeholder.com/150" style="width: 28px;border-radius: 50%; margin-right: 5px;" />Ahmed</a></span>
                    <ul>
                        <li><span><a href="${pageContext.request.contextPath}/student/student-profile">Profile</a></span></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>

                    </ul>
                </li>
            </sec:authorize>
        </ul>
    </nav>
    <!-- Search Menu -->
    <div class="search-overlay-menu">
        <span class="search-overlay-close"><span class="closebt"><i class="ti-close"></i></span></span>
        <form role="search" id="searchform" method="get">
            <input value="" name="q" type="search" placeholder="Search..." />
            <button type="submit"><i class="icon_search"></i>
            </button>
        </form>
    </div>
</header>