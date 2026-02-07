package com.update_employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class UpdateEmployee {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = dbConnection.getConnection();
		System.out.println("What details you want to Update? \n 1. Name \n 2. Dept \n 3. Salary \n 4. Incentives");
		Scanner sc = new Scanner(System.in);
		int choice=0;
		try {
		System.out.println("Enter the choice (1/2/3/4): ");
		 choice = sc.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Input Type Mismatch!");
		}
		
		switch(choice) {
		case 1:
			System.out.println("Enter the Employee id: ");
			int empId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Name to be Updated: ");
			String empName = sc.nextLine();
			System.out.println();
			String query = "UPDATE employee SET name = ? WHERE id = ?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(2, empId);
				statement.setString(1, empName);
				statement.executeUpdate();
				System.out.println("Employee Name Updated Successfully........");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 2:
			System.out.println("Enter the Employee id: ");
			int empId1 = sc.nextInt();
			System.out.println("Enter the Department to be Updated: ");
			sc.nextLine();
			String empDept = sc.nextLine();
			System.out.println();
			String query1 = "UPDATE employee SET department = ? WHERE id = ?";
	
			try {
				PreparedStatement statement = connection.prepareStatement(query1);
				statement.setInt(2, empId1);
				statement.setString(1, empDept);
				statement.executeUpdate();
				System.out.println("Employee Department Updated Successfully........");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 3:
			System.out.println("Enter the Employee id: ");
			int empId2 = sc.nextInt();
			System.out.println("Enter the Salary to be Updated: ");
			int empSal = sc.nextInt();
			System.out.println();
			String query2 = "UPDATE employee SET salary = ? WHERE id = ?";
	
			try {
				PreparedStatement statement = connection.prepareStatement(query2);
				statement.setInt(2, empId2);
				statement.setInt(1, empSal);
				statement.executeUpdate();
				System.out.println("Employee Salary Updated Successfully........");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 4:
			System.out.println("Enter the Employee id: ");
			int empId3 = sc.nextInt();
			System.out.println("Enter the Increntives to be Updated: ");
			int empInc = sc.nextInt();
			System.out.println();
			String query3 = "UPDATE employee SET incentives = ? WHERE id = ?";
	
			try {
				PreparedStatement statement = connection.prepareStatement(query3);
				statement.setInt(2, empId3);
				statement.setInt(1, empInc);
				statement.executeUpdate();
				System.out.println("Employee Incentives Updated Successfully........");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		break;
		default:
			System.out.println("Select Correct choice (only numerical)!");
			break;
		}
	 sc.close();
	}
}
