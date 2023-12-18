package com.demo.service;

import java.sql.Connection;
import java.util.List;

import com.demo.bean.LoginBean;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	LoginDao logindao=new LoginDaoImpl();
	
	public LoginServiceImpl() {
		
	}
	@Override
	public LoginBean validateUser(String user, String pass) {
		
		return logindao.validateUser(user,pass);
	}
	@Override
	public List<LoginBean> getAll(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
}
