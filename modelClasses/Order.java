package ro.utcn.tp.assig3.modelClasses;
public class Order {
	private int ID;
	private int client_ID;
	private String client_name;
	private int product_ID;
	private String product_name;
	private int quantity;
	
	public Order(int ID, int client_ID, String client_name, int product_ID, String product_name, int quantity) {
		this.ID = ID;
		this.client_ID = client_ID;
		this.client_name = client_name;
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.quantity = quantity;
	}
	public Order(int client_ID,  int product_ID,  int quantity) {
		this.client_ID = client_ID;
		this.product_ID = product_ID;
		this.quantity = quantity;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getClient_ID() {
		return client_ID;
	}
	public void setClient_ID(int client_ID) {
		this.client_ID = client_ID;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
