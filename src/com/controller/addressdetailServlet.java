package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Addressdetails;

/**
 * Servlet implementation class addressdetailServlet
 */
@WebServlet("/addressdetailServlet")
public class addressdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       BLManager bl=new BLManager();
       Addressdetails a=new Addressdetails();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String mobileno=request.getParameter("mobileno");
		String pincode=request.getParameter("pincode");
		String apartment=request.getParameter("apartment");
		String area=request.getParameter("area");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		
		
		a.setFname(fname);
		a.setMobileno(mobileno);
		a.setPincode(pincode);
		a.setApartment(apartment);
		a.setArea(area);
		a.setCity(city);
		
		a.setState(state);
		
		
		bl.saveAddress(a);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('details are save..!');");
		out.print("location='cashoronline.jsp';");
		out.print("</script>");

	}

}
