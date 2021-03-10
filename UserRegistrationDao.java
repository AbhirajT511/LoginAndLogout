package com.fujitsu.LoginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.fujitsu.LoginAndRegister.model.User;

public class UserRegistrationDao 
{
	public boolean registerUser(User user)
	{
		String url = "jdbc:mysql://localhost:3306/test1";
		String db_username="root";
		String db_password="root";
		Connection con;
		PreparedStatement ps;
		String sql = "insert into user values(?,?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,db_username,db_password);		
			ps=con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(4,user.getPhone());
			ps.setNString(5, user.getAddress());
			int result = ps.executeUpdate();
			if(result>0)
				return true;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
