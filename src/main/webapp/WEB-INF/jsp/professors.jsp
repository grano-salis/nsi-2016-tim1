<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" content="text/html; charset=UTF-8">
<head>
  <title>NSI - Alpha</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="landing">
<!-- Header -->
<header id="header" class="alt">
  <h1 style="margin-right:5%;margin-left:5%"><strong><a href="index.html">Professor Evaluator</a></strong> by Alpha NSI
  </h1>
  <nav id="nav">
    <ul>
      <li style="display:inline"><a href="index">Home</a></li>
      <li style="display:inline"><a href="professors">Professors</a></li>
      <li style="display:inline"><a href="status">Student Service</a></li>
      <li style="display:inline;margin-right:42%"><a href="criteria">Criteria</a></li>
      <li style="display:inline;margin-right:42%">
        <form style="margin-right:5%;margin-left:3%;margin-top: -3cm" action="login" th:action="@{/logout}" method="post">
          <input type="submit" value="Logout" />
          <input type="hidden"
                 name="${_csrf.parameterName}"
                 value="${_csrf.token}"/>
        </form>
      </li>
    </ul>
  </nav>
</header>
<!-- Banner -->
<section id="banner" style="padding-top: 8.6em;padding-bottom: 3em">
  <div class="inner">
    <header>
      <h1>Professors</h1>
      <h3>List of professors and their CV lines</h3>
    </header>
  </div>
</section>


<!-- Three -->
<section id="three" class="wrapper align-center">
  <div class="inner">


    <div class="flexprof flex-2" v-for="professor in professors">
      <article>
        <div class="image round">
          <img src="images/tesla.jpg" alt="Pic 01" />
        </div>
        <header>
          <h3><span v-text="professor.firstName"></span> <span v-text="professor.lastName"></span></h3>
        </header>
        <div class="professor description">
          <p>Nikola Tesla is a a Serbian-American inventor, electrical engineer, mechanical engineer, physicist, and futurist best known for his contributions to the design of the modern alternating current (AC) electricity supply system. Tesla is renowned for his achievements and showmanship, eventually earning him a reputation in popular culture as an archetypal "mad scientist" His patents earned him a considerable amount of money, much of which was used to finance his own projects with varying degrees of success</p>
        </div>
        <footer>
          <a href="#" class="button">Go to full CV</a>
        </footer>
      </article>
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
<script src="assets/js/professors.js"></script>

</body>
</html>