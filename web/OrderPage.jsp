<%-- 
    Document   : index
    Created on : Feb 5, 2013, 10:59:54 AM
    Author     : Skybeorn
--%>

<%@page import="Model.FoodCombo"%>
<%@page import="Model.FakeDB"%>
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
                <%
                    for (FoodCombo menuItem : FakeDB.combos) {
                        String item = menuItem.getName();
                        double itemPrice = menuItem.getPrice();
                        String description = menuItem.getDescription();
                %>

                <option value="<%= item%>"><%= (description + ", " + itemPrice)%></option>

                <%
                    }
                %>
            </select>

            <input type="submit" value="ADD TO ORDER"></input>

        </form>
    </body>
</html>
