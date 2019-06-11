package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Booktable;
import com.pojo.Registration;


@WebServlet("/BookTableServlet")
public class BookTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
	Booktable b=new Booktable();
     Registration r=new Registration(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		String date=request.getParameter("bookingdate");
		String emailid=request.getParameter("emailid");
		String From=request.getParameter("fromtime");
		String To=request.getParameter("tofrom");
		String tablename=request.getParameter("tablename");
		r=bl.searchbyRegistrationID(emailid);
		b.setRegistration(r);
		b.setBookingdate(Date.valueOf(date));
		b.setFromtime(From);
		b.setTofrom(To);
		b.setTablename(tablename);
		
		bl.saveTable(b);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Table book successfully..!!');");
		out.print("location='booktable.jsp';");
		out.print("</script>");
		
		
		
	}

}
