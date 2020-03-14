package ro.utcn.tp.assig3.businessLogicClasses;

import ro.utcn.tp.assig3.modelClasses.Product;

public class ProductValidation {
	
	public static boolean valid(Product product) {
		if (product.getNume()!=null && product.getPret()>=1 && product.getQuantity()>=0)
			return true;
		return false;
	}
}
