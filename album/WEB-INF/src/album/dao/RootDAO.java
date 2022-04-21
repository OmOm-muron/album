package album.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RootDAO implements AutoCloseable {
    protected Connection connection;
    
    public RootDAO() {
        this.connection = null;
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public void setConnection() throws NamingException, SQLException {
        try {
            if (this.connection == null || this.connection.isClosed()) {
                InitialContext contxt = new InitialContext();
                DataSource ds = (DataSource)contxt.lookup("java:comp/env/jdbc/album");
                this.connection = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            this.connection = null;
            e.printStackTrace();
            throw(e);
        }
    }
    
    public void close() {
        if (this.connection == null) {
            return;
        }
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.connection = null;
        }
    }
    
    public void commit() throws SQLException {
        this.connection.commit();
    }
}
