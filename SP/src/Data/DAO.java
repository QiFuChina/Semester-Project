package Data;
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
		Connection conn =mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO customer (Username,Password) values(?,?)");
		myStmt.setString(1, c.getUsername());
		myStmt.setString(2, c.getPassword());
		
		myStmt.executeUpdate();
	}
//	public void addBook(Customer c) throws SQLException {
//		Connection conn =mysqlDS.getConnection();
//		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO customer (bookname,bookauthor) values(?,?)");
//		myStmt.setString(1, c.getBookname());
//		myStmt.setString(2, c.getBookauthor());
//		
//		myStmt.executeUpdate();
//	}
	public void updateCustomer(Customer c) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("UPDATE customer SET city='" + c.getCity()
				+ "', firstname='" + c.getFirstname() + "',bookname='" + c.getBookname() + "',bookauthor='"+c.getBookauthor()+"'");

		myStmt.setString(1, c.getCity());
		myStmt.setString(2, c.getFirstname());
		myStmt.setString(3, c.getBookname());
		myStmt.setString(4, c.getBookauthor());
		myStmt.executeUpdate();
	}
	public void deleteCustomer(Customer c) throws SQLException {

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("DELETE FROM customer WHERE Username = ? ");
	     myStmt.setString(1, c.getUsername());
	     System.out.println(myStmt);
		 myStmt.executeUpdate();
	}
	
	public ArrayList<Customer> getCustomer() throws Exception {

		ArrayList<Customer> customer = new ArrayList<>();

		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select * from customer");
		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String Username=rs.getString("Username");
			String Password=rs.getString("Password");
			String city = rs.getString("city");  
			String firstname = rs.getString("firstname");
			String bookname = rs.getString("bookname");
			String bookauthor = rs.getString("bookauthor");
			customer.add(new Customer(Username,Password,city,firstname,bookname,bookauthor));
		}
		return customer;
	}
}
