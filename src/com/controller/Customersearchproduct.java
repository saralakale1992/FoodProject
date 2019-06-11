package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Addproduct;
import com.pojo.Mainproduct;


@WebServlet("/Customersearchproduct")
public class Customersearchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
	Mainproduct m=new Mainproduct();
	Addproduct a=new Addproduct();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		String mnane=request.getParameter("mname");
		m=bl.searchbymname(mnane);
		
		String nm=m.getMname();
		int mid=m.getMid();
		
		List<Addproduct> ab=bl.searchbyID(mid);
		System.out.println("ab" +ab);
	
		for(int i=0;i<ab.size();i++)
		{
	     String name=ab.get(0).getName();
	     String price=ab.get(0).getPrice();
	     
	        
	     
		}
		
		if(ab!=null)
		{
		 HttpSession session=request.getSession();
		 session.setAttribute("list", ab);
		 response.sendRedirect("cssmenu.jsp");
		}
		else
		{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Sorry product not available');");
			out.print("location='customersearchmenu.jsp';");
	        out.print("</script>");
		}
		
		
	}

}
