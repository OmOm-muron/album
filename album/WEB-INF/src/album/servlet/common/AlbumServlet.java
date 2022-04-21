package album.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import album.dao.AlbumDAO;
import album.dto.Album;

public class AlbumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("contextPath", req.getContextPath());
        int offset = 0;
        String offsetStr = req.getParameter("offset");
        if (offsetStr != null && !offsetStr.isBlank()) {
            offset = Integer.parseInt(offsetStr);
        }
        
        try (AlbumDAO dao = new AlbumDAO()) {
            List<Album> albumList = dao.getFifteenAlbum(offset);
            req.setAttribute("albumList", albumList);
            if (offset != 0) {
                // Ajaxからの呼び出しならJSON形式でデータを返して終了
                rsp.setContentType("application/json");
                rsp.setCharacterEncoding("UTF-8");
                JSONObject json = new JSONObject();
                PrintWriter writer = rsp.getWriter();
                for (Iterator<Album> it = albumList.iterator(); it.hasNext();) {
                    Album album = it.next();
                    int imageid = album.getImageid();
                    String imagepath = album.getImagepath();
                    String comment = album.getComment();
                    String location = album.getLocation();
                    String tag = album.getTag();
                    
                    JSONObject jsonTmp = new JSONObject();
                    jsonTmp.put("imageid", imageid);
                    jsonTmp.put("imagepath", imagepath);
                    jsonTmp.put("comment", comment);
                    jsonTmp.put("location", location);
                    jsonTmp.put("tag", tag);
                    json.append("album", jsonTmp);
                }
                writer.print(json.toString());
                writer.flush();
                return;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/album.jsp");
        rd.forward(req, rsp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        doGet(req, rsp);
    }
}
