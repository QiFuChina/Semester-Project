package Data;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import DAO.DAO;
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
	public void login(Customer c) throws Exception{
		try {
			DAO.login(c);	
			//System.out.println("Register OK");
		} catch (Exception e) {
					
		}
	}
	public String addCustomer(Customer c) throws Exception{
		try {
			DAO.addCustomer(c);	
			FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
			System.out.println("Register OK");
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(e.toString());
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;	
		}
		return "Information.xhtml";
	}

//	public String editAction(Customer c) {
//
//		c.setEditable(true);
//		return null;
//	}
//	
//	public String saveAction() {
//		for (Customer c : customer){
//		
//		
//			c.setEditable(false);
//		}
//		return null;
//
	
   // <h:commandButton value="update" action="#{customerControl.updateCustomer(c)}" />
//	}
	
	public String renewCustomer(Customer c){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("customer",customer);
		return "Information.xhtml";
	}
	public String updateCustomer(Customer c)throws Exception{
		
		
	try{/*	
			for (Customer customer : customer){
			
			
			customer.setEditable(false);
			}
			*/
			DAO.updateCustomer(c);
			
			System.out.println("Update OK");
		}catch (Exception e) {
			
			System.out.println("Update null");
		}
		return "Customers";
	}
	public void deleteCustomer(Customer c) throws Exception{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("customer", customer);
		try{
			DAO.deleteCustomer(c);
			System.out.println("Delete OK");
			FacesContext.getCurrentInstance().getExternalContext().redirect("Customers.xhtml");
		}catch (Exception e) {
			
			System.out.println("Delete null");
		}
	}
}
