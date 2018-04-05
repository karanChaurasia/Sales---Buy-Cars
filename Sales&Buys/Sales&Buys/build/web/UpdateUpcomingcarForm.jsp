<%-- 
    Document   : UpdateUpcomingcarForm
    Created on : Oct 24, 2017, 9:10:02 PM
    Author     : ANITA-PC
--%>
<%@page import="Model.UpcomingCar.UpcomingCarG_S"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAOImpl"%>
<%@page import="Model.UpcomingCar.UpcomingCarDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Upcoming Car Page</title>
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> 
    </head>
     <%       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
          int cid=Integer.parseInt(request.getParameter("cid"));
            UpcomingCarDAO updao=new UpcomingCarDAOImpl();
            UpcomingCarG_S up=updao.getUpcomingById(cid);
    %>
 
    <body>
                <c:import url="Header.jsp"></c:import>
          <div class="container">
        
        <form  action="UpdateUpcomingcar" method="post" enctype="multipart/form-data" style="margin: auto; width: 80%; ">
            
        <input type="hidden" name="cid" value="<%=up.getCid()%>">
        <div class="container">
          <h1>Update Upcoming CAR</h1>
          <p>Please fill the detail so that people easily get detail about New car.</p>
          
            <div class="form-group row">
            <div class="col-md-4">
            <label>Car Name and Model*</label>
            <input type="text" class="form-control" name="txt_namemodel" value="<%=up.getNamemodel()%>">
            </div>
            
              <div class="col-md-3">
                <label for="ex1">Version*</label>
                <input class="form-control" name="txt_version"type="text" value="<%=up.getVersion()%>">
              </div>
              <div class="col-md-2">
                <label for="ex2">Fuel Type*</label>
                <input class="form-control" name="txt_fuel" type="text" value="<%=up.getFuel_type()%>">
              </div>
            </div>
                <div class="form-group row">
                                  <div class="col-md-4">
                <label for="ex1">Color*</label>
                <input class="form-control" name="txt_color" type="text" value="<%=up.getColor()%>">
              </div>
           
                <div class="col-md-3">
                <label for="ex1">Mileage*</label>
                <input class="form-control" name="txt_mileage" type="number" value="<%=up.getMileage()%>">
              </div>
                        <div class="col-md-2">
                <label for="ex3">city*</label>
                <input class="form-control" name="txt_city" type="text" value="<%=up.getCity()%>">
                </div>
             </div>
            
          
          <div class="form-group row">
            <div class="col-md-9">
            <label>Car pic*</label>
            <input type="file" class="form-control" name="txt_image" accept="image/*" value="<%=up.getPic_name()%>">
            </div>
            
            </div>
            
            <div class="form-group row">
                 
                <div class="col-md-2">
               <label for="ex2">first range Price *</label>
                <input class="form-control" name="txt_fir" type="number" value="<%=up.getFirstrange()%>">
              </div>
              <div class="col-md-2">
                <label for="ex2">second range Price *</label>
                <input class="form-control" name="txt_sec" type="number" value="<%=up.getSecondrange()%>">
              </div>
              <div class="col-md-5">
                <label for="ex1">in word*</label>
                <select name="amountinword" class="form-control" value="<%=up.getRangepriceinword()%>">
                    <option>--Select--</option>
                    <option value="Thousand">Thousand </option>
                    <option value="Lakh">Lakh</option>
                    <option value="Crore">Crore</option>
                </select>
                
              </div>

       </div>
       
                <div class="form-group row">
                <div class="col-md-4">
                <label for="ex2">Actual Price*</label>
                <input class="form-control" name="txt_actualamount" type="number" value="<%=up.getActualamount()%>">
              </div>
              <div class="col-md-3">
                <label for="ex2">RTO*</label>
                <input class="form-control" name="txt_rto" type="number" value="<%=up.getRto()%>">
              </div>
              <div class="col-md-2">
                <label for="ex1">Insurance*</label>
                <input class="form-control" name="txt_insurance" type="number" value="<%=up.getInsurance()%>">
              </div></div>
            <div class="form-group row">    
                <div class="col-md-2">
                <label for="ex2">Other Price*</label>
                <input class="form-control" name="txt_otherprice" type="number" value="<%=up.getOtherprice()%>">
               
              </div>
                <div class="col-md-2">
                     <label for="ex2">Other Price name*</label>
                <input type="text" name="txt_nameofprice" class="form-control" value="<%=up.getOtherpriceindetail()%>">
                </div>
                <div class="col-md-5">
                <label for="ex3">On-Road Price*</label>
                <input class="form-control" name="txt_roadprice" type="number" value="<%=up.getRoadprice()%>">

                </div>
            </div>
       
            <div class="form-group row">
                <div class="col-md-9">
                        <label for="ex1">Car Condition*</label>
                        <select name="txt_star" class="form-control" value="<%=up.getRating()%>">
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
                <textarea class="form-control" rows="2" name="txt_sd"><%=up.getShort_description()%></textarea>

                </div>
            </div>
        <div class="form-group row">
            <div class="col-md-9">
            <label>Summary*:</label>
            <textarea class="form-control" rows="4" name="txt_sum"><%=up.getSummary()%></textarea>
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
	
    </body>
</html>
