package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerTypeDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerTypeDao dao;
	
	@Override
	@Transactional
	public Integer saveCustomer(Customer c) {
		// TODO Auto-generated method stub
		return dao.saveCustomer(c);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		dao.updateCustomer(c);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Customer getOneCustomer(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOneCustomer(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

}
