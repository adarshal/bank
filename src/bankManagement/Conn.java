package bankManagement;

import java.sql.*;

public class Conn {

	Connection c;
	Statement s;
	public Conn() {
		try {
//			Class.forName(com.mysql.cj.jdbc.Driver);
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementSystem","root","password");
			s=c.createStatement();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public Statement createStatement() throws SQLException {
        return c.createStatement();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return c.prepareStatement(sql);
    }

}
