package com.dao.impl;

import com.bean.Customer;
import com.dao.basedao.BaseDaoInterface;

public interface UserDaoImpl extends BaseDaoInterface<Customer> {

	public Customer getCustomerByName(String userName) ;
}
