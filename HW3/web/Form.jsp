<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 24.10.16
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FORM</title>
</head>
<body>
<form action="/quest" method="get">
    1. Do you like girls?<br>
    <input type="radio" name="q1" value="yes"/> Yes<br>
    <input type="radio" name="q1" value="no"/> No<br><br>
    2. Do you like money?<br>
    <input type="radio" name="q2" value="yes"/> Yes<br>
    <input type="radio" name="q2" value="no"/> No<br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
