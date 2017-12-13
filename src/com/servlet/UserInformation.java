package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class UserInformation {

	public static boolean getUserInformation(String uname, String pass) {
		boolean istrue = false;
		try {
			if (uname != null) {
				Connection con = DBConnection.getConnection();

				Statement st = con.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select * from users where uname='" + uname);
				if (rs.next()) {
					istrue = true;
				} else {
					istrue = false;
				}
			}
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return istrue;
	}
	
	public static boolean getPassword(String password) {
		boolean istrue = false;
		try {
			if (password != null) {
				Connection con = DBConnection.getConnection();

				Statement st = con.createStatement();
				ResultSet rs;
				rs = st.executeQuery("select * from users where pass='" + password);
				if (rs.next()) {
					istrue = true;
				} else {
					istrue = false;
				}
			}
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return istrue;
	}
}
