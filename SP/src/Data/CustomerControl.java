package Data;

import java.util.ArrayList;
import java.util.Map;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
public class CustomerControl {
	 ArrayList<Customer> customer;
	 DAO DAO;
	
	public CustomerControl() throws Exception {
	
		this.customer=new ArrayList<Customer>();
		this.DAO = new DAO();
	
	}

	public ArrayList<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(ArrayList<Customer> customer) {
		this.customer = customer;
	}

	public void loadCustomer() throws Exception {		
		customer = DAO.getCustomer();
		System.out.println(customer);
	}
	public void addCustomer(Customer c) throws Exception{
		try {
			DAO.addCustomer(c);	
			System.out.println("Register OK");
		} catch (Exception e) {
					
		}
	}
//	public void addBook(Customer c) throws Exception{
//		try {
//			DAO.addBook(c);	
//			System.out.println("Add OK");
//		} catch (Exception e) {
//					
//		}
//	}
	
	public void updateCustomer(Customer customer){
		try{
			DAO.updateCustomer(customer);
			System.out.println("Update OK");
		}catch (Exception e) {
			
			System.out.println("Update null");
		}
		
	}
	public void deleteCustomer(Customer customer) {
//		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		Map<String, Object> requestMap = externalContext.getRequestMap();
//		requestMap.put("customer", customer);
		try{
			DAO.deleteCustomer(customer);
			System.out.println("Delete OK");
//			FacesContext.getCurrentInstance().getExternalContext().redirect("Customers.xhtml");
		}catch (Exception e) {
			
			System.out.println("Delete null");
		}
	}
}
