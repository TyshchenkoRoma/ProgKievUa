<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Prog.kiev.ua</title>
    </head>
    <body>
        <div align="center">
            <h1>All fotos:</h1>

            <input type="submit" value="Delete Photo" onclick="window.location='/delete/${photo_id}';" />
            <input type="submit" value="Upload New" onclick="window.location='/';" />

            <br/><br/><img src="/table/${photo_id}" />
        </div>
    </body>
</html>