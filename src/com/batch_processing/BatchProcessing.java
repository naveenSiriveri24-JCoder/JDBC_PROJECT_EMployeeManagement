package com.batch_processing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class BatchProcessing {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = dbConnection.getConnection();
		String query = "INSERT INTO employee (name, department, salary, incentives) VALUES(?,?,?,?) ";
		PreparedStatement statement=null;
		
		try {
			 statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Need to Insert the Data into Table in BULK!..");
		System.out.println("Enter the value of the How many entries you want to make: ");
		int entriesNum = sc.nextInt();
		
		for(int i = 1; i<=entriesNum; i++) {
			sc.nextLine();
			System.out.println("Enetr the Name of Employee " + i +": ");
			String empName = sc.nextLine();
			
			System.out.println("Enetr the Department of Employee " + i +": ");
			String empDept = sc.nextLine();
			
			System.out.println("Enetr the Salary of Employee " + i +": ");
			int empSal = sc.nextInt();
			
			System.out.println("Enetr the incentives of Employee " + i +": ");
			int empInc = sc.nextInt();
		
			try {
				statement.setString(1, empName);
				statement.setString(2, empDept);
				statement.setInt(3, empSal);
				statement.setInt(4, empInc);
				statement.addBatch();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		
		}
		
		try {
			statement.executeBatch();
			System.out.println("Details of Entered Employees are Updated Successfully.........");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
