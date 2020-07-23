<%-- 
    Document   : login
    Created on : Jul 23, 2020, 3:08:12 PM
    Author     : Ahmed Hafez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="/resources/header.jsp" %>
    </head>
    <body id="login_bg">
        <nav id="menu" class="fake_menu"></nav>
        <div id="preloader">
            <div data-loader="circle-side"></div>
        </div>
        <!-- End Preload -->
        <div id="login">
            <aside>
                <figure>
                    <a href="index.html"><img src="resources/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
                </figure>
                <form>
                    <div class="access_social">
                        <a href="#0" class="social_bt facebook">Login with Facebook</a>
                        <a href="#0" class="social_bt google">Login with Google</a>
                        <a href="#0" class="social_bt linkedin">Login with Linkedin</a>
                    </div>
                    <div class="divider"><span>Or</span></div>
                    <div class="form-group">
                        <span class="input">
                            <input class="input_field" type="email" autocomplete="off" name="email">
                            <label class="input_label">
                                <span class="input__label-content">Your email</span>
                            </label>
                        </span>

                        <span class="input">
                            <input class="input_field" type="password"  name="password">
                            <label class="input_label">
                                <span class="input__label-content">Your password</span>
                            </label>
                        </span>
                        <small><a href="#0">Forgot password?</a></small>
                    </div>
                    <a href="#0" class="btn_1 rounded full-width add_top_60">Login to Udema</a>
                    <div class="text-center add_top_10">New to Udema? <strong><a href="register.html">Sign up!</a></strong></div>
                </form>
                <div class="copy">© 2017 Udema</div>
            </aside>
        </div>
        <!-- /login -->
    </body>
</html>
