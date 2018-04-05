<%-- 
    Document   : SalerDetail
    Created on : Oct 13, 2017, 12:55:25 AM
    Author     : ANITA-PC
--%>
<%@page import="Model.Profile.ProfileG_S"%>
<%@page import="Model.Profile.ProfileDAOImpl"%>
<%@page import="Model.Profile.ProfileDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saler Page</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <%       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        int cid=Integer.parseInt(request.getParameter("cid"));
        ProfileDAO pdao=new ProfileDAOImpl();
        ProfileG_S p=pdao.getprofileUsedCarSeller(cid);
    %>
    <body>
        <c:import url="Header.jsp"></c:import>  <br><br>
                 
        <div class="container">
      <div class="row">
        <div class="col-md-offset-2 col-md-8 col-md-offset-2" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"><%=p.getNamemodel()%></h3>
            </div>
            <div class="panel-body">
              <div class="row"><br>
                  <div class="col-md-3" align="center"> <img alt="car Pic" src="<%=p.getPic_name()%>" class="img-circle img-responsive"> </div>
                <div class=" col-md-9"> 
                  <table class="table">
                    <tbody>
                      <tr>
                        <td>Owner Name:</td>
                        <td><%=p.getName()%></td>
                      </tr>
                                              
                      <tr>
                        <td>Address</td>
                        <td><%=p.getLocation()%></td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td><a href="mailto:info@support.com"><%=p.getEmail()%></a></td>
                      </tr>
                      <tr> 
                        <td>Phone Number</td>
                        <td><%=p.getPhone()%></td>     
                      </tr>
                  </tbody>
                  </table>
                         <a href="Cart.jsp" class="btn btn-info">Click & Check your cart</a>&nbsp
                         <a href="Index.jsp#contactus" class="btn btn-primary">Click & write if any query</a> 
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                     <p><strong>Note:</strong><small>&nbsp You can also see the saler detail in cart inside the Booked Used CAR tab.</small></p>
                    </div>
            
          </div>
        </div>
      </div>
    </div
    </body>
</html>
