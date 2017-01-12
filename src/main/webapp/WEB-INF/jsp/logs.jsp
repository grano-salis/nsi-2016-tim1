<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<section id="three" class="wrapper align-center" style="margin-top: 60px; margin-left: 250px; margin-right: 250px; height: 60%; background: rgba(75, 75, 93, 0.85);opacity: 0.9; color:white;text-align: left; font-size: small; font-weight: 400;padding-top: 10px;padding-bottom: 10px;padding-right: 10px; padding-left: 10px">
<p>Last 500 logged lines:</p>
    <%
        String jspPath = "/home/akiselica/NSI-Alpha/nsi-2016-tim1/";
        String fileName = "nsi-alpha.debug.log";
        String txtFilePath = jspPath + fileName;
        BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
        //BufferedReader br = new InputStreamReader(new FileInputStream(txtFilePath));
        StringBuilder sb = new StringBuilder();
        int lineCounter = 0;
        while(reader.readLine()!= null){
            lineCounter++;
        }

        reader = new BufferedReader(new FileReader(txtFilePath));
        String line;
        if (lineCounter > 500) {
            for (int i = 0; i<500; i++) {
                line = reader.readLine();
                sb.append(line+"\n");
            }
            out.println(sb.toString());
        } else {
            while((line = reader.readLine())!= null) {
                line = reader.readLine();
                sb.append(line + "\n");
            }
            out.println(sb.toString());
        }

    %>

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
                    <th v-text="convertDate(cvItem.item.insertDate)"></th>
                    <th><button @click="downloadAttachment(cvItem.item.attachmentLink)" class="attachment">Download</button></th>
                </tr>
            </table>
        </div>
    </div>
</section>

</body>
</html>