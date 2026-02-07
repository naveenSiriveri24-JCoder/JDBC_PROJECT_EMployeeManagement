package com.insert_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class InsertEmployee {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enetr the Name of Employee: ");
		String empName = sc.nextLine();
		
		System.out.println("Enetr the Department of Employee: ");
		String empDept = sc.nextLine();
		
		System.out.println("Enetr the Salary of Employee: ");
		int empSal = sc.nextInt();
		
		System.out.println("Enetr the incentives of Employee: ");
		int empInc = sc.nextInt();
		
		Connection connection = dbConnection.getConnection();
		String query = "INSERT INTO employee (name, department, salary, incentives) VALUES(?,?,?,?) ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, empName);
			statement.setString(2, empDept);
			statement.setInt(3, empSal);
			statement.setInt(4, empInc);
		
			statement.executeUpdate();
			System.out.println("Details are Inserted in employee table Successfully......");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
	}
}
