package ro.utcn.tp.assig3.presentationClasses;



import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import ro.utcn.tp.assig3.businessLogicClasses.Reflection;
import ro.utcn.tp.assig3.dataAccessClasses.ClientAcces;
import ro.utcn.tp.assig3.dataAccessClasses.DBConect;
import ro.utcn.tp.assig3.dataAccessClasses.OrderAcces;
import ro.utcn.tp.assig3.dataAccessClasses.ProductAcces;
import ro.utcn.tp.assig3.modelClasses.Client;
import ro.utcn.tp.assig3.modelClasses.Order;
import ro.utcn.tp.assig3.modelClasses.Product;



@SuppressWarnings("serial")
public class Window extends JFrame{
	public static DBConect db;
	
	
	private JTable clienttable;
	private JTable producttable;
	private JTable ordertable;
	
	private JScrollPane sp=new JScrollPane();
	

	public static ArrayList<Product> products;
	public static ArrayList<Client> clients;
	public static ArrayList<Order> orders;
	
	private JTextField client=new JTextField("Name        ");
	private JTextField clientvarsta=new JTextField("Age   ");
	private JTextField clientemail=new JTextField("Email                      ");
	private JTextField clientphonenumber=new JTextField("Phone number");
	
	private JTextField delclient=new JTextField("Client ID");
	
	private JTextField editclientid=new JTextField("Client ID");
	private JTextField editclientname=new JTextField("New name");
	private JTextField editclientvarsta=new JTextField("New age");
	private JTextField editclientemail=new JTextField("New email");
	private JTextField editclientphonenumber=new JTextField("New phonenumber");
	
	private JTextField product=new JTextField("Product name      ");
	private JTextField productQuantity=new JTextField("Product quantity");
	private JTextField productPret=new JTextField("Product price");
	
	private JTextField delproductID=new JTextField("ProductID");
	
	private JTextField editproduct=new JTextField("PruductID");
	private JTextField editproductname=new JTextField("New name    ");
	private JTextField editproductquantity=new JTextField("New quantity");
	private JTextField editproductprice=new JTextField("New price");
	
	
	private JTextField orderclient=new JTextField("ClientID");
	private JTextField orderproduct=new JTextField("ProductID");
	private JTextField orderquantity=new JTextField("Qantity");
	private JTextField orderdel=new JTextField("OrderID");
	
	private JButton showClients=new JButton("Show Client Table");
	private JButton showProducts=new JButton("Show Product Table");
	private JButton showOrders=new JButton("Show Order Table");
	private JButton showReflectionResult=new JButton("Show ReflectionResult");
	private JButton addClient=new JButton("Add client");
	private JButton deleteClient=new JButton("Delete client");
	private JButton editClient=new JButton("Edit client");
	private JButton addProduct=new JButton("Add product");
	private JButton deleteProduct=new JButton("Delete product");
	private JButton editProduct=new JButton("Edit product");
	private JButton makeOrder=new JButton("Make Order");
	private JButton deleteOrder=new JButton("Delete Order");
	
	private JPanel mainPanel1=new JPanel();
	private JPanel mainPanel2=new JPanel();
	private JPanel mainPanel=new JPanel();
	
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel panel3=new JPanel();
	private JPanel panel4=new JPanel();
	private JPanel panel5=new JPanel();
	private JPanel panel6=new JPanel();
	private JPanel panel7=new JPanel();
	private JPanel panel8=new JPanel();
	private JPanel panel9=new JPanel();
	
	private ArrayList<Object> objects;
	public Window() {
		db=new DBConect();

		new JFrame();
		setTitle("GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(670, 480);

		mainPanel1.setLayout(new FlowLayout());
		
		createPanel1();
		createPanel2();
		createPanel3();
		createPanel4();
		createPanel5();
		createPanel6();
		createPanel7();
		createPanel8();
		createPanel9();
		
		addPanels();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(mainPanel1);
		mainPanel.add(mainPanel2);
		
		addActionListeners();
		setContentPane(mainPanel);
		setVisible(true);
		
		//Aici se adaug obiectele pentru verificarea metodei reflection care de fapt primeste obiecte de tip Client si Product si 
		//uneste tabelele lor, de fapt este un "select * from Client and Product"
		objects=new ArrayList<Object>();
		Client c1=new Client(1,"Jon",25,"mail1","phone1");
		Client c2=new Client(2,"Peter",30,"mail2","phone2");
		Product p=new Product(1,"Salam",25,10);
		Product p2=new Product(2,"Parizer",25,10);
		objects.add(c1);
		objects.add(c2);
		objects.add(p);
		objects.add(p2);
		objects.add(p2);
		objects.add(p2);
		//la metoda addShowReflectionListener() este apelat metoda Reflection.createTableWithReflection(ArrayList<Object> objects).
		
	}
	
	public void createPanel1() {
		panel1.setLayout(new FlowLayout());
		panel1.add(showClients);panel1.add(Box.createRigidArea(new Dimension(10,0)));
		panel1.add(showProducts);panel1.add(Box.createRigidArea(new Dimension(10,0)));
		panel1.add(showOrders);panel1.add(Box.createRigidArea(new Dimension(10,0)));
		panel1.add(showReflectionResult);
	}
	public void createPanel2() {
		panel2.setLayout(new FlowLayout());
		panel2.add(client);panel2.add(Box.createRigidArea(new Dimension(10,0)));
		panel2.add(clientvarsta);panel2.add(Box.createRigidArea(new Dimension(10,0)));
		panel2.add(clientemail);panel2.add(Box.createRigidArea(new Dimension(10,0)));
		panel2.add(clientphonenumber);panel2.add(Box.createRigidArea(new Dimension(10,0)));
		panel2.add(addClient);
	}
	public void createPanel3() {
		panel3.setLayout(new FlowLayout());
		panel3.add(delclient);panel3.add(Box.createRigidArea(new Dimension(10,0)));panel3.add(deleteClient);
	}
	public void createPanel4() {
		panel4.setLayout(new FlowLayout());
		panel4.add(product);panel4.add(Box.createRigidArea(new Dimension(10,0)));
		panel4.add(productQuantity);panel4.add(Box.createRigidArea(new Dimension(10,0)));
		panel4.add(productPret);panel4.add(Box.createRigidArea(new Dimension(10,0)));
		panel4.add(addProduct);
	}
	public void createPanel5() {
		panel5.setLayout(new FlowLayout());
		panel5.add(delproductID);panel5.add(Box.createRigidArea(new Dimension(10,0)));panel5.add(deleteProduct);
	}
	public void createPanel6() {
		panel6.setLayout(new FlowLayout());
		panel6.add(editproduct);panel6.add(Box.createRigidArea(new Dimension(10,0)));
		panel6.add(editproductname);panel6.add(Box.createRigidArea(new Dimension(10,0)));
		panel6.add(editproductquantity);panel6.add(Box.createRigidArea(new Dimension(10,0)));
		panel6.add(editproductprice);panel6.add(Box.createRigidArea(new Dimension(10,0)));
		panel6.add(editProduct);
	}
	public void createPanel7() {
		panel7.setLayout(new FlowLayout());
		panel7.add(editclientid);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel7.add(editclientname);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel7.add(editclientvarsta);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel7.add(editclientemail);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel7.add(editclientphonenumber);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel7.add(editClient);
	}
	public void createPanel8() {
		panel8.setLayout(new FlowLayout());
		panel8.add(orderclient);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel8.add(orderproduct);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel8.add(orderquantity);panel7.add(Box.createRigidArea(new Dimension(10,0)));
		panel8.add(makeOrder);
	}
	public void createPanel9() {
		panel9.setLayout(new FlowLayout());
		panel9.add(orderdel);panel9.add(Box.createRigidArea(new Dimension(10,0)));
		panel9.add(deleteOrder);
	}
	public void addPanels() {
		mainPanel2.setLayout(new BoxLayout(mainPanel2, BoxLayout.Y_AXIS));
		mainPanel2.add(Box.createRigidArea(new Dimension(0,10)));
		mainPanel2.add(panel1);
		mainPanel2.add(panel2);
		mainPanel2.add(panel3);
		mainPanel2.add(panel7);
		mainPanel2.add(panel4);
		mainPanel2.add(panel5);
		mainPanel2.add(panel6);
		mainPanel2.add(panel8);
		mainPanel2.add(panel9);
	}
	public void addActionListeners() {
		addShowClientsListener();
		addShowProductsListener();
		addShowOrdersListener();
		addAddClientListener();
		addRemoveClientListener();
		addEditClientListener();
		addAddProductListener();
		addDeleteProductListener();
		addEditProductListener();
		addMakeOrderListener();
		addRemoveOrderListener();
		addShowReflectionListener();
	}
	public JTable makeClientJTable() {
		String col_names[]= {"Id","Name","Age","Email","PhoneNumber"};
		clients=ClientAcces.getClientTableData();
		
		String[][] tableData=new String[clients.size()][];
		
		for (int i=0;i<clients.size();i++) {
			String[] aux=new String[5];
			aux[0]=""+clients.get(i).getId();
			aux[1]=""+clients.get(i).getNume();
			aux[2]=""+clients.get(i).getVarsta();
			aux[3]=""+clients.get(i).getEmail();
			aux[4]=""+clients.get(i).getPhoneNumber();
			tableData[i]=aux;
		}
		
		clienttable=new JTable(tableData,col_names);
		clienttable.setPreferredScrollableViewportSize(new Dimension(600,50));
		clienttable.setFillsViewportHeight(true);
		return clienttable;
	
	}
	public JTable makeProductJTable() {
		String col_names[]= {"Id","Name","Qantity","Price"};
		products=ProductAcces.getProductTableData();
		String[][] tableData=new String[products.size()][];
		
		for (int i=0;i<products.size();i++) {
			String[] aux=new String[4];
			aux[0]=""+products.get(i).getID();
			aux[1]=""+products.get(i).getNume();
			aux[2]=""+products.get(i).getQuantity();
			aux[3]=""+products.get(i).getPret();
			tableData[i]=aux;
		}
		producttable=new JTable(tableData,col_names);
		producttable.setPreferredScrollableViewportSize(new Dimension(600,50));
		producttable.setFillsViewportHeight(true);
		return producttable;
	
	}
	public JTable makeOrderJTable() {
		String col_names[]= {"Id","Client ID","Client Name","Product ID", "Product Name", "Quantity"};
		orders=OrderAcces.getOrderTableData();
		String[][] tableData=new String[orders.size()][];
		
		for (int i=0;i<orders.size();i++) {
			String[] aux=new String[6];
			aux[0]=""+orders.get(i).getID();
			aux[1]=""+orders.get(i).getClient_ID();
			aux[2]=""+orders.get(i).getClient_name();
			aux[3]=""+orders.get(i).getProduct_ID();
			aux[4]=""+orders.get(i).getProduct_name();
			aux[5]=""+orders.get(i).getQuantity();
			tableData[i]=aux;
		}
		ordertable=new JTable(tableData,col_names);
		ordertable.setPreferredScrollableViewportSize(new Dimension(600,50));
		ordertable.setFillsViewportHeight(true);
		return ordertable;
	
	}
	public void addShowClientsListener() {
		showClients.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clienttable=makeClientJTable();
				mainPanel1.remove(sp);
				sp=new JScrollPane(clienttable);
				mainPanel1.add(sp);
				mainPanel1.revalidate();
				
			}
		});	
	}
	public void addShowProductsListener() {
		showProducts.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				producttable=makeProductJTable();
				mainPanel1.remove(sp);
				sp=new JScrollPane(producttable);
				mainPanel1.add(sp);
				mainPanel1.revalidate();
				
			}
		});	
	}
	public void addShowOrdersListener() {
		showOrders.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clients=ClientAcces.getClientTableData();
				products=ProductAcces.getProductTableData();
				ordertable=makeOrderJTable();
				mainPanel1.remove(sp);
				sp=new JScrollPane(ordertable);
				mainPanel1.add(sp);
				mainPanel1.revalidate();
				
			}
		});	
	}
	public void addShowReflectionListener() {
		showReflectionResult.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				mainPanel1.remove(sp);
				JTable table=Reflection.createTableWithReflection(objects);
				table.setPreferredScrollableViewportSize(new Dimension(1000,50));
				table.setFillsViewportHeight(true);
				sp=new JScrollPane(table);
				mainPanel1.add(sp);
				mainPanel1.revalidate();
				
			}
		});	
	}
	public void addAddClientListener() {
		addClient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				String name=client.getText();
				String vartas=clientvarsta.getText();
				vartas=vartas.replaceAll(" ","");
				int varsta=Integer.parseInt(vartas);
				String email=clientemail.getText();
				String pnumber=clientphonenumber.getText();
				Client c=new Client(name,varsta,email,pnumber);
				ClientAcces.insertClient(c);
			}
		});
	}
	public void addRemoveClientListener() {
		deleteClient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String client_ids=delclient.getText();
				client_ids=client_ids.replaceAll(" ","");
				int c_ID=Integer.parseInt(client_ids);
				ClientAcces.deleteClient(c_ID);
			}
		});
	}
	public void addEditClientListener() {
		editClient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String client_ids=editclientid.getText();
				client_ids=client_ids.replaceAll(" ","");
				int c_ID=Integer.parseInt(client_ids);
				String newnames=editclientname.getText();
				String newwrts=editclientvarsta.getText();
				newwrts=newwrts.replaceAll(" ","");
				int newvarsta=Integer.parseInt(newwrts);
				String newwemail=editclientemail.getText();
				String newwpn=editclientphonenumber.getText();
				ClientAcces.editClient(c_ID, newnames, newvarsta, newwemail, newwpn);
				
			}
		});
	}
	public void addAddProductListener() {
		addProduct.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name=product.getText();
				String product_qantitys=productQuantity.getText();
				product_qantitys=product_qantitys.replaceAll(" ","");
				int p_qant=Integer.parseInt(product_qantitys);
				String product_prices=productPret.getText();
				product_prices=product_prices.replaceAll(" ","");
				int p_price=Integer.parseInt(product_prices);
				Product p=new Product(name,p_qant,p_price);
				ProductAcces.insertProduct(p);
			}
		});
	}
	public void addDeleteProductListener() {
		deleteProduct.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String product_id=delproductID.getText();
				product_id=product_id.replaceAll(" ","");
				int p_ID=Integer.parseInt(product_id);
				ProductAcces.deleteProduct(p_ID);
			}
		});
	}
	public void addEditProductListener() {
		editProduct.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String product_id=editproduct.getText();
				product_id=product_id.replaceAll(" ","");
				int p_ID=Integer.parseInt(product_id);
				String p_name=editproductname.getText();
				String product_qantitys=productQuantity.getText();
				product_qantitys=product_qantitys.replaceAll(" ","");
				int p_qant=Integer.parseInt(product_qantitys);
				String product_price=editproductprice.getText();
				product_price=product_price.replaceAll(" ","");
				int price=Integer.parseInt(product_price);
				ProductAcces.editProduct(p_ID, p_name, p_qant, price);
			}
		});
	}
	public void addMakeOrderListener() {
		makeOrder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clients=ClientAcces.getClientTableData();
				products=ProductAcces.getProductTableData();
				String c_IDs=orderclient.getText();
				c_IDs=c_IDs.replaceAll(" ","");
				int c_ID=Integer.parseInt(c_IDs);
				String p_IDs=orderproduct.getText();
				p_IDs=p_IDs.replaceAll(" ","");
				int p_ID=Integer.parseInt(p_IDs);
				String quantitys=orderquantity.getText();
				quantitys=quantitys.replaceAll(" ","");
				int qantity=Integer.parseInt(quantitys);
				OrderAcces.insertOrder(new Order(c_ID, p_ID, qantity));
			}
		});
	}
	public void addRemoveOrderListener() {
		deleteOrder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String order_ids=orderdel.getText();
				order_ids=order_ids.replaceAll(" ","");
				int o_ID=Integer.parseInt(order_ids);
				OrderAcces.deleteOrder(o_ID);
			}
		});
	}
	
}
