package com.view_employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class ViewEmployee {

	public static void main(String[] args) {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = dbConnection.getConnection();
		String query = "SELECT * FROM employee";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getInt(4) +"\t"+rs.getInt(5) );
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		ViewEmployee.getEmployeeByID();
	}
	
	public static void getEmployeeByID() {
		DataBaseConnection dbConnection = new DataBaseConnection();
		Connection connection = dbConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("============You can get One Employee details at once As Well==========");
		System.out.println("Enter the empID: ");
		int empId = sc.nextInt();
		String query = "SELECT * FROM employee WHERE id = ?";	
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, empId);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getInt(4) +"\t"+rs.getInt(5) );
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	}

