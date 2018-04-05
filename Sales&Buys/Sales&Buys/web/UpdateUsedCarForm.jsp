<%-- 
    Document   : UpdateUsedCarForm
    Created on : Nov 3, 2017, 1:15:35 PM
    Author     : ANITA-PC
--%>
<%@page import="Model.SellUsedCar.UsedCarG_S"%>
<%@page import="Model.SellUsedCar.UsedCarDAOImpl"%>
<%@page import="Model.SellUsedCar.UsedCarDao"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Used car Page</title>
    </head>
    <%       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        int cid=Integer.parseInt(request.getParameter("cid"));
       
               UsedCarDao ucdao=new UsedCarDAOImpl();
               UsedCarG_S u=ucdao.getOldCarDetailByID(cid);
       
    %>
    <body>
                <c:import url="Header.jsp"></c:import>
           <div class="container">
        
        <form  action="UpdateUsedcar" method="post" enctype="multipart/form-data" style="margin: auto; width: 80%; ">
            
        <input type="hidden" name="cid" value="<%=u.getCid()%>">
        <div class="container">
                    <h2>Update Used CAR Details</h2>
          <p>Please fill the detail so that people easily get detail about your OLD car which you want to sell.</p>

            <div class="form-group row">
                        <div class="col-md-7">
                <label for="ex3">Car Name*</label>
                <input class="form-control" name="txt_namemodel" type="text" value="<%=u.getNamemodel()%>" required>
              </div>
                        </div>
                <div class="form-group row">	
              <div class="col-md-4">
             <label for="ex1">Version*</label>
                <input class="form-control" name="txt_version" type="text" value="<%=u.getVersion()%>" required>
              </div>
              <div class="col-md-3">
                <label for="ex2">Fuel Type*</label>
                <input class="form-control" name="txt_fuel" type="text" value="<%=u.getFuel_type()%>" required>
              </div>
            </div>
                <div class="form-group row">
                              <div class="col-md-4">
                <label for="ex1">Mileage*</label>
                <input class="form-control" name="txt_mileage" type="text" value="<%=u.getMileage()%>" required>
              </div>
              <div class="col-md-3">
                <label for="ex3">city*</label>
                <input class="form-control" name="txt_city" type="text" value="<%=u.getCity()%>" required>
                </div>

                </div>
         <div class="form-group row">
            <div class="col-md-7">
            <label>Car pic*</label>
            <input type="file" class="form-control" name="txt_image" accept="image/*" value="<%=u.getPic_name()%>" required>
            </div>
            </div>
        

        <div class="form-group row">
                <div class="col-md-4">
                <label for="ex2">amount*</label>
                <input class="form-control" name="txt_amount" type="text" value="<%=u.getAmount()%>" required>
              </div>
                <div class="col-md-3">
                <label for="ex1">In word*</label>
                <select name="txt_inword" class="form-control" value="<%=u.getAmountinword()%>" required>
                    <option>--Select--</option>
                    <option value="Thousand">Thousand </option>
                    <option value="Lakh">Lakh</option>
                    <option value="Crore">Crore</option>
                </select>
                </div>
        </div>
                <div class="form-group row">
                 <div class="col-md-7">
                <label>No. of Owner*</label>
                <select name="txt_owner" class="form-control" value="<%=u.getNo_of_owner()%>" required>
                    <option>--Select--</option>
                    <option value="first">First Owner</option>
                    <option value="Second">Second Owner</option>
                    <option value="Third">Third Owner</option>
                     <option value="Fourth">Fourth Owner</option>
                      <option value="Fifth">Fifth Owner</option>
                </select>
                </div>
                </div>

                <div class="form-group row">
                              <div class="col-md-2">
                <label for="ex1">Location*</label>
                <input class="form-control" name="txt_location" type="text" value="<%=u.getLocation()%>" required>
              </div>
              <div class="col-md-2">
             <label for="ex1">Year Manufacture*</label>
                <input class="form-control" name="txt_manufacture" type="text" value="<%=u.getYear_manufacture()%>"> </div>
                        <div class="col-md-3">
                    <label for="ex1">Car Condition*</label>
                    <select name="star" class="form-control" value="<%=u.getRating()%>" required>
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
                <label for="ex3">Reason of car selling*</label>
                <input class="form-control" name="txt_sd" type="text" value="<%=u.getShort_description()%>">

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
	        <hr>
	<%@ include file = "Footer.jsp" %>

    </body>
</html>
