<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" content="text/html; charset=UTF-8">
<head>
  <title>Create CV Item</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="assets/css/main.css" />
  <link rel="stylesheet" href="assets/css/bootstrap.css" />
  <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/easyTree.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
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

<div class="row" style="margin-top: 50px; padding-left:180px; padding-right:180px">
    <div class="col-md-12">
        <div class="col-md-6">
            <div class="col-md-3" style="margin-top:0px;">
                <h4>Kategorije:</h4>
                <div id="criteriaTree" class="easy-tree" style="width:400px">
                    <ul>
                        <li v-bind:id='buildId(criterij_lvl1.id,criterij_lvl1.criteriaLevel)' v-for="criterij_lvl1 in criteria1">{{criterij_lvl1.name}}

                            <ul  v-if="criteria_level(2,criterij_lvl1) != '' ">
                                <li  v-bind:id='buildId(criterij_lvl2.id,criterij_lvl2.criteriaLevel)' v-for="criterij_lvl2 in criteria_level(2,criterij_lvl1)">{{criterij_lvl2.name}}

                                    <ul v-if="criteria_level(3,criterij_lvl2) != '' ">
                                        <li v-bind:id='buildId(criterij_lvl3.id,criterij_lvl3.criteriaLevel)' v-for="criterij_lvl3 in criteria_level(3,criterij_lvl2)">{{criterij_lvl3.name}}

                                            <ul v-if="criteria_level(4,criterij_lvl3) != '' ">
                                                <li v-bind:id='buildId(criterij_lvl4.id,criterij_lvl4.criteriaLevel)' v-for="criterij_lvl4 in criteria_level(4,criterij_lvl3)">{{criterij_lvl4.name}}

                                                    <ul v-if="criteria_level(5,criterij_lvl4) != '' ">
                                                        <li v-bind:id='buildId(criterij_lvl5.id,criterij_lvl5.criteriaLevel)' v-for="criterij_lvl5 in criteria_level(5,criterij_lvl4)">{{criterij_lvl5.name}}

                                                            <ul v-if="criteria_level(6,criterij_lvl5) != '' ">
                                                                <li v-bind:id='buildId(criterij_lvl6.id,criterij_lvl6.criteriaLevel)' v-for="criterij_lvl6 in criteria_level(6,criterij_lvl5)">{{criterij_lvl6.name}}

                                                                    <ul v-if="criteria_level(7,criterij_lvl6) != '' ">
                                                                        <li v-bind:id='buildId(criterij_lvl7.id,criterij_lvl7.criteriaLevel)' v-for="criterij_lvl7 in criteria_level(7,criterij_lvl6)">{{criterij_lvl7.name}}

                                                                            <ul v-if="criteria_level(8,criterij_lvl7) != '' ">
                                                                                <li v-bind:id='buildId(criterij_lvl8.id,criterij_lvl8.criteriaLevel)' v-for="criterij_lvl8 in criteria_level(8,criterij_lvl7)">{{criterij_lvl8.name}}


                                                                                </li>
                                                                            </ul>
                                                                        </li>
                                                                    </ul>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="inner">
                <div class="form-group">
                    <label>Name: </label>
                    <input style="border: 1px solid rgba(0, 0, 0, 0.15);
                        background: white; color: #55595c"
                           id="name" type="text"/>
                </div>
                <br><br>
                <div class="form-group">
                    <label>Description: </label>
                    <textarea class="form-control" id="description" rows="7" ></textarea>
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
                <br><br><br><br>
                <div class="btn btn-success btn-file pull-right" onclick="saveCvItem()">
                    Save CV Item
                </div><br><br><br>
                <div id="saveStatus"></div>
            </div>
        </div>
    </div>
</div>

<!-- Three -->
<%--<section id="three" class="wrapper align-center">
  <div class="inner">
      <div class="form-group">
        <label>Name: </label>
        <input style="border: 1px solid rgba(0, 0, 0, 0.15);
                        background: white; color: #55595c"
               id="name" type="text"/>
      </div>
      <br><br>
      <div class="form-group">
        <label>Description: </label>
        <textarea class="form-control" id="description" rows="7" ></textarea>
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
      <br><br><br><br>
      <div class="btn btn-success btn-file pull-right" onclick="saveCvItem()">
          Save CV Item
      </div><br><br><br>
      <div id="saveStatus"></div>
  </div>
</section>--%>

<!-- Footer -->
<footer id="footer">
  <div class="inner">
  </div>
</footer>


<script type="text/javascript">

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-36251023-1']);
    _gaq.push(['_setDomainName', 'jqueryscript.net']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();

</script>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.form.js"></script>
<script src="assets/js/criteria.js"></script>
<script src="assets/js/easyTree.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/vue.js"></script>
<script src="assets/js/cv-item.js"></script>

</body>
</html>