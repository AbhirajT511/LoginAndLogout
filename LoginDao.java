package com.fujitsu.LoginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
	public boolean verifyUser(String username, String password)
	{
		String url = "jdbc:mysql://localhost:3306/test1";
		String db_username="root";
		String db_password="root";
		Connection con;
		PreparedStatement ps;
		String sql = "select * from user where username=? and password=?";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,db_username,db_password);		
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if(result.next())
				return true;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;		
	}
}
