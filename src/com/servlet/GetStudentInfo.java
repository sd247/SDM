package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mvc.bean.*;
import com.mvc.dao.*;
import com.servlet.DBConnection;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
/**
 * Servlet implementation class GetStudentInfo
 */
@WebServlet("/GetStudentInfo")
public class GetStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentBean sB = new StudentBean();
	StudentDAO sD = new StudentDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String param = request.getParameter("param");
		//System.out.println(param);
		String sessionStatus = (String) request.getSession().getAttribute("status");
		try {
			sB = sD.getStudentRecord(Integer.parseInt(param));
			HttpSession session = request.getSession();
			session.setAttribute("fname", sB.getFirst_Name());
			session.setAttribute("lname", sB.getLast_Name());
			session.setAttribute("contact", sB.getContact());
			session.setAttribute("address", sB.getAddress());
			session.setAttribute("email", sB.getEmail());
			session.setAttribute("status", sessionStatus);
			//session.setAttribute("s", param2);
			response.sendRedirect("StudentInfo.jsp");
			//System.out.println(sB.getFirst_Name());
			//RequestDispatcher rd = request.getRequestDispatcher("/StudentInfo.jsp");
			//rd.include(request,response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String dpt = request.getParameter("dept");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		sB.setStudent_ID(userid);
		sB.setFirst_Name(firstName);
		sB.setLast_Name(lastName);
		sB.setAddress(address);
		sB.setContact(Integer.parseInt(contact));
		sB.setEmail(email);
		
		//sB.setDept_Code(dpt);
		try {
			String sff = sB.getFirst_Name();
			//System.out.println(sff);
			String flag = sD.updateStudent(sB);
			if(flag.equals("SUCCESS")) {
				//doGet(request, response);
				request.getSession().setAttribute("name", sB.getFirst_Name());
				response.sendRedirect("Student.jsp");
			}else {
				System.out.println("Nah!! Not working!!");
			}
		}catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(e.getLocalizedMessage());
		}
		 
	}

}
