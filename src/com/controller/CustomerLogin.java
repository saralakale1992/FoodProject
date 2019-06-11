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
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Registration r=new Registration();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("Username");
		String password=request.getParameter("Password");
		
		r=bl.searchcuname(username);
		System.out.println("username" +username);
		
		r=bl.searchuserpass(username,password);
		System.out.println("r:"+r);
		PrintWriter out=response.getWriter();
		
		if(r!=null){
			int id=r.getId();
			String uname=r.getUsername();
			String pass=r.getPassword();
			String fname=r.getFname();
			String lname=r.getLname();
			String mobileno=r.getMobileno();
						String address=r.getAddress();
			String emailid=r.getEmailid();
			
			HttpSession session=request.getSession();
			
			session.setAttribute("id", id);
			
			session.setAttribute("username", uname);
			
			session.setAttribute("password", pass);
			session.setAttribute("fname", fname);
			session.setAttribute("lname", lname);
			session.setAttribute("mobileno", mobileno);
			
			session.setAttribute("address", address);
			session.setAttribute("emailid", emailid);
			//session.setAttribute("password", pass);
			
			System.out.println("welcome User");
			
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Welcome..!!');");
		    out.print("location='Customerheader.jsp';");
		    out.print("</script>");
			
		}
		else{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please Enter correct username and password');");
			out.print("location='Customerlogin.jsp';");
			out.print("</script>");
		}
	}

}
