package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Mainproduct;

/**
 * Servlet implementation class Savemainmenu
 */
@WebServlet("/Savemainmenu")
public class Savemainmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Mainproduct m=new Mainproduct();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String mname=request.getParameter("mname");
		
		m.setMname(mname);
		
		bl.savemainmenu(m);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Main menu added');");
		out.print("location='Addmainmenu.jsp';");
		out.print("</script>");
		
		//response.sendRedirect("Addmainmenu.jsp");
	}

}
