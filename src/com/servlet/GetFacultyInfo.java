package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.FacultyBean;
import com.mvc.bean.*;
import com.mvc.dao.*;

/**
 * Servlet implementation class GetFacultyInfo
 */
@WebServlet("/GetFacultyInfo")
public class GetFacultyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FacultyBean sB = new FacultyBean();
	FacultyDAO sD = new FacultyDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFacultyInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String param = request.getParameter("param");
		// System.out.println(param);
		String FsessionStatus = (String) request.getSession().getAttribute("status");
		try {
			sB = sD.getFacultyRecord(Integer.parseInt(param));
			HttpSession session = request.getSession();
			session.setAttribute("fname", sB.getFirst_Name());
			session.setAttribute("lname", sB.getLast_Name());
			session.setAttribute("contact", sB.getContact());
			session.setAttribute("address", sB.getAdrress());
			session.setAttribute("email", sB.getEmail());
			session.setAttribute("status", FsessionStatus);
			response.sendRedirect("FacultyInfo.jsp");

			// RequestDispatcher rd = request.getRequestDispatcher("/StudentInfo.jsp");
			// rd.include(request,response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String dpt = request.getParameter("dept");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		sB.setFaculty_ID(userid);
		sB.setFirst_Name(firstName);
		sB.setLast_Name(lastName);
		sB.setAddress(address);
		sB.setContact(Integer.parseInt(contact));
		sB.setEmail(email);
		//sB.setDept_Code(dpt);
		try {
			String sff = sB.getFirst_Name();
			//System.out.println(sff);
			String flag = sD.updateFaculty(sB);
			if(flag.equals("SUCCESS")) {
				//doGet(request, response);
				request.getSession().setAttribute("name", sB.getFirst_Name());
				response.sendRedirect("Faculty.jsp");
			}else {
				System.out.println("Nah!! Not working!!");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(e.getLocalizedMessage());
		}
		//doGet(request, response);
	}

}
