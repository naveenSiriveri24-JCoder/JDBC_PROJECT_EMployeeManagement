package com.delete_employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class DeleteEmployeee {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = dbConnection.getConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Need to DELETE an Employee..! Enter Required details of that employee");
		System.out.println("Enter the Id of employee: ");
		int empId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Name of Employee");
		String empName = sc.nextLine();
		
		String query = "DELETE FROM employee WHERE id = ? AND name = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, empId);
			statement.setString(2, empName);
			statement.executeUpdate();
			System.out.println("The Employee " +empName+ " is DELETED Successfully.......");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
