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

            <header class="header menu_2">
                <div id="preloader"><div data-loader="circle-side"></div></div><!-- /Preload -->
                <div id="logo">
                    <a href="index.html"><img src="img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
                </div>
                <ul id="top_menu">
                    <li><a href="login.html" class="login">Login</a></li>
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
                        <li><span><a href="#0">Home</a></span>
                            <ul>
                                <li><a href="index.html">Home version 1</a></li>
                                <li><a href="index-2.html">Home version 2</a></li>
                                <li><a href="index-3.html">Home version 3</a></li>
                                <li><a href="index-4.html">Home version 4</a></li>
                                <li><a href="index-5.html">With Cookie bar (EU law)</a></li>
                            </ul>
                        </li>
                        <li><span><a href="#0">Courses</a></span>
                            <ul>
                                <li><a href="courses-grid.html">Courses grid</a></li>
                                <li><a href="courses-grid-sidebar.html">Courses grid sidebar</a></li>
                                <li><a href="courses-list.html">Courses list</a></li>
                                <li><a href="courses-list-sidebar.html">Courses list sidebar</a></li>
                                <li><a href="course-detail.html">Course detail</a></li>
                                <li><a href="course-detail-2.html">Course detail working form</a></li>
                                <li><a href="admission.html">Admission wizard</a></li>
                                <li><a href="teacher-detail.html">Teacher detail</a></li>
                            </ul>
                        </li>
                        <li><span><a href="#0">Pages</a></span>
                            <ul>
                                <li><a href="#0">Menu 2</a></li>
                                <li><a href="about.html">About</a></li>
                                <li><a href="blog.html">Blog</a></li>
                                <li><a href="login.html">Login</a></li>
                                <li><a href="register.html">Register</a></li>
                                <li><a href="contacts.html">Contacts</a></li>
                                <li><a href="404.html">404 page</a></li>
                                <li><a href="agenda-calendar.html">Agenda Calendar</a></li>
                                <li><a href="faq.html">Faq</a></li>
                                <li><a href="help.html">Help</a></li>
                            </ul>
                        </li>
                        <li><span><a href="#0">Extra Pages</a></span>
                            <ul>
                                <li><a href="media-gallery.html">Media gallery</a></li>
                                <li><a href="cart-1.html">Cart page 1</a></li>
                                <li><a href="cart-2.html">Cart page 2</a></li>
                                <li><a href="cart-3.html">Cart page 3</a></li>
                                <li><a href="pricing-tables.html">Responsive pricing tables</a></li>
                                <li><a href="coming_soon/index.html">Coming soon</a></li>
                                <li><a href="icon-pack-1.html">Icon pack 1</a></li>
                                <li><a href="icon-pack-2.html">Icon pack 2</a></li>
                                <li><a href="icon-pack-3.html">Icon pack 3</a></li>
                                <li><a href="icon-pack-4.html">Icon pack 4</a></li>
                            </ul>
                        </li>
                        <li><span><a href="#0">Buy template</a></span></li>
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
            <!-- /header -->

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
                                <figure><img src="http://via.placeholder.com/150x150/ccc/fff/teacher_2_small.jpg" alt="Teacher" class="rounded-circle"></figure>
                                <ul class="social_teacher">
                                    <li><a href="#"><i class="icon-facebook"></i></a></li>
                                    <li><a href="#"><i class="icon-twitter"></i></a></li>
                                    <li><a href="#"><i class="icon-linkedin"></i></a></li>
                                    <li><a href="#"><i class="icon-email"></i></a></li>
                                </ul>
                                <ul>
                                    <li>Name <span class="float-right">Silvia Doe</span> </li>
                                    <li>Students <span class="float-right">42</span></li>
                                    <li>Lessons <span class="float-right">12</span></li>
                                    <li>Courses <span class="float-right">15</span></li>
                                </ul>
                            </div>
                        </aside>
                        <!--/aside -->

                        <div class="col-lg-9">
                            <div class="box_teacher">
                                <div class="indent_title_in">
                                    <i class="pe-7s-user"></i>
                                    <h3>Profile</h3>
                                    <p>Mussum ipsum cacilds, vidis litro abertis.</p>
                                </div>
                                <div class="wrapper_indent">
                                    <p>Lorem ipsum dolor sit amet, dicta oportere ad est, ea eos partem neglegentur theophrastus. Esse voluptatum duo ne, expetenda corrumpit no per, at mei nobis lucilius. No eos semper aperiri neglegentur, vis noluisse quaestio no. Vix an nostro inimicus, qui ut animal fabellas reprehendunt. In quando repudiare intellegebat sed, nam suas dicta melius ea.</p>
                                    <p>Mei ut decore accusam consequat, alii dignissim no usu. Phaedrum intellegat sit ut, no pri mutat eirmod. In eum iriure perpetua adolescens, pri dicunt prodesset et. Vis dicta postulant ad.</p>
                                    <h5>Credentials</h5>
                                    <p>Lorem ipsum dolor sit amet, dicta oportere ad est, ea eos partem neglegentur theophrastus. Esse voluptatum duo ne, expetenda corrumpit no per, at mei nobis lucilius. No eos semper aperiri neglegentur, vis noluisse quaestio no. Vix an nostro inimicus, qui ut animal fabellas reprehendunt. In quando repudiare intellegebat sed, nam suas dicta melius ea.</p>
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
                                    <p>Mussum ipsum cacilds, vidis litro abertis.</p>
                                </div>
                                <div class="wrapper_indent">
                                    <p>Mei ut decore accusam consequat, alii dignissim no usu. Phaedrum intellegat sit ut, no pri mutat eirmod. In eum iriure perpetua adolescens, pri dicunt prodesset et. Vis dicta postulant ad.</p>
                                    <table class="table table-responsive table-striped add_bottom_30">
                                        <thead>
                                            <tr>
                                                <th>Category</th>
                                                <th>Course name</th>
                                                <th>Rate</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Business Plan</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star voted"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Economy pinciples</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i> <i class="icon-star"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Understand diagrams</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Marketing strategies</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Marketing</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star voted"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Business Plan</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star"></i> <i class="icon-star"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Economy pinciples</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star"></i></td>
                                            </tr>
                                            <tr>
                                                <td>Business</td>
                                                <td><a href="#">Understand diagrams</a></td>
                                                <td class="rating"><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i><i class="icon-star voted"></i> <i class="icon-star"></i></td>
                                            </tr>
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