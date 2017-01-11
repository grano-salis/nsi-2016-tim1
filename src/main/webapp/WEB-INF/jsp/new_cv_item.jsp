<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" content="text/html; charset=UTF-8">
<head>
  <title>NSI Alpha - New CV Item</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="css/easyTree.css">
    <style>
        body {
            background: #eee;
        }
    </style>
</head>
<body class="landing">
<!-- Header -->
<header id="header" class="alt">
    <nav id="nav" style="margin-top: -20px">
        <ul>
            <li style="display:inline"><a href="index">Home</a></li>
            <li style="display:inline"><a href="new_cv_item">New CV item</a></li>
            <li style="display:inline"><a href="status">Pending CV items</a></li>
            <li style="display:inline"><a href="criteria">Categories</a></li>
            <li style="display:inline;margin-right:37%"><a href="logs">Logs</a></li>
            <li style="display:inline;margin-right:42%">
                <form style="margin-right:5%;margin-left:3%;margin-top: -3cm" action="/logout"
                      method="post">
                    <input type="submit" value="Logout"/>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
            </li>
        </ul>
    </nav>
</header>
<!-- Banner -->
<section id="banner" style="height: 300px; margin-top: -70px">
    <div class="inner">
        <header style="float: left; margin-top: -205px">
            <h4 style="color:white">Professor<h4>
            <h5 style="color:white">CV item management</h5>
        </header>
    </div>
</section>

<div class="row" style="margin-top: 50px; padding-left:180px; padding-right:180px">
    <div class="col-md-12">
        <div style="float: right;margin-right: 0;" class="col-md-5">
                <div id="criteriaTree" class="easy-tree" style="width:100%;opacity: 1">
                    <h5 style="font-weight: 800; color:whitesmoke;margin-left: 20px">Select item category:</h5>
                    <ul>
                        <li v-bind:id='buildId(criterij_lvl1.id,criterij_lvl1.criteriaLevel)' v-for="criterij_lvl1 in criteria1">{{criterij_lvl1.name}}

                            <ul style="margin-left: 11px;"  v-if="criteria_level(2,criterij_lvl1) != '' ">
                                <li  v-bind:id='buildId(criterij_lvl2.id,criterij_lvl2.criteriaLevel)' v-for="criterij_lvl2 in criteria_level(2,criterij_lvl1)">{{criterij_lvl2.name}}

                                    <ul style="margin-left: 12px;" v-if="criteria_level(3,criterij_lvl2) != '' ">
                                        <li v-bind:id='buildId(criterij_lvl3.id,criterij_lvl3.criteriaLevel)' v-for="criterij_lvl3 in criteria_level(3,criterij_lvl2)">{{criterij_lvl3.name}}

                                            <ul style="margin-left: 11px;" v-if="criteria_level(4,criterij_lvl3) != '' ">
                                                <li v-bind:id='buildId(criterij_lvl4.id,criterij_lvl4.criteriaLevel)' v-for="criterij_lvl4 in criteria_level(4,criterij_lvl3)">{{criterij_lvl4.name}}

                                                    <ul style="margin-left: 11px;" v-if="criteria_level(5,criterij_lvl4) != '' ">
                                                        <li v-bind:id='buildId(criterij_lvl5.id,criterij_lvl5.criteriaLevel)' v-for="criterij_lvl5 in criteria_level(5,criterij_lvl4)">{{criterij_lvl5.name}}

                                                            <ul style="margin-left: 12px;" v-if="criteria_level(6,criterij_lvl5) != '' ">
                                                                <li v-bind:id='buildId(criterij_lvl6.id,criterij_lvl6.criteriaLevel)' v-for="criterij_lvl6 in criteria_level(6,criterij_lvl5)">{{criterij_lvl6.name}}

                                                                    <ul style="margin-left: 11px;" v-if="criteria_level(7,criterij_lvl6) != '' ">
                                                                        <li v-bind:id='buildId(criterij_lvl7.id,criterij_lvl7.criteriaLevel)' v-for="criterij_lvl7 in criteria_level(7,criterij_lvl6)">{{criterij_lvl7.name}}

                                                                            <ul style="margin-left: 11px;" v-if="criteria_level(8,criterij_lvl7) != '' ">
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
        <div class="col-md-5" style="float: left;background-color: rgba(75, 75, 93, 0.85);">
            <div class="inner" >
                <div class="form-group">
                    <form id="cvItemFileUploadForm" method="POST" enctype="multipart/form-data" style="display: block"
                          action="/upload_cv_item_attachment">

                        <div class="form-group">
                            <h5 style="color: white;font-weight: 800">Name: </h5>
                            <input style="border: 1px solid rgba(75, 75, 93, 0.85);background-color: rgba(75, 75, 93, 0.85);"
                                   id="name" type="text"/>
                        </div>
                        <div class="form-group">
                            <h5 style="color: white;font-weight: 800">Description: </h5>
                            <textarea class="form-control" id="description" rows="5" style="background-color: rgba(75, 75, 93, 0.85);border: 1px solid rgba(75, 75, 93, 0.85);color: whitesmoke"></textarea>
                        </div>

                        <h5 style="display: block;color: white;font-weight: 800">Attach file:</h5>
                        <input type="file" id="file-picker-button" name="file" style="display: inline-block" readonly>
                        <div style="margin-top: -15px" onclick="uploadCvItemAttachment()" id="file-upload-button" class="btn btn-danger btn-file">Upload</div><br>
                        <br><br>
                        <input style="width: 265px;" id="delete-button" type="button" onclick="deleteUpload()" value="Clear Attachment"/>
                        <input style="float: right;" type="submit" onclick="saveCvItem()" value="Save CV item"/>
                    </form>
                    <div style="margin-top: 5px" id="uploadStatus"></div>
                </div>
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