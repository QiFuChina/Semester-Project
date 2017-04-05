	package Data;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Customer {
	private String Username;
	private String Password;
	private String city;


	private String firstname;
	private String bookname;
	private String bookauthor;
	 boolean editable;
	
	public Customer() {
		super();
	}

	public Customer(String Username,String Password,String city, String firstname, String bookname, String  bookauthor) {
		super();
		this.Password=Password;
		this.Username=Username;
		this.city = city;
		this.firstname = firstname;
		this.bookname = bookname;
		this.bookauthor = bookauthor;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public boolean isEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
		
	}

	
	}
