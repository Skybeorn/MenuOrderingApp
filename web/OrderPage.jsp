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
        <form id="one" name="one" method="POST" action="MenuInput" >
            <p> Is this a New Order?</p>
            <select id="isNewOrder" name="isNewOrder" >
                <option value="YES">Yes</option>
                <option value="NO">No</option>
                <option value="empty" selected="empty"></option>
            </select>
            <br>
            <h1> Please select a menu Choice</h1>
            <select id="menuChoice" name="menuChoice">
                <option value="comboOne">Nachos w/Chorizo</option>
                <option value="comboTwo">Nachos w/Beef</option>
            </select>
            <input type="submit" value="ADD TO ORDER"></input>

        </form>
    </body>
</html>
