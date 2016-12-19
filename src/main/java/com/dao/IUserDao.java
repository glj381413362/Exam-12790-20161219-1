package com.dao;

import com.bean.Customer;
import com.dao.basedao.BaseDaoInterface;

public interface IUserDao extends BaseDaoInterface<Customer> {

	public Customer getCustomerByName(String userName) ;
}
