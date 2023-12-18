package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

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
 * Servlet implementation class DisplayAllInformation
 */
public class DisplayAllInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    ServletContext ctx;
    Connection con;
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con=DBUtil.getCon(ctx.getInitParameter("driverName"),
				ctx.getInitParameter("url"),
		        ctx.getInitParameter("userName"),
	            ctx.getInitParameter("password"));
		System.out.println("In display all "+con);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		LoginService ls=new LoginServiceImpl();
		List<LoginBean> list=ls.getAll(con);
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		
		out.println("<h1>User Details</h1>");
		out.println("<tableborder="+2+">"+"<tr><td>UserName</td><td>Role</td></tr>");
		
		for(LoginBean lb : list) {
			
			String edit="<a href="+">Edit</a>";
			String delete="<a href="+">Delete?username\"+lb.getUser()</a>";
			
			out.println("<tr><td>"+lb.getUser()+"</td><td>"+lb.getRole()+"</td></tr>");
		}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
