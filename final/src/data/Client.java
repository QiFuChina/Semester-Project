package data;
import javax.faces.bean.ManagedBean;
@ManagedBean
public class Client {
	private String city;
	private String firstname;
	private String surname;
	
	public Client(String city, String firstname,String surname) {
		super();
		this.city = city;
		this.firstname = firstname;
		this.surname = surname;
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
}
