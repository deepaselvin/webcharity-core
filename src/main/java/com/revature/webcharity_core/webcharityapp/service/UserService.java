package com.revature.webcharity_core.webcharityapp.service;

import com.revature.webcharity_core.webcharityapp.projectdept2.dao.UserDAODetails;
import com.revature.webcharity_core.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.AdminAct;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.ContributeRequest;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.loginUser;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.requestlist;

import java.sql.SQLException;
import java.util.List;

public class UserService {
	

	public static loginUser loginProcess( String name,long phnno,int id)throws SQLException, DBException, ClassNotFoundException {
		
		loginUser rd=null;
		
		rd=UserDAODetails.login(name, phnno,id);
		return rd;
	    }


	public static void registerProcess( ContributeRequest rd) throws DBException {
		
		//UserDAODetails.contribute(0, 0, 0);

	}

	
	
	public static void registerProcess( RegUserDetails rd)throws SQLException, DBException, ClassNotFoundException {
		
		UserDAODetails.register(rd);
		}	
	public static  List<AdminAct> Requestlist(){
		 List<AdminAct> list=null;
			try {
				try {
					list = UserDAODetails .Requestlist();
				} catch (DBException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		 
		}	
	public static  List<ContributeRequest> userlist(){
	
		 List<ContributeRequest> list = null;
			
		 try {
				try {
					list =UserDAODetails.userRequest();
				} catch (DBException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
		}	
	
	
}

	

