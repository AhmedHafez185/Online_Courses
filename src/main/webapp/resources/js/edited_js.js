/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function playVid(id) {
    var video = "gossVideo" + id;
    var vid = document.getElementById(video);
    vid.play();
}
function pauseVid(id) {
    var video = "gossVideo" + id;
    var vid = document.getElementById(video);
    vid.pause();
}


$(document).ready(function () {
    // Gets the video src from the data-src on each button
    var $videoSrc;
    $(".video-btn").click(function () {
        $videoSrc = $(this).attr("data-src");
        console.log("button clicked" + $videoSrc);
    });

    // when the modal is opened autoplay it
    $("#myModal").on("shown.bs.modal", function (e) {
        console.log("modal opened" + $videoSrc);
        // set the video src to autoplay and not to show related video. Youtube related video is like a box of chocolates... you never know what you're gonna get
        $("#video").attr(
                "src",
                $videoSrc + "?amp;showinfo=0&amp;modestbranding=1&amp;autoplay=1"
                );
    });

    // stop playing the youtube video when I close the modal
    $("#myModal").on("hide.bs.modal", function (e) {
        // a poor man's stop video
        $("#video").attr("src", $videoSrc);
    });

    // document ready
});



function toggleShow() {
    var x = document.getElementById("instructor_courses");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function toggleShowDetails(id) {
    var x = document.getElementById("details" + id);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function addCourseToCart(u, id) {
//    $.post(u,{courseId: id},function (data) {
//                if (data.messageType === "success") {
//                }
//                swal(data.message, data.messageTitle, data.messageType);
//            }
//    );
//    $.ajaxError(function(response){
//        swal(response.message, response.messageTitle, response.messageType);
//    });
   $.ajax({
       
        type: "POST",
        url: u,
      data :{courseId : id} ,
        success: function (data) {
          swal(data.message, data.messageTitle, data.messageType);

      },
       error: function (xhr,textStatus) {
           try{
               console.log(xhr.status);
            if(xhr.status === 401){
               swal("Error 401", "You Must Login First</br></br><a class='btn btn-info' href=\"login\">Login</a>", "error");
            }
           }catch(e){
               
           }
            // window.location = "logout";
       }
    });
}

