
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

public class DAO {
	private DataSource mysqlDS;
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/customers";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}	
	
	public void addCustomer(Customer c) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO customer values(?,?,?)");

		 myStmt.setString(1, c.getCity()); 
		 myStmt.setString(2, c.getFirstname());
		 myStmt.setString(3, c.getSurname());

		myStmt.executeUpdate();
	}
	public ArrayList<Customer> getCustomer() throws Exception {

		ArrayList<Customer> customer = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from customer");
		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String city = rs.getString("city");  
			String firstname = rs.getString("firstname");
			String surname = rs.getString("surname");  
			customer.add(new Customer(city,firstname,surname));
		}
		return customer;
	}
}
