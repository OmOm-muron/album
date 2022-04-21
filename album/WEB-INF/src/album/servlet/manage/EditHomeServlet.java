package album.servlet.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.servlet.util.AlbumUtil;

public class EditHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        AlbumUtil util = new AlbumUtil();
        try {
            if (!util.isValidSession(req)) {
                RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
                rd.forward(req, rsp);
                return;
            }
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
        
        // TODO make edit home page.
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/album.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        AlbumUtil util = new AlbumUtil();
        try {
            if (!util.isValidSession(req)) {
                RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
                rd.forward(req, rsp);
                return;
            }
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
        doGet(req, rsp);
    }
}
