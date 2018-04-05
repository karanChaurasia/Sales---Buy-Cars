<%-- 
    Document   : AWCarDetail
    Created on : Oct 31, 2017, 7:20:08 PM
    Author     : ANITA-PC
--%>
<%@page import="Model.Profile.ProfileG_S"%>
<%@page import="Model.Profile.ProfileDAOImpl"%>
<%@page import="Model.Profile.ProfileDAO"%>
<%@page import="Model.UpcomingCar.UpcomingCarG_S"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAOImpl"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAO"%>
<%@page import="Model.AddCarItem.AddItemG_S"%>
<%@page import="Model.AddCarItem.AddItemDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@page import="Model.AddCarItem.AddItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Detail Page</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                
    </head>
    <%         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       HttpSession hs=request.getSession();
       int uiid=(Integer)hs.getAttribute("id");
       int uid=(Integer)hs.getAttribute("uid");
    
       UsedCarDao ucdao=new UsedCarDAOImpl();
       List<UsedCarG_S> list3=ucdao.getallrecordbyUserId(uiid);
       request.setAttribute("list3",list3);
       
       AddItemDAO adao=new AddItemDAOImpl();
       List<AddItemG_S> list2=adao.getallDetailbyUserId(uiid);
       request.setAttribute("list2",list2);
       
       UpcomingCarDAO udao=new UpcomingCarDAOImpl();
       List<UpcomingCarG_S> list1=udao.getUpcomingByUiid(uiid);
       request.setAttribute("list1",list1);
       
       ProfileDAO pdao=new ProfileDAOImpl();
        List<ProfileG_S> list4=pdao.getbookedrecordbyuiid(uiid,3);
       request.setAttribute("list4",list4);
       List<ProfileG_S> list5=pdao.getbookedrecordbyuiid(uiid,2);
       request.setAttribute("list5",list5);
       List<ProfileG_S> list6=pdao.getbookedrecordbyuiid(uiid,1);
       request.setAttribute("list6",list6);
       
    %>
    <body>
            <c:import url="Header.jsp"></c:import>
                <c:set var = "uid" scope = "session" value ="<%= uid%>" />
                <div class="container foot">
                    <div class="row">
                        <div class="col-md-12"><br>
                            <h1 style="margin:auto; alignment-adjust: central;">
                            <small style="padding-left: 5%">YOUR CAR POST DETAILS</small>
                            <span class="pull-right">
                                <a href="" class="btn btn-lg btn-default" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;Booked Detail</a>
                            </span></h1>
                        </div>
                    </div><br>      
                    <ul class="nav nav-tabs nav-justified">
                        <c:if test="${uid != 3}">
                            <li class="active"><a data-toggle="tab" href="#home">Your Used Car Post</a></li>
                            <li><a data-toggle="tab" href="#menu1">Your New Car Post</a></li>
                            <li><a data-toggle="tab" href="#menu2">Your Upcoming Car Post</a></li>
                        </c:if>
                    </ul>

                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">
                            <div class="container">
                                <div class="row">
                                    <div class="table table-responsive">
                                        <table class="table table-striped">
                                        <c:choose>
                                            <c:when test="${empty list3}">
                                                <tr class="text-center">
                                                    <div class="col-md-offset-1 col-md-11"><br><br>   
                                                        <h2>No Record are found...</h2>
                                                    </div>    
                                                </tr>
                                            </c:when>
                                        <c:otherwise>    
                                            <thead class="panel-info">
                                                <tr class="text-center panel-heading"><br>
                                                    <td><strong>#Your Used Car </strong></td>
                                                    <td><strong>Name&Model</strong></td>
                                                    <td><strong>Version</strong></td>
                                                    <td><strong>Expected Price</strong></td>
                                                    <td><strong>View</strong></td>
                                                    <td><strong>Update</strong></td>
                                                    <td><strong>Delete</strong></td>
                                                </tr>
                                            </thead>
                                            <tbody>        
                                                <c:forEach items="${list3}" var="x" >
                                                    <tr class="text-center">
                                                        <td>
                                                        <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                                        </td>	
                                                        <td>${x.getNamemodel()}</td>
                                                        <td>${x.getVersion()}</td>
                                                        <td>${x.getAmount()} ${x.getAmountinword()}</td>
                                                        <td class="text-center"><a href="ProductView.jsp?id=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                                        <td class="text-center"><a href="UpdateUsedCarForm.jsp?cid=${x.getCid()}" class="btn btn-success"><span class="glyphicon glyphicon-edit"></span>&nbsp;Edit</a></td>
                                                        <td class="text-center"><a href="DeleteFromUsedCar?cid=${x.getCid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:otherwise>
                                    </c:choose>
                                </table>
                            </div> 
                        </div>
                    </div>
                </div>
                <c:if test="${uid != 3}">
                <div id="menu1" class="tab-pane fade">
                <div class="container">
		    <div class="row">
                        <div class="table table-responsive">
                        <table class="table table-striped">
                            <c:choose>
                                <c:when test="${empty list2}">
                                    <tr class="text-center">
                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                            <h2>No Record are found...</h2>
                                        </div>    
                                    </tr>
                                </c:when>
                                <c:otherwise>    
                                    <thead class="panel-info">
                                        <tr class="text-center panel-heading"><br>
                                            <td><strong>#Your Car </strong></td>
                                            <td><strong>Name&Model</strong></td>
                                            <td><strong>Version</strong></td>
                                            <td><strong>Ex-show Room Price</strong></td>
                                            <td><strong>View</strong></td>
                                            <td><strong>Update</strong></td>
                                            <td><strong>Delete</strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>        
                                        <c:forEach items="${list2}" var="x" >
                                            <tr class="text-center">
                                                <td>
                                                    <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                                </td>	
                                                <td>${x.getNamemodel()}</td>
                                                <td>${x.getVersion()}</td>
                                                <td>${x.getFirstrange()}-${x.getSecondrange()} ${x.getRangepriceinword()}</td>
                                                <td class="text-center"><a href="NewCarProductView.jsp?cid=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                                <td class="text-center"><a href="UpdateAddItem.jsp?cid=${x.getCid()}" class="btn btn-success"><span class="glyphicon glyphicon-edit"></span>&nbsp;Edit</a></td>
                                                <td class="text-center"><a href="DeleteFromAddItem?cid=${x.getCid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                            </tr>
                                        </c:forEach>
                                </c:otherwise>
                            </c:choose>
                                            
                            </tbody>
                        </table> </div>
                    </div>
                </div>
                </div>
                
                <div id="menu2" class="tab-pane fade">
                  
                <div class="container">
		    <div class="row">
                        <div class="table table-responsive">
                        <table class="table table-striped">
                            <c:choose>
                                <c:when test="${empty list1}">
                                    <tr class="text-center">
                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                            <h2>No Record are found...</h2>
                                        </div>    
                                    </tr>
                                </c:when>
                                <c:otherwise>    
                                    <thead class="panel-info">
                                        <tr class="text-center panel-heading"><br>
                                            <td><strong>#Your Car </strong></td>
                                            <td><strong>Name&Model</strong></td>
                                            <td><strong>Version</strong></td>
                                            <td><strong>Ex-show Room Price</strong></td>
                                            <td><strong>View</strong></td>
                                            <td><strong>Update</strong></td>
                                            <td><strong>Delete</strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>        
                                        <c:forEach items="${list1}" var="x" >
                                            <tr class="text-center">
                                                <td>
                                                    <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                                </td>	
                                                <td>${x.getNamemodel()}</td>
                                                <td>${x.getVersion()}</td>
                                                <td>${x.getFirstrange()}-${x.getSecondrange()} ${x.getRangepriceinword()}</td>
                                                <td class="text-center"><a href="UpcomingProductView.jsp?cid=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                                <td class="text-center"><a href="UpdateUpcomingcarForm.jsp?cid=${x.getCid()}" class="btn btn-success"><span class="glyphicon glyphicon-edit"></span>&nbsp;Edit</a></td>
                                                <td class="text-center"><a href="DeleteUpcomingcar?cid=${x.getCid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                               
                                            </tr>
                                        </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table> 
                        </div>
                    </div>
                </div>
                </div></c:if>
            </div>
                         <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog modal-lg">
                      <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Booked Car Detail</h4>
                        </div>
                        <div class="modal-body">
                            <ul class="nav nav-tabs nav-justified">
                                <c:if test="${uid != 3}">
                                    <li class="active"><a data-toggle="tab" href="#home1">Your Used Car Post</a></li>
                                    <li><a data-toggle="tab" href="#menu11">Your New Car Post</a></li>
                                    <li><a data-toggle="tab" href="#menu12">Your Upcoming Car Post</a></li>
                                </c:if>
                            </ul>
                            <div class="tab-content">
                                <div id="home1" class="tab-pane fade in active">
                                    <div class="table table-responsive">
                                        <table class="table table-striped">
                                            <c:choose>
                                                <c:when test="${empty list4}">
                                                    <tr class="text-center">
                                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                                            <h2>No Record are found...</h2>
                                                        </div>    
                                                    </tr>
                                                </c:when>
                                        <c:otherwise>    
                                            <thead class="panel-info">
                                                <tr class="text-center panel-heading"><br>
                                                    <td><strong>#Your Car</strong></td> 
                                                    <td><strong>Booked BY</strong></td>
                                                    <td><strong>Email</strong></td>
                                                    <td><strong>Phone no.</strong></td>
                                                    <td><strong>Address </strong></td>
                                                </tr>
                                            </thead>
                                            <tbody>        
                                                <c:forEach items="${list4}" var="x" >
                                                    <tr class="text-center">
                                                        <td>
                                                            <a class="" href="#"> <img class="" src="${x.getImageofbookedcar()}" style="width: 92px; height: 72px;"> </a>
                                                        </td>	
                                                        <td>${x.getName()}</td>
                                                        <td>${x.getEmail()}</td>
                                                        <td>${x.getPhone()}</td>
                                                        <td>${x.getAddress()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:otherwise>
                                    </c:choose>
                                </table> 
                            </div>
                        </div>
                        <c:if test="${uid != 3}">
                            <div id="menu11" class="tab-pane fade">
                                <div class="table table-responsive">
                                    <table class="table table-striped">
                                    <c:choose>
                                        <c:when test="${empty list5}">
                                            <tr class="text-center">
                                                <div class="col-md-offset-1 col-md-11"><br><br>   
                                                    <h2>No Record are found...</h2>
                                                </div>    
                                            </tr>
                                        </c:when>
                                        <c:otherwise>    
                                            <thead class="panel-info">
                                                <tr class="text-center panel-heading"><br>
                                                    <td><strong>#Your Car</strong></td> 
                                                    <td><strong>Booked BY</strong></td>
                                                    <td><strong>Email</strong></td>
                                                    <td><strong>Phone no.</strong></td>
                                                    <td><strong>Address </strong></td>
                                                </tr>
                                            </thead>
                                            <tbody>        
                                                <c:forEach items="${list5}" var="x" >
                                                    <tr class="text-center">
                                                        <td>
                                                            <a class="" href="#"> <img class="" src="${x.getImageofbookedcar()}" style="width: 92px; height: 72px;"> </a>
                                                        </td>	
                                                        <td>${x.getName()}</td>
                                                        <td>${x.getEmail()}</td>
                                                        <td>${x.getPhone()}</td>
                                                        <td>${x.getAddress()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </c:otherwise>
                                    </c:choose>
                               </table>
                            </div>
                        </div>
                
                <div id="menu12" class="tab-pane fade">
                    <div class="table table-responsive">
                        <table class="table table-striped">
                            <c:choose>
                                <c:when test="${empty list6}">
                                    <tr class="text-center">
                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                            <h2>No Record are found...</h2>
                                        </div>    
                                    </tr>
                                </c:when>
                                <c:otherwise>    
                                    <thead class="panel-info">
                                        <tr class="text-center panel-heading"><br>
                                            <td><strong>#Your Car</strong></td> 
                                            <td><strong>Booked BY</strong></td>
                                            <td><strong>Email</strong></td>
                                            <td><strong>Phone no.</strong></td>
                                            <td><strong>Address </strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>        
                                        <c:forEach items="${list6}" var="x" >
                                            <tr class="text-center">
                                                <td>
                                                    <a class="" href="#"> <img class="" src="${x.getImageofbookedcar()}" style="width: 92px; height: 72px;"> </a>
                                                </td>	
                                                <td>${x.getName()}</td>
                                                <td>${x.getEmail()}</td>
                                                <td>${x.getPhone()}</td>
                                                <td>${x.getAddress()}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </c:otherwise>
                            </c:choose>
                        </table>
                    </div>
                </div>
            </c:if>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
                </div>
                    </div>
                        </div>
                            </div>
                                </div>
                                    </div><hr>
            <%@ include file = "Footer.jsp" %>
    </body>
</html>
