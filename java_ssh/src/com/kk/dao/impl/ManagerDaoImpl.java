package com.kk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kk.dao.ManagerDao;
import com.kk.entity.Manager;
import com.kk.util.JdbcUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.regexp.internal.recompile;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public boolean add(Manager manager) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql ="insert into Manager(userID,username,password) value(?,?,?)";
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, manager.getUserID());
			stmt.setString(2,manager.getUsername());
			stmt.setString(3, manager.getPassword());
			stmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Manager manager) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql ="update Manager set username=?,password=? where userID=?";
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1,manager.getUsername());
			stmt.setString(2, manager.getPassword());
			stmt.setString(3, manager.getUserID());
			stmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql ="delete from Manager  where userID=?";
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Manager findByID(String id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql ="select * from Manager where userID=?";
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rSet = stmt.executeQuery();
			Manager manager =new Manager();
			if (rSet.next()) {
				manager.setUserID(id);
				manager.setUsername(rSet.getString(2));
				manager.setPassword(rSet.getString(3));
			}
			return manager;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql ="select * from Manager";
			PreparedStatement stmt =conn.prepareStatement(sql);
			ResultSet rSet = stmt.executeQuery();
		    List<Manager> list =new ArrayList<>();
			if (rSet.next()) {
				Manager manager =new Manager();
				manager.setUserID(rSet.getString(1));
				manager.setUsername(rSet.getString(2));
				manager.setPassword(rSet.getString(3));
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
