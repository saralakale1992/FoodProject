package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Offer;

/**
 * Servlet implementation class Deletespecialoffer
 */
@WebServlet("/Deletespecialoffer")
public class Deletespecialoffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BLManager bl=new BLManager();
	Offer o=new Offer();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String oid=request.getParameter("oid");
		int aid=Integer.parseInt(oid);
		
		o=bl.serachspecialoffer(aid);
		
		bl.deleteoffer(o);
		
		response.sendRedirect("managespecialoffer.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
