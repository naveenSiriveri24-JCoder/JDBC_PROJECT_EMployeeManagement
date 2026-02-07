package com.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.db_connection.DataBaseConnection;

public class StoredProcedure {
	public static void main(String[] args) {
		
	
	DataBaseConnection dbConnection = new DataBaseConnection();
	Connection connection = dbConnection.getConnection();
	Scanner sc = new Scanner(System.in);
	boolean iteration = true;
	
	while(iteration) {
	System.out.println("\n=============<<<<<<<<<>>>>>>>>=============");
	System.out.println("Select any of these Stored Procedures:\n 1.getEmployeeByName() -- Will gives the Employee Detailes \n 2.getEmployeeBySalaryByName() -- Will gives the salary selected employee \n 3. getEmployeeCount() -- Will returns the Total employee count \n 0.Exit");
	System.out.println("Enter your Choice: ");
	int choice = sc.nextInt();
	sc.nextLine();
	switch(choice) {
	case 1:
	try {
		System.out.println("Enter the Employee Name: ");
		String empName = sc.nextLine();
		CallableStatement call = connection.prepareCall("{CALL getEmployeeByName(?)}");
		call.setString(1,empName);
		ResultSet rs = call.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+ rs.getString(3) +"\t"+ rs.getInt(4) +"\t"+rs.getInt(5));
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	break;
	
	case 2:
		try {
			System.out.println("Enter the Employee Name: ");
			String empName = sc.nextLine();
			CallableStatement call = connection.prepareCall("{CALL getEmployeeBySalaryByName(?, ?)}");
			call.setString(1,empName);
			call.registerOutParameter(2, Types.INTEGER);
			call.execute();
			
			System.out.println("The salary of employee  "+empName+" is "+call.getInt(2));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		break;
	case 3:
		try {
			CallableStatement call = connection.prepareCall("{CALL getEmployeeCount(?)}");
			call.registerOutParameter(1, Types.INTEGER);
			call.execute();
			System.out.println("The Total Employee Count : "+call.getInt(1));
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		break;
	case 0:
		iteration = false;
		System.out.println("Operation Disbursed Successfully.......!");
		break;
	default:
		System.out.println("Enter valied choice! ");
		break;
	}
	
}
	sc.close();
}
}