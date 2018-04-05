<%-- 
    Document   : wholeSellerform
    Created on : Sep 19, 2017, 9:38:43 PM
    Author     : ANITA-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WholeSaler Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    %>
    <body>
           <c:import url="Header.jsp"></c:import>
            <form  action="Dowholesignup" method="post" style="margin: auto; width: 65%;">
                <input type="hidden" name="currentDate" value="<%=new Date()%>">
                <input type="hidden" name="uid" value="2"/>
                <h1 align="center">WholeSeller sign up form</h1>
                <label>Name:</label>
                <input type="text" name="txt" value=""  class="form-control" placeholder="Enter your Name" required><br>
                <label>Phone no:</label>
                <input type="number" name="txt" value="" class="form-control" placeholder="Enter your Phone no." required><br>
                <label>Email:</label>
                <input type="Email" name="txt" value="" class="form-control" placeholder="Enter your Email" required><br>
                <label>Password:</label>
                <input type="password" name="txt" value="" class="form-control" placeholder="Enter your Password " required><br>
                <label>Address:</label>
                <textarea name="txt" class="form-control" placeholder="Enter your Address" required></textarea><br>
                 <input type="submit" value="Submit" class="btn btn-success">
            </form>
            <hr>
	
        <%@ include file = "Footer.jsp" %>
    </body>
    
</html>
