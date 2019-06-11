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
import com.pojo.Addproduct;
import com.pojo.Mainproduct;



@WebServlet("/Updateproduct")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 70,
maxRequestSize = 1024 * 1024 * 100)
public class Updateproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static String SAV_DIR = "c://ProjectDemo/Foodorder/WebContent/menuimages/";
	    FilePermission permission1=new FilePermission(SAV_DIR, "write");
	    
       BLManager bl=new BLManager();
       Addproduct a=new Addproduct();
     Mainproduct m=new Mainproduct();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		int aid=Integer.parseInt(id);
		
		a=bl.serachbyid(aid);
		
		HttpSession session=request.getSession();
		session.setAttribute("list",a);
		
		response.sendRedirect("UpdateProduct.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		
		Part image=request.getPart("image");
		String Quantity=request.getParameter("Quantity");
		
		
		a.setName(name);
		a.setPrice(price);
		a.setQuantity(Quantity);
		try{
			String img1=extractFileName(image);
			a.setImage(img1);
			
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
		
		bl.saveUpdate(a);
		

		
		out.print("<script type=\"text/javascript\">");
		out.print("alert('Record update successfully....');");
		out.print("location='viewproduct1.jsp';");
		out.print("</script>");
		
		//response.sendRedirect("Addsunmenu.jsp");
		
		
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
