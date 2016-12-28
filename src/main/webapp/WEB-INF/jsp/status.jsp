
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>NSI - Alpha</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">

<!-- Header -->
<header id="header" class="alt">
    <h1 style="margin-right:5%;margin-left:5%"><strong><a href="index.html">Professor Evaluator</a></strong> by Alpha NSI</h1>
    <nav id="nav">
        <ul>
            <li style="display:inline"><a href="index">Home</a></li>
            <li style="display:inline"><a href="professors">Professors</a></li>
            <li style="display:inline"><a href="status">Student Service</a></li>
            <li style="display:inline;margin-right:43%"><a href="criteria">Categories</a></li>
            <li style="display:inline;margin-right:42%">
                <form style="margin-right:5%;margin-left:3%;margin-top: -3cm" action="login" th:action="@{/logout}"
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
<section id="banner">
    <div class="inner">
        <header>
            <h1>Student Service</h1>
            <h3>Filtering professors via categories and subcategories</h3>
        </header>
    </div>
</section>


<!-- Three -->
<section id="three" class="wrapper align-center">
    <div class="inner">
        <ul class="tabstatus">
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Pending')" id="defaultOpen">Pending</a></li>
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Approved')">Approved</a></li>
            <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'Rejected')">Rejected</a></li>
        </ul>

        <div id="Pending" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>CV Item name</th>
                    <th>CV Item link</th>
                    <th>Date applied</th>
                    <th class="centered">Approve</th>
                    <th class="centered">Reject</th>
                </tr>
                <tr v-for="cvItem in pendingItems">
                    <th v-text="cvItem.name"></th>
                    <th v-text="cvItem.description">/th>
                    <th v-text="convertDate(cvItem.startDate)"></th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem, 1)" class="approveItem">Approved</button>
                    </th>
                    <th class="centered">
                        <button @click="changeStatus(cvItem, 2)" class="rejectItem">Reject</button>
                    </th>
                </tr>
            </table>
        </div>

        <div id="Approved" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>CV Item name</th>
                    <th>CV Item link</th>
                    <th>Date applied</th>
                    <th>Date approved</th>
                </tr>

                <tr v-for="cvItem in approvedItems">
                    <th v-text="cvItem.name"></th>
                    <th v-text="cvItem.description"></th>
                    <th v-text="convertDate(cvItem.startDate)"></th>
                    <th v-text="convertDate(cvItem.lastUpdateDate)"></th>
                </tr>
            </table>
        </div>

        <div id="Rejected" class="tabcontent">
            <table class="studentServiceItems">
                <tr class="header">
                    <th>CV Item name</th>
                    <th>CV Item link</th>
                    <th>Date applied</th>
                    <th>Date approved</th>
                </tr>

                <tr v-for="cvItem in rejectedItems">
                    <th v-text="cvItem.name"></th>
                    <th v-text="cvItem.description"></th>
                    <th v-text="convertDate(cvItem.startDate)"></th>
                    <th v-text="convertDate(cvItem.lastUpdateDate)"></th>
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
