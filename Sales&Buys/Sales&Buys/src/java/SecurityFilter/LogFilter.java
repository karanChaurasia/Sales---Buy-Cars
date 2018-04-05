/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecurityFilter;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author ANITA-PC
 */
@WebFilter(filterName = "LogFilter", urlPatterns = {"/RecordInfo","/ContactUs","/DoUsedCar",
    "/ProfileHandler.jsp","/Cart.jsp","/NewCarProductView.jsp","/ProductView.jsp","/UpcomingProductView.jsp"
       , "/UsedCarForm.jsp"
})
public class LogFilter implements Filter{
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out=response.getWriter();
        System.out.println("Log filter called");
//        out.println("Log filter called..");
        
         HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/Login.jsp";
        
        boolean loggedIn = session != null && session.getAttribute("name") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            System.out.println("User pass the logfilter");
            chain.doFilter(request, response);
        } else {
            System.out.println("User failed in logfilter");
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
