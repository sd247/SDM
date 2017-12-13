package com.mvc.bean;

public class FacultyBean {
	private int Faculty_ID;
	private String First_Name;
	private String Last_Name;
	private String Address;
	private int Contact;
	private String Email;
	private String Dept_Code;

	public FacultyBean() {
		// TODO Auto-generated constructor stub
	}

	public FacultyBean(int Facutly_ID, String Frist_Name, String Last_Name, String Address, int Contact, String Email,
			String Dept_Code) {
		this.Faculty_ID = Facutly_ID;
		this.First_Name = Frist_Name;
		this.Last_Name = Last_Name;
		this.Address = Address;
		this.Contact = Contact;
		this.Email = Email;
		this.Dept_Code = Dept_Code;
	}

	public FacultyBean(int Facutly_ID, String Dept_Code) {
		// TODO Auto-generated constructor stub
		this.Faculty_ID = Facutly_ID;
		this.Dept_Code = Dept_Code;
	}

	public int getFaculty_ID() {
		return Faculty_ID;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public String getAdrress() {
		return Address;
	}

	public int getContact() {
		return Contact;
	}

	public String getEmail() {
		return Email;
	}

	public String getDept_Code() {
		return Dept_Code;
	}

	public void setFaculty_ID(int Faculty_ID) {
		this.Faculty_ID = Faculty_ID;
	}

	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}

	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}

	public void setContact(int Contact) {
		this.Contact = Contact;
	}

	public void setAddress(String Address) {

		this.Address = Address;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public void setDept_Code(String Dept_Code) {
		this.Dept_Code = Dept_Code;
	}

}
