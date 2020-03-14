package ro.utcn.tp.assig3.dataAccessClasses;

import java.sql.ResultSet;
import java.util.ArrayList;

import ro.utcn.tp.assig3.businessLogicClasses.ClientValidation;
import ro.utcn.tp.assig3.modelClasses.Client;
import ro.utcn.tp.assig3.presentationClasses.Window;

public class ClientAcces {
	public static ArrayList<Client> getClientTableData() {
		
		ArrayList<Client> clients=new ArrayList<Client>();
		
		try {
			String querry="select * from Clientt";
			ResultSet rs=Window.db.getRs();
			rs=Window.db.getSt().executeQuery(querry);
			
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("nume");
				int varsta=rs.getInt("varsta");
				String email=rs.getString("email");
				String phone_number=rs.getString("phoneNumber");
				Client c=new Client(id, name, varsta, email, phone_number);
				clients.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}
	public static void insertClient(Client client)
	{
		try {
			
			String add="insert into Clientt(nume,varsta,email,phoneNumber) values ('"+client.getNume()+"',"+client.getVarsta()+",'"
		+client.getEmail()+"','"+client.getPhoneNumber()+"')";
			
			if(ClientValidation.valid(client)) 
				Window.db.getSt().executeUpdate(add);
			else
				System.out.println("Invalid Client to insert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteClient(int clientID) {

		try {
			String accesn="SET FOREIGN_KEY_CHECKS=0;";
			String delete="DELETE FROM Clientt where id="+clientID;
			String acces="SET FOREIGN_KEY_CHECKS=1;";
			Window.db.getSt().executeUpdate(accesn);
			Window.db.getSt().executeUpdate(delete);
			Window.db.getSt().executeUpdate(acces);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void editClient(int clientID, String newName, int newVarsta, String newEmail, String newPhoneNumber) {
		try {
			String edit="update Clientt set nume='"+newName+"', varsta="+newVarsta+", email='"+newEmail+
				"', phoneNumber='"+newPhoneNumber+"' where id="+clientID;
			Window.db.getSt().executeUpdate(edit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
