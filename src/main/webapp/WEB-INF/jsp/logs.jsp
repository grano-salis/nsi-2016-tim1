<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!DOCTYPE HTML>
        <html xmlns:th="http://www.thymeleaf.org">
        <head>
            <title>NSI Alpha - Logs</title>
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
            <h4 style="color:white">Logs</h4>
            <h5 style="color:white">System activity logs</h5>
        </header>
    </div>
</section>
<!-- Three -->
<section id="three" class="wrapper align-center" style="margin-top: 60px; margin-left: 250px; margin-right: 0px; height: 60%; background: rgba(75, 75, 93, 0.85);opacity: 0.9">
    <div class="inner">
        <div id="Pending" class="tabcontent" style="">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>File Name</th>
                    <th>Date Applied</th>
                    <th class="centered">Attachment</th>
                </tr>
                <tr v-for="cvItem in pendingItems">
                    <th v-text="cvItem.professorName"></th>
                    <th v-text="cvItem.item.name"></th>
                    <th v-text="cvItem.item.description"></th>
                    <th v-text="convertDate(cvItem.item.insertDate)"></th>
                    <th>
                        <button @click="downloadAttachment(cvItem.item.attachmentLink)" class="attachment">Download</button>
                    </th>
                </tr>
            </table>
        </div>
    </div>
</section>

</body>
</html>