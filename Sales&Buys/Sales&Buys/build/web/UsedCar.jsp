<%-- 
    Document   : SellOldCar
    Created on : Sep 13, 2017, 11:33:02 AM
    Author     : ANITA-PC
--%>



<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@page import="java.util.List"%>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Used Car Page</title>
    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>  
   
    </head>
    <%       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
        UsedCarDao ucdao=new UsedCarDAOImpl();
        ArrayList<UsedCarG_S> list1=(ArrayList)ucdao.used_dta();
        JSONArray  json=new JSONArray();
        for (UsedCarG_S u: list1) {
            json.add(u.getJSONObject());
        }
        String jsonData=json.toString();

  
        %>
        
                    <c:set var="used_dta" value="<%=jsonData%>"/>
    <script>
            var app=angular.module("myApp",[]);
            app.controller("myController",function($scope) {
    $scope.data=${used_dta};
//    $scope.checkjson=function()
//    $scope.message="";
//    {
//        if(data.length===0)
//        {
//            message="No data found";        }
//    }
//    
});
     </script>
    <body ng-app="myApp" ng-controller="myController">
        <c:import url="Header.jsp"></c:import>
        
        <div class="well" >    
            <h1 align="center"><b>ALL USED CAR</b></h1>
            <input class="form-control" ng-model="search.name" type="text" placeholder="Search.."><br>
        </div>
        <div class="container">    
        <hr>
            <div  id="UsedCarG_S" class="container-fluid"   >
                 <!--{{data | filter:sea}}-->
                 <!--{{message}}-->
                <div class="row"> 
                    <div class="col-md-4" ng-repeat="x in data| filter:search" >
                    <div class="panel panel-default">
                    <a href="ProductView.jsp?id={{x.cid}}">
                    <img src="{{x.picname}}" width="100%" height="250px"></a>
                    <div class="panel-body text-capitalize">   
                        <a href="ProductView.jsp?id={{x.cid}}" target="_blank">
                        <h4><p align="left">{{x.name}}</p></h4></a>
                        <span class="text-warning">
                            <p align="left"><b>&nbsp;{{x.version}}</b></p>
                            <p align="left"><b>&nbsp;{{x.fuel}}</b></p>
                            <p align="left"><b>&nbsp;{{x.city}}</b></p>
                        <h4><p align="left" >Expected amount<b>&nbsp;₹ {{x.amount}}{{x.amountinword}}</b></p></h4>
                        </span>
                            <p align="right"> <a href="ProductView.jsp?id={{x.cid}}" class="btn btn-success">Read More</a></p>

                    </div>
                    </div>
                </div>
                </div>
            </div>
            
        </div>
        <%@ include file = "Footer.jsp" %>


    </body>
</html>
