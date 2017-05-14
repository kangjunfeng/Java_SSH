package com.kk.service;

import java.util.List;

import com.kk.entity.Student;

public interface StudentService {
	/**
	 * 添加
	 * @param stu
	 * @return
	 */
	public boolean add(Student stu);
	
	/**
	 * 更新
	 * @param stu
	 * @return
	 */
	public boolean update(Student stu);
	
	/**
	 * 删除
	 * @param stu
	 * @return
	 */
	public boolean delete(String id);
	
	/**
	 * 查找单个学生
	 * @param id
	 * @return
	 */
	public Student findStudentById(String id);
	
	/**
	 * 查找所有学生
	 * @return
	 */
	public List<Student> findAll();
	
}
