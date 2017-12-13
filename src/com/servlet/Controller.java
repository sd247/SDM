package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import com.mvc.bean.*;
import com.mvc.dao.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserInformation uInfo = new UserInformation();
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {
			String _username = request.getParameter("uname");
			String _password = request.getParameter("password");
			try {
				if (_username != null) {

					Connection con = DBConnection.getConnection();

					Statement st = con.createStatement();
					ResultSet rs;
					rs = st.executeQuery(
							"select * from User where User_ID='" + _username + "' and Password='" + _password + "'");
					if (rs.next()) {
						String status = rs.getString("Status");
						if (status.equals("S")) {
							StudentDAO sDao = new StudentDAO();
							StudentBean sBean = new StudentBean();
							// StudentBean s = new StudentBean();
							sBean = sDao.getStudentRecord(rs.getInt("User_ID"));
							HttpSession session = request.getSession();
							session.setAttribute("username", _username);
							session.setAttribute("status", status);
							session.setAttribute("name", sBean.getFirst_Name());
							response.sendRedirect("Student.jsp");
						} else if (status.equals("F")) {
							FacultyBean fBean = new FacultyBean();
							FacultyDAO f = new FacultyDAO();
							fBean = f.getFacultyRecord(rs.getInt("User_ID"));
							HttpSession session = request.getSession();
							session.setAttribute("username", _username);
							session.setAttribute("status", status);
							session.setAttribute("name", fBean.getFirst_Name());
							response.sendRedirect("Faculty.jsp");
						} else if (status.equals("A")) {
							HttpSession session = request.getSession();
							session.setAttribute("username", _username);
							session.setAttribute("status", status);
							response.sendRedirect("users.jsp");
							// response.sendRedirect(".jsp");
						} else {
							response.sendRedirect("403.jsp");
						}

					} else {
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						out.println("<font color=red>Either user name or password is wrong.</font>");
						rd.include(request, response);
					}
				}

			} catch (Exception e) {
				out.println("Error:" + e.getMessage());
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
