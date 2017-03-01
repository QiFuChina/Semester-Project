package Data;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
public class CustomerControl {
	private ArrayList<Customer> customer;
	private DAO DAO;
	
	public CustomerControl() {
		try {
			DAO = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Customer> getCustomer() {
		return customer;
	}

	public void loadCustomer() throws Exception {		
		customer = DAO.getCustomer();
	
	}
	
	public void addCustomer(Customer c) throws Exception {
		try {
			DAO.addCustomer(c);
		
		} catch (Exception e) {
			System.out.println("null");
		}

	}
	public void deleteCustomer(Customer c){

		try{
			DAO.deleteCustomer(c);
		}catch (Exception e) {
			System.out.println("Delete null");
		}
	}
}
