package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Addproduct;
import com.pojo.Addressdetails;
import com.pojo.Addtocart;
import com.pojo.Admin;
import com.pojo.Booktable;
import com.pojo.Item;
import com.pojo.Mainproduct;
import com.pojo.Offer;
import com.pojo.Orderstatus;
import com.pojo.Registration;
import com.pojo.Specialmenu;

public class BLManager {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public Admin searchbyEmailPassowrd(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		Admin a = (Admin) cr.uniqueResult();

		return a;
	}

	public Item searchid(int id) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Item.class);
		cr.add(Restrictions.eq("id", id));
		Item a=(Item) cr.uniqueResult();
		
		return a;
	}
	public void updateRecord(Item i) {
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		session.update(i);
		t.commit();
		session.close();
		
	}
	
	
	public Admin searchbyusername(String username) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("username", username));
		Admin a = (Admin) cr.uniqueResult();

		return a;

		
	}
	public List<Item> searchbystatus(String status){
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Item.class);
		cr.add(Restrictions.eq("status", status));
		List<Item> list = cr.list();
		return list;
	}
	
	public List<Item> searchbyid1(int id){
		Session s1=sf.openSession();
		String hql="FROM Item i WHERE i.registration=?";
		Query q=s1.createQuery(hql);
		q.setInteger(0, id);
		List l=q.list();
		return l;
		
	}
/*   public List searchAllPandingRecord(String status){
	   Session s1=sf.openSession();
	   //String hql="From Item i,Orderstatus o where i.registration=o.registration AND i.status=?";
	   //FROM Employee e INNER JOIN Team t ON e.Id_team=t.Id_team
	   String hql="FROM Item i1, Orderstatus o1 where i1.registration=o1.registration AND i1.status=?";
	   Query q=s1.createQuery(hql);
	   q.setString(0, status);
	   List l=q.list();
	   return l;
		
	}
*/	
	public List<Item> searchAllPandingRecord(String status){
	   Session s1=sf.openSession();
	   String hql="From Item i where i.status=?";
	   //FROM Employee e INNER JOIN Team t ON e.Id_team=t.Id_team
	 //  String hql="FROM Item i1 INNER JOIN Registration r1 ON i1.id=r1.id AND i1.status=?";
	   Criteria cr=s1.createCriteria(Item.class);
	 
	   Query q=s1.createQuery(hql);
	   q.setString(0,status);
	   List<Item> l=cr.list();
	   return l;
	}	
	
	public List<Orderstatus> searcgstatus(String status){
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Orderstatus.class,"o");
		cr.createAlias("o.item", "is");
		cr.add(Restrictions.eq("is.status", status));
		List<Orderstatus> l=cr.list();
		return l;
		
		
	
	}

	public List<Orderstatus> searchorder(){
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Orderstatus.class);
	    List<Orderstatus> a=cr.list();
	    return a;
	}
	public List<Item> searchItems(){
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Item.class);
	    List<Item> a=cr.list();
	    return a;
	}
	public List<Admin> searchid(){
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Admin.class);
		List<Admin> a=cr.list();
		return a;
		
	}

	public Admin searchbyid(int aid) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Admin.class);
		cr.add(Restrictions.eq("id", aid));
		Admin a=(Admin) cr.uniqueResult();
		return a;
	}

	

	public void updateRecord(Admin a) {
		// TODO Auto-generated method stub
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.update(a);
		t1.commit();
		s1.close();
		
	}

	public void savemainmenu(Mainproduct m) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.save(m);
		t1.commit();
		s1.close();
		
	}
	
	public List<Mainproduct> searchbylist(){
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Mainproduct.class);
		List<Mainproduct> m=cr.list();
		return m;
	}

	public Mainproduct searchbymname(String mname) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Mainproduct.class);
		cr.add(Restrictions.eq("mname", mname));
		Mainproduct a=(Mainproduct) cr.uniqueResult();
		return a;
	}

	public void saveRecord(Addproduct a) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.save(a);
		t1.commit();
		s1.close();
		
	}

	

	public List<Addproduct> searchbyID(int mid) {
		// TODO Auto-generated method stub
		
		Session s1=sf.openSession();
		
		String hql="FROM Addproduct A WHERE A.mainproduct=? ";
		Query q=s1.createQuery(hql);
		q.setInteger(0, mid);
		List l=q.list();
		return l;
	}
	
	public List<Addproduct> search(){
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Addproduct.class);
    List<Addproduct> a=cr.list();
    
    return a;
		
	}

	public Addproduct serachbyid(int aid) {
		Session s = sf.openSession();
		Criteria cr = s.createCriteria(Addproduct.class);
		cr.add(Restrictions.eq("id", aid));
		Addproduct a=(Addproduct) cr.uniqueResult();
		s.close();
		return a;
	}

	public void saveUpdate(Addproduct a) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.update(a);
		t1.commit();
		 s1.close();
		
	}

	public void saveregister(Registration r) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.save(r);
		t1.commit();
		s1.close();
		
	}
	
	public List<Registration> searchregi(){
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Registration.class);
	    List<Registration> r=cr.list();
	    return r;
		
	}

	public Registration searchcuname(String username) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Registration.class);
		cr.add(Restrictions.eq("username", username));
		Registration r=(Registration) cr.uniqueResult();
		return r;
	}

	public Registration searchuserpass(String username, String password) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Registration.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		Registration r=(Registration) cr.uniqueResult();
		return r;
	}


	public void saveupdateC(Registration r) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.update(r);
		t1.commit();
		s1.close();
		
	}

	public Registration searchByRegId(int id1)
	{
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Registration.class);
		cr.add(Restrictions.eq("id", id1));
		Registration a=(Registration) cr.uniqueResult();
		return a;
	}

	public Addproduct searchbyProductId(int id) {
		Session s1=sf.openSession();
		Criteria cr=s1.createCriteria(Addproduct.class);
		cr.add(Restrictions.eq("id", id));
		Addproduct a=(Addproduct) cr.uniqueResult();
		return a;
	}
	
	
public List<Registration> searchByList(){
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Registration.class);
	List<Registration> r=cr.list();
	return r;
}

public void saveTable(Booktable b) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(b);
	t1.commit();
	s1.close();
	
}

public Registration searchbyRegistrationID(String emailid) {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Registration.class);
	cr.add(Restrictions.eq("emailid", emailid));
	Registration a=(Registration) cr.uniqueResult();
	return a;
}

public List<Booktable> searchbooking(){
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Booktable.class);
	List<Booktable> b=cr.list();
	return b;
	
}

public void saveSpecialmenu(Specialmenu s) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(s);
	t1.commit();
	s1.close();
	
}

public List<Specialmenu> searchspecialmenu(){
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Specialmenu.class);
	List<Specialmenu> s=cr.list();
	return s;
	
}

public Specialmenu searchsid(int sid) {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Specialmenu.class);
	cr.add(Restrictions.eq("id", sid));
	Specialmenu s=(Specialmenu) cr.uniqueResult();
	return s;
}

public void Updatespecialmenu(Specialmenu s) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.update(s);
	t1.commit();
	s1.close();
	
	
}

public void saverecordAdd(Addtocart ac) {
//	Session s1=sf.openSession();
//	Transaction t1=s1.beginTransaction();
//	s1.save(ac);
//	t1.commit();
//	s1.close();
	
	Session s2=sf.openSession();
	Transaction t=s2.beginTransaction();
	s2.saveOrUpdate(ac);
	t.commit();
	s2.close();
	
}
	

/*	
public void saveRecord(Addtocart m) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(m);
	t1.commit();
	s1.close();
	
}*/
	
	
public void saveitems(Item i) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	//s1.saveOrUpdate(r);
	s1.save(i);
	t1.commit();
	s1.close();
	
}

public void updateitesm(Item i) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	//s1.saveOrUpdate(r);
	s1.saveOrUpdate(i);
	t1.commit();
	s1.close();
	
}



public void add(Item i) {

	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	//s1.saveOrUpdate(r);
	s1.save(i);
	t1.commit();
	s1.close();
	
}



public void upadte(int id, int quantity) {

	Session s1=sf.openSession();
	Transaction t=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Item.class);
	
	String hql="update Item p set p.iquantity=:quantity where p.addproduct.id=:id";
	Query q=s1.createQuery(hql);
	q.setParameter("id", id);
	q.setParameter("quantity", quantity);
	q.executeUpdate();
	t.commit();
	s1.close();
	
	
	
}



public void delete(int id) {
	

	Session s1=sf.openSession();
	Transaction t=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Item.class);
	String hql="delete from Item p where p.addproduct.id=:id";
	Query q=s1.createQuery(hql);
	q.setParameter("id", id);
	q.executeUpdate();
	t.commit();
	s1.close();
	
	
}



public void upadtetable(int id, int quantity) {


	Session s1=sf.openSession();
	Transaction t=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Item.class);
	
	String hql="update Item p set p.iquantity=:quantity where p.addproduct.id=:id";
	Query q=s1.createQuery(hql);
	q.setParameter("id", id);
	q.setParameter("quantity", quantity);
	q.executeUpdate();
	t.commit();
	s1.close();
	
}

public List<Registration> serachbyuserlist() {
	Session s1 = sf.openSession();
	Criteria cr = s1.createCriteria(Registration.class);
	List<Registration> r = cr.list();
	s1.close();
	return r;

}

public Registration SearchbyEmail(String emailid) {
	Session session = sf.openSession();
	Criteria cr = session.createCriteria(Registration.class);
	cr.add(Restrictions.eq("emailid", emailid));
	Registration a = (Registration) cr.uniqueResult();
	session.close();
	return a;
}

public void update(Registration r) {
	Session s1 = sf.openSession();
	Transaction t1 = s1.beginTransaction();
	s1.update(r);
	t1.commit();
	s1.close();
}



public void savespecialoffer(Offer o) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(o);
	t1.commit();
	s1.close();
}

public List<Offer> searchoffer(){
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Offer.class);
	List<Offer> s=cr.list();
	return s;
	
}



public Offer serachspecialoffer(int aid) {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Offer.class);
	cr.add(Restrictions.eq("oid", aid));
	Offer a=(Offer) cr.uniqueResult();
	return a;
}



public void saveUpdatesoffer(Offer o) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.update(o);
	t1.commit();
	s1.close();
}

public void deleteoffer(Offer o) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.delete(o);
	t1.commit();
	s1.close();
	
	
}





public List<Item> searchcustomerorder(){
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Item.class);
	List<Item> s=cr.list();
	return s;
	
}



public void saveAddress(Addressdetails a) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(a);
	t1.commit();
	s1.close();
	
}



public Addressdetails searchaddress(int id) {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Addressdetails.class);
	cr.add(Restrictions.eq("adid", id));
    Addressdetails a=(Addressdetails) cr.uniqueResult();
	return a;
}



public void updateadd(Addressdetails a) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.update(a);
	t1.commit();
	s1.close();
	
}



public void saveorderdetails(Orderstatus o) {
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.save(o);
	t1.commit();
	s1.close();
}


public List<Orderstatus> searchorderstatus(){
	Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	Criteria cr=s1.createCriteria(Orderstatus.class);
	List<Orderstatus> s=cr.list();
	return s;
	
}



public List<Item> sarchbyitem(int iid) {
Session s1=sf.openSession();
	
	String hql="FROM Item A WHERE A.registration=? ";
	Query q=s1.createQuery(hql);
	q.setInteger(0, iid);
	List l=q.list();
	return l;
	
}



public Registration searchregistration(int rid) {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Registration.class);
	cr.add(Restrictions.eq("id", rid));
	Registration a=(Registration) cr.uniqueResult();
	s1.close();
	return a;
	
}

public Item searchstatus(int id) {
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Item.class);
	cr.add(Restrictions.eq("id", id));
	Item a=(Item) cr.uniqueResult();
	s1.close();
	return a;
}
public List<Item> searchlist(){
	Session s1=sf.openSession();
	Criteria cr=s1.createCriteria(Item.class);
	List<Item> i=cr.list();
	return i;
}





}
