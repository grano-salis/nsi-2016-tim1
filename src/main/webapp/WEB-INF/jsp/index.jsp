<!DOCTYPE HTML>
<html>
<head>
  <title>NSI Alpha</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>

<!-- Header -->
<header id="header" class="alt">
  <h1 style="margin-right:4%;margin-left:4%;"><strong><a href="index">Professor Evaluator</a></strong> by Alpha NSI
   </h1>
  <nav id="nav">
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
<section id="banner" style="padding-top: 8.6em;padding-bottom: 8.6em">
  <div class="inner">
    <header>
      <h1>Welcome to Professor Evaluator</h1>
    </header>

    <div class="flex">

        <div class="hover-link" style="width:250px;padding: 0px 20px 20px 20px;">
            <a href="new_cv_item" style="text-decoration: none;">
                <span class="icon fa-list-alt"></span>
                <h3>New CV item</h3>
                <p style="width: inherit">Submit new CV item</p>
            </a>
        </div>

        <div class="hover-link" style="width:auto;padding: 0px 20px 20px 20px;">
            <a href="status" style="text-decoration: none;margin-left: 0">
            <span class="icon fa-book"></span>
            <h3>Pending CV items</h3>
            <p style="width: inherit">Handle submitted CV items</p>
            </a>
        </div>

        <div class="hover-link" style="width:250px;padding: 0px 20px 20px 20px;">
            <a href="criteria" style="text-decoration: none;margin-left: 0">
                <span class="icon fa-list"></span>
                <h3>Categories</h3>
                <p style="width: inherit">Handling categories and subcategories</p>
            </a>
        </div>

        <div class="hover-link" style="width:250px;padding: 0px 20px 20px 20px;">
            <a href="logs" style="text-decoration: none">
                <span class="icon fa-user"></span>
                <h3>Logs</h3>
                <p>System activity logs</p>
            </a>
        </div>

    </div>

    <footer>
      <a href="help" class="button">Using this first time?</a>
    </footer>
  </div>
</section>


<!-- Three -->
<!--
<section id="three" class="wrapper align-center">
  <div class="inner">
    <div class="flex flex-2">
      <article>
        <header>
          <h3>Lorem ipsum<br /> dolor amet nullam</h3>
        </header>
        <p>Morbi in sem quis dui placerat ornare. Pellentesquenisi<br />euismod in, pharetra a, ultricies in diam sed arcu. Cras<br />consequat  egestas augue vulputate.</p>
        <footer>
          <a href="#" class="button">Learn More</a>
        </footer>
      </article>
      <article>
        <header>
          <h3>Sed feugiat<br /> tempus adipicsing</h3>
        </header>
        <p>Pellentesque fermentum dolor. Aliquam quam lectus<br />facilisis auctor, ultrices ut, elementum vulputate, nunc<br /> blandit ellenste egestagus commodo.</p>
        <footer>
          <a href="#" class="button">Learn More</a>
        </footer>
      </article>
    </div>
  </div>
</section>
-->
<!-- Footer -->
<!--<footer id="footer">
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

</body>
</html>