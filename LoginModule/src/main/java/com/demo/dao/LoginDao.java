package com.demo.dao;

import java.sql.Connection;
import java.util.List;

import com.demo.bean.LoginBean;

public interface LoginDao {

	LoginBean validateUser(String user, String pass);
	
	List<LoginBean> getAll(Connection con);
}