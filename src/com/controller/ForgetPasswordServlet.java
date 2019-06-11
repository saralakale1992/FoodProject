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
import com.pojo.Registration;



/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      BLManager bl=new BLManager();
     Registration r=new Registration();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		

		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String f = request.getParameter("flag");
		
		if(f.equals("Reset Password"))
		{
			String emailid=request.getParameter("email");
			
			System.out.println(emailid);
			
             List<Registration> ulist=bl.serachbyuserlist();
             System.out.println(ulist);
             
            // System.out.println(ulist.get(0).getEmail());
             
             for(int i=1;i<ulist.size();i++)
             {
            	 
            	// System.out.println(ulist.get(i).getEmail());
             
             if(ulist.get(i).getEmailid().equals(emailid))
             {

			r = bl.SearchbyEmail(emailid);
			
			session.setAttribute("emailid", r);
         response.sendRedirect("updatepassword.jsp");
             }
             else
             {
            	 out.println("<script type=\"text/javascript\">");
 				out.println("alert('Email ID does not exist');");
 				out.println("location='ForgetPassword.jsp';");
 				out.println("</script>");
             }
             }
		}
	}

}
