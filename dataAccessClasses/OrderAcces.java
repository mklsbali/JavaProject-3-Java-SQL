package ro.utcn.tp.assig3.dataAccessClasses;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.ArrayList;

import ro.utcn.tp.assig3.businessLogicClasses.OrderValidation;
import ro.utcn.tp.assig3.modelClasses.Client;
import ro.utcn.tp.assig3.modelClasses.Order;
import ro.utcn.tp.assig3.modelClasses.Product;
import ro.utcn.tp.assig3.presentationClasses.Window;

public class OrderAcces {
public static ArrayList<Order> getOrderTableData() {
		
		ArrayList<Order> orders=new ArrayList<Order>();
		
		try {
			String querry="select * from Orderr";
			ResultSet rs=Window.db.getRs();
			rs=Window.db.getSt().executeQuery(querry);
			
			while (rs.next()) {
				int id=rs.getInt("id");
				int c_id=rs.getInt("client_id");
				String c_name=rs.getString("client_name");
				int p_id=rs.getInt("product_id");
				String p_name=rs.getString("product_name");
				int qantity=rs.getInt("quantity");
				Order o=new Order(id,c_id,c_name,p_id,p_name,qantity);
				orders.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
		
	public static void insertOrder(Order order) {
		if (OrderValidation.valid(order))
		{
			String c_name=null,p_name=null;int p_q=-1,p_p=-1;
			for (Client c:Window.clients) {
				if (order.getClient_ID()==c.getId())
					c_name=c.getNume();
			}
			for (Product p:Window.products) {
				if (order.getProduct_ID()==p.getID())
				{
					p_name=p.getNume();
					p_q=p.getQuantity();
					p_p=p.getPret();
				}
					
			}
			try {
				String add="insert into Orderr(client_id, client_name, product_id, product_name, quantity) values "
					+ "("+order.getClient_ID()+",'"+c_name+"',"+order.getProduct_ID()+",'"+p_name+"',"+order.getQuantity()+")";
				Window.db.getSt().executeUpdate(add);
				ProductAcces.editProduct(order.getProduct_ID(), p_name, p_q-order.getQuantity(), p_p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeBill();
			return;
		}
		System.out.println("Nu mai este in stoc!");
	}
	public static void deleteOrder(int orderID) {
		try {
			String delete="DELETE FROM Orderr where id="+orderID;
			Window.db.getSt().executeUpdate(delete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void writeBill() {
		ArrayList<Order> datas=OrderAcces.getOrderTableData();
		
		
		try {
			PrintWriter writer = new PrintWriter("Bill.txt", "UTF-8");
			for (Order o:datas)
			{
				writer.println("Nr: "+o.getID());
				writer.println("Client ID: "+o.getClient_ID());
				writer.println("Client Name: "+o.getClient_name());
				writer.println("Product ID: "+o.getProduct_ID());
				writer.println("Product Name: "+o.getProduct_name());
				writer.println("Qantity: "+o.getQuantity());
				writer.println("");
			}
			writer.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
