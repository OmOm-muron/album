package album.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import album.dto.Owner;

public class OwnerDAO extends RootDAO {
    public OwnerDAO() {
        super();
    }
    
    public boolean existsOwner(String ownerid, String password) throws NamingException, SQLException {
        String sql = "SELECT 1 FROM owner\n"
                + "WHERE ownerid = ?\n"
                + "AND password = ?";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            state.setString(1, ownerid);
            state.setString(2, password);
            ResultSet rs = state.executeQuery();
            return rs.next();
        } catch (NamingException | SQLException e) {
            throw(e);
        }
    }
    
    public Owner getOwnerProfile() throws NamingException, SQLException, Exception {
        String sql = "SELECT ownername, ownerprofile, ownerimagepath\n"
                + "FROM owner";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            if (!rs.next()) {
                throw new Exception("The system is in irregal status.\nPlease contact administrator.");
            }
            
            Owner owner = new Owner();
            owner.setOwnername(rs.getString("ownername"));
            owner.setOwnerprofile(rs.getString("ownerprofile"));
            owner.setOwnerimagepath(rs.getString("ownerimagepath"));
            if (rs.next()) {
                throw new Exception("The system is in irregal status.\nPlease contact administrator.");
            }
            return owner;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
    
    public Owner getOwnerContact() throws NamingException, SQLException, Exception {
        String sql = "SELECT ownername, ownertelno, ownermail, ownertwitter, ownerinstagram, ownerfacebook\n"
                + "FROM owner";
        
        try {
            setConnection();
            PreparedStatement state = connection.prepareStatement(sql);
            ResultSet rs = state.executeQuery();
            if (!rs.next()) {
                throw new Exception("The system is in irregal status.\nPlease contact administrator.");
            }
            
            Owner owner = new Owner();
            owner.setOwnername(rs.getString("ownername"));
            owner.setOwnertelno(rs.getString("ownertelno"));
            owner.setOwnermail(rs.getString("ownermail"));
            owner.setOwnertwitter(rs.getString("ownertwitter"));
            owner.setOwnerinstagram(rs.getString("ownerinstagram"));
            owner.setOwnerfacebook(rs.getString("ownerfacebook"));
            if (rs.next()) {
                throw new Exception("The system is in irregal status.\nPlease contact administrator.");
            }
            return owner;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }
}
