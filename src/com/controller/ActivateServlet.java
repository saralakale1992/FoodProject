package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.model.Emailutil;
import com.pojo.Item;
import com.pojo.Registration;

/**
 * Servlet implementation class ActivateServlet
 */
@WebServlet("/ActivateServlet")
public class ActivateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 BLManager bl=new BLManager();
 Registration r=new Registration();
 Item i=new Item();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String actStatus = "Confirmed";
	Item ii=bl.searchid(id);
		
		

	System.out.println("id"+ii.getId());
	System.out.println("name"+ii.getRegistration().getFname());
	
	i.setId(ii.getId());
	
	i.setIquantity(ii.getIquantity());
	i.setAddproduct(ii.getAddproduct());
	i.setRegistration(ii.getRegistration());
	i.setStatus(actStatus);
	
	
	
  bl.updateRecord(i);
  
  String mail=ii.getRegistration().getEmailid();
	String info1 = "Hi "+ii.getRegistration().getEmailid()+" your account is activate successfully.\nUser Id: "+ii.getRegistration().getEmailid()+"\nPassword: "+ii.getRegistration().getPassword();
	ServletContext context = getServletContext();
	String host = context.getInitParameter("host");
	String port = context.getInitParameter("port");
	String user = context.getInitParameter("user");
	String pass = context.getInitParameter("pass");
	System.out.println(host + " " + port + "  " + user + " " + pass + " " + mail + "  " + info1);

	try {
		Emailutil.sendEmail1(host, port, user, pass, mail, info1);
	} catch (Exception ex) {
		ex.printStackTrace();

	}

	String m = "User activated successfully";
	HttpSession session=request.getSession();
	session.setAttribute("MsgConfirm", m);
	response.sendRedirect("newOrderConfirm1.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
