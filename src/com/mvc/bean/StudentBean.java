package com.mvc.bean;
public class StudentBean 
{

		private int Student_ID;
		private String First_Name;
		private String Last_Name;
		private String Address;
		private int Contact;
		private String Email;
		private String Dept_Code;
		
		public StudentBean() {
			
		}
		 public StudentBean(int Student_ID, String First_Name, String Last_Name, String Address, int Contact, String Email, String Dept_Code) {
			 
			 this.Student_ID = Student_ID;
			 this.First_Name = First_Name;
			 this.Last_Name = Last_Name;
			 this.Address = Address;
			 this.Contact = Contact;
			 this.Email = Email;
			 this.Dept_Code = Dept_Code;
		 }
		 
		 public int getStudent_ID() {
			 return Student_ID;
		 }
		 
		 public void setStudent_ID(int Student_ID) {
			 this.Student_ID = Student_ID;
		 }
		 
		 public String getFirst_Name() {
			 return First_Name;
		 }
		 
		 public void setFirst_Name(String First_Name) {
			 this.First_Name = First_Name;
		 }
		 
		 public String getLast_Name() {
			 return Last_Name;
		 }
		 
		 public void setLast_Name(String Last_Name) {
			 this.Last_Name = Last_Name;
		 }
		 
		 public String getAddress() {
			 return Address;
		 }
		 
		 public void setAddress(String Address) {
			 this.Address = Address;
		 }
		 
		 public int getContact() {
			 return Contact;
		 }
		 
		 public void setContact(int Contact) {
			 this.Contact = Contact;
		 }
		 
		 public String getEmail() {
			 return Email;
		 }
		 
		 public void setEmail(String Email) {
			 this.Email = Email;
		 }
		 
		 public String getDept_Code() {
			 return Dept_Code;
		 }
		 
		 public void setDept_Code(String Dept_Code) {
			 this.Dept_Code = Dept_Code;
		 }

	}


