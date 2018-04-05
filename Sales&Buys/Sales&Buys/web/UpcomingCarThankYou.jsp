<%-- 
    Document   : UpcomingCarThankYou
    Created on : Oct 4, 2017, 1:13:54 PM
    Author     : ANITA-PC
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you Page</title>
     
    </head>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        HttpSession hs=request.getSession();
        Integer uid=(Integer)hs.getAttribute("uid");
    %>
    <body>
        <c:import url="Header.jsp"></c:import><br>
        <div class="container text-center">
            <h1>Thank you <small>For Booked the car</small></h1>
            <hr>
            <div class="text-left">
                <h1>
                <small>Now You Can Go To </small><a href="Index.jsp">Home</a><hr>
                <c:set var = "uid" scope = "session" value ="<%= uid%>" />        
                <c:if test="${name != null}">
                    <c:if test="${uid == 1}">
                        <small>Now You Check Your Post Car Detail </small><a href="AdminConsole.jsp">Post Detail</a><hr>
                    </c:if>
                    <c:if test="${uid == 2}">
                        <small>Now You Check Your Post Car Detail </small><a href="wholeSalerConsole.jsp">Post Detail</a><hr>
                    </c:if>
                    <c:if test="${uid == 3}">
                        <small>Now You Check Your Post Car Detail </small><a href="AWCarDetail.jsp">Post Detail</a><hr>
                    </c:if>
                </c:if>
                <small>If You Have Select More Than Five Quantity Please UPDATE From Cart Detail Here </small><a href="Cart.jsp">Cart</a><hr>        
                </h1>
            </div>
        </div>
    </body>
</html>
