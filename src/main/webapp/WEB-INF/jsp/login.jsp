<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
    <link href="http://weloveiconfonts.com/api/?family=fontawesome" rel="stylesheet">
    <style>
        [class*="fontawesome-"]:before {
            font-family: 'FontAwesome', sans-serif;
        }

        body {
            background: #2c3338;
            color: #606468;
            font: 87.5%/1.5em 'Open Sans', sans-serif;
            margin: 0;
        }

        input {
            border: none;
            font-family: 'Open Sans', Arial, sans-serif;
            font-size: 16px;
            line-height: 1.5em;
            padding: 0;
            -webkit-appearance: none;
        }

        p {
            line-height: 1.5em;
        }

        #login {
            margin: 50px auto;
            width: 320px;
        }

        #login form {
            margin: auto;
            padding: 22px 22px 22px 22px;
            width: 100%;
            border-radius: 5px;
            background: #282e33;
            border-top: 3px solid #434a52;
            border-bottom: 3px solid #434a52;
        }

        #login form span {
            background-color: #363b41;
            border-radius: 3px 0px 0px 3px;
            border-right: 3px solid #434a52;
            color: #606468;
            display: block;
            float: left;
            line-height: 50px;
            text-align: center;
            width: 50px;
            height: 50px;
        }

        #login form input[type="text"] {
            background-color: #3b4148;
            border-radius: 0px 3px 3px 0px;
            color: #a9a9a9;
            margin-bottom: 1em;
            padding: 0 16px;
            width: 235px;
            height: 50px;
        }

        #login form input[type="password"] {
            background-color: #3b4148;
            border-radius: 0px 3px 3px 0px;
            color: #a9a9a9;
            margin-bottom: 1em;
            padding: 0 16px;
            width: 235px;
            height: 50px;
        }

        #login form input[type="submit"] {
            background: #b5cd60;
            border: 0;
            width: 100%;
            height: 40px;
            border-radius: 3px;
            color: white;
            cursor: pointer;
            transition: background 0.3s ease-in-out;
        }
        #login form input[type="submit"]:hover {
            background: #16aa56;
        }
    </style>
    <title tiles:fragment="title">Login</title>
</head>
<body>
<div tiles:fragment="content" id="login">
    <form name='form-login' th:action="@{/login}" method="post">
        <fieldset>
            <span class="fontawesome-user"></span>
            <input type="text" id="username" name="username"/>
            <span class="fontawesome-lock"></span>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Login">
        </fieldset>
    </form>
                </div>
</div>
</body>
</html>