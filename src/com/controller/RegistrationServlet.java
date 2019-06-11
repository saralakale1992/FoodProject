package com.controller;

import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	    
	    BLManager bl=new BLManager();
	    Registration r=new Registration();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		
		String emailid=request.getParameter("emailid");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String mobileno=request.getParameter("mobileno");
		
		r.setFname(fname);
		r.setLname(lname);
		r.setEmailid(emailid);
		r.setUsername(username);
		r.setPassword(password);
		r.setAddress(address);
		r.setMobileno(mobileno);
		
		
		
		bl.saveregister(r);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Register successfully..........!!!!');");
		out.print("location='Customerlogin.jsp';");
		out.print("</script>");
		
		
		
	}


	

}
