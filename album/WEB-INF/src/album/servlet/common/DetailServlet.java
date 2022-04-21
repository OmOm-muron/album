package album.servlet.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.dao.AlbumDAO;
import album.dto.Album;

public class DetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        
        try (AlbumDAO dao = new AlbumDAO()) {
            int imageid = Integer.parseInt(req.getParameter("imageid"));
            Album album = dao.getAlbum(imageid);
            req.setAttribute("album", album);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/detail.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
