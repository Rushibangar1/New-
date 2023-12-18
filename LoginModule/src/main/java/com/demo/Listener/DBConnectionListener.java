package com.demo.Listener;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.demo.dao.DBUtil;

/**
 * Application Lifecycle Listener implementation class DBConnectionListener
 *
 */
public class DBConnectionListener implements ServletContextListener {

	ServletContext ctx;
	Connection con;
    /**
     * Default constructor. 
     */
    public DBConnectionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	ctx=arg0.getServletContext();
    	con=DBUtil.getCon(
    	ctx.getInitParameter("driverName"),
    	ctx.getInitParameter("url"),
        ctx.getInitParameter("username"),
        ctx.getInitParameter("password"));
    	
    	System.out.println("contextInitialized "+ con);
    	ctx.setAttribute("dbCon", con);
    }
	
}
