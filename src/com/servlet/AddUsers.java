package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UserBean;
import com.mvc.dao.UserDAO;

/**
 * Servlet implementation class AddUsers
 */
@WebServlet("/AddUsers")
public class AddUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InsertUser(request, response);
		//doGet(request, response);
	}
	
	protected void InsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int users = Integer.parseInt(request.getParameter("userid"));
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dpt = request.getParameter("dept");
		
		UserBean userBean = new UserBean();
		userBean.setUser_ID(users);
		userBean.setPassword(password);
		userBean.setStatus(status);
		userBean.setDept_Code(dpt);
		userBean.setFirst_Name(fname);
		userBean.setLast_Name(lname);
		
		String sta = userBean.getStatus();
		UserDAO addusers = new UserDAO();
		
		try {
			String flag = addusers.AddUser(userBean);
			if(flag.equals("SUCCESS")) {
				request.getRequestDispatcher("/users.jsp").forward(request, response);
				 
			}
			else   //On Failure, display a meaningful message to the User.
			 {
			 request.setAttribute("errMessage", sta);
			 request.getRequestDispatcher("/AddStudent.jsp").forward(request, response);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
