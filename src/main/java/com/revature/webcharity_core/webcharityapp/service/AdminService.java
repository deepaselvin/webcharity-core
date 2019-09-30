package com.revature.webcharity_core.webcharityapp.service;

import java.sql.SQLException;

import com.revature.webcharity_core.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharity_core.webcharityapp.projectdept2.exception.DBException;

import com.revature.webcharity_core.webcharityapp.projectdept2.model.adminreg;

public class AdminService {

public static adminreg loginProcess( String name,long phnno) {
		
	adminreg user=null;
		
	try {
		user=UserDAODetails.adminLogin(name, phnno);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
		return user;
	    }
public static void registerProcess( adminreg user)throws SQLException, DBException {
	
	UserDAODetails.adminRegister(user);
	}	
public static void addrequestProcess(String Name ) {
	try {
		UserDAODetails.adminRequest(Name);
	} catch (SQLException e) {

		e.printStackTrace();
	} catch (DBException e) {
		
		e.printStackTrace();
	}
}
}
