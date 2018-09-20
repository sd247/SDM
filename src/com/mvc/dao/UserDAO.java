package com.mvc.dao;

import java.sql.SQLException;

import com.mvc.bean.UserBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.DBConnection;

public class UserDAO {
	private Connection con;

	public UserDAO() {
		con = DBConnection.getConnection();
	}

	public String AddUser(UserBean ub) throws Exception {
		
		try {
			
			int j = 0;
			int k = 0;
			String insert_query = "INSERT INTO user(User_ID,Password,Status) VALUES (?, ?, ?)";
			
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(insert_query);

			ps.setInt(1, ub.getUser_ID());
			ps.setString(2, ub.getPassword());
			ps.setString(3, ub.getStatus());

			int i = ps.executeUpdate();
			ps.close();

			if ((ub.getStatus()).equals("F")) {

				

				String fquery = "INSERT INTO faculty(Faculty_ID,First_Name,Last_Name,Address,Contact,Email,Dept_Code) VALUES (?, ?, ?, ?, ?, ?,?)";
				// String iQuery = "insert into 'User' (Users_ID, Password, Status) VALUES ()";
				PreparedStatement fps = (PreparedStatement) con.prepareStatement(fquery);

				fps.setInt(1, ub.getUser_ID());
				fps.setString(2, ub.getFirst_Name());
				fps.setString(3, ub.getLast_Name());
				fps.setString(4, "NULL");
				fps.setInt(5, 0);
				fps.setString(6, "NULL");
				fps.setString(7, ub.getDept_Code());

				try {
					j = fps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if ((i != 0) && (j != 0))
					return "SUCCESS";
				fps.close();
			}

			if ((ub.getStatus()).equals("S")) {
				
				String squery = "INSERT INTO student(Student_ID,First_Name,Last_Name,Address,Contact,Email,Dept_Code) VALUES (?, ?, ?, ?, ?, ?, ?)";
				// String iQuery = "insert into 'User' (Users_ID, Password, Status) VALUES ()";
				PreparedStatement sps = (PreparedStatement) con.prepareStatement(squery);
				// UserBean s = new UserBean(4,"ddd","F","neha","sagar","SWE");
				sps.setInt(1, ub.getUser_ID());
				sps.setString(2, ub.getFirst_Name());
				sps.setString(3, ub.getLast_Name());
				sps.setString(4, "NULL");
				sps.setInt(5, 0);
				sps.setString(6, "NULL");
				sps.setString(7, ub.getDept_Code());
				try {
					k = sps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if ((i != 0) && (k != 0))
					return "SUCCESS";
				sps.close();
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "F";
	}

	public String deleteUser(UserBean ub) throws Exception {
		int i = 0, j = 0;
		if ((ub.getStatus()).equals("F")) {
			String fdelete = "DELETE FROM faculty where Faculty_ID = '" + ub.getUser_ID() + "'";
			PreparedStatement fps = (PreparedStatement) con.prepareStatement(fdelete);
			try {
				j = fps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
			fps.close();
			if (i != 0 || j != 0)
				return "SUCCESS";
		}

		else if ((ub.getStatus()).equals("S")) {
			String sdelete = "DELETE FROM student where Student_ID = '" + ub.getUser_ID() + "'";
			PreparedStatement sps = (PreparedStatement) con.prepareStatement(sdelete);
			try {
				j = sps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}

			sps.close();
			if (i != 0 || j != 0)
				return "SUCCESS";
		}
		con.close();

		return "FAIL";
	}

}
