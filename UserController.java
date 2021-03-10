package com.fujitsu.LoginAndRegister.controller;

import java.util.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.LoginAndRegister.DAO.UserDao;
import com.fujitsu.LoginAndRegister.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDao udao = new UserDao();
		ResultSet rs = udao.getValues();
		User user;
		ArrayList<User> al = new ArrayList<User>();

		try {
			while(rs.next())
			{
				user = new User(rs.getInt(1), rs.getInt(4), rs.getString(3), rs.getString(2), rs.getString(5));
				al.add(user);
			}

			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("lists", al);
		response.sendRedirect("admin.jsp");
		System.out.println(al);
	}
}
