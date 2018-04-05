<%-- 
    Document   : AdminConsloe
    Created on : Sep 19, 2017, 12:18:37 PM
    Author     : ANITA-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Console Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body
                {
                    padding-top:50px;
                }
        </style>
    </head>
    <body>
    <%
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    %>        
    <c:import url="Header.jsp"></c:import> 
    <div class="container foot">
	<div class="row">
            <div class="col-md-12 col-sm-12">
                <h1>Admin Resources
                <span class="pull-right">
                    <a href="AddNewCarForm.jsp" class="btn btn-md btn-default">
                    <span class="glyphicon glyphicon-plus"></span> Add New Car</a>
                    <a href="AddUpcomingCarForm.jsp" class="btn btn-md btn-default">
                    <span class="glyphicon glyphicon-plus"></span> Add Upcoming Car</a>
                    <a href="wholeSalerform.jsp" class="btn btn-md btn-primary">
                    <span class="glyphicon glyphicon-plus"></span> Add WholeSaler</a>
                </span>   
                </h1>
            </div>
        </div><br><br>
            <div class="row">
                <div class="col-md-3">
                    <div class="thumbnail">                           
                        <div class="caption">
                            <h3><span class="glyphicon glyphicon-user"></span> 
                                View User Detail</h3>
                                <p>Insert, Update, Delete</p>
                            <p align="right">
                            <a href="viewprofile.jsp" class="btn btn-primary">View</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">                           
                        <div class="caption">
                            <h3>
                            <span class="glyphicon glyphicon-shopping-cart"></span> 
                                View Car Detail</h3>
                            <p>Insert, Update, Delete</p>
                            <p align="right">
                            <a href="AWCarDetail.jsp" class="btn btn-primary">View</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div><hr>
    <%@ include file = "Footer.jsp" %>
    </body>
</html>
