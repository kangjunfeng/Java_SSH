package com.kk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kk.dao.StudentDao;
import com.kk.entity.Student;
import com.kk.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	private Student stu;

	@Override
	public boolean add(Student stu) {
		// TODO Auto-generated method stub
		try {
			Connection  conn = JdbcUtil.getConnection();
			String  sql ="insert into Student(uuid,name,age,sex,email,cellPhone) values(?,?,?,?,?,?)";
			PreparedStatement preStmt =conn.prepareStatement(sql);
			preStmt.setString(1, stu.getId());
			preStmt.setString(2, stu.getName());
			preStmt.setInt(3, stu.getAge());
			preStmt.setString(4, stu.getSex());
			preStmt.setString(5, stu.getEmail());
			preStmt.setString(6, stu.getCellPhone());
			preStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		try {
			Connection  conn = JdbcUtil.getConnection();
			String  sql ="update  Student  set name =?,age =?,sex=?,email=?,cellPhone=? where uuid =?";
			PreparedStatement preStmt =conn.prepareStatement(sql);
			preStmt.setString(1, stu.getName());
			preStmt.setInt(2, stu.getAge());
			preStmt.setString(3, stu.getSex());
			preStmt.setString(4, stu.getEmail());
			preStmt.setString(5, stu.getCellPhone());
			preStmt.setString(6, stu.getId());
			preStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		try {
			Connection conn =JdbcUtil.getConnection();
			String sql ="select * from Student  where uuid=?";
			PreparedStatement preStme = conn.prepareStatement(sql);
			preStme.setString(2, id);
		    ResultSet rSet = preStme.executeQuery();
		    Student   stu = new Student();
			if (rSet.next()) {
				stu.setId(id);
				stu.setName(rSet.getString(3));
				stu.setAge(rSet.getInt(4));
				stu.setSex(rSet.getString(5));
				stu.setEmail(rSet.getString(6));
				stu.setCellPhone(rSet.getString(7));
			}
			return stu;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		try {
			Connection conn =JdbcUtil.getConnection();
			String sql ="delete from Student where uuid =?";
			PreparedStatement preStmt =conn.prepareStatement(sql);
			preStmt.setString(1, id);
			preStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		try {
			List<Student> stuList = new ArrayList<Student>();
			Connection conn  = JdbcUtil.getConnection();
			String sql ="select * from Student";
			PreparedStatement preStmt = conn.prepareStatement(sql);
			ResultSet rSet =preStmt.executeQuery();
			while (rSet.next()) {
				Student stu = new Student();
				stu.setId(rSet.getString(2));
				stu.setName(rSet.getString(3));
				stu.setAge(rSet.getInt(4));
				stu.setSex(rSet.getString(5));
				stu.setEmail(rSet.getString(6));
				stu.setCellPhone(rSet.getString(7));
				stuList.add(stu);
			}
			return stuList;
 		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
 			return null;
		}
	}

}
