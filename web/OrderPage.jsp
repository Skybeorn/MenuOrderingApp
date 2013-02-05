<%-- 
    Document   : index
    Created on : Feb 5, 2013, 10:59:54 AM
    Author     : Skybeorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <form id="one" name="one" method="POST" action="MenuInput">

            <select name="menuChoice">
                <option value="Steak">Steak</option>
                <option value="Lobster">Lobster</option>
                <option value="Chili">Chili</option>
            </select>

            <input type="submit" value="Order"></input>

        </form>
    </body>
</html>
