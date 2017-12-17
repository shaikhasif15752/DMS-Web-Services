package com.admin.dao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.serv.db.MySessionFactory;
import com.dev.mgm.bean.Admin;


/**
 *@author Asif
 *@date 16/12/2017
 */


public class ChangePasswordDAO {
	private static Logger log=Logger.getLogger(LoggingDAO.class);
	
	public String changePassword(Admin adminJSON){
		//TODO  Load all logs of device
		try {
			
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Admin admin;
			Transaction tx=session.beginTransaction();
			admin=session.get(Admin.class,1);
			System.out.println("json="+adminJSON.getPassword());
			System.out.println("admin="+admin.getPassword());
			if(adminJSON.getPassword().equals(admin.getPassword())) {
				
				admin.setPassword(adminJSON.getNewPassword());
				tx.commit();
				return "Password Change Successfully";
				
			}
			else{
				return "Password Not match";
			}
			
		}
		
	catch(HibernateException e) {
		log.error("Unable to Change Password!",e);
		}
		return null;
	}

}
