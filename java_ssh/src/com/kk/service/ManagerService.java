package com.kk.service;

import java.util.List;

import com.kk.entity.Manager;

public interface ManagerService {
	/**
	 * 添加
	 * @param manager
	 * @return
	 */
	public  boolean add(Manager manager);
	
	/**
	 * 更新
	 * @param manager
	 * @return
	 */
	public boolean update(Manager manager);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public boolean delete(String id);
	
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	public Manager findByID(String id);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<Manager> findAll();
}
