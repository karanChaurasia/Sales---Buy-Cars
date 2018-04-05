<%-- 
    Document   : ProductView
    Created on : Sep 15, 2017, 12:19:58 PM
    Author     : badree.tiwari
--%>

<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Old Car Page</title>
        <link href="viewproduct.css" rel="stylesheet"> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body
                {
                    padding-top:10px;
                }
        </style>
    </head>
    <%  
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        int cid=Integer.parseInt(request.getParameter("id"));
        UsedCarDao ucdao=new UsedCarDAOImpl();
        UsedCarG_S u=ucdao.getOldCarDetailByID(cid);
    %>
    <body>
        <c:import url="Header.jsp"></c:import>   
	<div class="container foot">
            <div class="card">
                <div class="container-fliud">
                    <div class=" row">
                        <div class="preview col-md-6">
                            <div class="preview-pic tab-content">
                                <div class="tab-pane active" id="pic-1"><img src="<%=u.getPic_name()%>" width="450" height="350"/></div>
                                <div class="tab-pane" id="pic-2"><img src="" /></div>
                                <div class="tab-pane" id="pic-3"><img src="" /></div>
                                <div class="tab-pane" id="pic-4"><img src="" /></div>
                                <div class="tab-pane" id="pic-5"><img src="" /></div>
                            </div>
                            <ul class="preview-thumbnail nav nav-tabs">
                                <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="<%=u.getPic_name()%>" /></a></li>
                                <li><a data-target="#pic-2" data-toggle="tab"><img src="" /></a></li>
                                <li><a data-target="#pic-3" data-toggle="tab"><img src="" /></a></li>
                                <li><a data-target="#pic-4" data-toggle="tab"><img src="" /></a></li>
                                <li><a data-target="#pic-5" data-toggle="tab"><img src="" /></a></li>
                            </ul>
                            <c:set var = "sd" scope = "session" value ="<%=u.getShort_description()%>" />
                            <c:if test="${sd != ''}">
                                <div class="text-warning"><br>
                                    <h2><small><strong>Reason of car Selling-</strong>&nbsp;<span class="text-warning"><%=u.getShort_description()%></span></small></h2></p>
                                </div>
                            </c:if>
                        </div>
                        <div class="details col-md-6">
                            <h3 class="product-title"><%=u.getNamemodel()%></h3>
                                <div class="rating">
                                    <div class="stars">
                                        <c:set var = "star" scope ="session" value = "<%=u.getRating()%>"/>	
                                        <c:choose>
                                            <c:when test = "${star == 5}">
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                            </c:when>
                                            <c:when test = "${star == 4}">
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star"></span>
                                            </c:when> 
                                            <c:when test = "${star == 3}">
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                            </c:when>
                                            <c:when test = "${star == 2}">
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="fa fa-star checked"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                                <span class="fa fa-star"></span>
                                            </c:otherwise>            
                                        </c:choose>
                                    </div>
                                    <span class="review-no"><b>Car condition rating</b></span>
                                </div>
                                <table class="table table-bordered product-description text-warning">
                                    <thead>
                                        <tr>
                                            <th>Version</th>
                                            <th><%=u.getVersion()%></th>                                                            
                                        </tr>
                                        <tr>
                                            <th>Fuel type</th>
                                            <th><%=u.getFuel_type()%></th>                                                            
                                        </tr>
                                        <tr>
                                            <th>Mileage</th>
                                            <th><%=u.getMileage()%> km</th>                                                            
                                        </tr>
                                        <tr>
                                            <th>Year</th>
                                            <th><%=u.getYear_manufacture()%></th>                                                            
                                        </tr>
                                        <tr>
                                            <th>No. of Owner</th>
                                            <th><%=u.getNo_of_owner()%></th>                                                            
                                        </tr>
                                        <tr>
                                            <th>Location</th>
                                            <th><%=u.getLocation()%></th>                                                            
                                        </tr>
                                        <tr>
                                            <th>City</th>
                                            <th><%=u.getCity()%></th>                                                            
                                        </tr>
                                    </thead> 
                                </table>
                                <h4 class="price">Expected price: <span><%=u.getAmount()%> <%=u.getAmountinword()%></span></h4>
                                <div class="details action">
                                    <form action="RecordInfo" method="post">    
                                        <input type="hidden" name="cid" value="<%=u.getCid()%>">
                                        <input type="hidden" name="rid" value="3">
                                        <input type="hidden" name="txt_noofcar" value="1">
                                        <div class="form-group">
                                            <input type="submit" value="Click for Booked a car" class="btn btn-success btn-lg btn-block">                                   							
                                        </div>
                                    </form>	
                                </div>
                            </div>
                        </div>
                    </div>
		</div>
            </div>
        <hr>
	<%@ include file = "Footer.jsp" %>
    </body>
</html>
