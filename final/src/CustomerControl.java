
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

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
	
	public String addCustomer(Customer c) throws Exception {
		try {
			DAO.addCustomer(c);
			return "Customers";
		} catch (Exception e) {
			return e.toString();
		}

	}
}
