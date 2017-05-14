package com.kk.service.impl;

import java.util.List;

import com.kk.dao.impl.ManagerDaoImpl;
import com.kk.entity.Manager;
import com.kk.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	ManagerDaoImpl dao =new ManagerDaoImpl();
	@Override
	public boolean add(Manager manager) {
		// TODO Auto-generated method stub
		return dao.add(manager);
	}

	@Override
	public boolean update(Manager manager) {
		// TODO Auto-generated method stub
		return dao.update(manager);
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public Manager findByID(String id) {
		// TODO Auto-generated method stub
		return dao.findByID(id);
	}

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
