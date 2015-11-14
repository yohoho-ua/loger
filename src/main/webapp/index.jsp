<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logger.Autorization</title>
    <link href="resources/css/style_index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main">

    <div class="content">
        <p class="title"><span class="text"><img src="resources/images/ammonite-silhouette-ammonoidea_small.jpg"
                                                 hspace="10" vspace="10" align="middle"></span></p>

        <p class="title">Logger</p>

        <p class="text">Welcome to looger notes.</p>

        <p class="text">Email <a href="mailto:yohoho.ua@gmail.com">yohoho.ua@gmail.com</a></p>

        <p>&nbsp;</p>

    </div>

    <div class="login_div">
        <p class="title">Autorize:</p>

        <form class="login_form" name="login" action="pages/main.jsp" method="POST">
            <table>
                <tr>
                    <td>email:</td>
                    <td><input type="text" name="email" value="" size="20"/></td>
                </tr>
                <tr>
                    <td> password:</td>
                    <td> <input type="password" name="password" value="" size="20"/></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="submit"/>
        </form>

    </div>

    <div class="footer">
        Developer: Zim, 2015
    </div>
</div>


</body>
</html>
