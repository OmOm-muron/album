package album.servlet.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import album.dao.OwnerDAO;

public class ManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        
        RequestDispatcher rd;
        HttpSession session = req.getSession();
        Object login = session.getAttribute("login");
        if (login != null && login.equals("true")) {
            session.removeAttribute("login");
            rd = req.getRequestDispatcher("/jsp/home.jsp");
        } else {
            rd = req.getRequestDispatcher("/jsp/login.jsp");
        }
        
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        HttpSession session = req.getSession(true);
        boolean validOwner = false;
        String ownerid = req.getParameter("ownerid");
        String password = req.getParameter("password");
        try (OwnerDAO dao = new OwnerDAO()) {
            validOwner = dao.existsOwner(ownerid, password);
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
        
        if (validOwner) {
            session.setAttribute("login", "true");
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/home.jsp");
            rd.forward(req, rsp);
        } else {
            req.setAttribute("message", "You entered wrong user information.\nPlease check userid and password.");
            req.setAttribute("ownerid", ownerid);
            doGet(req, rsp);
        }
    }
}
