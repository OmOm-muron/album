package album.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import album.dto.Album;

public class AlbumDAO extends RootDAO {
    public AlbumDAO() {
        super();
    }
    
    public List<Album> getFifteenAlbum(int offset) throws NamingException, SQLException {
        String sql = "SELECT imageid, imagepath, comment, location, tag\n"
                + "FROM album\n"
                + "ORDER BY imageid\n"
                + "OFFSET ?"
                + "LIMIT 15";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1, offset);
            ResultSet rs = state.executeQuery();
            
            List<Album> albumList = new ArrayList<>();
            while(rs.next()) {
                Album album = new Album();
                album.setImageid(rs.getInt("imageid"));
                album.setImagepath(rs.getString("imagepath"));
                album.setComment(rs.getString("comment"));
                album.setLocation(rs.getString("location"));
                album.setTag(rs.getString("tag"));
                albumList.add(album);
            }
            return albumList;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
    
    public Album getAlbum(int imageid) throws NamingException, SQLException, Exception {
        String sql = "SELECT imageid, imagepath, comment, location, tag\n"
                + "FROM album\n"
                + "WHERE imageid = ?";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1, imageid);
            ResultSet rs = state.executeQuery();
            if (!rs.next()) {
                throw new Exception("cannot get album data.");
            }
            
            Album album = new Album();
            album.setImageid(rs.getInt("imageid"));
            album.setImagepath(rs.getString("imagepath"));
            album.setComment(rs.getString("comment"));
            album.setLocation(rs.getString("location"));
            album.setTag(rs.getString("tag"));
            
            if (rs.next()) {
                throw new Exception("The system is in irregal status.\nPlease contact administrator.");
            }
            return album;
        } catch (NamingException| SQLException e) {
            throw e;
        }
    }
    
    public boolean insertAlbum(Album album) throws NamingException, SQLException, Exception {
        String sql = "INSERT INTO album\n"
                + "(imagepath, comment, location, tag)\n"
                + "VALUES\n"
                + "(?, ?, ?, ?)";
        String imagepath = album.getImagepath();
        String comment = album.getComment();
        String location = album.getLocation();
        String tag = album.getTag();
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1, imagepath);
            state.setString(2, comment);
            state.setString(3, location);
            state.setString(4, tag);
            if (state.executeUpdate() == 0)  {
                throw new Exception("fault to insert album.");
            }
            return true;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
    
    public boolean deleteAlbum(int imageid) throws NamingException, SQLException, Exception {
        String sql = "DELETE FROM album\n"
                + "WHERE imageid = ?";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1, imageid);
            if (state.executeUpdate() == 0) {
                throw new Exception("fault to delete aulbum.");
            }
            return true;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
    
    public int getLatestId() throws NamingException, SQLException, Exception {
        String sql = "SELECT max(imageid) AS imageid\n"
                + "FROM album";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            if (!rs.next()) {
                throw new Exception("cannot get album data.");
            }
            return rs.getInt("imageid");
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
}
