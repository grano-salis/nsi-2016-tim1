<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>NSI Alpha - Help</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="assets/css/main.css" />
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
            <h4 style="color:white">Help</h4>
            <h5 style="color:white">Tips and tricks</h5>
        </header>
    </div>
</section>


<section>
    <br>
    <div class="col-md-12" style="margin-left: 50px; float: left">
        <h2>1. Submit new CV item - PROFESSORS</h2>
        <img src="/images/Screenshot1.png" alt="New items" height="452" width="842">
        <p style="text-align: center">1. Insert CV item name<br>2. Insert CV item description<br>3. Attach CV item file<br>4. Upload file on FTP server<br>5. Save/Discard CV item</p>
    </div>
    <div class="col-md-12" style="margin-right: 50px; float: right">
        <h2>2. Handle pending CV item - STUDENT SERVICE</h2>
        <img src="/images/Screenshot2.png" alt="Pending items" height="452" width="842">
        <p style="text-align: center">1. Download attachment for CV item<br>2. Approve pending CV item<br>3. Reject pending CV item<br>4. Download approved CV item<br>5. Set approved CV item to pending stage<br>6. Reject approved CV item<br>7. Download rejected CV item<br>8. Set rejected CV item to pending stage<br>9. Approve rejected CV item.</p>
    </div>
</section>

</body>
</html>
