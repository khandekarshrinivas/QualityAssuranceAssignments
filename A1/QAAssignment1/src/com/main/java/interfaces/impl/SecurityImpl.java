package com.main.java.interfaces.impl;

import com.main.java.datalayer.OrderDB;
import com.main.java.interfaces.Security;

public class SecurityImpl implements Security{

	@Override
	public boolean IsDealerAuthorized(String dealerid, String dealeraccesskey) {
		
		OrderDB db = new OrderDB();
		
		if(!db.authenticateDealerId(dealerid))
				return false;
		if(! db.authenticateDealerAccessKey(dealeraccesskey))
			return false;
		return true;
		
	}
}
 