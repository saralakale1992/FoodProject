package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Addtocart;

/**
 * Servlet implementation class addtocartservletAdmin
 */
@WebServlet("/addtocartservletAdmin")
public class addtocartservletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

Addtocart ac=new Addtocart();
BLManager bl=new BLManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
String name=(String) session.getAttribute("name");
String price=(String) session.getAttribute("price");
String quantity=(String) session.getAttribute("quantity");


request.getRequestDispatcher("cart1.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
