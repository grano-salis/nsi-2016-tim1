<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" content="text/html; charset=UTF-8">
<head>
  <title>Create CV Item</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="assets/css/main.css" />
  <link rel="stylesheet" href="assets/css/bootstrap.css" />
</head>
<body class="landing">

<!-- Header -->
<header id="header" class="alt">
  <nav id="nav">
    <ul>
      <li style="display:inline"><a href="index">Home</a></li>
      <li style="display:inline"><a href="professors">Professors</a></li>
      <li style="display:inline;margin-right:43%"><a href="criteria">Categories</a></li>
    </ul>
  </nav>
</header>
<!-- Banner -->
<section id="banner">
  <div class="inner">
    <header>
      <h1>Professors</h1>
      <h3>List of professors and their CV lines</h3>
    </header>
  </div>
</section>


<!-- Three -->
<section id="three" class="wrapper align-center">
  <div class="inner">

      <div class="form-group">
        <label class="form-control">Name: </label>
        <input class="form-control" type="text"/>
      </div>
      <br><br>
      <div class="form-group">
        <label class="form-control">Description: </label>
        <textarea class="form-control" rows="7" ></textarea>
      </div>
      <br><br>
      <div class="form-group">
        <form id="cvItemFileUploadForm" method="POST" enctype="multipart/form-data" style="display: block"
                action="/upload_cv_item_attachment">

          <label style="display: block">Attach file:</label>
          <input type="file" id="fileLoader" name="file" style="display: inline-block" readonly>
          <div onclick="uploadCvItemAttachment()" id="uploadFile" class="btn btn-danger btn-file">Upload</div>
          <div id="fileUploadPercents" style="padding-left: 5px; display: inline-block">0%</div>

        </form>
        <div id="clearAttachment" class="btn btn-info btn-file" onclick="deleteUpload()">Clear Attachment</div>
        <br>
        <div id="uploadStatus"></div>
      </div>

  </div>
</section>

<button class="btn-default btn-sm btn-icon glyphicon glyphicon-download"
         style="border: none;"
         onclick="downloadFile('file upload test.txt')">
</button>

<!-- Footer -->
<footer id="footer">
  <div class="inner">
  </div>
</footer>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.form.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/vue.js"></script>
<script src="assets/js/cv-item.js"></script>

</body>
</html>