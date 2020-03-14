package ro.utcn.tp.assig3.businessLogicClasses;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JTable;
import javax.swing.plaf.synth.SynthScrollBarUI;

import ro.utcn.tp.assig3.modelClasses.Client;

public class Reflection {
	//Metoda functioneaza doar pentru obiecte de top Client si Product, asa am implementat :-) 
	public static JTable createTableWithReflection(ArrayList<Object> objects) {
		Set<Object> headers=new LinkedHashSet<Object>();
		
		ArrayList<Object[]>clients=new ArrayList<Object[]>();
		ArrayList<Object[]>products=new ArrayList<Object[]>();
		for (Object o:objects) {
			Field[] fields=o.getClass().getDeclaredFields();
			for (Field f:fields) {
				String s=o.getClass().getSimpleName();
				headers.add(s+" "+f.getName());
			}
		}
		for (Object o:objects) {
			Field[] fields=o.getClass().getDeclaredFields();
			if (o.getClass().getSimpleName().equals("Client")) {
				int i=0;
				Object[] row=new Object[5];
				for (Field f:fields) {
					try {
						f.setAccessible(true);
						Object value=f.get(o);
						row[i]=value;
						i++;
					} catch (Exception e) {
			
						e.printStackTrace();
					} 
					
				}
				clients.add(row);
			}
			if (o.getClass().getSimpleName().equals("Product")) {
				int i=0;
				Object[] row=new Object[4];
				for (Field f:fields) {
					try {
						f.setAccessible(true);
						Object value=f.get(o);
						row[i]=value;
						i++;
					} catch (Exception e) {
			
						e.printStackTrace();
					} 
					
				}
				products.add(row);
			}
		}
		ArrayList<Object[]> datas=new ArrayList<Object[]>();
		int c=0,p=0;
		

		while (c<clients.size() || p<products.size()) {
		
			Object[] datarow=new Object[9];
			Object[] crow=null;
			Object[] prow=null;
			if (c<clients.size())
				crow=clients.get(c);
			if (p<products.size())
				prow=products.get(p);
			for (int i=0;i<5;i++) {
				if (c<clients.size())
					datarow[i]=crow[i];
				else
					datarow[i]=null;
			}
			for (int j=5;j<9;j++) {
				if (p<products.size())
					datarow[j]=prow[j-5];
				else
					datarow[j]=null;
			}
			datas.add(datarow);
			c++;
			p++;
		}
		
		Object[][] jtabledatas=new Object[datas.size()][];
		Object[] jtableheader=new Object[headers.size()];
		for (int i=0;i<datas.size();i++) {
			jtabledatas[i]=datas.get(i);
			
		}
		int i=0;
		for (Object o:headers) {
			jtableheader[i]=o;
			i++;
		}
		for (i=0;i<9;i++) {
			//System.out.print(jtableheader[i]+"    ");
		}
	//	System.out.println();System.out.println();
		for (i=0;i<jtabledatas.length;i++)
		{
			for (int j=0;j<9;j++) {
				//System.out.print(jtabledatas[i][j]+"                ");
			}
		//	System.out.println();
		}
		return new JTable(jtabledatas,jtableheader);
		
	}
}
