package album.servlet.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.dao.AlbumDAO;
import album.servlet.util.AlbumUtil;

public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
        
        int imageid = Integer.parseInt(req.getParameter("imageid"));
        try (AlbumDAO dao = new AlbumDAO()) {
            dao.deleteAlbum(imageid);
            dao.commit();
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
        
        req.setAttribute("message", "deleted 1 data successfully.");
        RequestDispatcher rd = req.getRequestDispatcher("/album");
        rd.forward(req, rsp);
    }
}
