package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Customer;
import com.dao.IUserDao;
import com.dao.db.DBUtil;


public class UserDao implements IUserDao {

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
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Customer obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Customer obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> queryByExample(Customer instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByName(String userName) {
		Customer customer = null;
		String sql="select * from customer where first_name=?";
		Object[] params = new Object[] { userName };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				customer = new Customer();
				customer.setCustomer_id(rs.getInt("CUSTOMER_ID"));
				customer.setFirst_name(rs.getString("FIRST_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}
