package ro.utcn.tp.assig3.modelClasses;

public class Product {
	private int ID;
	private String nume;
	private int quantity;
	private int pret;
	
	public Product(int ID, String nume, int quantity, int pret) {
		this.ID = ID;
		this.nume = nume;
		this.quantity = quantity;
		this.pret = pret;
	}
	public Product(String nume, int quantity, int pret) {
		this.nume = nume;
		this.quantity = quantity;
		this.pret = pret;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
}
