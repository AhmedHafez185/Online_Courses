<%-- 
    Document   : index
    Created on : Jul 22, 2020, 9:45:46 AM
    Author     : Ahmed Hafez
--%>

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
                <section id="hero_in" class="contacts">
                    <div class="wrapper">
                        <div class="container">
                            <h1 class="fadeInUp"><span></span>Contact Udema</h1>
                        </div>
                    </div>
                </section>
                <!--/hero_in-->

                <div class="contact_info">
                    <div class="container">
                        <ul class="clearfix">
                            <li>
                                <i class="pe-7s-map-marker"></i>
                                <h4>Address</h4>
                                <span>PO Box 97845 Baker st. 567, Los Angeles<br>California - US.</span>
                            </li>
                            <li>
                                <i class="pe-7s-mail-open-file"></i>
                                <h4>Email address</h4>
                                <span>admission@udema.com - info@udema.com<br><small>Monday to Friday 9am - 7pm</small></span>

                            </li>
                            <li>
                                <i class="pe-7s-phone"></i>
                                <h4>Contacts info</h4>
                                <span>+ 61 (2) 8093 3402 + 61 (2) 8093 3402<br><small>Monday to Friday 9am - 7pm</small></span>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--/contact_info-->

                <div class="bg_color_1">
                    <div class="container margin_120_95">
                        <div class="row justify-content-between">
                            <div class="col-lg-5">
                                <div class="map_contact">
                                </div>
                                <!-- /map -->
                            </div>
                            <div class="col-lg-6">
                                <h4>Send a message</h4>
                                <p>Ex quem dicta delicata usu, zril vocibus maiestatis in qui.</p>
                                <div id="message-contact"></div>
                                <form method="post" action="assets/contact.php" id="contactform" autocomplete="off">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <span class="input">
                                                <input class="input_field" type="text" id="name_contact" name="name_contact">
                                                <label class="input_label">
                                                    <span class="input__label-content">Your Name</span>
                                                </label>
                                            </span>
                                        </div>
                                        <div class="col-md-6">
                                            <span class="input">
                                                <input class="input_field" type="text" id="lastname_contact" name="lastname_contact">
                                                <label class="input_label">
                                                    <span class="input__label-content">Last name</span>
                                                </label>
                                            </span>
                                        </div>
                                    </div>
                                    <!-- /row -->
                                    <div class="row">
                                        <div class="col-md-6">
                                            <span class="input">
                                                <input class="input_field" type="email" id="email_contact" name="email_contact">
                                                <label class="input_label">
                                                    <span class="input__label-content">Your email</span>
                                                </label>
                                            </span>
                                        </div>
                                        <div class="col-md-6">
                                            <span class="input">
                                                <input class="input_field" type="text" id="phone_contact" name="phone_contact">
                                                <label class="input_label">
                                                    <span class="input__label-content">Your telephone</span>
                                                </label>
                                            </span>
                                        </div>
                                    </div>
                                    <!-- /row -->
                                    <span class="input">
                                        <textarea class="input_field" id="message_contact" name="message_contact" style="height:150px;"></textarea>
                                        <label class="input_label">
                                            <span class="input__label-content">Your message</span>
                                        </label>
                                    </span>
                                    <span class="input">
                                        <input class="input_field" type="text" id="verify_contact" name="verify_contact">
                                        <label class="input_label">
                                            <span class="input__label-content">Are you human? 3 + 1 =</span>
                                        </label>
                                    </span>
                                    <p class="add_top_30"><input type="submit" value="Submit" class="btn_1 rounded" id="submit-contact"></p>
                                </form>
                            </div>
                        </div>
                        <!-- /row -->
                    </div>
                    <!-- /container -->
                </div>
                <!-- /bg_color_1 -->
            </main>
            <!--/main-->
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
