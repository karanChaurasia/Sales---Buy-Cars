<%-- 
    Document   : viewprofile
    Created on : Aug 18, 2017, 3:08:08 AM
    Author     : ANITA-PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Model.Profile.ProfileG_S"%>
<%@page import="Model.Profile.ProfileDAOImpl"%>
<%@page import="Model.Profile.ProfileDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Profile Page</title>

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
    <%         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        ProfileDAO pdao=new ProfileDAOImpl();
        List<ProfileG_S> list=pdao.getprofile();
        
        request.setAttribute("product", list);
    %>
    <body>
            <c:import url="Header.jsp"></c:import>
            <div class="container" >
        <div class="row">    
            <div class="col-md-12"><br>
                <h1 style="margin:auto; alignment-adjust: central"><small>VIEW USERS PROFILE DETAILS</small>
                <span class="pull-right">
                    <a href="Signup.jsp" class="btn btn-md btn-primary">
                        <span class="glyphicon glyphicon-plus"></span> Add User</a>
                </span></h1><br><br>
        </div>
        </div>
            <div class="table-responsive">    
        <table class="table table-striped table-hover" style="margin:auto; text-align: center;">
        
            <thead class="panel-info">
            <tr class="panel-heading">
                    <th>UIID</th>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>CONTACT</th>
                    <th>ADDRESS</th>
                    <th>USERTYPE</th>
                    <th>SIGNUP DETAIL</th>
                    <th>DELETE</th>
                    <th>UPDATE</th>
            </tr>
            </thead>
        
        <tbody>
            <c:forEach items="${product}"   var="x" >
            <tr>
                    <th>${x.getUiid()}</th>
                    <th>${x.getName()}</th>
                    <th>${x.getEmail()}</th>
                    <th>${x.getPhone()}</th>
                    <th>${x.getAddress()}</th>
                    <th>${x.getUid()}</th>
                    <th>${x.getDate()}</th>
                    <th><a href="DeleteFromDB?id=${x.getUiid()}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a></th>
                    <th><a href="ProfileUpdate.jsp?id=${x.getUiid()}" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></a></th>
            </tr>
            </c:forEach>
        </tbody>
        </table></div>
            </div>
                <hr>             <%@ include file = "Footer.jsp" %>
    </body>
</html>
