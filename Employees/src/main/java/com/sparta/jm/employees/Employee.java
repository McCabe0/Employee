package com.sparta.jm.employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
private String employeeID;
private String namePrexif;
private String firstName;
private String middleInital;
private String lastName;
private String gender;
private String email;
private LocalDate dateOfBirth; //FORMATE
private LocalDate dateOfJoining;
private int salary; // male int

    public Employee(String employeeID, String namePrexif, String firstName, String middleInital,
                    String lastName, String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoining, int salary) {
        this.employeeID = employeeID;
        this.namePrexif = namePrexif;
        this.firstName = firstName;
        this.middleInital = middleInital;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }
    public String getEmployeeID() { return employeeID;
    }
    public String getNamePrexif() { return namePrexif;
    }
    public String getFirstName() { return firstName;
    }
    public String getLastName() { return lastName;
    }
    public String getGender() { return gender;
    }
    public String getEmail() { return email;
    }
    public LocalDate getDateOfBirth() { return dateOfBirth;
    }
    public LocalDate getDateOfJoining() { return dateOfJoining;
    }
    public int getSalary() { return salary;
    }
    public String getMiddleInital() { return middleInital;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", namePrexif='" + namePrexif + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInital='" + middleInital + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary + '}';
    }
}
