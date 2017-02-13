package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.*;
import javax.sql.DataSource;





public class DAO {
	private DataSource mysqlDS;
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/client";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	public ArrayList<Client> getClient() throws Exception {

		ArrayList<Client> client = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from client");

		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {

			String city = rs.getString("city");  
			String firstname = rs.getString("firstname");
			String surname = rs.getString("surname");  
		

			client.add(new Client(city,firstname,surname));
		}

		return client;
	}
}
