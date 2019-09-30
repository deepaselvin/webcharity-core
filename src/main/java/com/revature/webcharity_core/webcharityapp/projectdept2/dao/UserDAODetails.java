package com.revature.webcharity_core.webcharityapp.projectdept2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.webcharity_core.webcharityapp.projectdept2.util.ConncetionUtil;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.AdminAct;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.requestlist;
import com.revature.webcharity_core.webcharityapp.projectdept2.exception.DBException;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.ContributeRequest;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.RegUserDetails;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.adminreg;
import com.revature.webcharity_core.webcharityapp.projectdept2.model.loginUser;

public class UserDAODetails {

	static Connection con = null;
	static PreparedStatement pst = null;

	public static int register(RegUserDetails User) throws SQLException, DBException {

		String sql = "insert into Users(name,phone_no) values (?,?)";
		 try {
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, User.getName());
			pst.setLong(2, User.getPhoneno());
			int rows = pst.executeUpdate();
			return rows;
		} catch (SQLException e) {
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}
	}

	public static loginUser login(String name,  long phone_no )
			throws SQLException, ClassNotFoundException, DBException {

		String sql = "select * from Users where name=? and phone_no=?";
		//select * from Users where name=? and phone_no=?
	//	select id,name,phone_no from Users 
		loginUser rg = null;
		try {
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setLong(2, phone_no);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				rg = new loginUser();
				rg.setId(rs.getInt("id"));
				rg.setName(rs.getString("name"));
			
				rg.setPhone_no(rs.getLong("phone_no"));
				System.out.println(" Login sucessfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}
		return rg;
	}

	public static int adminRegister(adminreg User) throws SQLException, DBException {

		try {
			String sql = "insert into AdminUsers(name,phone_no) values (?,?)";
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, User.getAdminName());
			pst.setLong(2, User.getPhnoneno());
			int rows = pst.executeUpdate();
			return rows;
		} finally {
			ConncetionUtil.close(con, pst);
		}
	}

	public static adminreg adminLogin(String adminName, long Phnoneno) throws Exception {

		String sql = "select * from AdminUsers where name=? and phone_no=? ";
		adminreg user = null;
		try {
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, adminName);
			pst.setLong(2, Phnoneno);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user = new adminreg();
				user.setAdminName(rs.getString("name"));
				System.out.println("ADMIN Login sucessfully");
			} else {
				System.out.println("ADMIN Login failed");

			}
		} catch (SQLException e) {
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}
		return user;
	}


	public static int requestInsert(String Request_need, int Deposit, int Request_no) throws SQLException, DBException {

		try {
			String sql = "insert into employees(Request_name,Amount_Donated,Request_no) values (?,?,?)";
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, Request_need);
			pst.setInt(2, Deposit);
			pst.setInt(3, Request_no);
			int rows = pst.executeUpdate();
			return rows;
		}
		catch (SQLException e) {
				throw new DBException("unable to select");
			} finally {
				ConncetionUtil.close(con, pst);
			}

	}

	public static void requestUpdate(int totalBalance, String Request_need) throws SQLException, DBException {

		try {
			con = ConncetionUtil.getconnection();
			String sql1 = "update employees set Amount_Donated=? where Request_need=?";
			pst = con.prepareStatement(sql1);
			pst.setInt(1, totalBalance);
			pst.setString(2, Request_need);
			pst.executeUpdate();
		}
		catch (SQLException e) {
				throw new DBException("unable to select");
			} finally {
				ConncetionUtil.close(con, pst);
			}

	}

	public static void fundinfo(int Fund_needed) throws SQLException, DBException {

		try {
			con = ConncetionUtil.getconnection();
			String sql = "insert into employees(Fund_needed) values (?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, Fund_needed);
			pst.executeUpdate();
		}		catch (SQLException e) {
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}

	}

	public static void adFundinfo(int Fund_needed, int Request_no) throws SQLException, DBException {

		try {
			con = ConncetionUtil.getconnection();
			String sql1 = "update employees set Fund_needed=? where Request_no=?";
			pst = con.prepareStatement(sql1);
			pst.setInt(1, Fund_needed);
			pst.setInt(2, Request_no);
			pst.executeUpdate();
		}		catch (SQLException e) {
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}


	}

	public static void fundUpdate(int fund_needed, int category_id) throws SQLException, DBException {

		try {
			con = ConncetionUtil.getconnection();
			String sql1 = "update employees set Fund_needed=? where category_id=?";
			pst = con.prepareStatement(sql1);
			pst.setInt(1, fund_needed);
			pst.setInt(2, category_id);
			pst.executeUpdate();
		}		catch (SQLException e) {
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}

	}

	public static List<ContributeRequest> userRequest() throws SQLException, DBException {
 
		List<ContributeRequest> list=null;
		ResultSet rs=null;
		try {
			
			con = ConncetionUtil.getconnection();
			String sql1 = "select name,request_id,amount_donated from Users u,User_activity a where u.id=a.user_id;";
			pst = con.prepareStatement(sql1);
			 rs = pst.executeQuery();
			list = new ArrayList<ContributeRequest>();
			while (rs.next()) {
				ContributeRequest user = toRow(rs);

				list.add(user);
			}
			
		}		catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst,rs);
		}
		return list;

	}

	private static ContributeRequest toRow(ResultSet rs) throws SQLException, DBException {
		ContributeRequest user = new ContributeRequest();

		try {
			String name = rs.getString("name");
			int requestid = rs.getInt("request_id");
			int amountdonated = rs.getInt("amount_donated");
			
			
			user.setName(name);
			user.setRequestid(requestid);
			user.setAmountdonated(amountdonated);
		
		}	catch (SQLException e) {
			throw new DBException("unable to select");
		}
		return user;
	}

	

	public static int adminRequest(AdminAct request) throws SQLException, DBException {

		try {
			String sql = "insert into category(request_type,fund_needed) values (?,?)";
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, request.getRequest_type());
			pst.setDouble(2, request.getFund_needed());
			int rows = pst.executeUpdate();
			return rows;
		} 	catch (SQLException e) {
			throw new DBException("unable to select");
		}finally {
			ConncetionUtil.close(con, pst);
		}
	}

	public static List<AdminAct> Requestlist() throws SQLException, DBException {
		ResultSet rs =null;
		List<AdminAct> list=null;
		try {
			con = ConncetionUtil.getconnection();
			String sql1 = "select * from category ";
			pst = con.prepareStatement(sql1);
			rs = pst.executeQuery();
		 list = new ArrayList<AdminAct>();
			while (rs.next()) {
				AdminAct us = toRow1(rs);

				list.add(us);
			}
			
		}	catch (SQLException e) {
			throw new DBException("unable to select");
		}finally {
			ConncetionUtil.close(con, pst);
		}
		return list;
	}

	private static AdminAct toRow1(ResultSet rs) throws SQLException {

		String request_type = rs.getString("request_type");
		double fund_needed=rs.getDouble("fund_needed") ;

		AdminAct user = new AdminAct();
		user.setRequest_type(request_type);;
		user.setFund_needed(fund_needed);;

		return user;
	}

	public static int insert(ContributeRequest User) throws SQLException, DBException {

		String sql = "insert into User_activity(user_id,request_id,amount_donated) values (?,?,?)";
		 try {
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			pst.setLong(1, User.getUserId());
			pst.setInt(2, User.getRequestid());
			pst.setDouble(3, User.getAmountdonated());
			
			int rows = pst.executeUpdate();
			return rows;
		} catch (SQLException e) {
		 	 e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}
	}

	public static int update(ContributeRequest User) throws SQLException, DBException {

		String sql = "update category set fund_needed= fund_needed - ? where id=?";
		 try {   
			con = ConncetionUtil.getconnection();
			pst = con.prepareStatement(sql);
			 pst.setDouble(1, User.getAmountdonated());
	            pst.setInt(2, User.getRequestid());
	       
			int rows = pst.executeUpdate();
			System.out.println(rows);
			return rows;
		} catch (SQLException e) {
		 	 e.printStackTrace();
			throw new DBException("unable to select");
		} finally {
			ConncetionUtil.close(con, pst);
		}
	}



}
