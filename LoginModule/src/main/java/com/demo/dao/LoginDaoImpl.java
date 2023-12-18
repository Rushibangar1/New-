package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.LoginBean;

public class LoginDaoImpl implements LoginDao {
	
	public LoginDaoImpl() {
		
	}
	@Override
	public LoginBean validateUser(String user,String pass) {
		LoginBean l=null;
//		if(user.equals("user") && pass.equals("user")) {
//			l= new LoginBean();
//			l.setUser(user);
//			l.setPass(pass);
//			l.setRole("user");
//			
//			return l;
//		}
//		return l;
		
		
		
		try {
			Connection con=DBUtil.getCon();
			String sql="Select * from LoginModule where username=? and password=?";
			PreparedStatement pstat=con.prepareStatement(sql);
			
			pstat.setString(1, user);
			pstat.setString(2, pass);
			
			ResultSet rs=pstat.executeQuery();
			
			if(rs.next()) {
				l=new LoginBean();
				l.setUser(rs.getString(1));
				l.setPass(rs.getString(2));
				l.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	@Override
	public List<LoginBean> getAll(Connection con) {
		List<LoginBean> l=null;
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from LoginModule");
			l=new ArrayList<LoginBean>();
			LoginBean lb=new LoginBean();
			while(rs.next()) {
				lb=new LoginBean();
				lb.setUser(rs.getString(1));
				lb.setPass(rs.getString(2));
				lb.setRole(rs.getString(3));
				l.add(lb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}