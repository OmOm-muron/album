package album.servlet.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/home.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
