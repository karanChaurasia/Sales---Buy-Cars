<%-- 
    Document   : Login
    Created on : Aug 24, 2017, 10:53:51 AM
    Author     : ANITA-PC
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%
           response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    %>
    <style>
        .jumbotron
        {
            height: 100%;
            background-color:tomato !important; 
        }
        body
	{
		padding-top:50px;
	}
        .form-group
        {
            padding-left: 60px;
            width:80%;
        }
    </style>
    <body>
        <c:import url="Header.jsp"></c:import>
        <div class="jumbotron" >
            <div class="container"><br>
                <h1 class="form-group"><b>Login form</b></h1>
                <form action="DoLogin" method="post" >
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control"  placeholder="Enter email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password:</label>
                        <input type="password" class="form-control" id="myInput" placeholder="Enter password" name="txt_Password" required>
                    </div>
                    <div class="checkbox form-group">
                        <label><input type="checkbox" onclick="myFunction()">Show Password</label>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Submit" class="btn btn-success">
                    </div>
                    <div class="form-group">
                        <h4><bold> If you have no account then <a href="Signup.jsp"> Click me</a></bold></h4>
                    </div>
                </form>
             </div>
        </div>
        <%@ include file = "Footer.jsp" %>
        <script>
            function myFunction() 
            {
                var x = document.getElementById("myInput");
                if (x.type === "password") 
                {
                    x.type = "text";
                } else 
                {
                    x.type = "password";
                }
            }
        </script> 
    </body>
</html>
