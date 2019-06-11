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
import com.pojo.Admin;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Admin a=new Admin();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*String id=request.getParameter("id");
		int aid=Integer.parseInt(id);
		a=bl.searchbyid(aid);
		HttpSession session=request.getSession();
		session.setAttribute("list",a);
		
		response.sendRedirect("Adminprofile.jsp");*/


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	a.setId(id);
	
	a.setUsername(username);
	a.setPassword(password);
	
	bl.updateRecord(a);
	
	
	out.print("<script type=\"text/javascript\">");
	out.print("alert('Record Updated sucessfully');");
	out.print("location='Adminprofile.jsp';");
	out.print("</script>");
	
	//response.sendRedirect("Adminprofile.jsp");
	}

}
