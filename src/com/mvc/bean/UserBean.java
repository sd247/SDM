package com.mvc.bean;

public class UserBean
{
private int User_ID;
private String Password;
private String Status;
private String Dept_Code;
private String First_Name;
private String Last_Name;

public UserBean() 
{
	super();
}

public UserBean(int User_ID,String Password, String Status,String First_Name,String Last_Name,String Dept_Code) 
{
	   this.User_ID=User_ID;
	   this.Password=Password;
	   this.Status=Status;
	   this.Dept_Code=Dept_Code;
	   this.First_Name=First_Name;
	   this.Last_Name=Last_Name;
}

public int getUser_ID() 
{
	
	return User_ID;
}

public String getPassword() 
{
	
    return Password;
}

public String getStatus() 
{
    return Status ;
}

public String getFirst_Name()
{
	
	return First_Name;
}

public String getLast_Name()
{
	
	return Last_Name;
}

public void setUser_ID(int User_ID) 
{
	
    this.User_ID= User_ID;
}

public void setPassword(String Password) 
{
    this.Password=Password;
}

public void setStatus(String Status) 
{
    this.Status=Status;
}

public String getDept_Code() 
{
	
  return Dept_Code ;
}

public void setDept_Code(String Dept_Code) 
{
    this.Dept_Code= Dept_Code;
}

public void setFirst_Name(String FirstName)
{
	this.First_Name = FirstName;
}

public void setLast_Name(String Last_Name)
{
	this.Last_Name=Last_Name;
}
}


