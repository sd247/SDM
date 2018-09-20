package com.mvc.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.FacultyBean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.DBConnection;

public class FacultyDAO 
{
	private Connection con;
	
	public FacultyDAO()
	{
		con=DBConnection.getConnection();
	}
	
	
	public String updateFaculty(FacultyBean f) throws Exception 
	{
		
		 try {
	
			 String update_query = "UPDATE faculty SET   First_Name = ?, Last_Name = ?, Address= ?, Contact= ?, Email= ?, Dept_Code=?";
			 update_query += " WHERE Faculty_ID = ?";
	      
			 PreparedStatement ps= (PreparedStatement) con.prepareStatement(update_query) ;
       
        	ps.setString(1, f.getFirst_Name());
        	ps.setString(2,f.getLast_Name());
        	ps.setString(3, f.getAdrress());
        	ps.setInt(4, f.getContact());  
        	ps.setString(5,f.getEmail()); 
        	ps.setString(6, f.getDept_Code());
        	ps.setInt(7, f.getFaculty_ID());
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
	 
	 
	 public FacultyBean getFacultyRecord(int Faculty_ID) throws SQLException
 	 {
		 FacultyBean f=new FacultyBean();
		 try
		 {
         //Connection con=dbcon.getConnection();
    
         PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM Faculty WHERE Faculty_ID = ?");
         ps.setInt(1, Faculty_ID);
          
         ResultSet rs = ps.executeQuery();
          
         if (rs.next()) 
         {
        	// f.setFaculty_ID(rs.getInt("Faculty_ID"));
        	 f.setFirst_Name(rs.getString("First_Name"));
        	 f.setLast_Name(rs.getString("Last_Name"));
        	 f.setAddress(rs.getString("Address"));
        	 f.setContact(rs.getInt("Contact"));
        	 f.setEmail(rs.getString("Email"));
        	 f.setDept_Code(rs.getString("Dept_Code"));

         }
     
         rs.close();
         ps.close();
      
		}catch(SQLException e){
		 e.printStackTrace();
		 }
         
		 return f;
		      
     }

	 
}
