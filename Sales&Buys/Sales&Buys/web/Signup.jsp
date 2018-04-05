
<%-- 
    Document   : Signup
    Created on : Aug 25, 2017, 3:06:05 PM
    Author     : ANITA-PC
--%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> 
        <style>
            .jumbotron
            {
                height: 100%;
                background-color:tomato !important; 
            }
            .form-group
            {
                padding-left: 60px;
                width:80%;
            }
        </style>
    </head>
    <body>
        <c:import url="Header.jsp"></c:import>
        <div class="jumbotron">
            <div class="container foot">
                <h1 class="form-group"><b>SignUp Form</b></h1>
                <form  action="Dosignup" method="post">
                    <input type="hidden" name="currentDate" value="<%=new Date()%>">
                    <input type="hidden" name="uid" value="3"/>
                    <div class="form-group">
                        <label>Name:</label>
                        <input type="text" name="txt" value="" minlength="4" maxlength="12"  class="form-control" placeholder="Enter your Name" required/>
                    </div>
                    <div class="form-group">
                        <label>Phone no:</label>
                        <input type="text" name="txt"  class="form-control" pattern="[1-9]{10}" maxlength="10" title="Enter 10 digit Phone number" placeholder="Enter your Phone no." required/>
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" id="ValEmail" name="txt" class="form-control" placeholder="Enter your Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/>
                    </div>
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" name="txt" class="form-control" minlength="8" maxlength="20" placeholder="Enter your Password " required>
                    </div>
                    <div class="form-group">
                        <label>Address:</label>
                        <textarea name="txt" class="form-control" minlength="10" maxlength="20" placeholder="Enter your Address" required></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Submit" class="btn btn-success" onclick="myFunction()"/>
                    </div>
                    <div class="form-group">
                        <h4><bold> If you have already account then<a href="Login.jsp"> Click me</a></bold></h4>
                    </div>
                </form>
            </div>
        </div>
        <%@ include file = "Footer.jsp" %>
        <script>
            function myFunction() 
            {
                var x = document.getElementById("ValEmail").pattern;
                document.getElementById("demo").innerHTML = x;
            }
        </script>
    </body>
</html>
