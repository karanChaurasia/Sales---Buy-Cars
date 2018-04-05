<%-- 
    Document   : AddUpcomingCar
    Created on : Sep 23, 2017, 9:44:34 PM
    Author     : ANITA-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Upcoming Car Page</title>
 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> 
        
    </head>
        <%
    
       
          HttpSession hs=request.getSession();
       
        %>

    <body>        <c:import url="Header.jsp"></c:import>
          <div class="container">
        
        <form  action="UpcomingCar" method="post" enctype="multipart/form-data" style="margin: auto; width: 90%; ">
            <input type="hidden" name="currentDate" value="<%=new Date()%>">
            <input type="hidden" name="uiid" value="<%=hs.getAttribute("id")%>">
        <div class="container">
          <h1>Add Upcoming Car Item</h1>
          <p>Please fill the detail so that people easily get detail about New car.</p>
          
            <div class="form-group row">
            <div class="col-md-4">
            <label>Car Name and Model*</label>
            <input type="text" class="form-control" name="txt_namemodel">
            </div>
            
              <div class="col-md-3">
                <label for="ex1">Version*</label>
                <input class="form-control" name="txt_version"type="text">
              </div>
              <div class="col-md-2">
                <label for="ex2">Fuel Type*</label>
                <input class="form-control" name="txt_fuel" type="text">
              </div>
            </div>
            <div class="form-group row">
                                  <div class="col-md-4">
                <label for="ex1">Color*</label>
                <input class="form-control" name="txt_color" type="text">
              </div>
           
                <div class="col-md-3">
                <label for="ex1">Mileage*</label>
                <input class="form-control" name="txt_mileage" type="number" step="any">
              </div>
                        <div class="col-md-2">
                <label for="ex3">city*</label>
                <input class="form-control" name="txt_city" type="text">
                </div>
             </div>
            
          
            <div class="form-group row">
            <div class="col-md-9">
            <label>Car pic*</label>
            <input type="file" class="form-control" name="txt_image" accept="image/*">
            </div>
            
            </div>
                    
                
            <div class="form-group row">
                 
                <div class="col-md-2">
               <label for="ex2">first range Price *</label>
                <input class="form-control" name="txt_fir" type="number">
              </div>
              <div class="col-md-2">
                <label for="ex2">second range Price *</label>
                <input class="form-control" name="txt_sec" type="number">
              </div>
              <div class="col-md-5">
                <label for="ex1">in word*</label>
                <select name="amountinword" class="form-control">
                    <option>--Select--</option>
                    <option value="Thousand">Thousand </option>
                    <option value="Lakh">Lakh</option>
                    <option value="Crore">Crore</option>
                </select>
                
              </div>

       </div>
            <div class="" ng-app="" ng-init="txt_actual='';txt_rto='';txt_insurance='';txt_otherprice=''">
                <div class="form-group row">
                <div class="col-md-4">
                <label for="ex2">Actual Price*</label>
                <input class="form-control" name="txt_actualamount" type="number" ng-model="txt_actual">
              </div>
              <div class="col-md-3">
                <label for="ex2">RTO*</label>
                <input class="form-control" name="txt_rto" type="number" ng-model="txt_rto">
                
              </div>
                    
              <div class="col-md-2">
                <label for="ex1">Insurance*</label>
                <input class="form-control" name="txt_insurance" type="number" ng-model="txt_insurance">
              </div></div>
            <div class="form-group row">    
                <div class="col-md-2">
                <label for="ex2">Other Price*</label>
                <input class="form-control" name="txt_otherprice" type="number" ng-model="txt_otherprice">
               
              </div>
                <div class="col-md-2">
                     <label for="ex2">Other Price name*</label>
                <input type="text" name="txt_nameofprice" class="form-control" value="" />
                </div>
                <div class="col-md-5">
                <label for="ex3">On-Road Price*</label>
                <input class="form-control" name="txt_roadprice" type="number" value="{{txt_actual+txt_rto+txt_insurance+txt_otherprice}}">

                </div></div>
       </div>
            <div class="form-group row">
                <div class="col-md-9">
                        <label for="ex1">Cars rating according to Expert*</label>
                        <select name="txt_star" class="form-control">
                            <option value="0">--select--</option>
                            <option value="5">Excellent</option>
                            <option value="4">Very Good</option>
                            <option value="3">Normal</option>
                            <option value="2">Poor</option>
                            <option value="1">Bad</option>
                        </select>

                </div></div>
            <div class="form-group row">
                <div class="col-md-9">
                <label for="ex3">Short description*</label>
                <textarea class="form-control" rows="2" name="txt_sd"></textarea>

                </div>
            </div>
        <div class="form-group row">
            <div class="col-md-9">
            <label>Summary*:</label>
            <textarea class="form-control" rows="4" name="txt_sum"></textarea>
        </div>
        </div>
                <div class="form-group row">
                                        <div class="col-md-5">
                <label for="ex3"></label>
                <input class="form-control btn btn-success" type="submit" value="Submit" >
                </div>
                <div class="col-md-4">
                    <label></label>
                    <input class="form-control" type="reset" value="Reset">
                </div>
                </div>

        
            </div>
        </form>
    </div>
            <hr>
	
        <%@ include file = "Footer.jsp" %>

    </body>
</html>
