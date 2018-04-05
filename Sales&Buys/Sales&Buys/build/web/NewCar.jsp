<%-- 
    Document   : Category
    Created on : Aug 24, 2017, 11:20:36 AM
    Author     : ANITA-PC
--%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="Model.AddCarItem.AddItemG_S"%>
<%@page import="Model.AddCarItem.AddItemDAOImpl"%>
<%@page import="Model.AddCarItem.AddItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Car Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        
    </head>
    <%
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");    
        AddItemDAO aidao=new AddItemDAOImpl();
        List<AddItemG_S> list=aidao.getDetail();
        request.setAttribute("List",list);
    
        ArrayList<AddItemG_S> list1=(ArrayList)aidao.new_dta();
        JSONArray  json=new JSONArray();
        for (AddItemG_S a: list1) 
        {
            json.add(a.getJSONObject1());
        }
        String jsonData=json.toString();
    %>
    <c:set var="new_dta" value="<%=jsonData%>"/>
    <script>
        var app=angular.module("myApp",[]);
        app.controller("myController",function($scope) 
        {
            $scope.data=${new_dta};   
        });
    </script>
    <body ng-app="myApp" ng-controller="myController">
        <c:import url="Header.jsp"></c:import>
        <div class="well">    
            <h1  align="center"><b>ALL NEW CAR</b></h1>
            <input class="form-control" ng-model="search.name" type="text" placeholder="Search for a car..."><br>
        </div>
        <div id="AddItemG_S" class="container"><hr>
            <div class="row">
                <div class="col-md-4" ng-repeat="x in data| filter:search">
                    <div class="panel panel-default">
                        <a href="NewCarProductView.jsp?cid={{x.cid}}">
                        <img src="{{x.picname}}" alt="Lights" width="100%" height="250px"><br></a>
                        <div class="panel-body text-capitalize">
                            <a href="ViewAddCar.jsp" target="_blank"><h3><p align="left">{{x.name}}</p></h3></a>
                            <span class="text-warning">
                                <p align="left"><b>&nbsp;{{x.version}}</b></p>
                                <p align="left"><b>&nbsp;{{x.mileage}} km</b></p>
                                <p align="left"><b>&nbsp;{{x.city}}</b></p>
                                <h4><p align="left">Ex-showroom<b>&nbsp;₹ {{x.firstrange}}-{{x.secondrange}}&nbsp{{x.rangeinword}}</b></p></h4>
                            </span>
                            <p align="right" ><a href="NewCarProductView.jsp?cid={{x.cid}}" class="btn btn-success">Read More</a>
                        </div>
                    </div>       
                </div>
            </div>
        </div>
         <%@ include file = "Footer.jsp" %>
    </body>
</html>
