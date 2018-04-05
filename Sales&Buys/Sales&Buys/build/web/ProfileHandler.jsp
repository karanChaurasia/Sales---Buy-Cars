<%-- 
    Document   : ProfileHandler
    Created on : Sep 22, 2017, 11:21:17 AM
    Author     : ANITA-PC
--%>
<%@page import="Model.UpcomingCar.UpcomingCarG_S"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAOImpl"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAO"%>
<%@page import="Model.AddCarItem.AddItemG_S"%>
<%@page import="Model.AddCarItem.AddItemDAOImpl"%>
<%@page import="Model.AddCarItem.AddItemDAO"%>
<%@page import="java.util.List"%>
<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@page import="Model.Profile.ProfileG_S"%>
<%@page import="Model.Profile.ProfileDAOImpl"%>
<%@page import="Model.Profile.ProfileDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>  
    </head>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        HttpSession hs=request.getSession();
        int uiid=(Integer)hs.getAttribute("id");
       
        ProfileDAO pdao=new ProfileDAOImpl();      
        ProfileG_S p=pdao.getprofile(uiid);       
    %>
    
    <body>
        <c:import url="Header.jsp"></c:import>
        <div class="container">
            <h2>Profile Modify Tabs</h2>
            <ul class="nav nav-tabs nav-justified">
                <li class="active"><a data-toggle="tab" href="#menu0">Update Profile</a></li>
                <li><a data-toggle="tab" href="#menu1">Change Password</a></li>    
            </ul>
            <div class="tab-content">
                <div id="menu0" class="tab-pane fade in active">
                    <div class="container">
                        <form  action="UpdatePROFILE" method="post" style="margin: auto; width: 90%; ">
                            <input type="hidden" name="hid" value="<%=uiid%>"/> 
                            <br>
                            <label>Name:</label>
                            <input type="text" name="txtName" value="<%=p.getName()%>" minlength="4" maxlength="12" class="form-control enableOnInput" disabled/><br>
                            <label>Phone no:</label>
                            <input type="text" name="txtPhoneno" value="<%=p.getPhone()%>" pattern="[1-9]{10}" maxlength="10" title="Enter 10 digit Phone number" class="form-control enableOnInput"  disabled/><br>
                            <label>Email:</label>
                            <input type="Email" name="txtEmail" value="<%=p.getEmail()%>" class="form-control"  disabled/><br>
                            <label>Address:</label>
                            <textarea name="txtAddress" minlength="8" maxlength="20" class="form-control enableOnInput" disabled><%=p.getAddress()%></textarea><br>
                            <input type="submit" value="Update"  class="btn btn-success"/>
                            <input type="button" value="Edit" id='submitBtn' class="btn btn-default"/>
                        </form>
                    </div>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <h3>Change your password</h3><br>
                    <div class="container">
                        <form method="post" name="f1" ng-app="" action="Changepassword" onsubmit="return matchpass()">
                            <div class="col-md-offset-2 col-md-6 col-md-offset-4">
                                <label>Old Password</label>
                            </div>
                            <div class="col-md-offset-2 col-md-8 col-md-offset-2">       
                                <input type="Password" name="txt_oldpass" class="form-control" placeholder="Enter your old password" required><br>
                            </div>
                            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                                <label>New Password</label>
                            </div>
                            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                                <input type="Password" ng-model="password" name="txt_newpass" minlength="8" maxlength="15" class="form-control" placeholder="Enter your new password" required><br>
                            </div>
                            <div class="col-md-offset-2 col-md-8 col-md-offset-4">
                                <label>Confirmed New Password</label>
                            </div>
                            <div class="col-md-offset-2 col-md-8 col-md-offset-2"> 
                                <input type="Password"  minlength="8" maxlength="15" ng-model="confirmPassword" name="txt_cnpass" class="form-control" placeholder="Enter your confirmed password" required>
                                <span class="text-danger" ng-show="password !== confirmPassword"><b>Password not match!</b></span>
                            </div>
                            <div class="col-md-offset-2 col-md-4 col-md-offset-4"> 
                                <br><input type="submit" value="change" class="btn btn-success">
                            </div>
                        </form>  
                    </div>
                </div>
            </div>
        </div>
        <hr>
	<%@ include file = "Footer.jsp" %>
        <script type='text/javascript'>
            $(function()
            {
                $('#submitBtn').click(function()
                {
                    $('.enableOnInput').prop('disabled', false);
                });
            });
           
            function matchpass()
            {
                var firstpass=document.f1.txt_newpass.value;
                var secondpass=document.f1.txt_cnpass.value;
                if(firstpass==secondpass)
                {
                    return true;
                }
                else
                {
                    alert("Password must be same!");
                    return false;
                }
            }
        </script>
    </body>
</html>
