package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MySQL_DB2_non_select {

	public static void main(String[] args) throws SQLException {
		 Driver dbdriver=new Driver();
         DriverManager.registerDriver(dbdriver);
         Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
         Statement stat=con.createStatement();
         String query="insert into testyantra(id,name,sal) values(102,'prashant',600000)";
         int result=stat.executeUpdate(query);
         if(result==1) {
        	 System.out.println("user is created");
         }
        	 else {
        		 System.out.println("user is not created");
        	 }
         con.close();
        	 }
         }


