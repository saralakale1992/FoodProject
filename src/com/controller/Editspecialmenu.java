package com.controller;

import java.io.FilePermission;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Mainproduct;
import com.pojo.Specialmenu;

/**
 * Servlet implementation class Editspecialmenu
 */
@WebServlet("/Editspecialmenu")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)
public class Editspecialmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String SAV_DIR = "c://ProjectDemo/Foodorder/WebContent/menuimages/";
	    FilePermission permission1=new FilePermission(SAV_DIR, "write");
	    
	    BLManager bl=new BLManager();
	    Mainproduct m=new Mainproduct();
	    Specialmenu s=new Specialmenu();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  String id=request.getParameter("id");
	  int sid=Integer.parseInt(id);
	  
	  s=bl.searchsid(sid);
	  
	  HttpSession session=request.getSession();
	  session.setAttribute("list", s);
	  
	  response.sendRedirect("Editspecialmenu.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		String sname=request.getParameter("sname");
		Part image=request.getPart("image");
		String sprice=request.getParameter("sprice");
		String squantity=request.getParameter("squantity");
		String mname=request.getParameter("mname");
		
		s.setSname(sname);
		s.setSprice(sprice);
		s.setSquantity(squantity);
		
		try{
			String img1=extractFileName(image);
			s.setImage(img1);
			
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
		
		bl.Updatespecialmenu(s);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Record update successfully....');");
		out.print("location='viewspecialmenu.jsp';");
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
