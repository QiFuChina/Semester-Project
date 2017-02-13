package data;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
@ManagedBean
public class ClientControl {
	private ArrayList<Client> client;
	private DAO DAO;
	
	public ClientControl() {
		try {
			DAO = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Client> getClient() {
		return client;
	}

	public void loadClient() throws Exception {		
		client = DAO.getClient();
	
	}
}
