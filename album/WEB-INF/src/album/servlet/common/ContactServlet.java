package album.servlet.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.dao.OwnerDAO;
import album.dto.Owner;

public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        
        Owner owner = new Owner();
        try (OwnerDAO dao = new OwnerDAO()) {
            owner = dao.getOwnerContact();
            if (!owner.isValidOwner()) {
                new Exception("cannot get owner information");
            }
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
        
        req.setAttribute("owner", owner);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/contact.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
