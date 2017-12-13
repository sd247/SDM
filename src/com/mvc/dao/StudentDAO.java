package com.mvc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.StudentBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.DBConnection;

public class StudentDAO 
{
private Connection con;
	
	public StudentDAO()
	{
		con = DBConnection.getConnection();
	}
	

	 
	 	 public String updateStudent(StudentBean s) throws SQLException
	 	 {
	 		 
	 		 //Connection con=dbcon.getConnection();
	         String update_query = "UPDATE Student SET  First_Name = ?, Last_Name = ?, Address= ?, Contact= ?, Email= ?";
	         update_query += " WHERE Student_ID = ?";
	         try
	         {
	         PreparedStatement ps = (PreparedStatement) con.prepareStatement(update_query);
	         ps.setString(1, s.getFirst_Name());
	         ps.setString(2, s.getLast_Name());
	         ps.setString(3,s.getAddress());
	         ps.setInt(4, s.getContact());
	         ps.setString(5, s.getEmail());
		     //ps.setString(6, s.getDept_Code());
		     ps.setInt(6,  s.getStudent_ID());
	          
		       int i= ps.executeUpdate();
		        if(i!=0) 
		        	return "SUCCESS";
		        ps.close();    
		        con.close();
			  
			 	}catch(SQLException e){
			 		e.printStackTrace();
			 	}
			 	return "F";
	 	
	 	 }
	 	 
	 
	    
	 	 public StudentBean getStudentRecord(int Student_ID) throws SQLException
	 	 {
	 		StudentBean s=new StudentBean();
	         //Connection con=dbcon.getConnection();
        
	         PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM Student WHERE Student_ID = ?");
	         ps.setInt(1, Student_ID);
	          
	         ResultSet rs = ps.executeQuery();
	          
	         if (rs.next()) 
	         {
	       // 	 s.setStudent_ID(rs.getInt("Student_ID"));
	        	 s.setFirst_Name(rs.getString("First_Name"));
	        	 s.setLast_Name(rs.getString("Last_Name"));
	        	 s.setAddress(rs.getString("Address"));
	        	 s.setContact(rs.getInt("Contact"));
	        	 s.setEmail(rs.getString("Email"));
	        	 s.setDept_Code(rs.getString("Dept_Code"));
  
	         }
	     
	         rs.close();
	         ps.close();

	         
	         return s;
	     }


		public String newStudent(StudentBean s) throws Exception
		{
			
	    	//Connection con=dbcon.getConnection();
	   
	    	try {
	    	String insert_query = "INSERT INTO student(Student_ID, First_Name, Last_Name, Address, Contact, Email, Dept_Code) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    	
	        PreparedStatement ps = (PreparedStatement)con.prepareStatement(insert_query) ;
	        ps.setInt(1, s.getStudent_ID());
	        ps.setString(2, s.getFirst_Name());
	        ps.setString(3, s.getLast_Name());
	        ps.setString(4, s.getAddress());
	        ps.setInt(5, s.getContact());
	        ps.setString(6, s.getEmail());
	        ps.setString(7, s.getDept_Code());
	

	        int i= ps.executeUpdate();
	        if(i!=0) 
	        	return "SUCCESS";
	        ps.close();    
	        con.close();
		  
		 	}catch(SQLException e){
		 		e.printStackTrace();
		 	}
		 	return "F";
	    }
	    }


