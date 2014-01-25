import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBase {
	
	static final String User="username";
	static final String Pass="password";
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/"; 
	private static void main(String [] args)
	{
		Statement stmt=null;
		Connection connection =null;//define connection
	
		//step 2 register jdbc driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		//....................................................................................................................................................................................................
		//step 3 
		//open a connection
		
		System.out.print("connecting...");
		try {
			connection=DriverManager.getConnection("com.mysql.jdbc.Driver", User, Pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}//make connection
		//.....................................................................................................................................................................................................
		
		//step 4>> creating statement
		try {
			 stmt=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql;
		sql="CREATE DATABASE LightItUp"; 
		try {
			ResultSet result=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//.....................................................................................................................................................................................................
		
		
	}//main
	
	}
