package com.fujitsu.LoginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao 
{
	public ResultSet getValues()
	{
		String url = "jdbc:mysql://localhost:3306/test1";
		String db_username="root";
		String db_password="root";
		Connection con;
		PreparedStatement ps;
		String sql = "select * from user";
		ResultSet result = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,db_username,db_password);		
			ps=con.prepareStatement(sql);
			result = ps.executeQuery();
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}
}
