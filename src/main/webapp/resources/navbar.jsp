<header class="header menu_2">
    <div id="preloader"><div data-loader="circle-side"></div></div><!-- /Preload -->
    <div id="logo">
        <a href="index.html"><img src="${pageContext.request.contextPath}/resources/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
    </div>
    <ul id="top_menu">
        <li><a href="${pageContext.request.contextPath}/views/login.jsp" class="login">Login</a></li>
        <li><a href="#0" class="search-overlay-menu-btn">Search</a></li>
        <li class="hidden_tablet"><a href="admission.html" class="btn_1 rounded">Admission</a></li>
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
            <li><span><a href="${pageContext.request.contextPath}/views/index.jsp">Home</a></span>

            </li>
            <li><span><a href="#0">Courses</a></span>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Databases</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Programming</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Networks</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Operating System</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Languages</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/courses.jsp">Human Resources</a></li>
                </ul>
            </li>
            <li><span><a href="#0">About US</a></span>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/views/about-us.jsp">About Udema</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/contact-us.jsp">Contact Us</a></li>
                </ul>
            </li>
            <li><span><a href="#0">Teach With Us</a></span>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/views/teacher-profile.jsp">Teacher Profile</a></li>
                    <li><a href="${pageContext.request.contextPath}/instructor/register">Register</a></li>
                </ul>
            </li>
            <li><span><a href="${pageContext.request.contextPath}/views/student-profile.jsp">My Profile</a></span></li>
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
    </div><!-- End Search Menu -->
</header>