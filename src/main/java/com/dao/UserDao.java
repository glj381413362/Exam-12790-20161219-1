package com.dao;

import java.util.List;

import com.bean.Customer;
import com.dao.impl.UserDaoImpl;

public class UserDao implements UserDaoImpl {

	@Override
	public Customer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> queryByExample(Customer instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
