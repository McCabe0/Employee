package com.sparta.jm.employees;

import java.nio.file.Path;
import java.sql.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class InsertingUsers {

    private static final String Query = "INSERT INTO employees Values(?,?,?,?,?,?,?,?,?,?)";
    private static final String URL = "jdbc:mysql://localhost/employees?user=root&password=30139829mc";

    public void addEmpsToDB(Map<String, Employee> employeeMap){
        Employee[] arrayofEmps = employeeMap.values().toArray(new Employee[employeeMap.size()]);
        Thread[] threadsArray = new Thread[150];
        int employeeCount = arrayofEmps.length;
        int threadCount = threadsArray.length;
        int factor = employeeCount/threadCount;
        for (int i = 0; i < threadsArray.length; i++){
            final  int j = i;
            Runnable run;
            if(factor*(i+1)>employeeCount){
                run = () -> insert(Arrays.copyOfRange(arrayofEmps, (employeeCount*j)/threadCount,arrayofEmps.length));
            }else{
                run = () -> insert(Arrays.copyOfRange(arrayofEmps, (employeeCount*j)/threadCount, (employeeCount*(j+1))/threadCount));
            }
            threadsArray[i] = new Thread(run);
            threadsArray[i].start();
        }
        for (Thread t : threadsArray){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void insert(Employee[] employees){
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement statement = connection.prepareStatement(Query);
            for (Employee employee : employees) {
                statement.setString(1, employee.getEmployeeID());
                statement.setString(2, employee.getNamePrexif());
                statement.setString(3, employee.getFirstName());
                statement.setString(4, employee.getMiddleInital());
                statement.setString(5, employee.getLastName());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
                statement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                statement.setInt(10, employee.getSalary());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
