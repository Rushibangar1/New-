package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.LoginBean;
import com.demo.dao.DBUtil;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
    }

	
    
    ServletContext ctx;
    
	public void init(ServletConfig config) throws ServletException {
		
		ctx=config.getServletContext();
//		System.out.println(ctx.getInitParameter("driverName"));
//		System.out.println(ctx.getInitParameter("url"));
//		System.out.println(ctx.getInitParameter("userName"));
//		System.out.println(ctx.getInitParameter("password"));
		
		con=DBUtil.getCon(ctx.getInitParameter("driverName"),
				ctx.getInitParameter("url"),
		        ctx.getInitParameter("userName"),
	            ctx.getInitParameter("password")	
				);
		
//		con = DBUtil.getCon();
//		System.out.println(config.getInitParameter("d"));
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		System.out.println("Details "+user+" pass "+pass);
		
		LoginService ls=new LoginServiceImpl();
		LoginBean l=ls.validateUser(user, pass);
		if(l != null) {
		if(l.getRole().equals("user")) {
			
//			RequestDispatcher rd= request.getRequestDispatcher("CookieServlet");
//			rd.forward(request, response);
			
			RequestDispatcher rd= request.getRequestDispatcher("SessionServlet");
			rd.forward(request, response);
		}
		else if(l.getRole().equals("admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("Admin");
			rd.forward(request, response);
		}
		else {
			response.setContentType("text/html");
			out.println("Invalid Credentials");
			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}	}
	}
}