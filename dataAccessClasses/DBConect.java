package ro.utcn.tp.assig3.dataAccessClasses;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilderFactory;

import com.mysql.jdbc.*;

public class DBConect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public Statement getSt() {
		return st;
	}

	public ResultSet getRs() {
		return rs;
	}


	
	public DBConect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/assig3?autoReconnect=true&useSSL=false","root","parola");
			st=(Statement) con.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
}
