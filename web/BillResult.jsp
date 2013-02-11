<%-- 
    Document   : BillResult
    Created on : Feb 11, 2013, 12:42:31 PM
    Author     : Skybeorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Result</title>
    </head>
    <body>
        Your total Bill with Sales Tax and a 15% tip is:
        <% out.print(request.getAttribute("bill"));%> 
        <br /><br />
        <p>Please pay your server or 
            <a href="OrderPage.jsp"><strong>Continue Your Order</strong></a></p>
        
    </body>
</html>