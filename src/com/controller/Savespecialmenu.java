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
import javax.servlet.http.Part;

import com.model.BLManager;
import com.pojo.Mainproduct;
import com.pojo.Specialmenu;


@WebServlet("/Savespecialmenu")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)
public class Savespecialmenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String SAV_DIR = "c://ProjectDemo/Foodorder/WebContent/menuimages/";
    FilePermission permission1=new FilePermission(SAV_DIR, "write");
    
    BLManager bl=new BLManager();
    Specialmenu s=new Specialmenu();
    Mainproduct m=new Mainproduct();
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String sname=request.getParameter("sname");
		Part image=request.getPart("image");
		String sprice=request.getParameter("sprice");
		String squantity=request.getParameter("squantity");
		String mname=request.getParameter("mname");
		m=bl.searchbymname(mname);
		
		s.setSname(sname);
		s.setSprice(sprice);
		s.setSquantity(squantity);
		s.setMainproduct(m);
		
		try{
			String img1=extactFileName(image);
			s.setImage(img1);
			
		}catch(Exception e){
		 e.printStackTrace();
		}
		bl.saveSpecialmenu(s);
		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Special menu added');");
		out.print("location='addspecialmenu.jsp';");
		out.print("</script>");
	}


	private String extactFileName(Part image) {
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
