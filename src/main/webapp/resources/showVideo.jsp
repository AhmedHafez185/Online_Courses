<!-- Home Video Modal -->
<div class="modal fade" id="homeVideo${content.id}" tabindex="-" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog">
    <div class="modal-content">
      <button type="button" class="btn btn-default" data-dismiss="modal " onclick="pauseVid(${content.id})">X</button>
      <div class="embed-responsive embed-responsive-16by9">
        <video id="gossVideo${content.id}" class="embed-responsive-item" controls="controls" poster="${pageContext.request.contextPath}/resources/images/courses/${course.picture}">
            <source src="${pageContext.request.contextPath}/resources/courses/${course.title}/lessons/${content.video}" type="video/${content.extension}">
          <object type="application/x-shockwave-flash" data="https://releases.flowplayer.org/swf/flowplayer-3.2.1.swf" width="353" height="190">
            <param name="allowFullScreen" value="true">
            <img alt="Big Buck Bunny" src="${pageContext.request.contextPath}/resources/images/courses/${course.picture}" width="353" height="190" title="No video playback capabilities, please download the video below">
          </object>
        </video>
      </div>
    </div>
  </div>
  <!-- Home Video Modal -->
<div class="modal fade" id="homeVideo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <button type="button" class="btn btn-default" data-dismiss="modal" onclick="pauseVid()">X</button>
      <div class="embed-responsive embed-responsive-16by9">
        <video id="gossVideo" class="embed-responsive-item" controls="controls" poster="http://www.gossettmktg.com/video/dangot.png">
          <source src="Ahmed Gamal - Ehna Mesh Betoaa .mp4" type="video/mp4">
          <object type="application/x-shockwave-flash" data="https://releases.flowplayer.org/swf/flowplayer-3.2.1.swf" width="353" height="190">
            <param name="movie" value="https://releases.flowplayer.org/swf/flowplayer-3.2.1.swf">
            <param name="allowFullScreen" value="true">		<param name="wmode" value="transparent">
            <param name="flashVars" value="config={'playlist':['http%3A%2F%2Fwww.gossettmktg.com%2Fvideo%2Fdangot.png',{'url':'http%3A%2F%2Fwww.gossettmktg.com%2Fvideo%2Fdangot.mp4','autoPlay':false}]}">
            <img alt="Big Buck Bunny" src="http://www.gossettmktg.com/video/dangot.png" width="353" height="190" title="No video playback capabilities, please download the video below">
          </object>
        </video>
      </div>
    </div>
  </div>