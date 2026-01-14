package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args)  {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String url="jdbc:mysql://localhost:3306/school";
	String username="root";
	String password="root";
	
	try {
		Connection con = DriverManager.getConnection(url, username, password);
		while(true)
		{
			System.out.println("=================================");
			System.out.println("=================================");
			System.out.println("=================================");
			System.out.println("Enter 1 to add student");
			System.out.println("Enter 2 to see all student");
			System.out.println("Enter 3 to update student");
			System.out.println("Enter 4 to student delete");
			System.out.println("Enter 5 to TO search id for name ");
			System.out.println("Enter 6 to Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1 :
				System.out.println("Enter id");
				int id = sc.nextInt();
				
				System.out.println("Enter name");
				String name = sc.next();
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES(?,?)");
				ps.setInt(1,id);
				ps.setString(2,name);
				int update = ps.executeUpdate();
				System.out.println(update + "student added");
				
				System.out.println("student added");
				break;
			case 2:
				
						Statement statement=con.createStatement();
				
								ResultSet rs = statement.executeQuery("SELECT * FROM student");
								
								while(rs.next())
									{
											System.out.println(rs.getInt("id")+" "+rs.getString("name"));
									}    
									break;
			case 3 :
				System.out.println("Enter id to update");
				int idToUpdate = sc.nextInt();
				
				PreparedStatement psUpdate = con.prepareStatement("UPDATE student SET name=? WHERE id =?");
				
				System.out.println("Enter name");
				String newName = sc.next();
				
				psUpdate.setString(1,newName);
				psUpdate.setInt(2,idToUpdate);
				
				psUpdate.executeUpdate();
				
				System.out.println("Student updated");
				break;
			case 4 :
				System.out.println("Enter ID to Delete");
				int idDelete=sc.nextInt();
				   
				   PreparedStatement psDelete = con.prepareStatement("DELETE FROM student WHERE id=?");
				   psDelete.setInt(1,idDelete);
				   
				   psDelete.executeUpdate();
				
				System.out.println("student delete");
				break;
			case 5 :
				System.out.println("SELECT * FROM student ");
				break;
			case 6 :
				System.out.println("Bye");
			} 
		}
		//con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
