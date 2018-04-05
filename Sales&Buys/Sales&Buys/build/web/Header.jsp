<%-- 
    Document   : Header
    Created on : Aug 25, 2017, 3:00:37 PM
    Author     : ANITA-PC
--%>
    
<%@page import="Model.Profile.ProfileDAOImpl"%>
<%@page import="Model.Profile.ProfileG_S"%>
<%@page import="Model.Profile.ProfileDAO"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body
                {
                    padding-top:50px;
                }
        </style>
    </head>
    <%  
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       HttpSession hs=request.getSession();
       String name=(String)hs.getAttribute("name");
       Integer uid=(Integer)hs.getAttribute("uid");
    %>
    
    <body data-spy="scroll" data-target="#my-navbar">
        <nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
            <div class="container">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                        </button>
                        <a class="navbar-brand" href="Index.jsp"><b>B&S</b></a>
                    </div>
                    <div class="collapse navbar-collapse" id="navbar-collapse">   
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="Index.jsp">Home</a></li>
                            <li><a href="Index.jsp#Gallery">Gallery</a></li>
                            <li><a href="Index.jsp#features">Features</a></li>
                            <li><a href="Index.jsp#contactus">Contact Us</a></li>
                            <li>
                                <a  href="" class="dropdown dropdown-toggle" type="button" data-toggle="dropdown">Car Options
                                <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="NewCar.jsp">New Cars</a></li>
                                    <li class="divider"></li>
                                    <li><a href="UsedCar.jsp">Used Cars</a></li>
                                    <li class="divider"></li>
                                    <li><a href="Index.jsp#Gallery">Upcoming Cars</a></li>
                                </ul>
                            </li>
                        </ul>
       
                    <ul class="nav navbar-nav navbar-right">
                        <c:set var = "name" scope = "session" value ="<%= name%>" />
                        <c:set var = "uid" scope = "session" value ="<%= uid%>" />
                        <c:if test="${name != null}">
                            <c:if test="${uid == 1}">
                                <li><a href="AdminConsole.jsp" data-toggle="tooltip" data-placement="bottom" title="Edit your Car Detail"><i class="fa fa-key"></i>&nbsp;Console</a></li>
                            </c:if>
                            <c:if test="${uid == 2}">
                                <li><a href="wholeSalerConsole.jsp" data-toggle="tooltip" data-placement="bottom" title="Booked Car Detail"><i class="fa fa-key"></i>&nbsp;Console</a></li>
                            </c:if>
                            <c:if test="${uid == 3}">
                                <li><a href="AWCarDetail.jsp" data-toggle="tooltip" data-placement="bottom" title="Booked Car Detail"><i class="fa fa-key"></i>&nbsp;Console</a></li>
                            </c:if>
                            <li><a href="Cart.jsp" data-toggle="tooltip" data-placement="bottom" title="Booked Car Detail"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;Cart</a></li>
                            <li><a href="ProfileHandler.jsp" data-toggle="tooltip" data-placement="bottom" title="Edit Your Profile"><span class="glyphicon glyphicon-user"></span>&nbsp;${name}</a></li>
                            <li><a href="SessionKilled"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Logout</a></li>
                        </c:if>
                        <c:if test="${name == null}">
                            <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp;Sign Up</a></li>
                            <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a></li>
                        </c:if>
                    </ul>
                </div>  
            </div>
        </div>
    </nav>
        <script>
            $(document).ready(function(){
                $('[data-toggle="tooltip"]').tooltip();   
            });
        </script>
    </body>
</html>
