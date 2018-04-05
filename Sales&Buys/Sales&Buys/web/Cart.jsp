<%-- 
    Document   : cart
    Created on : Oct 4, 2017, 8:10:11 PM
    Author     : ANITA-PC
--%>
<%@page import="java.util.Locale"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="Model.RecordInfoProcess.RecordInfoG_S"%>
<%@page import="Model.RecordInfoProcess.RecordInfoDAO"%>
<%@page import="Model.RecordInfoProcess.RecordInfoDAOImpl"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Detail Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       
    </head>
    <%       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
               HttpSession hs=request.getSession();
               
               int uiid=(Integer)hs.getAttribute("id");
             
               RecordInfoDAO rdao=new RecordInfoDAOImpl();
               
               List<RecordInfoG_S> list1=rdao.getallCarrecordbyId(uiid,1);
               request.setAttribute("record1", list1);
               List<RecordInfoG_S> list2=rdao.getallCarrecordbyId(uiid,2);
               request.setAttribute("record2", list2);
               List<RecordInfoG_S> list3=rdao.getallCarrecordbyId(uiid,3);
               request.setAttribute("record3", list3);

    %>
    <body>
        <c:import url="Header.jsp"></c:import>
        <div class="container foot">
            <h1><small>CART Booked Car Detail</small></h1><br>  
            <ul class="nav nav-tabs nav-justified">
                <li class="active"><a data-toggle="tab" href="Cart.jsp#home">Upcoming New Booked Car</a></li>
                <li><a data-toggle="tab" href="#menu1">Booked New Car</a></li>
                <li><a data-toggle="tab" href="#menu2">Booked Used Car</a></li>
            </ul>

          <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <div class="container">
                        <div class="row">
                            <div class="table table-responsive">
                                <table class="table table-striped">
                                <c:choose>
                                    <c:when test="${empty record1}">
                                        <tr class="text-center">
                                            <div class="col-md-offset-1 col-md-11"><br><br>   
                                                <h2>No Record are found...</h2>
                                            </div>    
                                        </tr>
                                </c:when>
                                <c:otherwise>    
                                    <thead class="panel-info">
                                        <tr class="text-center panel-heading"><br>
                                            <td><strong>Your Register: # item </strong></td>
                                            <td><strong>Name&Model</strong></td>
                                            <td><strong>Version</strong></td>
                                            <td><strong>No. of Car</strong></td>
                                            <td><strong>Total Price</strong></td>
                                            <td><strong>View</strong></td>
                                            <td><strong>Remove</strong></td>
                                        </tr>
                                    </thead>
                                <tbody>     
                                    <c:set var="total" scope="request" value="${0}"/>
                                    <c:forEach items="${record1}" var="x" >
                                        <tr class="text-center">
                                            <td>
                                                <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                            </td>	
                                            <td>${x.getNamemodel()}</td>
                                            <td>${x.getVersion()}</td>
                                            <td>
                                                <form action="UpdateQuantity" method="post">
                                                    <div class="input-group">
                                                        <input type="text" name="txt_quantity" value="${x.getNoofcar()}" class="form-control" size="1">
                                                        <input type="hidden" name="riid" value="${x.getRiid()}">
                                                        <span class="input-group-btn">
                                                        <input type="submit" value="Update" class="btn btn-default"></span>
                                                    </div>
                                                </form>
                                            </td>
                                            <td>
                                                <c:set var="qp" value="${x.getNoofcar() * x.getAmount()}" />
                                                <fmt:formatNumber value="${qp}" type="number" />
                                            </td>
                                            <c:forEach var="price" items="${x.getAmount()}">
                                                <c:set var="tot" value="${x.getNoofcar() * price}" />
                                                <c:set var="total"  value="${total + tot}" />
                                            </c:forEach>
                                            <td class="text-center"><a href="UpcomingProductView.jsp?cid=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                            <td class="text-center"><a href="DeleteRecordCart?riid=${x.getRiid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </c:otherwise>
                            </c:choose>
                        </table>
                    </div>
                    <c:if test="${not empty total}">
                        <hr>
                            <h1 class="text-right"><small>Total Amount: </small><b><fmt:formatNumber value="${total}" type="number" /></b></h1>
                        <hr></c:if>
                    </div>
                </div>
            </div>
            
            <div id="menu1" class="tab-pane fade">
                <div class="container">
		    <div class="row">
                        <div class="table table-responsive">
                        <table class="table table-striped">
                            <c:choose>
                                <c:when test="${empty record2}">
                                    <tr class="text-center">
                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                            <h2>No Record are found...</h2>
                                        </div>    
                                    </tr>
                                </c:when>
                                <c:otherwise>    
                                    <thead class="panel-info">
                                        <tr class="text-center panel-heading"><br>
                                            <td><strong>Your Booked: # item </strong></td>
                                            <td><strong>Name&Model</strong></td>
                                            <td><strong>Version</strong></td>
                                            <td><strong>No. of Car</strong></td>
                                            <td><strong>Total Price</strong></td>
                                            <td><strong>View</strong></td>
                                            <td><strong>Remove</strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="total1" scope="request" value="${0}"/>
                                        <c:forEach items="${record2}" var="x" >
                                            <tr class="text-center">
                                                <td>
                                                    <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                                </td>	
                                                <td>${x.getNamemodel()}</td>
                                                <td>${x.getVersion()}</td>
                                                <td>
                                                    <form action="UpdateQuantity" method="post">
                                                        <div class="input-group">
                                                        <input type="text" name="txt_quantity" value="${x.getNoofcar()}" class="form-control" size="1">
                                                        <input type="hidden" name="riid" value="${x.getRiid()}">
                                                        <span class="input-group-btn">
                                                        <input type="submit" value="Update" class="btn btn-default"></span></div>
                                                    </form>
                                                </td>
                                                <td>
                                                    <c:set var="qp1" value="${x.getNoofcar() * x.getAmount()}" />
                                                    <fmt:formatNumber value="${qp1}" type="number" />
                                                </td>
                                                <c:forEach var="price1" items="${x.getAmount()}">
                                                    <c:set var="tot1" value="${x.getNoofcar() * price1}" />
                                                    <c:set var="total1" scope="request" value="${total1 + tot1}" />
                                                </c:forEach>
                                                <td class="text-center"><a href="NewCarProductView.jsp?cid=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                                <td class="text-center"><a href="DeleteRecordCart?riid=${x.getRiid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </c:otherwise>
                            </c:choose>
                        </table> 
                    </div>
                    <c:if test="${not empty total1}">
                        <hr>
                        <h1 class="text-right"><small>Total Amount: </small><b><fmt:formatNumber value="${total1}" type="number" /></b></h1>
                        <hr>
                    </c:if>
                </div>
            </div>
        </div>
            <div id="menu2" class="tab-pane fade">
              <div class="container">
		    <div class="row">
                        <div class="table table-responsive">
                        <table class="table table-striped">
                            <c:choose>
                                <c:when test="${empty record3}">
                                    <tr class="text-center">
                                        <div class="col-md-offset-1 col-md-11"><br><br>   
                                            <h2>No Record are found...</h2>
                                        </div>    
                                    </tr>
                                </c:when>
                            <c:otherwise>    
                            <thead class="panel-info">
                                <tr class="text-center panel-heading"><br>
                                    <td><strong>Your Booked: # item </strong></td>
                                    <td><strong>Name&Model</strong></td>
                                    <td><strong>Version</strong></td>
                                    <td><strong>Expected Price</strong></td>
                                    <td><strong>View</strong></td>
                                    <td><strong>Check Detail</strong></td>            
                                    <td><strong>Remove</strong></td>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:set var="total2" scope="request" value="${0}"/>
                                <c:forEach items="${record3}" var="x" >
                                    <tr class="text-center">
                                        <td>
                                            <a class="" href="#"> <img class="" src="${x.getPic_name()}" style="width: 92px; height: 72px;"> </a>
                                        </td>	
                                        <td>${x.getNamemodel()}</td>
                                        <td>${x.getVersion()}</td>
                                        <td><fmt:formatNumber value="${x.getAmount()}" type="number" /></td>
                                            <c:forEach var="price" items="${x.getAmount()}">
                                                <c:set var="total2" scope="request" value="${total2 + price}" />
                                            </c:forEach>
                                        <td class="text-center"><a href="ProductView.jsp?id=${x.getCid()}" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;View</a></td>
                                        <td class="text-center"><a href="UsedCarSellerDetail.jsp?cid=${x.getCid()}" class="btn btn-info">Seller Detail</a></td>
                                        <td class="text-center"><a href="DeleteRecordCart?riid=${x.getRiid()}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;Remove</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:otherwise>
                    </c:choose>
                </table>
            </div>
            <c:if test="${not empty total2}">
                <hr>
                    <h1 class="text-right"><small>Total Amount: </small><b><fmt:formatNumber value="${total2}" type="number" /></b></h1>
                <hr>
            </c:if>
        </div>
    </div>
        </div>
              </div>
                    </div>
                <hr>
        <%@ include file = "Footer.jsp" %>
    </body>
</html>
