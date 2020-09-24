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
            </main>
        </div>
        <div>
            Add Two Numbers:
            <br>
            <input id="inputNumber1" name="inputNumber1" type="text" size="5"> +
            <input id="inputNumber2" name="inputNumber2" type="text" size="5">
            <br>
            <input id="submitButton" type="submit" value="Add">
            <br>
            <span id="sum">result</span>
        </div>
        <%@ include file="/resources/scripts.jsp" %>  
        <script type="text/javascript">

            $('document').ready(function () {

                $('#submitButton').click(function (e) {
                    $.post("http://localhost:8087/Online_Courses/ajaxController/addNewComment",
                            {
                                comment: $("#inputNumber1").val(),
                                courseId: $("#inputNumber2").val()
                            },
                            function (data) {
                                alert(data.comment + "   : "+data.rate);
                                $("#sum").text(data.comment);
                            }
                    );
//
                });
            });

        </script>

    </body>


</html>
</html>
