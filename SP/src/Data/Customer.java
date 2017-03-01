package Data;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Customer {
	private String city;
	private String firstname;
	private String surname;
	private int phone;
	public Customer() {
		
	}

	public Customer(String city, String firstname,String surname,int phone) {
		super();
		this.city = city;
		this.firstname = firstname;
		this.surname = surname;
		this.phone = phone;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	}
