package JDBC.Basics;

import java.sql.Connection;
import java.sql.*;

public class JD {

    private static final String url = "jdbc:mysql://localhost:3306/SMS2";
    private static final String user = "root";
    private static final String password = "Hemanth@569++";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();

//        String query = "Select * from Students";
//        ResultSet rs = st.executeQuery(query);
//
//        while (rs.next())
//        {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            String email = rs.getString("email");
//            int marks = rs.getInt("marks");
//
//            System.out.println(id+" "+name+" "+email+" "+marks);
//        }

//        String query = String.format("insert into Students (id,name,email,marks) values (%d, '%s', '%s', %d)", 3, "Baby", "baby@gmail.com", 100);
//        int myRes = st.executeUpdate(query);
//        if(myRes>0) System.out.println("Success");
//        else System.out.println("Failed");

//        String query = String.format("Update Students set marks = %d where id = %d", 35,2);
//        int res = st.executeUpdate(query);
//        if(res>0) System.out.println("Success");
//        else System.out.println("Failed");

        String query = String.format("Delete from Students where id = %d",2);
        int rowsFull = st.executeUpdate(query);
        if(rowsFull>0) System.out.println("Deleted");
        else System.out.println("Not Deleted");

    }
}
