package ro.utcn.tp.assig3.businessLogicClasses;

import ro.utcn.tp.assig3.modelClasses.Client;

public class ClientValidation {
	public static boolean valid(Client client)
	{
		if (client.getNume()!=null && (client.getPhoneNumber()!=null||client.getEmail()!=null) )
			return true;
		return false;
	}
}
