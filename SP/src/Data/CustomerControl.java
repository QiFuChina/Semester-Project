package Data;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	public void checkCustomer(Customer c) throws Exception{
		try {
			DAO.checkCustomer(c);	
			System.out.println("Login OK");
		} catch (Exception e) {
					
		}
	}
	public String editAction(Customer c) {

		c.setEditable(true);
		return null;
	}
	
//	public String saveAction() {
//		for (Customer c : customer){
//		
//		
//			c.setEditable(false);
//		}
//		return null;
//
//	}
	public void updateCustomer(Customer c)throws Exception{
		
		
		try{
			c.setEditable(false);
			DAO.updateCustomer(c);
			
			System.out.println("Update OK");
		}catch (Exception e) {
			
			System.out.println("Update null");
		}
		
	}
	public void deleteCustomer(Customer c) throws Exception{
//		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		Map<String, Object> requestMap = externalContext.getRequestMap();
//		requestMap.put("customer", customer);
		try{
			DAO.deleteCustomer(c);
			System.out.println("Delete OK");
//			FacesContext.getCurrentInstance().getExternalContext().redirect("Customers.xhtml");
		}catch (Exception e) {
			
			System.out.println("Delete null");
		}
	}
}
