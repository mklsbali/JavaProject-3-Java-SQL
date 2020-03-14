package ro.utcn.tp.assig3.businessLogicClasses;

import ro.utcn.tp.assig3.modelClasses.Client;
import ro.utcn.tp.assig3.modelClasses.Order;
import ro.utcn.tp.assig3.modelClasses.Product;
import ro.utcn.tp.assig3.presentationClasses.Window;

public class OrderValidation {
	public static boolean valid(Order o) {
		boolean existsclient=false;
		boolean existsproduct=false;
		for (Client c:Window.clients) {
			if (c.getId()==o.getClient_ID())
				existsclient=true;
		}
		for (Product p:Window.products) {
			if (p.getID()==o.getProduct_ID() && p.getQuantity()>=o.getQuantity())
				existsproduct=true;
		}
		if (existsclient && existsproduct)
			return true;
		return false;
	} 
}
