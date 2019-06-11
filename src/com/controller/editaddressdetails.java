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
import com.pojo.Addressdetails;

/**
 * Servlet implementation class editaddressdetails
 */
@WebServlet("/editaddressdetails")
public class editaddressdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Addressdetails a=new Addressdetails();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out=response.getWriter();
			
			int adid=Integer.parseInt(request.getParameter("adid"));
			String fname=request.getParameter("fname");
			String mobileno=request.getParameter("mobileno");
			String apartment=request.getParameter("apartment");
			String area=request.getParameter("area");
			String pincode=request.getParameter("pincode");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			
			
			a.setAdid(adid);
			a.setFname(fname);
			a.setMobileno(mobileno);
			a.setApartment(apartment);
			a.setArea(area);
			a.setPincode(pincode);
			a.setCity(city);
			a.setState(state);
			
			
			bl.updateadd(a);
			
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Details are updated!');");
			out.print("location='cashoronline.jsp';");
			out.print("</script>");
			
		
	}

}
