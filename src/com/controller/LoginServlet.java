package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.model.BLManager;
import com.pojo.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Admin a = new Admin();
	BLManager bl = new BLManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String username = request.getParameter("Username");

		String password = request.getParameter("Password");
		
		System.out.println("Name" +username + password);

		//a = bl.searchbyusername(username);
		//System.out.println("username" + username);
		a = bl.searchbyEmailPassowrd(username, password);
		System.out.println("a:" + a);
		PrintWriter out = response.getWriter();

		if (a != null) {

			int id = a.getId();
			String uname = a.getUsername();
			String pass = a.getPassword();

			HttpSession session = request.getSession();

			session.setAttribute("id", id);
			session.setAttribute("username", uname);

			session.setAttribute("password", pass);

			System.out.println("Welcome Admin");

			out.print("<script type=\"text/javascript\">");
			out.print("alert('welcome admin');");
			out.print("location='adminDashboard.jsp';");
			out.print("</script>");

		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Enter correct username && password');");
			out.print("location='login.jsp';");
			out.print("</script>");

		}

	}

}
