package album.servlet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class AlbumUtil {
    public AlbumUtil() {
        return;
    }
    
    public boolean isValidSession(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        
        try {
            String isValid = String.valueOf(session.getAttribute("login"));
            return Boolean.parseBoolean(isValid);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public String getFilename(Part part) {
        String[] disposition = part.getHeader("Content-Disposition").split(";");
        for (int i = 0; i < disposition.length; i++) {
            if (disposition[i].trim().startsWith("filename")) {
                String filename = disposition[i].substring(disposition[i].indexOf("=") + 1).replace("\"","").trim();
                return filename;
            }
        }
        return "";
    }
}
