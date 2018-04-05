<%-- 
    Document   : NewProductView
    Created on : Sep 27, 2017, 10:27:57 AM
    Author     : ANITA-PC
--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="Model.AddCarItem.AddItemG_S"%>
<%@page import="Model.AddCarItem.AddItemDAOImpl"%>
<%@page import="Model.AddCarItem.AddItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Car Page</title>
        <link href="viewproduct.css" rel="stylesheet"> 
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            int cid=Integer.parseInt(request.getParameter("cid"));
            AddItemDAO adao=new AddItemDAOImpl();
            AddItemG_S a=adao.getDetailbyCarId(cid);
        %>

    <body>
        <c:import url="Header.jsp"></c:import>
        <div class="container">
            <div class="card">
                <div class="container-fliud">
                        <div class=" row">
                            <div class="preview col-md-6"><br><br>
                                <div class="preview-pic tab-content">
                                    <div class="tab-pane active" id="pic-1"><img src="<%=a.getPic_name()%>" width="100%" height:auto/></div>
                                    <div class="tab-pane" id="pic-2"><img src="" /></div>
                                    <div class="tab-pane" id="pic-3"><img src="" /></div>
                                    <div class="tab-pane" id="pic-4"><img src="" /></div>
                                    <div class="tab-pane" id="pic-5"><img src="" /></div>
                                </div>
                                <ul class="preview-thumbnail nav nav-tabs">
                                    <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="<%=a.getPic_name()%>" /></a></li>
                                    <li><a data-target="#pic-2" data-toggle="tab"><img src="" /></a></li>
                                    <li><a data-target="#pic-3" data-toggle="tab"><img src="" /></a></li>
                                    <li><a data-target="#pic-4" data-toggle="tab"><img src="" /></a></li>
                                    <li><a data-target="#pic-5" data-toggle="tab"><img src="" /></a></li>
                                </ul><br>
                                <h4 class="price">Ex-showroom price: <span><%=a.getFirstrange()%> - <%=a.getSecondrange()%>&nbsp<%=a.getRangepriceinword()%></span></h4>
                            </div>
                            <div class="details col-md-6">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a data-toggle="tab" href="#menu1">Car Detail</a></li>
                                    <li ><a data-toggle="tab" href="#home">Overview</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div id="home" class="tab-pane fade">
                                        <div class="container-fliud"><br>
                                            <h2 class="product-title" ><%=a.getNamemodel()%></h2>  
                                            <h3><b><%=a.getShort_description()%></b></h3>
                                            <h3><small><%=a.getSummary()%></small></h3>
                                        </div>
                                    </div>
                                    <div id="menu1" class="tab-pane fade in active"><br>
                                            <h3 class="product-title"><%=a.getNamemodel()%></h3>
						<div class="rating">
						     <c:set var = "star" scope ="session" value = "<%=a.getRating()%>"/>	
                                                    <div class="stars">
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
                                                <span class="review-no"><b>Car rating according to experts</b></span>
                                            </div>
                                            <table class="table table-bordered table-striped product-description text-warning">
                                                <thead>
                                                    <tr>
                                                        <th>Version</th>
                                                        <th><%=a.getVersion()%></th>                                                            
                                                    </tr>
                                                    <tr>
                                                        <th>Fuel Type</th>
                                                        <th><%=a.getFuel_type()%></th>                                                            
                                                    </tr>
                                                    <tr>
                                                        <th>Mileage</th>
                                                        <th><%=a.getMileage()%> km</th>                                                            
                                                    </tr>
                                                    <tr>
                                                        <th>Available Color</th>
                                                        <th><%=a.getColor()%></th>                                                            
                                                    </tr>
                                                    <tr>
                                                        <th>City</th>
                                                        <th><%=a.getCity()%></th>                                                            
                                                    </tr>
                                                    <tr>
                                                        <th>Road Price</th>
                                                        <th><a href="#" data-toggle="modal" data-target="#myModal">Click me</a></th>                                                            
                                                    </tr>
                                                </thead> 
                                            </table>
                                            <div class="modal fade" id="myModal" role="dialog">
                                                <div class="modal-dialog modal-lg">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">ON-Road Price:&nbsp<span class="text-info text-uppercase"><%=a.getNamemodel()%></span></h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <table class="table table-bordered table-striped product-description ">
                                                                <thead>
                                                                    <tr class="info">
                                                                        <th>Index</th>
                                                                        <th>Amount</th>                                                            
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Car Price</th>
                                                                        <th><fmt:formatNumber value="<%=a.getActualamount()%>" type="number" /></th>                                                            
                                                                    </tr>
                                                                    <tr>
                                                                        <th>RTO</th>
                                                                        <th><fmt:formatNumber value="<%=a.getRto()%>" type="number" /></th>                                                            
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Insurance</th>
                                                                        <th><fmt:formatNumber value="<%=a.getInsurance()%>" type="number" /></th>                                                            
                                                                    </tr>
                                                                    <tr>
                                                                        <th>Other Price <a href="#" title="Other Price" data-toggle="popover" data-trigger="focus" data-content="<%=a.getOtherpriceindetail()%>"><span class="glyphicon glyphicon-info-sign"></span></a></th>
                                                                        <th><fmt:formatNumber value="<%=a.getOtherprice()%>" type="number" /></th>                                                            
                                                                    </tr>
                                                                    <tr class="info">
                                                                        <th>Total Price</th>
                                                                        <th><fmt:formatNumber value="<%=a.getRoadprice()%>" type="number" /></th>                                                            
                                                                    </tr>
                                                                </thead> 
                                                            </table>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class=" details action">
                                                <form action="RecordInfo" method="post">    
                                                    <div class="form-group">
                                                        <select class="form-control input-lg" name="txt_noofcar" required>
                                                            <option class="dropdown-header" value="">----Select no. of Car you want to Booked----</option>
                                                            <option value="1">One Car</option>
                                                            <option value="2">Two Car</option>
                                                            <option value="3">Three Car</option>
                                                            <option value="4">Four Car</option>
                                                            <option value="5">Five Car</option>
                                                            <option value="6">More then Five</option>
                                                        </select>
                                                    </div>
                                                    <input type="hidden" name="cid" value="<%=a.getCid()%>">
                                                    <input type="hidden" name="rid" value="2">
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
                    </div>
                </div>
            <hr>
            <%@ include file = "Footer.jsp" %>
        <script>
            $(document).ready(function(){
                $('[data-toggle="popover"]').popover();   
            });
        </script>
    </body>
</html>
