package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Addproduct;
import com.pojo.Item;
import com.pojo.Registration;



/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   Registration r=new Registration();    
   Addproduct ad=new Addproduct();
   BLManager bl=new BLManager();
  
   Item i=new Item();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("Product  Id:"+id);
		
		int rid=(int)session.getAttribute("id");
		System.out.println("id"+rid);
		ad=bl.searchbyProductId(id);
		r=bl.searchregistration(rid);
		int iid=r.getId();
		String sid=String.valueOf(iid);
		
		int productid=ad.getId();
		
		
		
		
		String action =request.getParameter("action");
		
		String status="pending";
		session.setAttribute("pid", productid);
		if (action.equals("Add to cart")) {
			if (session.getAttribute("cart") == null) {
				List<Item> cart =bl.sarchbyitem(iid);
				
					
				cart.add(new Item(ad,r, 1,status));
				
				int iquantity=cart.get(0).getIquantity();
				System.out.println(iquantity);
				
				i.setIquantity(iquantity);
				i.setAddproduct(ad);
				i.setRegistration(r);
				i.setStatus(status);
				
                bl.add(i);
				
				session.setAttribute("cart", cart);  

			} else {
				

				List<Item> cart = bl.sarchbyitem(iid);
				int index = isExisting(id, cart,iid);
				
				System.out.println("index"+index);
				if (index == -1) {
					cart.add(new Item(ad,r, 1,status));
					
					int iquantity=1;
					i.setIquantity(iquantity);
					i.setAddproduct(ad);
					i.setRegistration(r);
					i.setStatus(status);
					
					bl.add(i);
					//cart.add(new item(p, 1));

				} else  {
					
					for(int i=0;i<cart.size();i++)
						
					{
					    if(cart.get(i).getRegistration().getId()==rid && cart.get(i).getAddproduct().getId()==productid )
					    {
					int quantity = cart.get(i).getIquantity() + 1;
					cart.get(index).setIquantity(quantity);
					//System.out.println("id"+id+" "+quantity );
					
						bl.upadte(id,quantity);
					    }
					}
				}
				session.setAttribute("cart", cart);
				
				
				 
			}
			
			
			//response.sendRedirect("cart1.jsp");
			request.getRequestDispatcher("cart1.jsp").forward(request, response);
		}

		else if (action.equals("delete")) {

			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index1 = isExisting(id, cart,iid);
			cart.remove(index1);
			bl.delete(id);
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("cart1.jsp").forward(request, response);
		}
	}

	private int isExisting(int id, List<Item> cart,int idd) {

		for (int i = 0; i < cart.size(); i++) {

			if (cart.get(i).getAddproduct().getId() == id) {
				//cart.get(i).getIquantity();
				return i;
				
			}
		}
		return -1;

		
	}
			
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		if(action.equalsIgnoreCase("update"))
		{
			
			
			List<Item> cart=(List<Item>) session.getAttribute("cart");
			
		int quantity=Integer.parseInt(request.getParameter("quantity"));
			//String quantity[]=request.getParameterValues("quantity");
			
			int id=(int)session.getAttribute("pid");
			for (int i = 0; i < cart.size() ; i++) {
				
				cart.get(i).setIquantity((quantity));
				//cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
				bl.upadtetable(id, quantity);
				
			}
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("cart1.jsp").forward(request, response);
			
		}
		
			}

	}


