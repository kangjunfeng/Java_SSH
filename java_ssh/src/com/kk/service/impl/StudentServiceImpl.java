package com.kk.service.impl;

import java.util.List;

import com.kk.dao.impl.StudentDaoImpl;
import com.kk.entity.Student;
import com.kk.service.StudentService;


public class StudentServiceImpl implements StudentService {

	StudentDaoImpl stdDao = new StudentDaoImpl();
	@Override
	public boolean add(Student stu) {
		// TODO Auto-generated method stub
		return stdDao.add(stu);
	}

	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		return stdDao.update(stu);
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return stdDao.delete(id);
	}
	
	@Override
	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		return stdDao.findStudentById(id);
	}
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return stdDao.findAll();
	}


}
