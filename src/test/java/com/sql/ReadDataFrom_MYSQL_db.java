package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_db {

	public static void main(String[] args) throws SQLException {
          Driver dbdriver=new Driver();
          DriverManager.registerDriver(dbdriver);
          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
          Statement stat=con.createStatement();
          String query="select  * from testyantra";
          ResultSet result=stat.executeQuery(query);
          while(result.next()) {
        	  System.out.println(result.getInt(1) + "   " + result.getString(2) + "  " + result.getString(3));
          }
          
          con.close();
	}

}
