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

/**
 * Servlet implementation class Searchproduct
 */
@WebServlet("/Searchproduct")
public class Searchproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Mainproduct m=new Mainproduct();
       Addproduct a=new Addproduct();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String mname=request.getParameter("mname");
		m=bl.searchbymname(mname);
		//m.getMname();
		String nm=m.getMname();
		int mid=m.getMid();
	
		List<Addproduct> ap=bl.searchbyID(mid);
		System.out.println("ap"+ap);
		if(ap!=null){
			HttpSession session=request.getSession();
			session.setAttribute("List", ap);
			response.sendRedirect("admincssmenu.jsp");
		}
		else{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('sorry product not available');");
			out.print("location='Searchproduct.jsp';");
			out.print("</script>");

		}
		
	}

}
