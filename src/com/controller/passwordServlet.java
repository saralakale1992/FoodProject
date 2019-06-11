package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Registration;



/**
 * Servlet implementation class passwordServlet
 */
@WebServlet("/passwordServlet")
public class passwordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  BLManager bl=new BLManager();
  Registration r=new Registration();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String f = request.getParameter("flag");
		System.out.println(f);
		
		if(f.equals("Reset Password"))
		{
		String s1=request.getParameter("emailid");
		String s2=request.getParameter("password");
		
		r= bl.SearchbyEmail(s1);
	
		int s3=r.getId();
		r.setId(s3);
	
		
		r.setEmailid(s1);
		r.setPassword(s2);
		bl.update(r);
		
		String ms="Password Reset successfully...";
		session.setAttribute("PMsg",ms);
		
		out.println("<script type=\"text/javascript\">");
			out.println("alert('Rest successfully');");
			out.println("location='Customerlogin.jsp';");
			out.println("</script>");
		
		
		
	}

	}}
