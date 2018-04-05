<%-- 
    Document   : wholeSalerConsole
    Created on : Oct 19, 2017, 12:53:28 PM
    Author     : ANITA-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WholeSaler Page</title>
        

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    </head>
<%
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
    <body>
       
    <c:import url="Header.jsp"></c:import> 
    <div class="container">
	<div class="row">
            <div class="col-md-12 col-sm-12">
    		  <h1>WholeSaler Resources
        	   <span class="pull-right">
                    <a href="UsedCarForm.jsp" class="btn btn-md btn-default">
                    <span class="glyphicon glyphicon-plus"></span> Add Used Car</a>
                    <a href="AddNewCarForm.jsp" class="btn btn-md btn-default">
                    <span class="glyphicon glyphicon-plus"></span> Add New Car</a>
                    <a href="AddUpcomingCarForm.jsp" class="btn btn-md btn-primary">
                    <span class="glyphicon glyphicon-plus"></span> Add Upcoming Car</a>
                      
                   
                </span>   
    		  </h1>
		</div>
		
        </div><br><br>
                <div class="row">
                <div class="col-md-12">
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
                    
                </div>
    </div>
    </body>
</html>
