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
import com.pojo.Item;
import com.pojo.Orderstatus;
import com.pojo.Registration;

/**
 * Servlet implementation class OrderdetailsServlet
 */
@WebServlet("/OrderdetailsServlet")
public class OrderdetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
	Orderstatus o=new Orderstatus();
	Registration r=new Registration();
	Item i=new Item();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String emailid=request.getParameter("emailid");
	   
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("aaaaa"+id);
		String date1=request.getParameter("deliverydate");
		String total=request.getParameter("total");
		String type=request.getParameter("type");
	
		
		
		r=bl.SearchbyEmail(emailid);
		i=bl.searchstatus(id);
		
		System.out.println(date1);
		o.setRegistration(r);
	

		o.setDeliverydate(Date.valueOf(date1));
		o.setTotal(total);
		o.setType(type);
		o.setItem(i);
		bl.saveorderdetails(o);
		
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Details are save..!');");
		out.print("location='cashoronline.jsp';");
		out.print("</script>");
		
		
		
		
	}

}
