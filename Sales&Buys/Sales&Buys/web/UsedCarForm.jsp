<%-- 
    Document   : UsedCarForm
    Created on : Sep 25, 2017, 2:49:32 AM
    Author     : ANITA-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Used Car form Page</title>
            <style>
                .entry:not(:first-of-type)
                {
                    margin-top: 10px;
                }

                .glyphicon
                {
                    font-size: 12px;
                }
                
            </style>
            
    </head>
    <%
    
              response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
          HttpSession hs=request.getSession();
       
    %>
    <body>
        <c:import url="Header.jsp"></c:import>
           <div class="container">
        
        <form  action="DoUsedCar" method="post" enctype="multipart/form-data" style="margin: auto; width: 90%; ">
            <input type="hidden" name="currentDate" value="<%=new Date()%>">
        <input type="hidden" name="uiid" value="<%=hs.getAttribute("id")%>">
        <div class="container">
                    <h2>Sell Your OLD CAR</h2>
          <p>Please fill the detail so that people easily get detail about your OLD car which you want to sell.</p>

            <div class="form-group row">
                        <div class="col-md-7">
                <label for="ex3">Car Name*</label>
                <input class="form-control" name="txt_namemodel" type="text" required>
              </div>
                        </div>
                <div class="form-group row">	
              <div class="col-md-4">
                <label for="ex1">Version*</label>
                <input class="form-control" name="txt_version" type="text" required>
              </div>
              <div class="col-md-3">
                <label for="ex2">Fuel Type*</label>
                <input class="form-control" name="txt_fuel" type="text" required>
              </div>
            </div>
                <div class="form-group row">
                              <div class="col-md-4">
                <label for="ex1">Mileage*</label>
                <input class="form-control" name="txt_mileage" type="number" required>
              </div>
                             <div class="col-md-3">
                <label for="ex3">city*</label>
                <input class="form-control" name="txt_city" type="text" required>
                </div>

                </div>
        <div class="form-group row">
            <div class="col-md-7">
            <label>Car pic*</label>
            <input type="file" class="form-control" name="txt_image" accept="image/*" required>
            </div>
            
            </div>
            
                <div class="form-group row">
                                  <div class="col-md-4">
                <label for="ex2">Amount*</label>
                <input class="form-control" name="txt_amount" type="number" required>
              </div>
             <div class="col-md-3">
                <label for="ex1">In word*</label>
                <select name="txt_inword" class="form-control" required>
                    <option class="dropdown-header" value="">--Select--</option>
                    <option value="Thousand">Thousand </option>
                    <option value="Lakh">Lakh</option>
                    <option value="Crore">Crore</option>
                </select>
                
              </div>

                </div>

                <div class="form-group row">
                                        <div class="col-md-7">
                <label for="ex3">No. of Owner*</label>
                <select name="txt_owner" class="form-control" required>
                    <option class="dropdown-header" value="">--Select--</option>
                    <option value="first">First Owner</option>
                    <option value="Second">Second Owner</option>
                    <option value="Third">Third Owner</option>
                     <option value="Fourth">Fourth Owner</option>
                      <option value="Fifth">Fifth Owner</option>
                </select>
                
                </div></div>

                <div class="form-group row">
                              <div class="col-md-2">
                <label for="ex1">Location*</label>
                <input class="form-control" name="txt_location" type="text" required>
              </div>
                    
              <div class="col-md-2">
                <label for="ex1">Year Manufacture*</label>
                <input class="form-control" name="txt_manufacture" type="number"> </div>
                <div class="col-md-3">
                    <label for="ex1">Car Condition*</label>
                    <select name="star" class="form-control" required>
                        <option value="0">--select--</option>
                        <option value="5">Excellent</option>
                        <option value="4">Very Good</option>
                        <option value="3">Normal</option>
                        <option value="2">Poor</option>
                        <option value="1">Bad</option>
                    </select>
                
              </div>
              
                </div>
              
                <div class="form-group row">
                                        <div class="col-md-7">
                <label for="ex3">Reason of car selling</label>
                <input class="form-control" name="txt_sd" type="text">

                </div></div>

                <div class="form-group row">
                                        <div class="col-md-4">
                <label for="ex3"></label>
                <input class="form-control btn btn-success" type="submit" value="Submit">
                </div>
                <div class="col-md-3">
                    <label></label>
                    <input class="form-control btn btn-default" type="reset" value="Reset">
                </div>
                </div>

        
        </div>
        </form></div>
	                <hr><%@ include file = "Footer.jsp" %>
    </body>
</html>
