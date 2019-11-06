package com.sparta.jm.controller;

import com.sparta.jm.employees.Employee;
import com.sparta.jm.employees.InsertingUsers;
import com.sparta.jm.employees.ReadingCVSFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeManger {
    public void CreatingTheHashMapToDisplay() {
        ReadingCVSFile read = new ReadingCVSFile();
        Map<String, Employee> employeeMap = read.readFile();
        System.out.println("Elements in database: " + employeeMap.size());
        InsertingUsers insertingUsers = new InsertingUsers();
        long start = System.currentTimeMillis();
        insertingUsers.addEmpsToDB(employeeMap);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to add the data " + (end - start) / 1000.0 + " Seconds");

    }

    public void TruncateData() {
        final String Query = "truncate employees";
        final String URL = "jdbc:mysql://localhost/employees?user=root&password=30139829mc";
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement statement = connection.prepareStatement(Query);
            statement.executeUpdate(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printList() {
        Map<String, Employee> employeeMap = new ReadingCVSFile().readFile();
        employeeMap.forEach((s, employee) -> System.out.println(employeeMap));
    }

    @Override
    public String toString() {
        return "EmployeeManger{}";
    }
}
