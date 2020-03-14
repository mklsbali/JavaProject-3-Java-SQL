package ro.utcn.tp.assig3.dataAccessClasses;

import java.sql.ResultSet;
import java.util.ArrayList;

import ro.utcn.tp.assig3.businessLogicClasses.ClientValidation;
import ro.utcn.tp.assig3.businessLogicClasses.ProductValidation;
import ro.utcn.tp.assig3.modelClasses.Product;
import ro.utcn.tp.assig3.presentationClasses.Window;

public class ProductAcces {
public static ArrayList<Product> getProductTableData() {
		
		ArrayList<Product> products=new ArrayList<Product>();
		
		try {
			String querry="select * from Product";
			ResultSet rs=Window.db.getRs();
			rs=Window.db.getSt().executeQuery(querry);
			
			while (rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("nume");
				int quantity=rs.getInt("quantity");
				int pret=rs.getInt("pret");
				Product p=new Product(id,name,quantity,pret);
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	public static void insertProduct(Product product)
	{
		try {
			
			String add="insert into Product(nume,quantity,pret) values ('"+product.getNume()+"',"+product.getQuantity()+","+product.getPret()+")";
			
			if(ProductValidation.valid(product)) 
				Window.db.getSt().executeUpdate(add);
			else
				System.out.println("Invalid Product to insert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteProduct(int productID) {

		try {
			String accesn="SET FOREIGN_KEY_CHECKS=0;";
			String delete="DELETE FROM Product where id="+productID;
			String acces="SET FOREIGN_KEY_CHECKS=1;";
			Window.db.getSt().executeUpdate(accesn);
			Window.db.getSt().executeUpdate(delete);
			Window.db.getSt().executeUpdate(acces);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void editProduct(int productID, String newName, int newQuantity, int newPret) {
		try {
			String edit="update Product set nume='"+newName+"', quantity="+newQuantity+", pret="+newPret+" where id="+productID;
			Window.db.getSt().executeUpdate(edit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
