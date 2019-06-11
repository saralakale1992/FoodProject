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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Offer;

/**
 * Servlet implementation class Updatespecialoffer
 */
@WebServlet("/Updatespecialoffer")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)
public class Updatespecialoffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static String SAV_DIR = "c://ProjectDemo/Foodorder/WebContent/menuimages/";
	    FilePermission permission1=new FilePermission(SAV_DIR, "write");
	    
	    BLManager bl=new BLManager();
	    Offer o=new Offer();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String oid=request.getParameter("oid");
		int aid=Integer.parseInt(oid);
		
		o=bl.serachspecialoffer(aid);
		
		HttpSession session=request.getSession();
		session.setAttribute("list",o);
		
		response.sendRedirect("updatespecialoffer.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 PrintWriter out=response.getWriter();
	 String oname=request.getParameter("oname");
	 Part image=request.getPart("image");
	 String date=request.getParameter("todate");
	 String sprice=request.getParameter("sprice");
	 
	 o.setOname(oname);
	 o.setTodate(Date.valueOf(date));
	 o.setSprice(sprice);
	 
	 try{
			String img1=extractFileName(image);
			o.setImage(img1);
			
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
	 
	 bl.saveUpdatesoffer(o);
		

		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Record update successfully....');");
		out.print("location='managespecialoffer.jsp';");
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
