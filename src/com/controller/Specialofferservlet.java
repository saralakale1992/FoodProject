package com.controller;

import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Offer;

/**
 * Servlet implementation class Specialofferservlet
 */
@WebServlet("/Specialofferservlet")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)
public class Specialofferservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static String SAV_DIR = "c://ProjectDemo/Foodorder/WebContent/menuimages/";
	    FilePermission permission1=new FilePermission(SAV_DIR, "write");
	    
	    BLManager bl=new BLManager();
	    Offer o=new Offer();
	    
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
	 String oname=request.getParameter("oname");
	 Part image=request.getPart("image");
	 String fromdate=request.getParameter("fromdate");
	 String todate=request.getParameter("todate");
	 String oprice=request.getParameter("oprice");
	 String sprice=request.getParameter("sprice");
	 
	 o.setOname(oname);
	 o.setFromdate(Date.valueOf(fromdate));
	 o.setTodate(Date.valueOf(todate));
	 o.setOprice(oprice);
	 o.setSprice(sprice);
	 
	 try{
			String img1=extractFileName(image);
			o.setImage(img1);
			
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
	     
	      bl.savespecialoffer(o);
	      
	      out.print("<script type=\"text/javascript\">");
			out.print("alert('Offer added');");
			out.print("location='Specialoffer.jsp';");
			out.print("</script>");
	 
	}


	private String extractFileName(Part image) {
		String contentDisp = image.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		
		return "";
	}

}
