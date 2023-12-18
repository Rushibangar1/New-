package com.demo.service;

import java.sql.Connection;
import java.util.List;

import com.demo.bean.LoginBean;

public interface LoginService {
	
	LoginBean validateUser(String user,String pass);
	
	List<LoginBean> getAll(Connection con);
}