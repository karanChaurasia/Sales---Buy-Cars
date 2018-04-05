<%-- 
    Document   : Index
    Created on : Sep 26, 2017, 11:42:12 AM
    Author     : ANITA-PC
--%>
<%@page import="java.util.Date"%>
<%@page import="Model.AddCarItem.AddItemG_S"%>
<%@page import="Model.AddCarItem.AddItemDAOImpl"%>
<%@page import="Model.AddCarItem.AddItemDAO"%>
<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@page import="java.util.List"%>
<%@page import="Model.UpcomingCar.UpcomingCarG_S"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAOImpl"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAO"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buying & Selling Cars</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .jumbotron {
                            margin-bottom: 0px;
                            background-image: url(carjumbo.jpg);
                            background-position: 0% 25%;
                            background-size: cover;
                            background-repeat: no-repeat;
                            
                            
                        }   
            body
            {
                    padding-top:50px;
            }

        </style>
    </head>
        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            HttpSession hs=request.getSession();
            String name=(String)hs.getAttribute("name");
            
            UpcomingCarDAO updao=new UpcomingCarDAOImpl();
            List<UpcomingCarG_S> list1=updao.getUpcoming();
            request.setAttribute("List1",list1);
            
            AddItemDAO adao=new AddItemDAOImpl();
            List<AddItemG_S> list2=adao.getNewCarMinDetail();
            request.setAttribute("List2",list2);
            
            UsedCarDao usdao=new UsedCarDAOImpl();
            List<UsedCarG_S> list3=usdao.getOldCarMinDetail();
            request.setAttribute("List3",list3);
        %>
    
    <body data-spy="scroll" data-target="#my-navbar">
    <c:import url="Header.jsp"></c:import>

        <div class="jumbotron">
            <div class="container text-center">
                <span class="text-warning" style="text-shadow: black 0.3em 0.3em 0.3em;">   
                <h1>Buying and Selling Cars</h1></span>
                <p class="text-capitalize" style="color: white;"><em> Welcome <b>${name}</b> to Cars <abbr title="Buying and Selling">B&S</abbr> here you can buy New Car or Used Car and also Sell your Old Car.</em></p>
                <div class="btn-group">
                    <a href="NewCar.jsp" class="btn btn-lg btn-warning"><strong>New Car</strong></a>
                    <a href="UsedCarForm.jsp" class="btn btn-lg btn-default"><strong>Sell Car</strong></a>
                    <a href="UsedCar.jsp" class="btn btn-lg btn-warning"><strong>Used Car</strong></a>
                </div>
            </div>
        </div>
    <div class="container">
        <section>
            <div class="page.header" id="Gallery">
		<h2>Gallery. <small>Check out the upcoming new Car</small></h2><hr>
            </div>
                <div class="carousel slide" id="screenshot-carousel" data-ride="carousel">
                    <ol class="carousel-indicators" >
                        <c:forEach items="${List1}" var="x" varStatus="status">
                           <li data-target="#screenshot-carousel" data-slide-to="${status.index}" class="<c:if test='${status.first}'>active</c:if>"></li>
                       </c:forEach>
                    </ol>
                <div class="carousel-inner">
                    <c:forEach items="${List1}" var="x" varStatus="status">
                    <div class="item  <c:if test='${status.first}'>active</c:if>">
                        <a href="UpcomingProductView.jsp?cid=${x.getCid()}"><img src="${x.getPic_name()}" width="100%" height="50%"></a>
                        <div class="carousel-caption">
                        <a href="UpcomingProductView.jsp?cid=${x.getCid()}"><h3 class=" w3-button w3-white w3-padding-large w3-large w3-opacity w3-hover-opacity-off">${x.getNamemodel()}</h3></a>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                    <a href="#screenshot-carousel" class="left carousel-control" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span></a>
                    <a href="#screenshot-carousel" class="right carousel-control" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
        </section>
    </div><br>
    
        <div class="container" >
            <section>
		<div class="page.header" id="features">
                    <h2>New Cars.<a href="NewCar.jsp"><small>Check out more new Car click me</small></a></h2></div><hr>
                    <div class="row">
                        <c:forEach items="${List2}" var="x">
                            <div class="col-md-4">
                                <div class="panel panel-default">
                                    <a href="NewCarProductView.jsp?cid=${x.getCid()}"><img src="${x.getPic_name()}" width="100%" height="250px"></a>
                                    <div class="panel-body text-capitalize">
                                        <a href="NewCarProductView.jsp?cid=${x.getCid()}">
                                        <h4><p align="left">${x.getNamemodel()}</p></h4></a>
                                        <span class="text-warning">
                                            <p align="left"><b>&nbsp;${x.getVersion()}</b></p>    
                                            <p align="left"><b>&nbsp;${x.getFuel_type()}</b></p>
                                            <p align="left"><b>&nbsp;${x.getCity()}</b></p>
                                            <h4> <p align="left" >Ex-showroom<b>&nbsp;₹ ${x.getFirstrange()}-${x.getSecondrange()}${x.getRangepriceinword()}</b></p></h4>
                                        </span>
                                            <p align="right"><a href="NewCarProductView.jsp?cid=${x.getCid()}" class="btn btn-info">Read More</a></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach> 
                    </div>	
                    <h2>Used Cars. <a href="UsedCar.jsp"><small>Check out more used Car Click me</small></a></h2><hr>	
                        <div class="row">
                            <c:forEach items="${List3}" var="x" >
                                <div class="col-md-4">
                                    <div class="panel panel-default">
                                        <a href="ProductView.jsp?id=${x.getCid()}"><img src="${x.getPic_name()}" width="100%" height="250px"></a>
                                        <div class="panel-body text-capitalize">
                                            <a href="ProductView.jsp?id=${x.getCid()}">
                                            <h4><p align="left">${x.getNamemodel()}</p></h4></a>
                                            <span class="text-warning">
                                            <p align="left"><b>&nbsp;${x.getVersion()}</b></p>    
                                            <p align="left"><b>&nbsp;${x.getFuel_type()}</b></p>
                                            <p align="left"><b>&nbsp;${x.getCity()}, ${x.getLocation()}</b></p>
                                            <h4> <p align="left" >Expected amount<b>&nbsp;₹ ${x.getAmount()}${x.getAmountinword()}</b></p></h4></span>
                                            <p align="right"><a href="ProductView.jsp?id=${x.getCid()}" class="btn btn-info">Read more</a></p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach> 
                        </div>
                </section>
            </div>	
                                
        <div class="container">
            <section>
                <div class="page.header" id="faq">
                    <h2>FAQ<small>Engaging with consumer</small> </h2>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Q1. what is the procedure after booked a new or used car ?</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <div class="panel-body">Our dealer or user will contact to you after booked the car.</div>
                    </div>
                </div>
            </section>
        </div>

        <div class="container">
            <section>
                <div class="page.header" id="contactus">
                    <h2>Contact Us.<small>Contact us  for more</small> </h2><hr>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p>Send us a message, or contact us from the address below</p>
                        <address>
                            <strong>Buy And Selling pvt Ltd.</strong><br>
                            call: 120210210
                        </address>
                    </div>
                    <div class="col-md-8">
                        <form action="ContactUs" method="post" class="form-horizontal">
                            <input type="hidden" name="currentDate" value="<%=new Date()%>">
                            <div class="form-group">
                                <label for="User-name" class="col-md-2 control-label">Name</label>
                                <div class="col-md-10">
                                    <input type="text" class="form-control" name="txt_name" placeholder="Enter your Name" required/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Email" class="col-md-2 control-label">Email</label>
                                <div class="col-md-10">
                                    <input type="Email" class="form-control" name="txt_email" placeholder="Enter your Email" required/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="Message" class="col-md-2 control-label">Message</label>
                                <div class="col-md-10">
                                    <textarea  class="form-control" name="txt_msg" placeholder="Enter your Query" required></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-2">
                                    <input type="submit" class="btn btn-primary" value="Submit">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section><hr>
        </div>
	<%@ include file = "Footer.jsp" %>
    </body>
</html>
