package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.LoginAndRegister.DAO.UserRegistrationDao;
import com.fujitsu.LoginAndRegister.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserRegistrationDao dao;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int phone=Integer.parseInt(request.getParameter("phone"));
		String address=request.getParameter("address");
		
		Random random=new Random();
		int userId= random.nextInt(999);
		System.out.println(userId);
		User newUser= new User(userId,phone,password,username,address);
		dao=new UserRegistrationDao();
		boolean result = dao.registerUser(newUser);
		if(result)
		{
			System.out.println("User registered successfully");
			response.sendRedirect("welcome.jsp");
		}
		else
			System.err.println("Server Error");
	}

}
