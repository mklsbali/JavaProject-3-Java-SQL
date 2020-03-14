package ro.utcn.tp.assig3.modelClasses;

public class Client {
	private int ID;
	private String nume;
	private int varsta;
	private String email;
	private String phoneNumber;
	
	public Client(int ID, String nume, int varsta, String email, String phoneNumber) {
		this.ID = ID;
		this.nume = nume;
		this.varsta = varsta;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public Client(String nume, int varsta, String email, String phoneNumber) {
		this.nume = nume;
		this.varsta = varsta;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		ID = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
