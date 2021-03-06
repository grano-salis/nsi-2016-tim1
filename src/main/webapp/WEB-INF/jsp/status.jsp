<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>NSI Alpha - Pending CV items</title>
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
            <h4 style="color:white">Student Service</h4>
            <h5 style="color:white">Handling CV items</h5>
        </header>
    </div>
</section>
<!-- Three -->
<section id="three" class="wrapper align-center" style="margin-top: -50px">
    <div class="inner">
        <ul class="tabstatus" style="background: rgba(75, 75, 93, 0.85);opacity: 0.9">
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Pending')" id="defaultOpen" style="color: white">Pending</a></li>
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Approved')" style="color: white">Approved</a></li>
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Rejected')" style="color: white">Rejected</a></li>
        </ul>

        <div id="Pending" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>Professor Name</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Date Applied</th>
                    <th class="centered">Attachment</th>
                    <th class="centered"></th>
                    <th class="centered"></th>
                </tr>
                <tr v-for="cvItem in pendingItems">
                    <th v-text="cvItem.professorName"></th>
                    <th v-text="cvItem.item.name"></th>
                    <th v-text="cvItem.item.description"></th>
                    <th v-text="convertDate(cvItem.item.insertDate)"></th>
                    <th>
                        <button @click="downloadAttachment(cvItem.item.attachmentLink)" class="attachment">Download</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 2)" class="approveItem">Approve</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 3)" class="rejectItem">Reject</button>
                    </th>
                </tr>
            </table>
        </div>

        <div id="Approved" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>Professor Name</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Date applied</th>
                    <th>Date approved</th>
                    <th class="centered">Attachment</th>
                    <th class="centered"></th>
                    <th class="centered"></th>
                </tr>

                <tr v-for="cvItem in approvedItems">
                    <th v-text="cvItem.professorName"></th>
                    <th v-text="cvItem.item.name"></th>
                    <th v-text="cvItem.item.description"></th>
                    <th v-text="convertDate(cvItem.item.insertDate)"></th>
                    <th v-text="convertDate(cvItem.item.lastUpdateDate)"></th>
                    <th>
                        <button @click="downloadAttachment(cvItem.item.attachmentLink)" class="attachment" style="border-color:rgba(75, 75, 93, 0.85); ">Download</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 1)" class="pendItem">Pend</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 3)" class="rejectItem">Reject</button>
                    </th>
                </tr>
            </table>
        </div>

        <div id="Rejected" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>Professor Name</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Date applied</th>
                    <th>Date approved</th>
                    <th class="centered">Attachment</th>
                    <th class="centered"></th>
                    <th class="centered"></th>
                </tr>

                <tr v-for="cvItem in rejectedItems">
                    <th v-text="cvItem.professorName"></th>
                    <th v-text="cvItem.item.name"></th>
                    <th v-text="cvItem.item.description"></th>
                    <th v-text="convertDate(cvItem.item.insertDate)"></th>
                    <th v-text="convertDate(cvItem.item.lastUpdateDate)"></th>
                    <th>
                        <button @click="downloadAttachment(cvItem.item.attachmentLink)" class="attachment">Download</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 1)" class="pendItem">Pend</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem.item, 2)" class="approveItem">Approve</button>
                    </th>
                </tr>
            </table>
        </div>
    </div>
</section>

<!-- Footer --><!--
<footer id="footer">
    <div class="inner">

        <h3>Get in touch</h3>

        <form action="#" method="post">

            <div class="field half first">
                <label for="name">Name</label>
                <input name="name" id="name" type="text" placeholder="Name">
            </div>
            <div class="field half">
                <label for="email">Email</label>
                <input name="email" id="email" type="email" placeholder="Email">
            </div>
            <div class="field">
                <label for="message">Message</label>
                <textarea name="message" id="message" rows="6" placeholder="Message"></textarea>
            </div>
            <ul class="actions">
                <li><input value="Send Message" class="button alt" type="submit"></li>
            </ul>
        </form>

        <div class="copyright">
            &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
        </div>

    </div>
</footer>
-->
<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/vue.js"></script>
<script src="assets/js/status.js"></script>
<script language="javascript" type="text/javascript">
    function openCity(evt, cityName) {
        // Declare all variables
        var i, tabcontent, tablinks;

        // Get all elements with class="tabcontent" and hide them
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }

        // Get all elements with class="tablinks" and remove the class "active"
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        // Show the current tab, and add an "active" class to the link that opened the tab
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }

    document.getElementById("defaultOpen").click();
</script>
</body>
</html>
