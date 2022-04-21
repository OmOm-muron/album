package album.servlet.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import album.dao.AlbumDAO;
import album.dto.Album;
import album.servlet.util.AlbumUtil;

@MultipartConfig(location="D:\\tomcat9.0.34\\apache-tomcat-9.0.34\\webapps\\images\\album")
public class SubmitServlet extends HttpServlet {
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
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/submit.jsp");
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
        
        try (AlbumDAO dao = new AlbumDAO()) {
            Part part = req.getPart("image");
            String filename = util.getFilename(part);
            part.write("D:\\tomcat9.0.34\\apache-tomcat-9.0.34\\webapps\\images\\album\\" + filename);
            
            String comment = req.getParameter("comment");
            
            Album album = new Album();
            album.setImagepath("/images/album/" + filename);
            album.setComment(comment);
            album.setLocation("");
            album.setTag("");
            
            dao.insertAlbum(album);
            int imageid = dao.getLatestId();
            dao.commit();
            RequestDispatcher rd = req.getRequestDispatcher("/detail?imageid=" + String.valueOf(imageid));
            rd.forward(req, rsp);
        } catch (Exception e) {
            RequestDispatcher rd = req.getRequestDispatcher("/jsp/error.jsp");
            rd.forward(req, rsp);
        }
    }
}
