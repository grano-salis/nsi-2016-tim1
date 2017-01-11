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


</body>
</html>
