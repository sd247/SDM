<%@ page import ="java.sql.*" %>
<%
try{
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp?useSSL=false",
            "root", "root");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from User where User_ID='" + userid + "' and Password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userid", userid);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("Student.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
}
catch(Exception e){
	System.out.println(e);
}
%>
