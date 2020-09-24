var vid = document.createElement('video');
document.getElementById('uploadedLesson').addEventListener('change', function() {
  // create url to use as the src of the video
  var fileURL = URL.createObjectURL(this.files[0]);
  vid.src = fileURL;
  // wait for duration to change from NaN to the actual duration
  vid.ondurationchange = function() {
      document.getElementById("vidDuration").value = Math.floor(this.duration);
  };
});