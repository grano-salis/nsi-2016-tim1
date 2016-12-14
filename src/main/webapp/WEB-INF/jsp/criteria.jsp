
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
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
            <li style="display:inline;margin-right:43%"><a href="criteria">Categories</a></li>
        </ul>
    </nav>
</header>
<!-- Banner -->
<section id="banner">
    <div class="inner">
        <header>
            <h1>Criteria</h1>
            <h3>List of criteria</h3>
        </header>
    </div>
</section>


<!-- Three -->
<section id="three" class="wrapper align-center">
    <div class="inner flex">
        <div id="listContainer">
            <h3>List of criteria</h3>
            <ul id="expList">
                <li>Kriterij 1
                    <ul>
                        <li>Level 1.1
                            <ul>
                                <li>Sublevel 1.1.1</li>
                                <li>Sublevel 1.1.2</li>
                                <li>Sublevel 1.1.3</li>
                            </ul>
                        </li>
                        <li>Level 1.2
                            <ul>
                                <li>Sublevel 1.2.1</li>
                                <li>Sublevel 1.2.2</li>
                            </ul>
                        </li>
                        <li>Level 1.3
                            <ul>
                                <li>Sublevel 1.2.1</li>
                                <li>Sublevel 1.2.2</li>
                                <li>Sublevel 1.2.3</li>
                                <li>Sublevel 1.2.4</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Kriterij 2
                    <ul>
                        <li>Projekti
                            <ul>
                                <li>Projekat 1</li>
                                <li>Projekat 2</li>
                                <li>Projekat 3</li>
                            </ul>
                        </li>
                        <li>Naucni radovi
                            <ul>
                                <li>Naucni rad 1</li>
                                <li>Naucni rad 2</li>
                            </ul>
                        </li>
                        <li>Patenti
                            <ul>
                                <li>Sublevel 2.1</li>
                                <li>Sublevel 2.2</li>
                                <li>Sublevel 2.3</li>
                                <li>Sublevel 2.4</li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li>Kriterij 3
                    <ul>
                        <li>Projekti
                            <ul>
                                <li>Projekat 1</li>
                                <li>Projekat 2</li>
                                <li>Projekat 3</li>
                            </ul>
                        </li>
                        <li>Naucni radovi
                            <ul>
                                <li>Naucni rad 1</li>
                                <li>Naucni rad 2</li>
                            </ul>
                        </li>
                        <li>Patenti
                            <ul>
                                <li>Patent 1</li>
                                <li>Patent 2</li>
                                <li>Patent 3</li>
                                <li>Patent 4</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</section>

<!-- Footer -->
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

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script type="text/javascript" src="listCollapse.js"></script>
<script type="text/javascript">
    function prepareList() {
        $('#expList').find('li:has(ul)')
                .click( function(event) {
                    if (this == event.target) {
                        $(this).toggleClass('expanded');
                        $(this).children('ul').toggle('medium');
                    }
                    return false;
                })
                .addClass('collapsed')
                .children('ul').hide();
    };

    $(document).ready( function() {
        prepareList();
    });
</script>

</body>
</html>
