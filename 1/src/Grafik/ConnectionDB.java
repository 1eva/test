package Grafik;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConnectionDB {
	private String host;
	private String user;
	private String password;
	private String nameDB;
	private String url;
	
	private Properties properties = new Properties();
	private Connection connect;
	
	public ConnectionDB(String host, String user, String password, String nameDB){
		this.host = host;
		this.user = user;
		this.password = password;
		this.nameDB = nameDB;
	}
	
	public void initProperties(){
		
		url = "jdbc:firebirdsql:" + host + "/" + "3050" + ":" + nameDB; 
		
		properties.setProperty("user", user);
		properties.setProperty("password", password);
		properties.setProperty("characterEncoding", "UTF-8");
		properties.setProperty("useUnicode", "true");
		
		System.out.println("URL: " + url);
		}
	
	public void init(){
		if(connect == null){
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			connect = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "connection sucsessfull");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "connection error");
			e.printStackTrace();
		}
	}
	
	}
	
	public void closeConnection(){
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String query){
		ResultSet result = null;		
		try {
			Statement stmt = connect.createStatement();
			result =  stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	public void updateQuert(String query){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
